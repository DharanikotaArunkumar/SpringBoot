package com.learnjava.cucumber.service;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learnjava.cucumber.bean.Customer;
import com.learnjava.cucumber.entity.CustomerEntity;
import com.learnjava.cucumber.repository.CustomerRepository;

@Service
public class CustomerService {
	
	
	@Autowired
	CustomerRepository customerRepo;
	
	
	public String saveCustomer(Customer customer) {
		System.out.println("Inside ");
		
		CustomerEntity entity = new CustomerEntity();
		entity.setUserName(customer.getName());
		entity.setPassword(customer.getPassword());
		
		CustomerEntity savedEntity = customerRepo.save(entity);
		System.out.println(savedEntity);
		return savedEntity.toString();
		
	}
	
	
	public CustomerEntity getCustomer(Integer customerId) {
		
		System.out.println("Inside ");
		
		Optional<CustomerEntity> findById = customerRepo.findById(customerId);
		
		if(findById.isPresent()) {
			return findById.get();
		}else {
		return 	null;
		}
		
	}
	

}
