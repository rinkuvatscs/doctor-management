package com.medical.solutions.service;

import java.util.List;

import com.medical.solutions.entity.Appointment;
import com.medical.solutions.enums.AppointmentEnum;

public interface AppointmentService {

	public String makeAppointment(Appointment makeAppointment);

	public String cancelAppoinment(Integer id);

	public List<Appointment> viewAppointment(Integer pId);
	
	public List<Appointment> viewAppointmentForDoctor(Integer dId);

	public AppointmentEnum getAppointmentEnum();
}
