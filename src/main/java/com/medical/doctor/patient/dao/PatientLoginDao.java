package com.medical.doctor.patient.dao;

import com.medical.doctor.patient.entity.PatientLogin;

public interface PatientLoginDao {

	String validateLogin(PatientLogin patientLogin);
	
	String signUp(PatientLogin patientLogin);
}
