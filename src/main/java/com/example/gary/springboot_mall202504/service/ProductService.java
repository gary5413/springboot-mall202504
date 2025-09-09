package com.example.gary.springboot_mall202504.service;

import java.util.List;

import com.example.gary.springboot_mall202504.dto.ProductRequest;
import com.example.gary.springboot_mall202504.model.Product;

public interface ProductService {
	
List<Product> getProducts();
	
  Product getProductById(Integer productId);
  
  Integer createProduct(ProductRequest productRequest);
  
  void updateProduct(Integer productId,ProductRequest productRequest);
  
  void deleteProductById(Integer productId);
}
