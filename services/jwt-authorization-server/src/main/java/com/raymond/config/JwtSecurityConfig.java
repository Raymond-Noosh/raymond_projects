package com.raymond.config;

import com.raymond.entrypoint.JwtAuthenticationEntryPoint;
import com.raymond.filter.JwtAuthFilter;
import com.raymond.filter.JwtTokenAuthenticationFilter;
import com.raymond.provider.JwtAuthProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletResponse;
import java.util.Collections;

/**
 * Created by Raymond Kwong on 11/24/2018.
 */
@EnableWebSecurity
public class JwtSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private JwtConfig jwtConfig;

    @Autowired
    private JwtAuthProvider authenticationProvider;

    @Autowired
    private JwtAuthenticationEntryPoint entryPoint;


    @Bean
    public AuthenticationManager authenticationManager() {
        return new ProviderManager(Collections.singletonList(authenticationProvider));
    }

    //create a custom filter
    @Bean
    public JwtAuthFilter authTokenFilter() {
        JwtAuthFilter filter = new JwtAuthFilter();
        filter.setAuthenticationManager(authenticationManager());
        //filter.setAuthenticationSuccessHandler(new JwtSuccessHandler());
        return filter;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                // make sure we use stateless session; session won't be used to store user's state.
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                // handle an authorized attempts
                .exceptionHandling().authenticationEntryPoint(entryPoint)
                .and()
                // Add a filter to validate the tokens with every request
                .addFilterAfter(authTokenFilter(), UsernamePasswordAuthenticationFilter.class)
                // authorization requests config
                .authorizeRequests()
                // allow all who are accessing "auth" service
//                .antMatchers(HttpMethod.POST, jwtConfig.getUri()).permitAll()
                // must be an admin if trying to access admin area (authentication is also required here)
                //.antMatchers("/gallery" + "/admin/**").hasRole("ADMIN")
                // Any other request must be authenticated
//                .anyRequest().authenticated();
                .anyRequest().permitAll();
    }
}
