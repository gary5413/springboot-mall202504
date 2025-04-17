package com.example.gary.springboot_mall202504.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.example.gary.springboot_mall202504.model.Product;
import com.example.gary.springboot_mall202504.rowmapper.ProductRowMapper;

@Component
public class ProductDaoImpl implements ProductDao {

  @Autowired
  private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  @Override
  public Product getProductById(Integer productId) {
    String sql="SELECT * FROM product WHERE product_id =:productId";
    Map<String,Object> map= new HashMap<>();
    map.put("productId",productId);
    List<Product> productList= namedParameterJdbcTemplate.query(sql, map,new ProductRowMapper());
    if(productList.size()>0){
      return productList.get(0);
    }else {
      return null;
    }
  }

}
