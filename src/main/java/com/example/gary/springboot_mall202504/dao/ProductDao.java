package com.example.gary.springboot_mall202504.dao;

import com.example.gary.springboot_mall202504.model.Product;

public interface ProductDao {
  Product getProductById(Integer productId);
}
