package com.example.gary.springboot_mall202504.service;

import java.security.DigestException;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.web.server.ResponseStatusException;

import com.example.gary.springboot_mall202504.dao.UserDao;
import com.example.gary.springboot_mall202504.dto.UserLoginRequest;
import com.example.gary.springboot_mall202504.dto.UserRegisterRequest;
import com.example.gary.springboot_mall202504.model.User;

@Service
public class UserServiceImpl implements UserService {

	private final static org.slf4j.Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private UserDao userDao;

	@Override
	public Integer register(UserRegisterRequest userRegisterRequest) {
//		應該先檢查帳號是否重複
		User user = userDao.getUserByEmail(userRegisterRequest.getEmail());
		if (user != null) {
//			加上log紀錄
			log.warn("該email {} 已經被註冊", userRegisterRequest.getEmail());
//			不為null 代表有帳號 回傳400
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
//		使用MD5 Hash加密 生成雜湊值
		String hashedPassword = DigestUtils.md5DigestAsHex(userRegisterRequest.getPassword().getBytes());
		userRegisterRequest.setPassword(hashedPassword);
//		創建帳號
		return userDao.createUser(userRegisterRequest);
	}

	@Override
	public User getUserById(Integer userId) {
		return userDao.getUserById(userId);
	}

	@Override
	public User login(UserLoginRequest userLoginRequest) {
		User user = userDao.getUserByEmail(userLoginRequest.getEmail());
//		檢查User是否存在
		if (user == null) {
			log.warn("該 email {} 尚未註冊", userLoginRequest.getEmail());
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}

//		使用MD5 生成密碼雜湊值
		String hashedPassword = DigestUtils.md5DigestAsHex(userLoginRequest.getPassword().getBytes());
//		比較密碼
//		if (user.getPassword().equals(userLoginRequest.getPassword())) {
		if (user.getPassword().equals(hashedPassword)) {
			return user;
		} else {
			log.warn("email {} 該密碼不正確", userLoginRequest.getEmail());
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}

	}

}
