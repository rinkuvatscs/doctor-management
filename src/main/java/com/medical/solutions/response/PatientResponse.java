package com.medical.solutions.response;

public class PatientResponse {

	private String message;

	public PatientResponse() {
	}

	public PatientResponse(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
