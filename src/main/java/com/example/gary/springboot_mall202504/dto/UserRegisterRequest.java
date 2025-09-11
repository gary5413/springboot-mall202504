package com.example.gary.springboot_mall202504.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserRegisterRequest {
	
	@NotBlank
	private String email;
	@NotBlank
	private String password;
}
