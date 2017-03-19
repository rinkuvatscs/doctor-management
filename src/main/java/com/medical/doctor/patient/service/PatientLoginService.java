package com.medical.doctor.patient.service;

import com.medical.doctor.patient.entity.Patient;
import com.medical.doctor.patient.entity.PatientLogin;
import com.medical.doctor.patient.enums.PatientLoginEnum;

public interface PatientLoginService {

	public PatientLoginEnum getLoginEnum();

	public String validateLogin(PatientLogin patientLogin);

	public int addLoginDetails(Patient patient);

	public String signUp(PatientLogin patientLogin);

}
