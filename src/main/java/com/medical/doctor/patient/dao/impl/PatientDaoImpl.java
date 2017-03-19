package com.medical.doctor.patient.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.medical.doctor.patient.constants.PatientLoginQueryConstants;
import com.medical.doctor.patient.constants.PatientQueryConstants;
import com.medical.doctor.patient.dao.PatientDao;
import com.medical.doctor.patient.entity.Patient;
import com.medical.doctor.patient.extractor.PatientExtractor;
import org.springframework.util.StringUtils;

@Component
public class PatientDaoImpl implements PatientDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Integer patientSignUp(Patient patient) {

		List<Patient> patientList = null;
		List<Object> args = new ArrayList<Object>();
		args.add(patient.getName());
		args.add(patient.getMobile());
		args.add(patient.getAdhaar());
		args.add(patient.getEmail());
		int patientResponse = jdbcTemplate.update(PatientQueryConstants.INSERT_PATIENT, args.toArray());
		if (patientResponse > 0) {
			args = new ArrayList<Object>();
			args.add(patient.getMobile());
			patientList = jdbcTemplate.query(PatientQueryConstants.GET_PATIENT_BY_MOBILE, new PatientExtractor(),
					args.toArray());
			if (!StringUtils.isEmpty(patientList) && !patientList.isEmpty()) {
				args = new ArrayList<>();
				args.add(patient.getMobile());
				args.add(patient.getPassword());
				args.add(patient.getAdhaar());
				args.add(patient.getEmail());
				args.add("p");
				args.add(patientList.get(0).getpId());
				int response = jdbcTemplate.update(PatientLoginQueryConstants.INSERT_LOGIN, args.toArray());
				if (response > 0) {
					return patientList.get(0).getpId();
				}
			}
		}
		return 0;
	}

	@Override
	public Boolean checkMobile(String mobile) {
		Object[] args = { mobile };
		List<Patient> response = jdbcTemplate.query("select * from patient where mobile = ? ", new PatientExtractor(),
				args);
		if (!response.isEmpty()) {
			return true;
		}
		return false;
	}

	@Override
	public Boolean checkAdhaar(String adhaar) {
		Object[] args = { adhaar };
		List<Patient> response = jdbcTemplate.query("select * from patient where adhaar = ? ", new PatientExtractor(),
				args);
		if (!response.isEmpty()) {
			return true;
		}
		return false;
	}

	@Override
	public Boolean checkEmail(String email) {
		Object[] args = { email };
		List<Patient> response = jdbcTemplate.query(" SELECT * from patient WHERE email = ? ", new PatientExtractor(),
				args);
		if (!response.isEmpty()) {
			return true;
		}
		return false;
	}

}
