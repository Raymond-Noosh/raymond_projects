package com.raymond.config;

import com.raymond.entrypoint.JwtAuthenticationEntryPoint;
import com.raymond.filter.JwtAuthFilter;
import com.raymond.filter.JwtUsernameAndPasswordAuthenticationFilter;
import com.raymond.provider.JwtAuthProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.Collections;

/**
 * Created by Raymond Kwong on 11/24/2018.
 */
@EnableWebSecurity
public class JwtSecurityConfig extends WebSecurityConfigurerAdapter {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private JwtConfig jwtConfig;

    @Autowired
    private JwtAuthProvider authenticationProvider;

    @Autowired
    private JwtAuthenticationEntryPoint entryPoint;

    @Autowired
    private UserDetailsService userDetailsService;

    /*@Bean
    public AuthenticationManager authenticationManager() {
        return new ProviderManager(Collections.singletonList(authenticationProvider));
    }*/

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        logger.info(jwtConfig.getUri());
        logger.info(jwtConfig.getUri2());
        http
                .csrf().disable()
                // make sure we use stateless session; session won't be used to store user's state.
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                // handle an authorized attempts
                .exceptionHandling().authenticationEntryPoint(entryPoint)
                .and()
                // Add a filter to validate the tokens with every request
                .addFilterAfter(new JwtUsernameAndPasswordAuthenticationFilter(jwtConfig.getUri(), authenticationManager(), jwtConfig), UsernamePasswordAuthenticationFilter.class) //method1
                .addFilterAfter(new JwtAuthFilter(jwtConfig.getUri2(), authenticationManager(), jwtConfig), UsernamePasswordAuthenticationFilter.class)//method 2
                // authorization requests config
                .authorizeRequests()
                // allow all who are accessing "auth" service
                .antMatchers(HttpMethod.POST, "/auth/**").permitAll()
                .antMatchers(HttpMethod.POST, "/auth2/**").permitAll()//method 2
                // must be an admin if trying to access admin area (authentication is also required here)
                //.antMatchers("/gallery" + "/admin/**").hasRole("ADMIN")
                // Any other request must be authenticated
                .anyRequest().authenticated();
                //.anyRequest().permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());//I can choose to either use a userservice
        auth.authenticationProvider(authenticationProvider);//or use a authenicationProvider, which has precendence, will run before userservice
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
