package com.medical.solutions.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medical.solutions.dao.PatientLoginDao;
import com.medical.solutions.entity.Patient;
import com.medical.solutions.entity.PatientLogin;
import com.medical.solutions.enums.PatientLoginEnum;
import com.medical.solutions.service.PatientLoginService;

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
