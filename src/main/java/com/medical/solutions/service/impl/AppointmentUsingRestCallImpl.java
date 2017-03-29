package com.medical.solutions.service.impl;

import java.util.List;

import com.medical.solutions.entity.Appointment;
import com.medical.solutions.enums.AppointmentEnum;
import com.medical.solutions.service.AppointmentService;

public class AppointmentUsingRestCallImpl implements AppointmentService {

	@Override
	public String makeAppointment(Appointment makeAppointment) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String cancelAppoinment(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Appointment> viewAppointment(Integer pId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Appointment> viewAppointmentForDoctor(Integer dId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AppointmentEnum getAppointmentEnum() {

		return AppointmentEnum.THROUGH_RESTTEMPLATE;
	}

}
