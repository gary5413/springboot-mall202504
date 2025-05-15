package com.example.gary.springboot_mall202504.model;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.example.gary.springboot_mall202504.constant.ProductCategory;

@Component
public class Product {
  private Integer productId;
  private String productName;
//  private String category;
//  改寫成Eumn類型
  private ProductCategory category;
  private String imageUrl;
  private Integer price;
  private Integer stock;
  private String description;
  private Date createDate;
  private Date lastModifiedDate;
  

    public Product(Integer productId,String productName,ProductCategory category,String imageUrl,String description,
      Integer price,Integer stock,Date createDate,Date lastModifiedDate){
        this.productId=productId;
        this.productName=productName;
        this.category=category;
        this.imageUrl=imageUrl;
        this.price=price;
        this.stock=stock;
        this.description=description;
        this.createDate=createDate;
        this.lastModifiedDate=lastModifiedDate;
      }

    public Product(){

    }


    /**
     * @return Integer return the productId
     */
    public Integer getProductId() {
        return productId;
    }

    /**
     * @param productId the productId to set
     */
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    /**
     * @return String return the productName
     */
    public String getProductName() {
        return productName;
    }

    /**
     * @param productName the productName to set
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * @return String return the category
     */
    public ProductCategory getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    /**
     * @return String return the imageUrl
     */
    public String getImageUrl() {
        return imageUrl;
    }

    /**
     * @param imageUrl the imageUrl to set
     */
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    /**
     * @return Integer return the price
     */
    public Integer getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(Integer price) {
        this.price = price;
    }

    /**
     * @return Integer return the stock
     */
    public Integer getStock() {
        return stock;
    }

    /**
     * @param stock the stock to set
     */
    public void setStock(Integer stock) {
        this.stock = stock;
    }

    /**
     * @return String return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return Date return the createDate
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * @param createDate the createDate to set
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * @return Date return the lastModifiedDate
     */
    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    /**
     * @param lastModifiedDate the lastModifiedDate to set
     */
    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

}
