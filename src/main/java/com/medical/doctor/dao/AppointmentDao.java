package com.medical.doctor.dao;

import java.util.List;

import com.medical.doctor.entity.Appointment;

public interface AppointmentDao {

	public String makeAppointment(Appointment makeAppointment);

	public String cancelAppointment(Integer id);

	public List<Appointment> viewAppointment(Integer pId);
	
	public List<Appointment> viewAppointmentForDoctor(Integer dId);
}
