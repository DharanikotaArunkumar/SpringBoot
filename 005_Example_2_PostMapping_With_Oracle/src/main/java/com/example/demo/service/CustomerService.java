package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.Customer;
import com.example.demo.entity.CustomerEntity;
import com.example.demo.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository customerRepo;

	public String saveCustomer(Customer customer, Boolean islocked,int failedAtt) {

		CustomerEntity entity = new CustomerEntity();

		
		entity.setFirstName(customer.getFirstName());
		entity.setLastName(customer.getLastName());
		entity.setEmail(customer.getEmail());
		entity.setPassword(customer.getPassword());
		entity.setIsAccountLocked(islocked);
		entity.setNoOfInvalidAtt(failedAtt);

		CustomerEntity savedEntity = customerRepo.save(entity);

		return savedEntity.toString();

	}

	public Customer fetchCustomer(Integer customerid) {

		CustomerEntity entity = customerRepo.getOne(customerid);

		Customer customer = new Customer();

		customer.setFirstName(entity.getFirstName());
		customer.setLastName(entity.getLastName());
		customer.setEmail(entity.getEmail());
		customer.setPassword(entity.getPassword());

		return customer;
	}

	public String fetchCustomerByEmail(Customer customer) {
		 List<CustomerEntity> customerList = customerRepo.findAll();
		 
		for(CustomerEntity entity :customerList) {
			if( entity.getEmail().equals(customer.getEmail()) && entity.getIsAccountLocked()) {
				return "Account Locked, Please Reset your account";
			}else if(entity.getEmail().equals(customer.getEmail()) && entity.getPassword().equals(customer.getPassword())){
				
				entity.setNoOfInvalidAtt(0);
				customerRepo.save(entity);
				
				
				return " Login successfully";				
			}else if (entity.getEmail().equals(customer.getEmail())) {
				String result = "login failed";
				Integer noOfInvalidAtt = entity.getNoOfInvalidAtt();
				if(noOfInvalidAtt<3) {
					noOfInvalidAtt =noOfInvalidAtt+1;
				}
				if(noOfInvalidAtt==3){
					entity.setIsAccountLocked(Boolean.TRUE);
				}
				entity.setNoOfInvalidAtt(noOfInvalidAtt);				
				customerRepo.save(entity);
				if(noOfInvalidAtt ==3) {
					return "Maximum attmpts reached ,Account Loccked";
				}
				return result;
				
			}
		}
		return "invalid Attempt";
		
	}	
		public String unlockByEmail(Customer customer) {
			 List<CustomerEntity> customerList = customerRepo.findAll();
			 
			for(CustomerEntity entity :customerList) {
				if( entity.getEmail().equals(customer.getEmail()) && entity.getIsAccountLocked()) {
					entity.setNoOfInvalidAtt(0);
					entity.setIsAccountLocked(false);
					customerRepo.save(entity);
					return " Account Unlocked successfully";
					
				}else if(entity.getEmail().equals(customer.getEmail()) && !entity.getIsAccountLocked()) {					
					return "account is not locked";
					
				}else {
					return " email does not exist";
				}
			}
		
		 return "un lock operation Failed";
		
	}

}
