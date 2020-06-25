package com.order.item.service.exceptionhandler;

import com.order.item.service.model.ErrorDetails;

/**
 * 
 * @author Rajesh
 *
 */
public class BaseException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2582898131097891819L;
	
	private ErrorDetails errorResponse;
	
	public BaseException() {
	}
	
	public BaseException(String message) {
		super(message);
	}
	
	public BaseException(Throwable cause) {
		super(cause);
	}
	
	public BaseException(ErrorDetails errorDetails) {
		this.errorResponse = errorDetails;
	}
	
	public BaseException(String message, Throwable cause) {
		super(message,cause);
	}

	public ErrorDetails getErrorResponse() {
		return errorResponse;
	}

	public void setErrorResponse(ErrorDetails errorResponse) {
		this.errorResponse = errorResponse;
	}
	
	
}
