package com.order.item.service.exceptionhandler;

import com.order.item.service.model.ErrorDetails;

/**
 * 
 * @author Rajesh
 *
 */

public class OrderItemNotFound extends BaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6614416909854333833L;

	
	public OrderItemNotFound() {
	}

	public OrderItemNotFound(String message) {
		super(message);
	}

	public OrderItemNotFound(Throwable cause) {
		super(cause);
	}

	public OrderItemNotFound(String message, Throwable cause) {
		super(message, cause);
	}

	public OrderItemNotFound(ErrorDetails errorDetail) {
		super(errorDetail);
		
	}

}
