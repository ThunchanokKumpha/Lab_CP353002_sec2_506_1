package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.model.Customer;

@Controller
public class Lab5_1Sec2_Controller {
	
	@GetMapping("/customer")
	public String greeting(Model model) {
		
		Customer myCust = new Customer(10L, "Jenny Kim");
		model.addAttribute("customer",myCust);
		
		model.addAttribute("name",myCust);
		return "customerview";
	}
	

}