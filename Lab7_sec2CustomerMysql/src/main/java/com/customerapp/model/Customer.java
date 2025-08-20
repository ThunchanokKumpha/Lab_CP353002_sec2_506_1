package com.customerapp.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="customer")
public class Customer {
		
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column
	private String name;
	public Customer() {
		this.name = name;
	}
	
	public Customer(Long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public long getId() {
		return this.id;
	}
	
	@JsonProperty("customerName")
	public String getName() {
		return this.name;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	@JsonProperty("customerName")
	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		return id+" : "+name;
	}
	

}
