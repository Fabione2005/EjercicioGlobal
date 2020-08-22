package com.app.exercise.model.generic;

public class UserToken {
	
	private String userEmail;
	private String password;
	private String token;
	
	public UserToken(String userEmail, String token) 
	{
		this.userEmail = userEmail;
		this.token = token;
	}
	
	public UserToken() 
	{
		
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	
	
}
