package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.Customer;
import com.example.demo.service.CustomerService;

@RestController
public class LoginControlller {
	
	
	@Autowired
	CustomerService customerService;
	
	@GetMapping("/healthcheck")
	public String healthCheck() {
		return "Ok";
	}	
	
	
	@PostMapping("/registercustomer")
	public String registerCustomer(@RequestBody Customer customer) {		
		return customerService.saveCustomer(customer,false,0);
	}
	
	
	@GetMapping("/getcustomer/{customerid}")
	public Customer getCustomer(@PathVariable Integer customerid) {
		System.out.println("Customer Id received from request"+customerid);		
		return customerService.fetchCustomer(customerid);
	}
	
	@PostMapping("/login")
	public String loginCustomer(@RequestBody Customer customer) {		
		
		return customerService.fetchCustomerByEmail(customer);
		
		
		
	}
	
	@PostMapping("/restpassword")
	public String resetCustomer(@RequestBody Customer customer) {
		
		//TO -DO
		return "HOME WORK - YET TO DO ";
		
		
		
	}
	
	@PostMapping("/unlockaccount")
	public String unlockCustomer(@RequestBody Customer customer) {
		
		return customerService.unlockByEmail(customer);
		
		
		
	}
	
	
	
	
}
