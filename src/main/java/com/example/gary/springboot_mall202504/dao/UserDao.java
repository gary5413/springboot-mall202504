package com.example.gary.springboot_mall202504.dao;

import com.example.gary.springboot_mall202504.dto.UserRegisterRequest;
import com.example.gary.springboot_mall202504.model.User;

public interface UserDao {
	
	User getUserByEmail(String email);
	Integer createUser(UserRegisterRequest userRegisterRequest);
	User getUserById(Integer userId);
}
