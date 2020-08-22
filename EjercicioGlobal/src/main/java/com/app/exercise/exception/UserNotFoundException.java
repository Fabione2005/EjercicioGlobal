package com.app.exercise.exception;

import org.springframework.http.HttpStatus;

public class UserNotFoundException extends GenericException implements CommonException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1189460730196188968L;

	public UserNotFoundException() {
		super("Usuario no encontrado", HttpStatus.NOT_FOUND);
	}

}
