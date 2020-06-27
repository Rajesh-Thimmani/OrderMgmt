package com.example.orderservice.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="orders")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="order_id", unique = true)	
	private Long orderId;
	
	@Column(name="customer_name")
	private String customerName;

	@Column(name= "order_date")
	private Date orderDate;

	@Column(name="shipping_address")
	private String shippingAddress;

	@Column(name="total_amount")
	private Long totalAmount;
	

}
