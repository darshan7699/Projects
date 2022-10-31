package com.te.resumebuilder.customexception;

@SuppressWarnings("serial")
public class DataNotFoundException extends RuntimeException {
	public DataNotFoundException(String messege) {
		super(messege);
	}
}
