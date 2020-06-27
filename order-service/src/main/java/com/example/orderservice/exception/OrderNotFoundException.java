package com.example.orderservice.exception;

public class OrderNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5381100218400386662L;
	
	public OrderNotFoundException() {
		
	}
	
	public OrderNotFoundException(String message) {
		super(message);
	}

}
