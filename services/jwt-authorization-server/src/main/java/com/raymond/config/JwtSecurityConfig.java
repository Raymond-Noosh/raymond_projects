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
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

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

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        logger.info(jwtConfig.getUri());
        logger.info(jwtConfig.getUri2());
        logger.info(jwtConfig.getPrefix());
        http
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .exceptionHandling().authenticationEntryPoint(entryPoint)
                .and()
                .addFilterAfter(new JwtUsernameAndPasswordAuthenticationFilter(jwtConfig.getUri(), authenticationManager(), jwtConfig), UsernamePasswordAuthenticationFilter.class) //method1
                .addFilterAfter(new JwtAuthFilter(jwtConfig.getUri2(), authenticationManager(), jwtConfig), UsernamePasswordAuthenticationFilter.class)//method 2
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, jwtConfig.getUri()).permitAll()
                .antMatchers(HttpMethod.POST, jwtConfig.getUri2()).permitAll()//method 2
                //.antMatchers("/gallery" + "/admin/**").hasRole("ADMIN")
                .anyRequest().authenticated();
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
