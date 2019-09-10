package com.learnjava.springboot.rest.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.learnjava.springboot.rest.validation.StringValidation;

@RestController
@Validated
public class GetCapitialCityController {
	
	@GetMapping(value = "/healthcheck")
	public String healthCheck() {
		return "Ok";
	}
	
	@GetMapping(value = "/getcapital")
	public String getCapitalCity(@RequestParam @StringValidation String country) {
		System.out.println(country);
		return country;
	}

}
