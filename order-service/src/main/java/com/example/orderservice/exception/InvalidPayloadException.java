package com.example.orderservice.exception;

public class InvalidPayloadException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3027550656713265668L;
	
	public InvalidPayloadException() {
		
	}
	
	public InvalidPayloadException(String message) {
		super(message);
	}

}
