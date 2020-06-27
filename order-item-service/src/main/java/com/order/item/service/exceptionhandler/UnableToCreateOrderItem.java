package com.order.item.service.exceptionhandler;

public class UnableToCreateOrderItem extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9182351260000310690L;

	public UnableToCreateOrderItem() {
		super();
	}

	public UnableToCreateOrderItem(String message) {
		super(message);
	}

}
