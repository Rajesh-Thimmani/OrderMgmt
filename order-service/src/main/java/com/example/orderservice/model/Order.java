
package com.example.orderservice.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

/**
 * 
 * @author Rajesh
 *
 */

public class Order implements Serializable {

	private static final long serialVersionUID = -1856504767521107736L;

	private Long id;

	private String customerName;

	private Date orderDate;

	private String shippingAddress;

	private Set<OrderItem> orderItem;

	private Long totalAmount;

	public Order() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public Set<OrderItem> getOrderItem() {
		return orderItem;
	}

	public void setOrderItem(Set<OrderItem> orderItem) {
		this.orderItem = orderItem;
	}

	public Long getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Long totalAmount) {
		this.totalAmount = totalAmount;
	}

}
