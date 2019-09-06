package com.learnjava.springboot.logging.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learnjava.springboot.logging.bean.Customer;
import com.learnjava.springboot.logging.entity.CustomerEntity;
import com.learnjava.springboot.logging.repository.CustomerRepository;

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
