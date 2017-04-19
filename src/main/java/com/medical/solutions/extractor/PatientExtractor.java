package com.medical.solutions.extractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.ResultSetExtractor;

import com.medical.solutions.entity.Patient;

public class PatientExtractor implements ResultSetExtractor<List<Patient>> {

	@Override
	public List<Patient> extractData(ResultSet rs) throws SQLException {

		List<Patient> patients = new ArrayList<Patient>();
		Patient patient;
		while (rs.next()) {
			patient = new Patient();
			patient.setpId(rs.getInt("pId"));
			patient.setName(rs.getString("name"));
			patient.setMobile(rs.getString("mobile"));
			patient.setAdhaar(rs.getString("adhaar"));
			patient.setEmail(rs.getString("email"));
			patient.setGender(rs.getString("gender"));
			patient.setAllergies(rs.getString("allergies"));
			patient.setDOB(rs.getDate("dob"));
			patient.setProfilePicPath(rs.getString("profilePicPath"));
			patients.add(patient);

		}
		return patients;
	}

}
