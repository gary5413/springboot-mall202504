package com.example.gary.springboot_mall202504.dto;

import com.example.gary.springboot_mall202504.constant.ProductCategory;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Data
public class ProductRequest {
  @NotNull
  private String productName;
  @NotNull
  private ProductCategory category;
  @NotNull
  private String imageUrl;
  @NotNull
  private Integer price;
  @NotNull
  private Integer stock;
  private String description;
}
