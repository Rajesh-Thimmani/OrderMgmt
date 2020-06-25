
package com.example.orderservice.model;

import java.io.Serializable;

/**
 * 
 * @author Rajesh
 *
 */

public class OrderItem implements Serializable {

	/**
	* 
	*/
	private static final long serialVersionUID = -8163966602582846025L;

	private Long id;

	private String productCode;

	private String productName;

	private Integer quantity;

	private Order order;

	public OrderItem() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "[productCode :: " + this.productCode + "product name :: " + this.productName + "]";
	}

}
