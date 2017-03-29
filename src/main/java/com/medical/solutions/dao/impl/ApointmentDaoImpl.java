package com.medical.solutions.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.medical.solutions.constants.AppointmentQueryConstants;
import com.medical.solutions.dao.AppointmentDao;
import com.medical.solutions.entity.Appointment;

@Repository
public class ApointmentDaoImpl implements AppointmentDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public String makeAppointment(Appointment makeAppointment) {

		String response;
		List<Object> args = new ArrayList<>();
		args.add(makeAppointment.getdId());
		args.add(makeAppointment.getpId());
		args.add(makeAppointment.getAppointmentDesc());
		int row = jdbcTemplate.update(AppointmentQueryConstants.INSERT_APPOINTMENT, args.toArray());
		if (row > 0) {
			response = "Appoinment Done";
		} else {
			response = "Appoinment Not Successful";
		}
		return response;
	}

	@Override
	public String cancelAppointment(Integer id) {

		String response = null;
		if (!StringUtils.isEmpty(id)) {
			Object args[] = { id };
			int row = jdbcTemplate.update(AppointmentQueryConstants.DELETE_APPOINTMENT, args);
			if (row > 0) {
				response = "Appoinment Cancelled";
			} else {
				response = "AppoinmentID does not exists";
			}
		}
		return response;
	}

	@Override
	public List<Appointment> viewAppointment(Integer pId) {

		List<Appointment> response = null;
		if (!StringUtils.isEmpty(pId)) {
			Object args[] = { pId };
			response = jdbcTemplate.query(AppointmentQueryConstants.GET_APPOINTMENT_BY_PID,
					new BeanPropertyRowMapper<Appointment>(Appointment.class), args);
			return response;
		}
		return response;
	}

	@Override
	public List<Appointment> viewAppointmentForDoctor(Integer dId) {

		List<Appointment> response = null;
		if (!StringUtils.isEmpty(dId)) {
			Object args[] = { dId };
			response = jdbcTemplate.query(AppointmentQueryConstants.GET_APPOINTMENT_BY_DID,
					new BeanPropertyRowMapper<Appointment>(Appointment.class), args);
			return response;
		}
		return response;
	}

}
