package com.order.item.service.exceptionhandler;

import com.order.item.service.model.ErrorDetails;
/**
 * 
 * @author Rajesh
 *
 */

public class OrderNotFoundException extends BaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6609806333495541623L;

	public OrderNotFoundException() {
	}

	public OrderNotFoundException(String message) {
		super(message);
	}

	public OrderNotFoundException(Throwable cause) {
		super(cause);
	}

	public OrderNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public OrderNotFoundException(ErrorDetails errorDetail) {
		super(errorDetail);
		
	}

}
