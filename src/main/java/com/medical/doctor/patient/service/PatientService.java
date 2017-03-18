package com.medical.doctor.patient.service;

import com.medical.doctor.patient.entity.Patient;

public interface PatientService {

	public Integer patientSignUp(Patient patient);
	
	public Boolean checkMobile(String mobile);
	
	public Boolean checkAdhaar(String adhaar);
	
	public Boolean checkEmail(String email);
}
