package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.example.model.User;

@SpringBootApplication
public class Lab3Sec21Application {

	public static void main(String[] args) {
		SpringApplication.run(Lab3Sec21Application.class, args);
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		User user = (User) context.getBean("user"); //ชื่อในฟังก์ชัน AppConfig ถ้าเปน user1 ก็ต้อง user1
		user.display();
		
//		User user2 = (User) context.getBean("user2","Jennie",25);
//		user2.display();
		
		User user1 = (User) context.getBean("user1");
		user1.setAge(10);
		user1.setName("Jennie");
		user1.display();
	}

}
