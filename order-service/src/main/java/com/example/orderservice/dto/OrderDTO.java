package com.example.orderservice.dto;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import lombok.Data;

@Data
public class OrderDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 668447754209158602L;

	private Long id;

	private Long orderId;
	
	private String customerName;

	private Date orderDate;

	private String shippingAddress;

	private Long totalAmount;
	
	private List<OrderItemDTO> orderItemDTOs;

}
