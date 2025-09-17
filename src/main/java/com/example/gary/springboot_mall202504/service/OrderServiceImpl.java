package com.example.gary.springboot_mall202504.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.gary.springboot_mall202504.dao.OrderDao;
import com.example.gary.springboot_mall202504.dao.ProductDao;
import com.example.gary.springboot_mall202504.dto.BuyItem;
import com.example.gary.springboot_mall202504.dto.CreateOrderRequest;
import com.example.gary.springboot_mall202504.model.Order;
import com.example.gary.springboot_mall202504.model.OrderItem;
import com.example.gary.springboot_mall202504.model.Product;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDao orderDao;

	@Autowired
	private ProductDao productDao;
	
	@Transactional
	@Override
	public Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest) {
		
		int totalAmount=0;
		List<OrderItem> orderItemList =new ArrayList<OrderItem>();
		for(BuyItem buyItem:createOrderRequest.getBuyItemList()) {
		
			Product product=productDao.getProductById(buyItem.getProductId());
			
//			計算總價
			int amount=buyItem.getQuantity()*product.getPrice();
			totalAmount+=amount;
			
//			轉換 BuyItem to OrderItem
			OrderItem orderItem=new OrderItem();
			orderItem.setProductId(buyItem.getProductId());
			orderItem.setQuantity(buyItem.getQuantity());
			orderItem.setAmount(amount);
			
			orderItemList.add(orderItem);
			}
		
		
//		創建訂單
		Integer orderId = orderDao.createOrder(userId,totalAmount);
		
//		創建訂單明細
		orderDao.createOrderItem(orderId,orderItemList);
		
		return orderId;
		
	}

	@Override
	public Order getOrderById(Integer orderId) {
		Order order=orderDao.getOrderById(orderId);
		List<OrderItem> orderItemList=orderDao.getOrderItemByOrderId(orderId);
		order.setOrderList(orderItemList);
		return order;
	}

	

}
