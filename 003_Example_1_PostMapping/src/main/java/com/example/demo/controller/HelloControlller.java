package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.Customer;

@RestController
public class HelloControlller {
	
	@GetMapping("/healthcheck")
	public String healthCheck() {
		return "Ok";
	}	
	
	
	@PostMapping("/savecustomer")
	public String saveCustomer(@RequestBody Customer customer) {		
		System.out.println(customer.toString());
		return "Customer is saved" +customer.toString();
	}
	
	
	
}
