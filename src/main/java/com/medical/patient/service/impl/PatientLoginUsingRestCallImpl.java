package com.medical.patient.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medical.patient.dao.PatientLoginDao;
import com.medical.patient.entity.Patient;
import com.medical.patient.entity.PatientLogin;
import com.medical.patient.enums.PatientLoginEnum;
import com.medical.patient.service.PatientLoginService;

@Service
public class PatientLoginUsingRestCallImpl implements PatientLoginService {

	@Autowired
	private PatientLoginDao patientLoginDao;

	@Override
	public PatientLoginEnum getLoginEnum() {
		return PatientLoginEnum.THROUGH_RESTTEMPLATE;
	}

	@Override
	public String validateLogin(PatientLogin patientLogin) {
		return patientLoginDao.validateLogin(patientLogin);
	}

	@Override
	public int addLoginDetails(Patient patient) {
		System.out.println("Temp");
		return 0;
	}

	@Override
	public String signUp(PatientLogin patientLogin) {
		// TODO Auto-generated method stub
		return null;
	}

}
