package com.example.orderservice.exception;

public class ErrorInCreatingOrder extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8499652661481538938L;

	public ErrorInCreatingOrder() {
		super();
	}

	public ErrorInCreatingOrder(String message) {
		super(message);
	}

}
