package com.te.lms.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.te.lms.customexception.IdNotFoundException;
import com.te.lms.response.Response;

@RestControllerAdvice
public class MyExceptionHandler {
	
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<Response> exception(IdNotFoundException exception){
		return new ResponseEntity<>(new Response(true, exception.getMessage(), null),HttpStatus.BAD_GATEWAY);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Response> exc(Exception exception){
		return new ResponseEntity<>(new Response(true, "Something Went Wrong", null),HttpStatus.BAD_GATEWAY);
	}

}
