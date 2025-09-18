package com.example.gary.springboot_mall202504.service;

import java.util.List;

import com.example.gary.springboot_mall202504.dto.CreateOrderRequest;
import com.example.gary.springboot_mall202504.dto.OrderQueryParams;
import com.example.gary.springboot_mall202504.model.Order;

public interface OrderService {

	Integer createOrder(Integer userId,CreateOrderRequest createOrderRequest);
	
	Order getOrderById(Integer orderId);
	
	List<Order> getOrders(OrderQueryParams orderQueryParams);
	
	Integer countOrder(OrderQueryParams orderQueryParams);
}
