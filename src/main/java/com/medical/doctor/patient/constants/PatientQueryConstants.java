package com.medical.doctor.patient.constants;

public interface PatientQueryConstants {

	String INSERT_PATIENT = "insert into patient (name, mobile, adhaar, email, createdDate) values (?,?,?,?, NOW())";
	
	String GET_PATIENT_BY_MOBILE = "Select * from patient where mobile = ? ";
	
}