package com.medical.patient.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.medical.patient.constants.PatientLoginQueryConstants;
import com.medical.patient.dao.PatientLoginDao;
import com.medical.patient.entity.PatientLogin;
import com.medical.patient.extractor.PatientLoginExtractor;

@Repository
public class PatientLoginDaoImpl implements PatientLoginDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
			Pattern.CASE_INSENSITIVE);

	@Override
	public String validateLogin(PatientLogin patientLogin) {

		StringBuffer query = new StringBuffer(PatientLoginQueryConstants.IS_EXIST);
		List<String> args = new ArrayList<>();

		if (!StringUtils.isEmpty(patientLogin.getUsername())) {
			if (isValidEmail(patientLogin.getUsername())) {
				query.append(" where email = ? ");
			} else if (isValidMobile(patientLogin.getUsername())) {
				query.append(" where mobile = ? ");
			} else {
				return "please provide valid username";
			}
			args.add(patientLogin.getUsername());
		}
		if (!StringUtils.isEmpty(patientLogin.getPassword())) {
			query.append(" and password = ? ");
			args.add(patientLogin.getPassword());
		}
		if (!StringUtils.isEmpty(patientLogin.getType())) {
			query.append(" and type = ? ");
			args.add(patientLogin.getType());
		}

		List<PatientLogin> response = jdbcTemplate.query(query.toString(), new PatientLoginExtractor(), args.toArray());

		if (!StringUtils.isEmpty(response) && !response.isEmpty()) {
			return "success";
		}
		return "failure";
	}

	@Override
	public String signUp(PatientLogin patientLogin) {
		List<Object> args = new ArrayList<>();
		if (!StringUtils.isEmpty(patientLogin) && !isExist(patientLogin)) {

		}
		return null;
	}

	private boolean isExist(PatientLogin patientLogin) {

		boolean response = false;
		String args[] = new String[1];
		if (!StringUtils.isEmpty(patientLogin) && !StringUtils.isEmpty(patientLogin.getUsername())) {
			StringBuffer query = new StringBuffer(PatientLoginQueryConstants.IS_EXIST);
			if (isValidEmail(patientLogin.getUsername())) {
				query.append(" where email = ? ");
			} else if (isValidMobile(patientLogin.getUsername())) {
				query.append(" where mobile = ? ");
			} else {
				return response;
			}
			args[0] = patientLogin.getUsername();
			List<PatientLogin> responseExist = jdbcTemplate.query(query.toString(), new PatientLoginExtractor(), args);
			if (!StringUtils.isEmpty(responseExist) && responseExist.size() > 0) {
				response = true;
			}
		}
		return response;
	}

	private boolean isValidEmail(String email) {

		if (!StringUtils.isEmpty(email) && VALID_EMAIL_ADDRESS_REGEX.matcher(email).matches()) {
			return true;
		}
		return false;
	}

	private boolean isValidMobile(String mobile) {

		if (!StringUtils.isEmpty(mobile) && mobile.matches("\\d{10}")) {
			return true;
		}
		return false;
	}

}
