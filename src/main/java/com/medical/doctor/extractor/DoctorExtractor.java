/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medical.doctor.extractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.medical.doctor.entity.Doctor;

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
			doctor.setAadhaarNumber(rs.getString("AdhaarNo"));
			doctor.setDaysCheckFree(rs
					.getInt("FreeDayConsulting"));
			doctor.setExpertized(rs.getString("doctor_expertized"));
			doctor.setIsGovernmentServent(rs
					.getBoolean("is_doctor_govt_servant"));
			doctor.setHighestDegree(rs.getString("doctor_highestdegree"));
			doctor.setHomeAddress(rs.getString("doctor_homeaddress"));
			doctor.setDoctorId(rs.getInt("DID"));
			doctor.setName(rs.getString("Name"));
			doctor.setMobile(rs.getString("MobileNo"));
			doctor.setOneTimeFee(rs.getString("ConsultingFees"));
			doctor.setClinicAddress(rs.getString("doctor_shop_address"));
			doctor.setEmail(rs.getString("Email"));
//			doctor.setAge(rs.getInt("age"));
			doctor.setGender(rs.getString("Gender"));
			doctorList.add(doctor);
		}
		return doctorList;
	}

}