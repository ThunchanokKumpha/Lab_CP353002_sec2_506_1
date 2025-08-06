package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.example.model.Customer;

@Configuration
@ComponentScan(basePackages = {"com.example.model"})
public class AppConfig {
	
	@Bean(name="customer")
	@Scope("prototype") //สร้างใหม่เรื่อยๆ

	public Customer getCustomer() {
		return new Customer();
		
	}
	
	@Bean(name="customerargs")
	@Scope("prototype") //สร้างใหม่เรื่อยๆ

	public Customer getCustomerArgs(Long id, String name) {
		return new Customer(id,name);
	}
	
	

	
}
