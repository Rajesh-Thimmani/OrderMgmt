package com.order.item.service.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class OrderItemDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3812220971701712679L;

	private Long id;

	private Long orderItemId;

	private Long orderId;

	private String productCode;

	private String productName;

	private Integer quantity;
	
	public OrderItemDTO() {
		
	}

}
