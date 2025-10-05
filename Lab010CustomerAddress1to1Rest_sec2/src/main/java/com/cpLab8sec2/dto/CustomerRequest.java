package com.cpLab8sec2.dto;

import com.cpLab8sec2.entity.Address;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;

public class CustomerRequest {
	@NotBlank(message = "customerName must not be blank")
	@JsonProperty("customerName")
	private String name;
	@NotBlank(message = "Email must not be blank")
	@Email(message = "Email must be valid")
	private String email;
	
	private AddressRequest address;
	
	public AddressRequest getAddress() {
		return address;
	}
	public void setAddress(AddressRequest address) {
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}	
}
