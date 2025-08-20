package com.customerapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import com.customerapp.repository.CustomerRepository;
import com.customerapp.model.Customer;


@Service
public class CustomerService {
	
	@Autowired
	CustomerRepository custRepo;
	public List<Customer> getCustomerList(){
		List<Customer> customers = (List<Customer>)custRepo.findAll();
		return customers;
	}
	
	public Customer getOneCustomerById(Long id) {
		return custRepo.findById(id).orElseThrow( () -> new CustomerNotFoundException(id));
	}
	
	public void save(Customer customer) {
		custRepo.save(customer);
	}
	
	public Customer addCustomer(Customer customer) {
		custRepo.save(customer);
		return customer;
	}
	
	public Customer updateCustomer(long id, Customer c) {
		Customer customer = custRepo.findById(id).orElseThrow( () -> new CustomerNotFoundException(id));
		
		//customer.setId(id);
		customer.setName(c.getName());
		return custRepo.save(customer);
	}
	
	public void deleteCustomer(Long id) {
		Customer cust = custRepo.findById(id).orElseThrow( () -> new CustomerNotFoundException(id));
		custRepo.delete(cust);
	}
	
	
}
