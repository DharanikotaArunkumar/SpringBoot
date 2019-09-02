package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.Customer;
import com.example.demo.service.CustomerService;

@RestController
public class HelloControlller {
	
	
	@Autowired
	CustomerService customerService;
	
	@GetMapping("/healthcheck")
	public String healthCheck() {
		return "Ok";
	}	
	
	
	@PostMapping("/savecustomer")
	public String saveCustomer(@RequestBody Customer customer) {		
		return customerService.saveCustomer(customer);
	}
	
	
	
}
