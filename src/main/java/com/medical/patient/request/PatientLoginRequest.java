package com.medical.patient.request;

public class PatientLoginRequest {

	private String email;
	private String mobile;
	private String username;
	private String type;
	private String password;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "PatientLoginRequest [email=" + email + ", mobile=" + mobile + ", username=" + username + ", type="
				+ type + ", password=" + password + "]";
	}

}
