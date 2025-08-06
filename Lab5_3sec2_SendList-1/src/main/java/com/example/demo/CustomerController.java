package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.model.Customer;



@Controller
public class CustomerController {
	AnnotationConfigApplicationContext appContext;
	
	public CustomerController () {
		appContext = new AnnotationConfigApplicationContext(AppConfig.class);
		}
	
	@RequestMapping("/customerTwo")
	@ResponseBody
	
	public String getCustomerTwo() {
		String text = "";
		Customer cust1 = (Customer) appContext.getBean("customerargs", 15L,"John Jony");
		text += cust1.getId()+":"
				+ cust1.getName();
		
		Customer cust2 = (Customer) appContext.getBean("customer");
		cust2.setId(25L);
		cust2.setName("Mila");
		text += "<br>" + cust2.getId()+":"+cust2.getName();
		return text;
	}
	
	
	
	@RequestMapping("/customers")
	public String getCustomers(Model model) {
	List<Customer> customers = new ArrayList<>();
		Customer cust1 = (Customer) appContext.getBean("customerargs", 15L,"Toro");
		customers.add(cust1);
		Customer cust2 = (Customer) appContext.getBean("customer");
		cust2.setId(25L);
		cust2.setName("Teemee");
		customers.add(cust2);
		model.addAttribute("listcustomers", customers);
		
		return "customertableview"; //customertableview.html
	}
	
	
	
	
}
