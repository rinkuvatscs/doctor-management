package com.medical.doctor.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.medical.doctor.constants.LoginQueryConstants;
import com.medical.doctor.dao.LoginDao;
import com.medical.doctor.entity.Login;
import com.medical.doctor.extractor.LoginExtractor;

@Repository
public class LoginDaoImpl implements LoginDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
			Pattern.CASE_INSENSITIVE);

	@Override
	public String validateLogin(Login login) {
		StringBuffer query = new StringBuffer(LoginQueryConstants.IS_EXIST);
		List<String> args = new ArrayList<>();

		if (!StringUtils.isEmpty(login.getUsername())) {
			if (isValidEmail(login.getUsername())) {
				query.append(" where email = ? ");
			} else if (isValidMobile(login.getUsername())) {
				query.append(" where mobile = ? ");
			} else {
				return "please provide valid username";
			}
			args.add(login.getUsername());
		}
		if (!StringUtils.isEmpty(login.getPassword())) {
			query.append(" and password = ? ");
			args.add(login.getPassword());
		}
		if (!StringUtils.isEmpty(login.getType())) {
			query.append(" and type = ? ");
			args.add(login.getType());
		}

		List<Login> response = jdbcTemplate.query(query.toString(), new LoginExtractor(), args.toArray());

		if (!StringUtils.isEmpty(response) && !response.isEmpty()) {
			return "success";
		}
		return "failure";

	}

	@Override
	public String signUp(Login login) {

		if(!StringUtils.isEmpty(login) && !isExist(login)){

		}
		return null;
	}

	private boolean isExist(Login login) {

		boolean response = false;
		String args[] = new String[1];
		if (!StringUtils.isEmpty(login) && !StringUtils.isEmpty(login.getUsername())) {
			StringBuilder query = new StringBuilder(LoginQueryConstants.IS_EXIST);
			if (isValidEmail(login.getUsername())) {
				query.append(" where email = ? ");
			} else if (isValidMobile(login.getUsername())) {
				query.append(" where mobile = ? ");
			} else {
				return response;
			}
			args[0] = login.getUsername();
			List<Login> responseExist = jdbcTemplate.query(query.toString(), new LoginExtractor(), args);
			if (!StringUtils.isEmpty(responseExist) && !responseExist.isEmpty()) {
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
