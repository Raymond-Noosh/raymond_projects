package com.raymond;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by Raymond Kwong on 11/24/2018.
 */
@EnableDiscoveryClient
@SpringBootApplication
public class JWTAuthorizationApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(JWTAuthorizationApplication.class, args);
    }
}
