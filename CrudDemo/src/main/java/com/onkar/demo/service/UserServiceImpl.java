package com.onkar.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onkar.demo.dao.UserDao;
import com.onkar.demo.exception.InvalidCredentialsException;
import com.onkar.demo.exception.UserNotFoundException;
import com.onkar.demo.model.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDao userDao;

	@Override
	public User validate(String email, String password) {
		return userDao.findByEmailAndPassword(email, password).orElseThrow(()-> new InvalidCredentialsException("Wrong Email or Password"));
	}

	@Override
	public User addUser(User user) {
		// TODO Auto-generated method stub
		return userDao.save(user);
	}

	@Override
	public User editUser(User user) {
		// TODO Auto-generated method stub
		User foundUser = userDao.findById(user.getId()).orElseThrow(()->new UserNotFoundException("User with given id does not exists!"));
		
		return foundUser;
	}

	@Override
	public User deleteUser(long id) {
		// TODO Auto-generated method stub
		User user = userDao.findById(id).orElseThrow(()->new UserNotFoundException("User with given id does not exists!"));
		return user;
	}

	@Override
	public List<User> getAllUsers() {
		return userDao.findAll();
	}

}
