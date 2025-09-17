package com.example.gary.springboot_mall202504.dto;

import java.util.List;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class CreateOrderRequest {
	
	@NotEmpty
	private List<BuyItem> buyItemList;
	
}
