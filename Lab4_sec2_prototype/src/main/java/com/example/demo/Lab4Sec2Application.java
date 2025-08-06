package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.shared.AppConfig;
import com.example.shared.CompanyInformation;

@SpringBootApplication
public class Lab4Sec2Application {

	public static void main(String[] args) {
		SpringApplication.run(Lab4Sec2Application.class, args);
		
		// สร้าง context ด้วย Java Config
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		CompanyInformation c1 = (CompanyInformation) context.getBean("company");
		c1.setName("HES");
		c1.setTelephone("0818658749");
		c1.printCompanyInfo();

		CompanyInformation c2 = (CompanyInformation) context.getBean("company");
		c2.printCompanyInfo();
		

		System.out.println("Hashcode c1: " + c1.hashCode());
		System.out.println("Hashcode c2: " + c2.hashCode());
		
		c2.setName("Hitech");
		c2.setTelephone("0999999999");
		

		c1.printCompanyInfo();
		c2.printCompanyInfo();
		
		// ปิด context
		context.close();
	}
}
