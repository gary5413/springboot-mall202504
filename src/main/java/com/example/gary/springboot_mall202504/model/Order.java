package com.example.gary.springboot_mall202504.model;

import java.util.Date;

import lombok.Data;

@Data
public class Order {
	private Integer orderId;
	private Integer userId;
	private Integer totalAmount;
	private Date createDate;
	private Date lastModifedDate;
}
