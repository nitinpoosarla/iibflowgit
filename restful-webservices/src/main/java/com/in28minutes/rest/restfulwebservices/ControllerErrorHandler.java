package com.in28minutes.rest.restfulwebservices;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerErrorHandler 
{
	@ExceptionHandler(Exception.class)
	public ResponseEntity<errorResponse> handleError(Exception e)
	{
		errorResponse er = new errorResponse();
	er.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
	er.setErrorMessage(e.getMessage());
		return new ResponseEntity<errorResponse>(er,HttpStatus.INTERNAL_SERVER_ERROR);
		
	}

}
