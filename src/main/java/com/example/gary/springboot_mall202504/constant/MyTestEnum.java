package com.example.gary.springboot_mall202504.constant;

public class MyTestEnum {
  public static void main(String[] args) {
    ProductCategory category=ProductCategory.FOOD;
    String s=category.name();
    System.out.println(s); //FOOD

    String s2="CAR";
    ProductCategory category2=ProductCategory.valueOf(s2);
    

  }
}
