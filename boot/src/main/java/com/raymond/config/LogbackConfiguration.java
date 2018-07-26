package com.raymond.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Raymond Kwong on 7/23/2018.
 */
@Configuration
public class LogbackConfiguration {
    @Bean
    public ServletRegistrationBean servletRegistrationBean(){
        return new ServletRegistrationBean(new ch.qos.logback.classic.ViewStatusMessagesServlet(),"/lbAccessStatus");
    }
}
