package com.example.orderservice.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class OrderItemDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6031381252712963931L;
	
	private Long id;
	
	private Long orderItemId;
	
	private Long orderId;
	
	private String productCode;

	private String productName;

	private Integer quantity;
}
