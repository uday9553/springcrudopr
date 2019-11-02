package com.uday.springcrudopr.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@RestControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler({ EntityNotFoundException.class })
	public ResponseEntity<ErrorResponse> entityNotFound(EntityNotFoundException exception) {
		return errorResponse(exception);
	}
	private ResponseEntity<ErrorResponse> errorResponse(BaseException exception) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setErrorMessage(exception.getMessage());
		errorResponse.setStatus(exception.getHttpStatus().getReasonPhrase());
		errorResponse.setReason(exception.getUserMessage());
		errorResponse.setSystemMessage(exception.getSystemMessage());
		return new ResponseEntity<>(errorResponse, exception.getHttpStatus());
	}

}
