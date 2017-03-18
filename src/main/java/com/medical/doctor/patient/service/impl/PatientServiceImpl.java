package com.medical.doctor.patient.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medical.doctor.patient.dao.PatientDao;
import com.medical.doctor.patient.entity.Patient;
import com.medical.doctor.patient.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	private PatientDao patientDao;

	@Override
	public Boolean checkMobile(String mobile) {
		return patientDao.checkMobile(mobile);
	}

	@Override
	public Boolean checkAdhaar(String adhaar) {
		return patientDao.checkAdhaar(adhaar);
	}

	@Override
	public Boolean checkEmail(String email) {
		return patientDao.checkEmail(email);
	}

	@Override
	public Integer patientSignUp(Patient patient) {
		return patientDao.patientSignUp(patient);
	}

}
