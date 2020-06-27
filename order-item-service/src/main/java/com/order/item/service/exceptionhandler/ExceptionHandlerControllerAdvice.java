package com.order.item.service.exceptionhandler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerControllerAdvice {

	@ExceptionHandler(OrderItemNotFound.class)
	public ResponseEntity<ErrorResponse> handleCustomException(final OrderItemNotFound exception,
			final HttpServletRequest request) {

		ErrorResponse error = new ErrorResponse();
		error.setErrorMessage(exception.getMessage());
		error.callerURL(request.getRequestURI());

		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(UnableToCreateOrderItem.class)
	public ResponseEntity<ErrorResponse> handleCustomException(final UnableToCreateOrderItem exception,
			final HttpServletRequest request) {

		ErrorResponse error = new ErrorResponse();
		error.setErrorMessage(exception.getMessage());
		error.callerURL(request.getRequestURI());

		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(ErrorInRetrievingDataException.class)
	public ResponseEntity<ErrorResponse> handleCustomException(final ErrorInRetrievingDataException exception,
			final HttpServletRequest request) {

		ErrorResponse error = new ErrorResponse();
		error.setErrorMessage(exception.getMessage());
		error.callerURL(request.getRequestURI());

		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleSuperNotFound(final Exception exception,
			final HttpServletRequest request) {

		ErrorResponse error = new ErrorResponse();
		error.setErrorMessage(exception.getMessage());
		error.callerURL(request.getRequestURI());

		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
