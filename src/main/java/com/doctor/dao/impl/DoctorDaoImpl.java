package com.doctor.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.doctor.dao.DoctorDao;
import com.doctor.db.config.QueryConstants;
import com.doctor.extractor.DoctorExtractor;
import com.doctor.types.pojo.Doctor;

@Component
public class DoctorDaoImpl implements DoctorDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public String addDoctor(Doctor doctor) {
		String response = null;
		if (!isDoctorExists(doctor)) {

			List<Object> args = new ArrayList<>();
			args.add(doctor.getDoctorName());
			args.add(doctor.getDoctorNumber());
			args.add(doctor.getDoctorHomeAddress());
			args.add(doctor.getDoctorAdhaarNumber());
			args.add(doctor.getDoctorHighestDegree());
			args.add(doctor.getDoctorExpertized());
			args.add(doctor.getDoctorGovtServent());
			args.add(doctor.getDoctorOneTimeConsultingFee());
			args.add(doctor.getDoctorDaystoCheckFreeInConsultingFee());
			args.add(doctor.getDoctorShopAddress());

			int row = jdbcTemplate.update(QueryConstants.ADD_DOCTOR, args.toArray());
			if (row == 1) {
				response = doctor.getDoctorName() + " registered successfully";
			} else {
				response = "Sorry, " + doctor.getDoctorName() + " not registered . Please try again";
			}
		} else {
			response = "Sorry, " + doctor.getDoctorName() + " already registered";
		}

		return response;
	}

	@Override
	public String deleteDoctor(Integer doctorId) {
		String response = null;
		List<Object> args = new ArrayList<>();
		args.add(doctorId);
		int row = jdbcTemplate.update(QueryConstants.DELETE_DOCTOR, args.toArray());
		if (row == 1) {
			response = "Doctor ID " + doctorId + " deleted successfully";
		} else {
			response = "Sorry, Doctor ID " + doctorId + " not exists in record. Please check again";
		}

		return response;
	}

	@Override
	public boolean isDoctorExists(Doctor doctor) {

		boolean isExist = false;
		List<String> args = new ArrayList<>();
		args.add(doctor.getDoctorNumber());
		args.add(doctor.getDoctorAdhaarNumber());
		List<Doctor> response = jdbcTemplate.query(QueryConstants.IS_DOCTOR_EXIST, new DoctorExtractor(),
				args.toArray());
		if (!StringUtils.isEmpty(response) && response.size() > 0) {
			isExist = true;
		}
		return isExist;
	}

	@Override
	public Doctor getDoctorById(Integer id) {

		Doctor doctor = new Doctor();
		int args[] = { id };
		List<Doctor> response = jdbcTemplate.query(QueryConstants.GET_DOCTOR_BY_ID, new DoctorExtractor(), args);
		if (!StringUtils.isEmpty(response) && response.size() > 0) {
			doctor = response.get(0);
		}
		return doctor;
	}

}
