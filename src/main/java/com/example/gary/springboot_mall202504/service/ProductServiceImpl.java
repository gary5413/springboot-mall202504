package com.example.gary.springboot_mall202504.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.gary.springboot_mall202504.constant.ProductCategory;
import com.example.gary.springboot_mall202504.dao.ProductDao;
import com.example.gary.springboot_mall202504.dto.ProductRequest;
import com.example.gary.springboot_mall202504.model.Product;

@Component
public class ProductServiceImpl implements ProductService {

  @Autowired
  private ProductDao productDao;

  
  
  
  @Override
  public Product getProductById(Integer productId) {
    return  productDao.getProductById(productId);
  }

@Override
public Integer createProduct(ProductRequest productRequest) {
	
	
	
	return productDao.createProduct(productRequest);
}

@Override
public void updateProduct(Integer productId, ProductRequest productRequest) {
	productDao.updateProduct(productId,productRequest);
}

@Override
public void deleteProductById(Integer productId) {
	productDao.deleteProductById(productId);
}

@Override
public List<Product> getProducts(ProductCategory productCategory,String search) {
	
	return productDao.getProducts(productCategory,search);
}

}
