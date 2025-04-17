package com.example.gary.springboot_mall202504.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.gary.springboot_mall202504.model.Product;

@SpringBootTest
class ProductDaoImplTest {
	
	@Autowired
	private ProductDao productDao;
	
	@Test
	public void testGetProduct() {
		Product product = productDao.getProductById(1);
		System.out.println(product);
		assertNotNull(product);
	}
}
