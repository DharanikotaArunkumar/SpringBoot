package com.example.demo.bean;

import java.io.Serializable;

/**
 * @author Dhara
 *
 */
public class Customer implements Serializable{
	
	private String name;
	private String password;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Customer [name=" + name + ", password=" + password + "]";
	}
	
	
	
	
	
	
	

}
