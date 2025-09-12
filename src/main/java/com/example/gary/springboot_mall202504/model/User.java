package com.example.gary.springboot_mall202504.model;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Component
@Data
public class User {
	private Integer userId;
//	@JsonProperty("e_mail")
	private String email;
	@JsonIgnore
	private String password;
	private Date createdDate;
	private Date lastModifiedDate;
}
