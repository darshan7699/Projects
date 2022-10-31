package com.te.resumebuilder.handler;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.te.resumebuilder.customexception.DataNotFoundException;
import com.te.resumebuilder.customexception.IdNotFoundException;
import com.te.resumebuilder.response.Response;
import com.te.resumebuilder.response.ResponseValidation;

@RestControllerAdvice
public class ResumeExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Response> exception(Exception exception) {
		return new ResponseEntity<>(new Response(true, exception.getMessage(), null), HttpStatus.BAD_GATEWAY);
	}

	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<Response> idnotfound(IdNotFoundException exception) {
		return new ResponseEntity<>(new Response(true, exception.getMessage(), null), HttpStatus.BAD_GATEWAY);
	}

	@ExceptionHandler(DataNotFoundException.class)
	public ResponseEntity<Response> dataexception(DataNotFoundException exception) {
		return new ResponseEntity<>(new Response(true, exception.getMessage(), null), HttpStatus.BAD_GATEWAY);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Response> validation(MethodArgumentNotValidException exception) {
		List<String> list = exception.getBindingResult().getAllErrors().stream().map(t -> t.getDefaultMessage())
				.toList();
		if (list.size() > 1) {
			String st ="";
			for (String string : list) {
				st = st + string + ", ";
			}
			return new ResponseEntity<>(new Response(true, st, null), HttpStatus.BAD_GATEWAY);
		} else {
			return new ResponseEntity<>(new Response(true, exception.getFieldError().getDefaultMessage(), null),
					HttpStatus.BAD_GATEWAY);

		}

	}

//	@ExceptionHandler(MethodArgumentNotValidException.class)
//	public ResponseEntity<ResponseValidation> validation(MethodArgumentNotValidException exception) {
//		List<String> list = exception.getBindingResult().getAllErrors().stream().map(t -> t.getDefaultMessage()).toList();
//		return new ResponseEntity<>(new ResponseValidation(true,list,null), HttpStatus.BAD_GATEWAY);
//	}

}
