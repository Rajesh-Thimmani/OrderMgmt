package com.order.item.service.exceptionhandler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.order.item.service.model.ErrorDetails;

/**
 * 
 * @author Rajesh
 *
 */

@Component
//@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class BaseExceptionHandler  extends ResponseEntityExceptionHandler  {

	private static final Logger LOGGER = LoggerFactory.getLogger(BaseExceptionHandler.class);

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> handleException(BaseException baseException, WebRequest request) {
		ErrorDetails errorDetails = null;
		LOGGER.debug("Starting handleException");

		if (null != baseException) {
			errorDetails = baseException.getErrorResponse();
			errorDetails.setExceptionClass(baseException.getErrorResponse().getExceptionClass());
		}
		LOGGER.debug("handleException completed");
		return new ResponseEntity<ErrorDetails>(errorDetails,
				(errorDetails != null && errorDetails.getHttpStatus() != null) ? errorDetails.getHttpStatus()
						: HttpStatus.INTERNAL_SERVER_ERROR);

	}
}
