package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Lab5_1Sec2_Controller {
	
	@GetMapping("/hello")
	public String greeting(Model model) {
		String myName = "Thunchanok Kumpha";
		
		model.addAttribute("name",myName);
		return "hello";
	}
	

}