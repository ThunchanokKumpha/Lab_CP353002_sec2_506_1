package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.model.User;

@Configuration
public class AppConfig {
	@Bean
	public User user() { //bean id = "user", it can get its name from the name of user() function
		return new User("Ink",21);
	}
	
}
