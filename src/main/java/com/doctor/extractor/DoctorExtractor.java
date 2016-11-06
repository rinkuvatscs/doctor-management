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

import com.doctor.types.pojo.Doctor;

/**
 *
 * @author Rinku
 */
public class DoctorExtractor implements ResultSetExtractor<List<Doctor>> {

	List<Doctor> doctorList = new ArrayList<>();

	@Override
	public List<Doctor> extractData(ResultSet rs) throws SQLException, DataAccessException {
		Doctor doctor;
		
		    while (rs.next()) {
			doctor = new Doctor();
		    doctor.setDoctorAdhaarNumber(rs.getString("doctor_adhaar_number"));
		    doctor.setDoctorDaystoCheckFreeInConsultingFee(rs.getInt("doctor_days_to_check_free_in_consulting_fee"));
		    doctor.setDoctorExpertized(rs.getString("doctor_expertized"));
		    doctor.setDoctorGovtServent(rs.getBoolean("is_doctor_govt_servant"));
		    doctor.setDoctorHighestDegree(rs.getString("doctor_highestdegree"));
		    doctor.setDoctorHomeAddress(rs.getString("doctor_homeaddress"));
		    doctor.setDoctorId(rs.getInt("doctor_id"));
		    doctor.setDoctorName(rs.getString("doctor_name"));
		    doctor.setDoctorNumber(rs.getString("doctor_number"));
		    doctor.setDoctorOneTimeConsultingFee(rs.getString("onetime_consulting_fee"));
		    doctor.setDoctorShopAddress(rs.getString("doctor_shop_address"));
			
			doctorList.add(doctor);
		}
		return doctorList;
	}

}
