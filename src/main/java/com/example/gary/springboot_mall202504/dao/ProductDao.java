package com.example.gary.springboot_mall202504.dao;

import java.util.List;

import com.example.gary.springboot_mall202504.constant.ProductCategory;
import com.example.gary.springboot_mall202504.dto.ProductQueryParams;
import com.example.gary.springboot_mall202504.dto.ProductRequest;
import com.example.gary.springboot_mall202504.model.Product;

public interface ProductDao {
	List<Product> getProducts(ProductCategory productCategory,String search);
	List<Product> getProducts(ProductQueryParams productQueryParams);

	Product getProductById(Integer productId);

	Integer createProduct(ProductRequest productRequest);

	void updateProduct(Integer productId, ProductRequest productRequest);

	void deleteProductById(Integer productId);
	
	Integer countProduct(ProductQueryParams productQueryParams);
}
