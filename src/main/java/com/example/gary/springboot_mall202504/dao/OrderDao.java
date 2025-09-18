package com.example.gary.springboot_mall202504.dao;

import java.util.List;

import com.example.gary.springboot_mall202504.dto.OrderQueryParams;
import com.example.gary.springboot_mall202504.model.Order;
import com.example.gary.springboot_mall202504.model.OrderItem;

public interface OrderDao {

	Integer createOrder(Integer userId,Integer totalAmount);
	
	void createOrderItem(Integer orderId,List<OrderItem> orderItemList);
	
	Order getOrderById(Integer orderId);
	
	List<OrderItem> getOrderItemByOrderId(Integer orderId);
	
	List<Order> getOrders(OrderQueryParams orderQueryParams);
	
	Integer countOrder(OrderQueryParams orderQueryParams);
	
	
}
