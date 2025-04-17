package com.example.gary.springboot_mall202504.controller;

import com.example.gary.springboot_mall202504.model.Product;
import com.example.gary.springboot_mall202504.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;





@RestController
public class ProductController {

  @Autowired
  private ProductService productService;
  
  @GetMapping("/products/{productId}")
  public ResponseEntity<Product> getProduct(@PathVariable Integer productId){
    Product product= productService.getProductById(productId);
    System.out.println(product);
    if(product !=null){
      return ResponseEntity.status(HttpStatus.OK).body(product);
    }else{
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
  }
  

}
