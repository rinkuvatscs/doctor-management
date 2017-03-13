package com.medical.doctor.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.medical.doctor.constants.LoginQueryConstants;
import com.medical.doctor.constants.QueryConstants;
import com.medical.doctor.dao.LoginDao;
import com.medical.doctor.entity.Login;
import com.medical.doctor.extractor.LoginExtractor;
import com.medical.doctor.request.LoginRequest;

@Repository
public class LoginDaoImpl implements LoginDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
			Pattern.CASE_INSENSITIVE);

	@Override
	public String validateLogin(LoginRequest loginRequest) {
		StringBuffer query = new StringBuffer(LoginQueryConstants.IS_EXIST);
		List<String> args = new ArrayList<>();

		if (!StringUtils.isEmpty(loginRequest.getUsername())) {
			if (isValidEmail(loginRequest.getUsername())) {
				query.append(" where email = ? ");
			} else if (isValidMobile(loginRequest.getUsername())) {
				query.append(" where mobile = ? ");
			} else {
				return "please provide valid username";
			}
			args.add(loginRequest.getUsername());
		}
		if (!StringUtils.isEmpty(loginRequest.getPassword())) {
			query.append(" and password = ? ");
			args.add(loginRequest.getPassword());
		}
		if (!StringUtils.isEmpty(loginRequest.getType())) {
			query.append(" and type = ? ");
			args.add(loginRequest.getType());
		}

		List<Login> response = jdbcTemplate.query(query.toString(), new LoginExtractor(), args.toArray());

		if (!StringUtils.isEmpty(response) && response.size() > 0) {
			return "success";
		}
		return "failure";

	}

	@Override
	public String signUp(LoginRequest loginRequest) {

		List<Object> args = new ArrayList<>();
		if(!StringUtils.isEmpty(loginRequest) && !isExist(loginRequest)){

		}
		return null;
	}

	private boolean isExist(LoginRequest loginRequest) {

		boolean response = false;
		String args[] = new String[1];
		if (!StringUtils.isEmpty(loginRequest) && !StringUtils.isEmpty(loginRequest.getUsername())) {
			StringBuffer query = new StringBuffer(LoginQueryConstants.IS_EXIST);
			if (isValidEmail(loginRequest.getUsername())) {
				query.append(" where email = ? ");
			} else if (isValidMobile(loginRequest.getUsername())) {
				query.append(" where mobile = ? ");
			} else {
				return response;
			}
			args[0] = loginRequest.getUsername();
			List<Login> responseExist = jdbcTemplate.query(query.toString(), new LoginExtractor(), args);
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
