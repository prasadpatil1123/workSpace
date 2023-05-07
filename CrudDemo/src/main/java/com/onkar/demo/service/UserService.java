package com.onkar.demo.service;

import java.util.List;

import com.onkar.demo.model.User;

public interface UserService {
	//Login
	User validate(String email, String password);
	//Post
	User addUser(User user);
	//Put
	User editUser(User user);
	//Delete
	User deleteUser(long id);
	//Get
	List<User> getAllUsers();

}
