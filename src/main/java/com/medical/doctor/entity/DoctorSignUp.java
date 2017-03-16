package com.medical.doctor.entity;

public class DoctorSignUp {

	private String name;
	private String email;
	private String mobile;
	private String aadhaarNumber;
	private String password;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

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

	public String getAadhaarNumber() {
		return aadhaarNumber;
	}

	public void setAadhaarNumber(String aadhaarNumber) {
		this.aadhaarNumber = aadhaarNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "DoctorSignUp [name=" + name + ", email=" + email + ", mobile="
				+ mobile + ", aadhaarNumber=" + aadhaarNumber + ", password="
				+ password + "]";
	}
}
