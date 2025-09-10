package com.example.gary.springboot_mall202504.dto;

import com.example.gary.springboot_mall202504.constant.ProductCategory;

import lombok.Data;

@Data
public class ProductQueryParams {
	private ProductCategory category;
	private String search;
	private String orderBy;
	private String sort;
	private Integer limit;
	private Integer offset;
}
