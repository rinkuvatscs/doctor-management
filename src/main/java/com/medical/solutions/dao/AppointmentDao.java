package com.medical.solutions.dao;

import java.util.List;

import com.medical.solutions.entity.Appointment;

public interface AppointmentDao {

	public String makeAppointment(Appointment makeAppointment);

	public String cancelAppointment(Integer id);

	public List<Appointment> viewAppointment(Integer pId);
	
	public List<Appointment> viewAppointmentForDoctor(Integer dId);

	public List<Appointment> doctorAppointmentWithPatientProfile(Integer pId);
}
