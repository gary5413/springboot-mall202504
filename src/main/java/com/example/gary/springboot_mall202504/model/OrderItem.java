package com.example.gary.springboot_mall202504.model;

import lombok.Data;

@Data
public class OrderItem {
	private Integer orderItemId;
	private Integer orderId;
	private Integer productId;
	private Integer quantity;
	private Integer amount;
}
