package com.te.ems.controlleradviser;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.te.ems.response.Response;

@RestControllerAdvice
public class ExceptionHandlerEmployee {
     
	@ExceptionHandler(DataNotFoundexception.class)
	public ResponseEntity<Response>exception(DataNotFoundexception exception){
		return new ResponseEntity<>(new Response(true,exception.getMessage(),null),HttpStatus.OK);
		
	}
	
	@ExceptionHandler(DatabaseEmptyException.class)
	public ResponseEntity<Response> execeptionDatabase(DatabaseEmptyException exception){
		return new ResponseEntity<>(new Response(true,exception.getMessage(),null),HttpStatus.OK);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Response> exeadd(){
		return new ResponseEntity<>(new Response(true,"Something Went Wrong ",null),HttpStatus.OK);
	}
} 
