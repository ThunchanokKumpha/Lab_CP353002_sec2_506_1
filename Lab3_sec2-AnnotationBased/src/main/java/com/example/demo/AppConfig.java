package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.example.model.User;

@Configuration
@ComponentScan("com.example.model")
public class AppConfig {
	@Bean
	public User user() { //bean id = "user", it can get its name from the name of user() function
		return new User("Ink",21);
	}
	
//	@Bean
//	public User user2(@Value("{$user.name}") String name, @Value("${user.age}") int age) { //bean id = "user", it can get its name from the name of user() function
//		return new User(name,age);
//	}
//	
	@Bean
	public User user1() { //bean id = "user", it can get its name from the name of user() function
		return new User();
	}
	
	
}





