package com.te.resumebuilder.customexception;

@SuppressWarnings("serial")
public class IdNotFoundException extends RuntimeException {
	public IdNotFoundException(String messege) {
		super(messege);
	}
}
