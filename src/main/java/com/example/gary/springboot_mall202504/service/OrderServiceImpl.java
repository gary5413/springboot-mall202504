package com.example.gary.springboot_mall202504.service;

import java.lang.System.Logger;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.example.gary.springboot_mall202504.dao.OrderDao;
import com.example.gary.springboot_mall202504.dao.ProductDao;
import com.example.gary.springboot_mall202504.dao.UserDao;
import com.example.gary.springboot_mall202504.dto.BuyItem;
import com.example.gary.springboot_mall202504.dto.CreateOrderRequest;
import com.example.gary.springboot_mall202504.model.Order;
import com.example.gary.springboot_mall202504.model.OrderItem;
import com.example.gary.springboot_mall202504.model.Product;
import com.example.gary.springboot_mall202504.model.User;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDao orderDao;

	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private UserDao userDao;
	
	private final static org.slf4j.Logger log = LoggerFactory.getLogger(OrderServiceImpl.class);
	
	@Transactional
	@Override
	public Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest) {
		
//		檢查 user 是否存在
		User user=userDao.getUserById(userId);
		if(user==null) {
			log.warn("該userId {} 不存在",userId);
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		
		
		
		
		
		int totalAmount=0;
		List<OrderItem> orderItemList =new ArrayList<OrderItem>();
		for(BuyItem buyItem:createOrderRequest.getBuyItemList()) {
		
			Product product=productDao.getProductById(buyItem.getProductId());
//			檢查 product是否存在 庫存是否足夠
			if(product ==null) {
				log.warn("商品 {} 不存在",buyItem.getProductId());
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
			}else if(product.getStock() <buyItem.getProductId()) {
				log.warn("商品 {} 庫存數量不足,無法購買 剩餘庫存 {},欲購買數量 {}",
						buyItem.getProductId(),product.getStock(),buyItem.getQuantity());
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
			}
//			扣除商品庫存
			productDao.updateStock(product.getProductId(),product.getStock()-buyItem.getQuantity());
			
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
