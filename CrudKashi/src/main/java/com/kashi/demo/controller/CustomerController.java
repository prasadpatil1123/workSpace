package com.kashi.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kashi.demo.model.Customer;
import com.kashi.demo.service.CustomerService;

@RestController
public class CustomerController {
	@Autowired
	CustomerService customerService;
	
	@PostMapping("/register")
	public Customer register(Customer customer){
		return customerService.createCustomer(customer);
//		return ResponseEntity.status(HttpStatus.ACCEPTED).body(savedCustomer);
	}
	
//	@PostMapping("/register")
//	public ResponseEntity<Customer> register(Customer customer){
//		return customerService.createCustomer(customer);
//		return ResponseEntity.status(HttpStatus.ACCEPTED).body(savedCustomer);
//	}
	
	@PostMapping("/login")
	public Customer login(@RequestParam String email,@RequestParam String password) {
		return customerService.login(email, password);
	}
	

}
