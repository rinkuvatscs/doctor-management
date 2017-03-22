package com.medical.patient.extractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.ResultSetExtractor;

import com.medical.patient.entity.PatientLogin;

public class PatientLoginExtractor implements ResultSetExtractor<List<PatientLogin>> {

	List<PatientLogin> patientLogins = new ArrayList<>();

	@Override
	public List<PatientLogin> extractData(ResultSet rs) throws SQLException {
		PatientLogin patientLogin;
		while (rs.next()) {
			patientLogin = new PatientLogin();
			patientLogin.setEmail(rs.getString("email"));
			patientLogin.setMobile(rs.getString("mobile"));
			patientLogin.setPassword(rs.getString("password"));
			patientLogin.setType(rs.getString("type"));
			patientLogin.setId(rs.getInt("typeId"));
			patientLogins.add(patientLogin);
		}

		return patientLogins;
	}

}
