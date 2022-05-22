package com.devsuperior.bds02.controllers.exceptions;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.devsuperior.bds02.services.exceptions.CityNotFoundException;
import com.devsuperior.bds02.services.exceptions.DatabaseIntegrityException;
import com.devsuperior.bds02.services.exceptions.EventNotFoundException;

@ControllerAdvice
public class ControllerExceptionsHandler {
	
	@ResponseBody
	@ExceptionHandler(EventNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String eventNotFoundExceptionHandler(EventNotFoundException exception) {
		return exception.getMessage();
	}
	
	@ResponseBody
	@ExceptionHandler(CityNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String cityNotFoundExceptionHandler(CityNotFoundException exception) {
		return exception.getMessage();
	}
	
	@ResponseBody
	@ExceptionHandler(DatabaseIntegrityException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public String databaseIntegrityExceptionHandler(DatabaseIntegrityException exception) {
		return exception.getMessage();
	}

}
