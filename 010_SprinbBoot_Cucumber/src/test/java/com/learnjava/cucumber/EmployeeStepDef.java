package com.learnjava.cucumber;

import org.springframework.beans.factory.annotation.Autowired;

import com.learnjava.cucumber.bean.Customer;
import com.learnjava.cucumber.service.CustomerService;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class EmployeeStepDef extends SpringIntegrationTest{
	
	@Autowired
	CustomerService customerService;
	
	
	
	@When("^the service request$")
	public void the_service_request() throws Throwable {
		Customer customer = new Customer();
		customer.setName("Arun");
		customer.setPassword("pass");		
		 String saveCustomer = customerService.saveCustomer(customer);
		System.out.println(saveCustomer);
	}

	@Then("^service request pass$")
	public void service_request_pass() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	}


	

	

}
