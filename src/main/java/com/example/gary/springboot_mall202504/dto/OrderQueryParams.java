package com.example.gary.springboot_mall202504.dto;

import lombok.Data;

@Data
public class OrderQueryParams {
	private Integer userId;
	private Integer limit;
	private Integer offset;
}
