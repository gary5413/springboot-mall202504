package com.example.gary.springboot_mall202504.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.gary.springboot_mall202504.constant.ProductCategory;
import com.example.gary.springboot_mall202504.model.Product;

public class ProductRowMapper implements RowMapper<Product> {
  

    @Override
    public Product mapRow(ResultSet rs, int rowNum) throws SQLException   {
      Product product= new Product();
      product.setProductId(rs.getInt("product_id"));;
      product.setProductName(rs.getString("product_name"));
      
//      product.setCategory(productCategory);
//      改成Enum類型 並轉型
      String categoryStr=rs.getString("category");
      ProductCategory productCategory=ProductCategory.valueOf(categoryStr);
      product.setCategory(productCategory);
      
      product.setImageUrl(rs.getString("image_url"));
      product.setPrice(rs.getInt("price"));
      product.setStock(rs.getInt("stock"));
      product.setDescription(rs.getString("description"));
      product.setCreateDate(rs.getTimestamp("created_date"));
      product.setLastModifiedDate(rs.getTimestamp("last_modified_date"));
      return product;
    }

    
}
