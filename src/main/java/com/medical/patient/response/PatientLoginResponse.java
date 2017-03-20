package com.medical.patient.response;

public class PatientLoginResponse {

	String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public PatientLoginResponse(String message) {
		super();
		this.message = message;
	}

	@Override
	public String toString() {
		return "PatientLoginResponse [message=" + message + "]";
	}

}
