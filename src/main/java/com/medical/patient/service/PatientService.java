package com.medical.patient.service;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.medical.patient.entity.Appointment;

import com.medical.patient.entity.Patient;
import com.medical.patient.request.PatientRequest;

public interface PatientService {

	public Integer patientSignUp(Patient patient);

	public Boolean checkMobile(String mobile);

	public Boolean checkAdhaar(String adhaar);

	public Boolean checkEmail(String email);

	public String addpatient(Patient patient);

	public String deletepatient(Patient patient);

	public Patient getpatientByMobileNumber(String mobileNumber);

	public Patient getpatientByAdharNumber(String adharNumber);

	public Patient getpatientByEmail(String email);

	public List<Patient> getpatientByName(String name);

	public Patient getpatientById(Integer id);

	public String updatepatient(Patient patient);
	
	public String makeAppointment(Appointment makeAppointment);
	
	public String cancelAppoinment(Integer id);
	
	public List<Appointment> viewAppointment(Integer pId);
	
}
