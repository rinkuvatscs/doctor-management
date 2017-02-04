/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.doctor.extractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.doctor.types.entity.Doctor;

/**
 *
 * @author Rinku
 */
public class DoctorExtractor implements ResultSetExtractor<List<Doctor>> {

	List<Doctor> doctorList = new ArrayList<>();

	@Override
	public List<Doctor> extractData(ResultSet rs) throws SQLException,
			DataAccessException {
		Doctor doctor;

		while (rs.next()) {
			doctor = new Doctor();
			doctor.setAadhaarNumber(rs.getString("doctor_adhaar_number"));
			doctor.setDaysCheckFree(rs
					.getInt("doctor_days_to_check_free_in_consulting_fee"));
			doctor.setExpertized(rs.getString("doctor_expertized"));
			doctor.setIsGovernmentServent(rs
					.getBoolean("is_doctor_govt_servant"));
			doctor.setHighestDegree(rs.getString("doctor_highestdegree"));
			doctor.setHomeAddress(rs.getString("doctor_homeaddress"));
			doctor.setDoctorId(rs.getInt("doctor_id"));
			doctor.setName(rs.getString("doctor_name"));
			doctor.setMobile(rs.getString("doctor_number"));
			doctor.setOneTimeFee(rs.getString("onetime_consulting_fee"));
			doctor.setClinicAddress(rs.getString("doctor_shop_address"));
			doctor.setEmail(rs.getString("email"));
			doctor.setAge(rs.getInt("age"));
			doctor.setGender(rs.getString("gender"));
			doctorList.add(doctor);
		}
		return doctorList;
	}

}