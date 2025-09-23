package com.lab09sec2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@ComponentScan(basePackages = "com.lab09sec2")
public class Lab09Sec2WebClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(Lab09Sec2WebClientApplication.class, args);
	}

}
