package com.te.ems.controlleradviser;

@SuppressWarnings("serial")
public class DatabaseEmptyException extends RuntimeException {

	public DatabaseEmptyException(String messege) {
		super(messege);
	}
}
