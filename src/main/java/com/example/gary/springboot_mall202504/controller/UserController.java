package com.example.gary.springboot_mall202504.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.gary.springboot_mall202504.dto.UserRegisterRequest;
import com.example.gary.springboot_mall202504.model.User;
import com.example.gary.springboot_mall202504.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/users/register")
	public ResponseEntity<User> register(
			@RequestBody UserRegisterRequest userRegisterRequest){
		Integer userId= userService.register(userRegisterRequest);
		User user=userService.getUserById(userId);
		return ResponseEntity.status(HttpStatus.CREATED).body(user);
	}
	
}
