package com.app.exercise.exception;

import org.springframework.http.HttpStatus;

public class GenericException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3270939065122319080L;
	private String message;
	private HttpStatus status;

	public GenericException(String message,HttpStatus status) {
	        super(message);
	        this.message = message;
	        this.status = status;
	    }

	@Override
	public String getMessage() {
		return message;
	}
	
	public HttpStatus getStatus() 
	{
		return status;
	}
	

}
