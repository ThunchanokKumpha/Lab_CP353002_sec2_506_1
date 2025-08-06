package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.model.User;

@SpringBootApplication
public class Lab3Sec21Application {

	public static void main(String[] args) {
		SpringApplication.run(Lab3Sec21Application.class, args);
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		User user = (User) context.getBean("user");
		user.display();
	}

}
