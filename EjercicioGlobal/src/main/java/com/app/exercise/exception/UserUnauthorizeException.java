package com.app.exercise.exception;

import org.springframework.http.HttpStatus;

public class UserUnauthorizeException extends GenericException implements CommonException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1189460730196188968L;

	public UserUnauthorizeException() {
		super("Usuario no autorizado", HttpStatus.UNAUTHORIZED);
	}

}
