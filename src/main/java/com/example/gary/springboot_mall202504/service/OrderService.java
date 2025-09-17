package com.example.gary.springboot_mall202504.service;

import com.example.gary.springboot_mall202504.dto.CreateOrderRequest;

public interface OrderService {

	Integer createOrder(Integer userId,CreateOrderRequest createOrderRequest);
}
