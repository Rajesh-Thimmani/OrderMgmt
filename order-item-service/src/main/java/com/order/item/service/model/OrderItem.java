
package com.order.item.service.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

/**
 * 
 * @author Rajesh
 *
 */

@Data
@Entity
@Table(name = "Order_Item")

public class OrderItem implements Serializable {

	/**
	* 
	*/
	private static final long serialVersionUID = -8163966602582846025L;

	@Id

	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "product_code", nullable = false)
	private String productCode;

	@Column(name = "product_name", nullable = false)
	private String productName;
	
	@Column(name = "quantity", nullable = false)
	private Integer quantity;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "order_id", nullable = false)
	@JsonIgnore  
	private Order order;

	public OrderItem() {

	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
	
	

}
