package com.example.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.shared.AppConfig;
import com.example.shared.CompanyInformation;

@RestController
public class CompanyRestController {
	private CompanyInformation company;
	@GetMapping("/company")
	public String getCompanyInformation() {
		return "Company : "+company.getName() + " Tel: " + company.getTelephone();
	}
	
	public CompanyRestController() {
		var context = new AnnotationConfigApplicationContext(AppConfig.class);
		company = context.getBean("company",CompanyInformation.class);
		company.setName("Abc");
		company.setTelephone("06154789");
		
	}

}
