package com.raymond;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * Created by Raymond Kwong on 11/24/2018.
 */
@SpringBootApplication
public class JWTAuthorizationApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(JWTAuthorizationApplication.class, args);
    }
}
