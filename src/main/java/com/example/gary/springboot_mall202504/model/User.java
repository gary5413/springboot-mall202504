package com.example.gary.springboot_mall202504.model;

import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class User {
	private Integer userId;
	private String email;
	private String password;
	private Date createdDate;
	private Date lastModifiedDate;
}
