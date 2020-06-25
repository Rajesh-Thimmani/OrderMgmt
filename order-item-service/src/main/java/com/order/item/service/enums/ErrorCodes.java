package com.order.item.service.enums;

import org.springframework.http.HttpStatus;

/**
 * 
 * @author Rajesh
 *
 */

public enum ErrorCodes {

	A001(HttpStatus.INTERNAL_SERVER_ERROR,"Generic Application Error"),
	R001(HttpStatus.BAD_REQUEST,"Order Not Found"),
	ORI001(HttpStatus.BAD_REQUEST,"Order Item Not Found");
	
	
	private String description;
	private HttpStatus status;
	
	private ErrorCodes() {
	}

	private ErrorCodes(HttpStatus status, String desc) {
		this.status = status;
		this.description=desc;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

}
