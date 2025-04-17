package com.example.gary.springboot_mall202504.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.gary.springboot_mall202504.dao.ProductDao;
import com.example.gary.springboot_mall202504.model.Product;

@Component
public class ProductServiceImpl implements ProductService {

  @Autowired
  private ProductDao productDao;

  @Override
  public Product getProductById(Integer productId) {
    return  productDao.getProductById(productId);
  }

}
