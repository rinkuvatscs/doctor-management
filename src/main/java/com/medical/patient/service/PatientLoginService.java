package com.medical.patient.service;

import com.medical.patient.entity.Patient;
import com.medical.patient.entity.PatientLogin;
import com.medical.patient.enums.PatientLoginEnum;

public interface PatientLoginService {

	public PatientLoginEnum getLoginEnum();

	public String validateLogin(PatientLogin patientLogin);

	public int addLoginDetails(Patient patient);

	public String signUp(PatientLogin patientLogin);

}
