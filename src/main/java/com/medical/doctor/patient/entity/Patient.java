package com.medical.doctor.patient.entity;

import java.util.Date;

public class Patient extends PatientSignUp {

	private Integer pId;
	private String name;
	private String mobile;
	private String adhaar;
	private String email;
	private String gender;
	private String allergies;
	private Date DOB;
	private String password;

	public Integer getpId() {
		return pId;
	}

	public void setpId(Integer pId) {
		this.pId = pId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAdhaar() {
		return adhaar;
	}

	public void setAdhaar(String adhaar) {
		this.adhaar = adhaar;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAllergies() {
		return allergies;
	}

	public void setAllergies(String allergies) {
		this.allergies = allergies;
	}

	public Date getDOB() {
		return DOB;
	}

	public void setDOB(Date dOB) {
		DOB = dOB;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Patient [pId=" + pId + ", name=" + name + ", mobile=" + mobile + ", adhaar=" + adhaar + ", email="
				+ email + ", gender=" + gender + ", allergies=" + allergies + ", DOB=" + DOB + ", password=" + password
				+ "]";
	}

}
