package com.example.demo.service;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
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
	
	@Cacheable(value="customerCache", key="#customerId")
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
