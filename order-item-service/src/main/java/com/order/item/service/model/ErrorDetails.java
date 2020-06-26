package com.order.item.service.model;

import java.io.Serializable;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.order.item.service.enums.ErrorCodes;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7593083841986837619L;
	
	private HttpStatus httpStatus;
	private String errorCode;
	private String errorMessage;
	private String errorDescription;
	private String exceptionClass;
	
	
	
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorDescription() {
		return errorDescription;
	}

	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}

	public String getExceptionClass() {
		return exceptionClass;
	}

	public void setExceptionClass(String exceptionClass) {
		this.exceptionClass = exceptionClass;
	}

	public ErrorDetails() {
		
	}
	
	public ErrorDetails(final String errorCode, final String errorMessage, final String errorDesc, final String exceptionClass) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		this.errorDescription = errorDesc;
		this.exceptionClass = exceptionClass;
	}
	
	public ErrorDetails(ErrorCodes code, String errorDesc) {
		this.httpStatus = code.getStatus();
		this.errorCode = code.toString();
		this.errorMessage=code.getDescription();
		this.errorDescription = errorDesc;
	}
	
	public ErrorDetails(ErrorCodes codes) {
		System.out.println("inside ErrorDetails ErrorCode Params constuctor");
		this.httpStatus = codes.getStatus();
		this.errorCode = codes.toString();
		this.errorMessage= codes.getDescription();
	}
	
	public ErrorDetails(final String errorCodes,final String errorMessage, final String errorDesc) {
		this.errorCode = errorCodes;
		this.errorMessage = errorMessage;
		this.errorDescription = errorDesc;
	}
	
	public ErrorDetails(final String errorCode, final String errorMessage) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}
	
	/*
	 * public ErrorDetails(final String errorCode) { this.errorCode = errorCode; }
	 */
}
