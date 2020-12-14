package com.photography.photographers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
@EnableEurekaClient
@ComponentScan(basePackages = "com.photography")
@EntityScan(basePackages = "com.photography")
@SpringBootApplication
public class PhotographersApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhotographersApplication.class, args);
	}

}
