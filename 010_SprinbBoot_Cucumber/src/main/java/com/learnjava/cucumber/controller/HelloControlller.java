package com.learnjava.cucumber.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.learnjava.cucumber.bean.Customer;
import com.learnjava.cucumber.entity.CustomerEntity;
import com.learnjava.cucumber.service.CustomerService;

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
	

	@GetMapping("/getcust")
	public CustomerEntity getCust(@RequestParam Integer id) {
		System.out.println("id value "+id);
		CustomerEntity customerEntity = customerService.getCustomer(id);
		return  customerEntity;
	}
	
	
	
	
}
