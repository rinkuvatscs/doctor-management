package com.medical.doctor.patient.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medical.doctor.patient.dao.PatientLoginDao;
import com.medical.doctor.patient.entity.Patient;
import com.medical.doctor.patient.entity.PatientLogin;
import com.medical.doctor.patient.enums.PatientLoginEnum;
import com.medical.doctor.patient.service.PatientLoginService;

@Service
public class PatientLoginUsingDatabaseImpl implements PatientLoginService {

	@Autowired
	private PatientLoginDao patientLoginDao;

	@Override
	public PatientLoginEnum getLoginEnum() {
		return PatientLoginEnum.DIRECT_DATABASE;
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
