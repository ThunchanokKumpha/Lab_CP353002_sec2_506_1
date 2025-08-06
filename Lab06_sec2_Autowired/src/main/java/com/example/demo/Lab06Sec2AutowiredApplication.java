package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.example")

public class Lab06Sec2AutowiredApplication {

	public static void main(String[] args) {
		SpringApplication.run(Lab06Sec2AutowiredApplication.class, args);
	}

}
