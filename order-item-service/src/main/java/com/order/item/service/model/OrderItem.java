
package com.order.item.service.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
	
	@Column(name="order_item_id", unique = true)
	private Long orderItemId;

	@Column(name="order_id")
	private Long orderId;

	@Column(name="product_code")
	private String productCode;

	@Column(name="product_name")
	private String productName;

	@Column(name="quantity")
	private Integer quantity;
	
	public OrderItem() {

	}
}
