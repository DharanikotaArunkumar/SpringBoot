package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.Customer;
import com.example.demo.entity.CustomerEntity;
import com.example.demo.repository.CustomerRepository;

@Service
public class CustomerService {
	
	
	@Autowired
	CustomerRepository customerRepo;
	
	public String saveCustomer(Customer customer) {
		
		CustomerEntity entity = new CustomerEntity();
		entity.setUserName(customer.getName());
		entity.setPassword(customer.getPassword());
		
		CustomerEntity savedEntity = customerRepo.save(entity);
		
		return savedEntity.toString();
		
	}

}
