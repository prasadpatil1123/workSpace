package com.onkar.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.onkar.demo.model.User;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(UserNotFoundException.class)
	ResponseEntity<String>  userNotFoundHandler(Exception ex){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User Not Found Occurred: "+ex.getMessage());
	}
	
	@ExceptionHandler(InvalidCredentialsException.class)
	ResponseEntity<String>  invalidCredHandler(Exception ex){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Cred Occurred: "+ex.getMessage());
	}
	
	@ExceptionHandler(Exception.class)
	ResponseEntity<String>  genericExceptionHandler(Exception ex){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Generic Exception Occurred: "+ex.getMessage());
	}

}
