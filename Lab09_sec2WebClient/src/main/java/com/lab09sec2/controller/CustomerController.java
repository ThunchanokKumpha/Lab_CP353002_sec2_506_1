package com.lab09sec2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.lab09sec2.dto.CustomerRequest;
import com.lab09sec2.dto.CustomerResponse;
import com.lab09sec2.service.WebClientCustomerService;

import reactor.core.publisher.Mono;



@Controller
public class CustomerController {

	private WebClientCustomerService custService;
	@Autowired
	public CustomerController(WebClientCustomerService s) {
		this.custService=s;
	}
	
	@GetMapping("/web/customers")
	public String getCustomers( Model model) {
		List<CustomerResponse> customers = custService.getCustomers()
											.collectList().block();
		model.addAttribute("customers", customers);
		return "customerListCRUD";
	}
	
	@GetMapping("/web/createacustomer") // Enter a new Customer
	public String createAuthor(Model model) {
		CustomerResponse cust = new CustomerResponse(0l,"","");
		model.addAttribute("customer", cust);
		return "addCustomerForm";
	}

	
	
	@PostMapping("/web/addCustomer") 
	public String addCustomer(@ModelAttribute CustomerRequest customerRequest, 
	                          Model model) {
	    System.out.println("add a new Customer");

	    Mono<CustomerResponse> monoCustomer = custService.addCustomer(customerRequest);

	    model.addAttribute("customer", monoCustomer.block());
	    return "redirect:/web/customers";   // redirect กลับไปหน้ารวม customer
	}
	
	
	@GetMapping("/web/editcustomer/{id}")
	public String editCustomer(@PathVariable Long id, Model model) {
	    CustomerResponse cust = custService.getCustomerById(id).block();
	    model.addAttribute("customer", cust);
	    return "editCustomerForm"; // ไปหน้าแก้ไข
	}


	@PostMapping("/web/updatecustomer/{id}")
	public String updateCustomer(@PathVariable Long id,
	                             @ModelAttribute CustomerRequest customerRequest) {
	    custService.updateCustomer(id, customerRequest).block();
	    return "redirect:/web/customers";
	}

	

	@GetMapping("/web/deletecustomer/{id}")
	public String deleteCustomer(@PathVariable Long id) {
	    custService.deleteCustomerById(id).block();
	    return "redirect:/web/customers";
	}
	
	@GetMapping("/web/viewcustomer/{id}")
	public String viewCustomer(@PathVariable Long id, Model model) {
	    CustomerResponse cust = custService.getCustomerById(id).block();
	    model.addAttribute("customer", cust);
	    return "viewCustomer"; // ไปหน้า viewCustomer.html
	}
	
	

}
