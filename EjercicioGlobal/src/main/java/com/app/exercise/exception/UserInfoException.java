package com.app.exercise.exception;

import org.springframework.http.HttpStatus;

public class UserInfoException extends GenericException implements CommonException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6664020609555381727L;

	public UserInfoException(String message, HttpStatus status) {
		super(message, status);
	}
	
	public UserInfoException() 
	{
		super("El correo ya esta registrado", HttpStatus.CONFLICT);
	}
	
}
