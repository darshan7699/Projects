package com.te.ems.controlleradviser;

@SuppressWarnings("serial")
public class ListEmptyException extends RuntimeException {

	public ListEmptyException(String messege) {
		super(messege);
	}
}
