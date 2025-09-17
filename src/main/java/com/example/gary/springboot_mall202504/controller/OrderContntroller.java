package com.example.gary.springboot_mall202504.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.gary.springboot_mall202504.dto.CreateOrderRequest;
import com.example.gary.springboot_mall202504.model.Order;
import com.example.gary.springboot_mall202504.service.OrderService;

import jakarta.validation.Valid;

@RestController
public class OrderContntroller {

	@Autowired
	private OrderService orderService;
	
	
	@PostMapping("/users/{userId}/orders")
	public ResponseEntity<?> createOrder(@PathVariable Integer userId,
			@RequestBody @Valid CreateOrderRequest createOrderRequest
			){
	
		
		Integer orderId= orderService.createOrder(userId,createOrderRequest);
		
		Order order=orderService.getOrderById(orderId);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(order);
	}
	
}
