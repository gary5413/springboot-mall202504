package com.example.gary.springboot_mall202504.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.example.gary.springboot_mall202504.dto.UserRegisterRequest;
import com.example.gary.springboot_mall202504.model.User;
import com.example.gary.springboot_mall202504.rowmapper.UserRowMapper;

@Repository
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public Integer createUser(UserRegisterRequest userRegisterRequest) {
		String sql="INSERT INTO User(email,password,created_date,last_modified_date)"
				+ " VALUES (:email,:password,:createdDate,:lastModifiedDate)";
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("email", userRegisterRequest.getEmail());
		map.put("password", userRegisterRequest.getPassword());
		
		Date now = new Date();
		map.put("createdDate",now);
		map.put("lastModifiedDate", now);
		
		KeyHolder keyHolder=new GeneratedKeyHolder();
		namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(map),keyHolder);
		int userId=keyHolder.getKey().intValue();
		return userId;
	}

	@Override
	public User getUserById(Integer userId) {
		String sql="SELECT * FROM User WHERE user_id= :userId";
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("userId", userId);
		List<User> userList=namedParameterJdbcTemplate.query(sql,map, new UserRowMapper());
		if(userList.size()>0) {
			return userList.get(0);
		}else {
			return null;
		}
	}

	@Override
	public User getUserByEmail(String email) {
		String sql="SELECT * FROM user WHERE email = :email";
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("email", email);
		List<User> userList = namedParameterJdbcTemplate.query(sql, map, new UserRowMapper());
		if(userList.size()>0) {
			return userList.get(0);
		}else {
			return null;
		}
	}

	
	
	
	
}
