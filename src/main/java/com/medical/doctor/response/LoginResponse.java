package com.medical.doctor.response;


public class LoginResponse {
	
	String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "LoginResponse [message=" + message + "]";
	}
	

}
