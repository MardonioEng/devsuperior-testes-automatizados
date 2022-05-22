package com.devsuperior.bds02.services.exceptions;

public class DatabaseIntegrityException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public DatabaseIntegrityException(String msg) {
		super(msg);
	}

}