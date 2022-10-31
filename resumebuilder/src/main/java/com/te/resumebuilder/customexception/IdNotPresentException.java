package com.te.resumebuilder.customexception;

@SuppressWarnings("serial")
public class IdNotPresentException extends RuntimeException {

	public IdNotPresentException(String messege) {
		super(messege);
	}

}
