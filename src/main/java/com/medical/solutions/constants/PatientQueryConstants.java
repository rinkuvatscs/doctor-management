package com.medical.solutions.constants;

public interface PatientQueryConstants {

	String INSERT_PATIENT = "insert into patient (name, mobile, adhaar, email, createdDate) values (?,?,?,?, NOW())";

	String GET_PATIENT_BY_MOBILE = "Select * from patient where mobile = ? ";

	String ADD_PATIENT = "insert into  patient(name, mobile, adhaar, " + "email) values" + "(?,?,?,?)";

	String IS_PATIENT_EXIST = "SELECT * FROM patient WHERE ";

	String DELETE_PATIENT = "delete from patient WHERE pId = ?";

	String GET_PATIENT_BY_ID = " SELECT * FROM patient WHERE pId = ? ";

	String GET_PATIENT_BY_ADHAR_NUMBER = " SELECT * FROM patient WHERE adhaar = ? ";

	String GET_PATIENT_BY_NAME = " SELECT * FROM patient WHERE name LIKE ? ";

	String GET_PATIENT_BY_EMAIL = " SELECT * FROM patient WHERE email = ? ";

}
