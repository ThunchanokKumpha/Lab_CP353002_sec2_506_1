package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.model.Customer;

@Controller
public class Lab5_1Sec2_Controller {
	
	@GetMapping("/customer")
	public String greeting(Model model) {
	    List<Customer> customerList = new ArrayList<>();
	    customerList.add(new Customer(10L, "Jenny Kim"));
	    customerList.add(new Customer(11L, "Lisa Manoban")); // เพิ่มอีกคน

	    model.addAttribute("customers", customerList); // ให้ชื่อตรงกับใน HTML
	    return "customerview";
	}

	

}

