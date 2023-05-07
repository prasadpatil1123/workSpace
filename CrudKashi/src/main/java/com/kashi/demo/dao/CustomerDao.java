package com.kashi.demo.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kashi.demo.model.Customer;

public interface CustomerDao extends JpaRepository<Customer, Integer> {
	Optional<Customer> findByEmailAndPassword(String email, String password);
}
