package com.medical.solutions.service;

import com.medical.solutions.entity.Patient;
import com.medical.solutions.entity.PatientLogin;
import com.medical.solutions.enums.PatientLoginEnum;

public interface PatientLoginService {

	public PatientLoginEnum getLoginEnum();

	public String validateLogin(PatientLogin patientLogin);

	public int addLoginDetails(Patient patient);

	public String signUp(PatientLogin patientLogin);

}
