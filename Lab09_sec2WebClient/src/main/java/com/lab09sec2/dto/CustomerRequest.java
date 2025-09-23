package com.lab09sec2.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CustomerRequest {
  @NotNull(message="Name must not be null")
  @NotBlank(message = "Name must not be blank")
  @JsonProperty("customerName")
  String name;
  @Email(message = "Emial must be valid")
  String email;
  
  public String getName() { return this.name;}
  public String getEmail() { return this.email;}
  public void setName(String name) {
	  this.name=name;
  }
  public void setEmail(String email) {
	  this.email=email;
  }
}
