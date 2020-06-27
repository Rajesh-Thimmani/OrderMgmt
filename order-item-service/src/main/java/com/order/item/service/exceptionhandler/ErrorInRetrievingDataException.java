package com.order.item.service.exceptionhandler;

public class ErrorInRetrievingDataException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1447025173457022920L;

	public ErrorInRetrievingDataException() {
		super();
	}

	public ErrorInRetrievingDataException(String message) {
		super(message);
	}

}
