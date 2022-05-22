package com.devsuperior.bds02.services.exceptions;

public class CityNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public CityNotFoundException(String msg) {
		super(msg);
	}

}
