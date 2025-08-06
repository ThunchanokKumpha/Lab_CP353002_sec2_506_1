package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Customer;
import com.example.service.CustomerService;

@RestController
@RequestMapping("/field")
public class FieldInjectionController {
	@Autowired
	CustomerService customerService; //field injection
	
	@GetMapping("/{id}") //Get http://localhost:8080/field/25
	public String getCustomer(@PathVariable Long id) {
		Customer cust = customerService.getCustomerById(id);
		return "Field Injection -> Customer ID:"+ cust.getId()+ ", Name:" + cust.getName();
	}
	
	@GetMapping("/customer/{id}/{name}") //Get http://localhost:8080/field/25/Thunchanok
	public String getCustomerByIdName(@PathVariable Long id, @PathVariable  String name) {
		Customer cust = customerService.getCustomerByIdName(id, name);
		return "Field Injection -> Customer ID:"+ cust.getId()+ ", Name:" + cust.getName();	
		}
	
	@GetMapping("/list") //Get http://localhost:8080/field/list
	public List<Customer> getCustomers() {
		List<Customer> customers = new ArrayList<>();
		customers = customerService.getCustomerList();
		return customers;
	}
	
	
}
