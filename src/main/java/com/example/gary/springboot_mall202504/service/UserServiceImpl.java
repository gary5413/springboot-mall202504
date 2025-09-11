package com.example.gary.springboot_mall202504.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gary.springboot_mall202504.dao.UserDao;
import com.example.gary.springboot_mall202504.dto.UserRegisterRequest;
import com.example.gary.springboot_mall202504.model.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

	@Override
	public Integer register(UserRegisterRequest userRegisterRequest) {
		return userDao.createUser(userRegisterRequest);
	}

	@Override
	public User getUserById(Integer userId) {
		return userDao.getUserById(userId);
	}
	
}
