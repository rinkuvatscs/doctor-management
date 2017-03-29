package com.medical.solutions.dao;

import com.medical.solutions.entity.PatientLogin;

public interface PatientLoginDao {

	String validateLogin(PatientLogin patientLogin);
	
	String signUp(PatientLogin patientLogin);
}
