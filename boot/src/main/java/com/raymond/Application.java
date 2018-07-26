package com.raymond;

import com.raymond.mongo.RestaurantController;
import com.raymond.mongo.service.RestaurantService;
import com.raymond.mongo.service.impl.RestaurantServiceImpl;
import com.raymond.web.HomeController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.bridge.SLF4JBridgeHandler;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.io.File;

//@SpringBootApplication // same as @Configuration @EnableAutoConfiguration @ComponentScan
@EnableAutoConfiguration(exclude={MongoAutoConfiguration.class, MongoDataAutoConfiguration.class})
@ComponentScan
@EnableCaching
public class Application extends SpringBootServletInitializer {

    public static String ROOT = "upload-dir";
    static final Logger LOG = LoggerFactory.getLogger(Application.class);
    private static final java.util.logging.Logger julLogger = java.util.logging.Logger.getLogger("com.raymond.Application");

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        LOG.info("Application Start, from slf4j");
        julLogger.info("Application Start, logging from julLogger");
		return application.sources(Application.class);
	}

    @Bean
    CommandLineRunner init() {
        return (String[] args) -> {
            new File(ROOT).mkdir();
        };
    }

}
