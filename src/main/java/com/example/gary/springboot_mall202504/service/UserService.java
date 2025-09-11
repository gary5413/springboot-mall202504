package com.example.gary.springboot_mall202504.service;

import com.example.gary.springboot_mall202504.dto.UserRegisterRequest;
import com.example.gary.springboot_mall202504.model.User;

public interface UserService {
	
	Integer register(UserRegisterRequest userRegisterRequest);
	User getUserById(Integer userId);
}
