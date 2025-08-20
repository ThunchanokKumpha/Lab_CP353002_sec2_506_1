package com.customerapp.service;

public class CustomerNotFoundException extends RuntimeException{

	public CustomerNotFoundException(Long id) {
		super("Could not find customer " + id);
	}
}
