package com.raymond.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
//@EnableDiscoveryClient
@SpringBootApplication
public class ConfigApplication {

	public static void main(String[] args) {
		System.out.println("RED-0.0.1-SNAPSHOT");
		SpringApplication.run(ConfigApplication.class, args);
	}
}