package com.cpLab8sec2.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cpLab8sec2.dto.CustomerRequest;
import com.cpLab8sec2.dto.CustomerResponse;
import com.cpLab8sec2.entity.Customer;
import com.cpLab8sec2.repository.CustomerRepository;
import com.cpLab8sec2.service.CustomerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
	@Autowired
	private CustomerService custService;
	
	@GetMapping
	public ResponseEntity<List<CustomerResponse>> getAllCustomer(){
		List<CustomerResponse> customers = custService.getCustomerList();
		return new ResponseEntity<>(customers,HttpStatus.OK);
	}
	@PostMapping
	public ResponseEntity<?> addCustomer(@RequestBody @Valid CustomerRequest cust,BindingResult br){
		if(br.hasErrors()) {
			Map<String , Object> err = new LinkedHashMap<>();
			err.put("status", 400);
			err.put("error", "Bad Request");
			err.put("message", "validation faild");
			err.put("fieldError", br.getFieldErrors().stream().map(fe->Map.of("field",fe.getField(),
					"message",fe.getDefaultMessage(),
					"rejectedValue",fe.getRejectedValue())).toList());
			return ResponseEntity.badRequest().body(err);
		}
		else {
			CustomerResponse response = custService.save(cust);
			return new ResponseEntity<>(response,HttpStatus.OK);
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<CustomerResponse> updateCustomer(@PathVariable Long id,@RequestBody CustomerRequest cust){
		CustomerResponse updatecust = custService.updateCustomer(id, cust);
		return new ResponseEntity<>(updatecust,HttpStatus.OK);
	}
	
	//เพิ่มเพื่อใช้view ในCilent
	@GetMapping("/{id}")
	public ResponseEntity<CustomerResponse> getCustomerById(@PathVariable Long id) {
	    CustomerResponse cust = custService.getCustomerById(id); // สร้าง method ใน service
	    return new ResponseEntity<>(cust, HttpStatus.OK);
	}
	
	
	@DeleteMapping("/{id}")
	public void deleteCustomer(@PathVariable Long id) {
		custService.deleteCustomerById(id);
	}
	

}