package com.medical.doctor.service;

import java.util.List;

import com.medical.doctor.entity.Appointment;
import com.medical.doctor.enums.AppointmentEnum;

public interface AppointmentService {

	public String makeAppointment(Appointment makeAppointment);

	public String cancelAppoinment(Integer id);

	public List<Appointment> viewAppointment(Integer pId);
	
	public List<Appointment> viewAppointmentForDoctor(Integer dId);

	public AppointmentEnum getAppointmentEnum();
}
