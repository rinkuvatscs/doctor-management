package com.medical.doctor.patient.dao;

import com.medical.doctor.patient.entity.Patient;

public interface PatientDao {

	public Integer patientSignUp(Patient patient);

	public Boolean checkMobile(String mobile);

	public Boolean checkAdhaar(String adhaar);

	public Boolean checkEmail(String email);
}
