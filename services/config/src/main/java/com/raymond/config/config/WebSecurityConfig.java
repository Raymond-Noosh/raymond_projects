package com.raymond.config.config;

import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;
import org.springframework.boot.actuate.health.HealthEndpoint;
import org.springframework.boot.actuate.info.InfoEndpoint;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by Raymond Kwong on 1/23/2019.
 */
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .requestMatchers(EndpointRequest.to(HealthEndpoint.class, InfoEndpoint.class))
                .permitAll()
                .requestMatchers(EndpointRequest.toAnyEndpoint())
                .fullyAuthenticated()
                .antMatchers("/encrypt**").fullyAuthenticated()
                .antMatchers("/decrypt**").fullyAuthenticated()
                .and().httpBasic();
    }
}