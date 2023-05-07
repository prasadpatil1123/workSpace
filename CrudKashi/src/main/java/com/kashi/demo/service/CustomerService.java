package com.kashi.demo.service;

import java.util.List;

import com.kashi.demo.model.Customer;

public interface CustomerService {
	
	// All methods Are declare in service interface and defined in implimentaion Class.. 
	//post => register the customer
	 Customer createCustomer(Customer cust);
	 
	 // POST => Login Method
	 Customer login(String email,String password);
	 
	 //GET => read-getAll
	 List<Customer> getAllCustomer();
	 
	 //PUT => edit users credential
	 Customer editCustomer(Customer cust);
	 
	 //delete => delete user
	 Customer deleteCustomer(int id);
	 
	
	 
	 
}
