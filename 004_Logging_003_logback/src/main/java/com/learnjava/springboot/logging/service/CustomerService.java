package com.learnjava.springboot.logging.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learnjava.springboot.logging.bean.Customer;
import com.learnjava.springboot.logging.entity.CustomerEntity;
import com.learnjava.springboot.logging.repository.CustomerRepository;

@Service
public class CustomerService {
	
	private static final Logger logger = LogManager.getLogger(CustomerService.class);
	
	@Autowired
	CustomerRepository customerRepo;
	
	public String saveCustomer(Customer customer) {
		
		logger.info("Starting saveCustomer ");
		
		CustomerEntity entity = new CustomerEntity();
		entity.setUserName(customer.getName());
		entity.setPassword(customer.getPassword());
		
		CustomerEntity savedEntity = customerRepo.save(entity);
		
		logger.info("ended saveCustomer ");
		
		return savedEntity.toString();
		
	}

}
