package com.medical.doctor.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medical.doctor.dao.AppointmentDao;
import com.medical.doctor.entity.Appointment;
import com.medical.doctor.enums.AppointmentEnum;
import com.medical.doctor.service.AppointmentService;

@Service
public class AppointmentUsingDatabaseImpl implements AppointmentService {

	@Autowired
	private AppointmentDao appointmentDao;

	@Override
	public String makeAppointment(Appointment makeAppointment) {

		return appointmentDao.makeAppointment(makeAppointment);
	}

	@Override
	public String cancelAppoinment(Integer id) {

		return appointmentDao.cancelAppointment(id);
	}

	@Override
	public List<Appointment> viewAppointment(Integer pId) {

		return appointmentDao.viewAppointment(pId);
	}

	@Override
	public List<Appointment> viewAppointmentForDoctor(Integer dId) {

		return appointmentDao.viewAppointmentForDoctor(dId);
	}

	@Override
	public AppointmentEnum getAppointmentEnum() {
		
		return AppointmentEnum.DIRECT_DATABASE;
	}

}
