package com.order.item.service.exceptionhandler;

/**
 * 
 * @author Rajesh
 *
 */

public class OrderItemNotFound extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6614416909854333833L;

	
	public OrderItemNotFound() {
	}

	public OrderItemNotFound(String message) {
		super(message);
	}
}
