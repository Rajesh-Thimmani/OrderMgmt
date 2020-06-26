
package com.order.item.service.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
@Table(name = "orders")
@JsonIgnoreProperties("{orderItem}")
public class Order implements Serializable {

	/**
	* 
	*/
	private static final long serialVersionUID = -1856504767521107736L;

	@Id

	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "customer_name")
	private String customerName;

	@Column(name = "order_date")
	private Date orderDate;

	@Column(name = "shipping_address")
	private String shippingAddress;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "order_id")
	private Set<OrderItem> orderItems = new HashSet<>();

	@Column(name = "total_amount")
	private Long totalAmount;

	public Order() {

	}
}

