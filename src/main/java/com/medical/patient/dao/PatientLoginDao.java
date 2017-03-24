package com.medical.patient.dao;

import com.medical.patient.entity.PatientLogin;

public interface PatientLoginDao {

	String validateLogin(PatientLogin patientLogin);
	
	String signUp(PatientLogin patientLogin);
}
