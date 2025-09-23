package com.lab09sec2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;


import com.lab09sec2.dto.CustomerRequest;
import com.lab09sec2.dto.CustomerResponse;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class WebClientCustomerService {
	@Autowired
	 private final WebClient webClient;
	 @Autowired
	 public WebClientCustomerService(WebClient webClient) {
	        this.webClient = webClient;
	 }
	 public Flux<CustomerResponse> getCustomers(){
		return  webClient.get()
		 .uri("")
		 .retrieve()
         .bodyToFlux(CustomerResponse.class) ;
	 }
	 
	 public Mono<CustomerResponse> getCustomerById(long id) {
	        return webClient.get() //GetMapping
	                .uri("/{id}", id)
	                .retrieve()
	                .bodyToMono(CustomerResponse.class);
	    }
	 public Mono<CustomerResponse> createCustomer(CustomerRequest custRequest) {

		    return webClient.post() //PostMapping
		            .uri("")
		            .body(Mono.just(custRequest), CustomerRequest.class)
		            .retrieve()
		            .onStatus(HttpStatusCode::is4xxClientError, clientResponse -> 
		                Mono.error(
		                		new RuntimeException("Client error during createAuthor")))
		            .onStatus(HttpStatusCode::is5xxServerError, clientResponse -> 
		                Mono.error(new RuntimeException("Server error during createAuthor")))
		            .bodyToMono(CustomerResponse.class)
		            .doOnNext(response ->
		                  System.out.println("Response received: " + response))
		            .doOnError(error ->
		                   System.out.println("Error occurred: " + error.getMessage()));
		}


	 	public Mono<CustomerResponse> updateCustomer(long id, CustomerRequest custRequest) {
		    return webClient.put()
		            .uri("/{id}", id)
		            .bodyValue(custRequest)
		            .retrieve()
		            .bodyToMono(CustomerResponse.class);
		}
	   
	    public Mono<Void> deleteCustomerById(long id) {
	    	//System.out.println("deleting an author having id ="+id);
	        return webClient.delete()
	                .uri("/{id}", id)
	                .retrieve()
	                .bodyToMono(Void.class);
	    }
	    
	    
	    public Mono<CustomerResponse> addCustomer(CustomerRequest request) {
	        return webClient.post()
	            .uri("")   // ต้องตรงกับ REST API ของ Lab08
	            .bodyValue(request)
	            .retrieve()
	            .bodyToMono(CustomerResponse.class);
	    }



}
