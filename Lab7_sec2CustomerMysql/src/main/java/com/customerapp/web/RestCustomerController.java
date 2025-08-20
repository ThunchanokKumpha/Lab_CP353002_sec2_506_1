package com.customerapp.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customerapp.model.Customer;
import com.customerapp.service.CustomerService;

@RestController
@RequestMapping("/api/customers")
public class RestCustomerController {
	
	@Autowired
	private CustomerService custService;
	
	@GetMapping
	public ResponseEntity<List<Customer>> getCustomer(){
		List<Customer> customers = custService.getCustomerList();
		return new ResponseEntity<>(customers, HttpStatus.OK);
	}
	
	@GetMapping("/{id}") //select * form Customer.id = id;
	public ResponseEntity<Customer> getCustomerById(@PathVariable long id){
		Customer customer = custService.getOneCustomerById(id);
		return new ResponseEntity<>(customer, HttpStatus.OK);
	}
	
	@PostMapping(consumes = "application/json", produces = "application/json")
	public ResponseEntity<Customer> createCustomer(@org.springframework.web.bind.annotation.RequestBody Customer cust){
		
		System.out.println("New Customer:" + cust);
		Customer custNew = custService.addCustomer(cust); //insert into Customer
		return new ResponseEntity<Customer>(custNew,HttpStatus.OK);
	
		
	}
	
	@PutMapping("/{id}") // Update Customer set(name, cust.name) where customer.id = id
	public ResponseEntity<Customer> updateCustomer(
			@PathVariable Long id, @RequestBody Customer cust){
		Customer updateCustomer = custService.updateCustomer(id, cust);
		return new ResponseEntity<>(updateCustomer,HttpStatus.OK);
	}
	
	
	@DeleteMapping("/{id}") //delete from customer where Customer.id = id
	public void deleteCustomer(@PathVariable Long id) {
		custService.deleteCustomer(id);
	}
	

}
