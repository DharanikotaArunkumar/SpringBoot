package com.learnjava.springboot.logging.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.learnjava.springboot.logging.bean.Customer;
import com.learnjava.springboot.logging.service.CustomerService;

@RestController
public class HelloControlller {
	
	private static final Logger logger = LogManager.getLogger(HelloControlller.class);
	
	@Autowired
	CustomerService customerService;
	
	@GetMapping("/healthcheck")
	public String healthCheck() {
		logger.debug("Inside Health check method");
		return "Ok";
	}	
	
	
	@PostMapping("/savecustomer")
	public String saveCustomer(@RequestBody Customer customer) {	
		logger.debug("Inside save customer  method");
		logger.info ("Customer input "+customer);
		return customerService.saveCustomer(customer);
	}
	
	
	
}
