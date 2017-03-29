package com.medical.solutions.extractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.medical.solutions.entity.Doctor;

public class DoctorSignUpExtractor implements ResultSetExtractor<List<Doctor>> {

	@Override
	public List<Doctor> extractData(ResultSet rs) throws SQLException,
			DataAccessException {

		List<Doctor> doctors = new ArrayList<Doctor>();
		Doctor doctor = null;

		while (rs.next()) {
			doctor = new Doctor();
			doctor.setName(rs.getString("name"));
			doctor.setEmail(rs.getString("email"));
			doctor.setMobile(rs.getString("mobile"));
			doctor.setAadhaarNumber(rs.getString("aadhaarNumber"));
			doctor.setPassword(rs.getString("password"));
			doctors.add(doctor);
		}
		return doctors;
	}

}
