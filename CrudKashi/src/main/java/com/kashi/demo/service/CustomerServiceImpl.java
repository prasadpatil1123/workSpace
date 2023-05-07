package com.kashi.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kashi.demo.dao.CustomerDao;
import com.kashi.demo.model.Customer;

@Service
@Transactional 
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	CustomerDao customerDao;
	
	@Override
	public Customer createCustomer(Customer cust) {
		return customerDao.save(cust);
	}

	@Override
	public Customer editCustomer(Customer cust) {
		Customer foundCust = customerDao.findById(cust.getId()).orElseThrow(()-> new RuntimeException("User not found!"));
		foundCust.setName(cust.getName());
		foundCust.setEmail(cust.getEmail());
		foundCust.setPassword(cust.getPassword());
		return customerDao.save(foundCust);
	}

	@Override
	public Customer deleteCustomer(int id) {
		// TODO Auto-generated method stub
		Customer foundCustomer = customerDao.findById(id).orElseThrow(()-> new RuntimeException("User not found!"));
		customerDao.deleteById(id);
		return foundCustomer;
	}

	@Override
	public List<Customer> getAllCustomer() {
		return customerDao.findAll();
	}


	@Override
	public Customer login(String email, String password) {
		return customerDao.findByEmailAndPassword(email, password).orElseThrow(()->new RuntimeException("Invalid Credentials! Please try again"));
	}

}
