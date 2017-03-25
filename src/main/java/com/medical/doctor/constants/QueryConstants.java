package com.medical.doctor.constants;

public interface QueryConstants {

	String ADD_DOCTOR = "insert into  DOCTOR(Name,mobile,adhaar,email) values(?,?,?,?)";

	String IS_DOCTOR_EXIST = "SELECT * FROM doctor WHERE ";

	String DELETE_DOCTOR = "delete from doctor WHERE dId = ?";

	String GET_DOCTOR_BY_ID = " SELECT * FROM doctor WHERE dId = ? ";

	String GET_DOCTOR_BY_ADHAR_NUMBER = " SELECT * FROM doctor WHERE adhaar = ? ";

	String GET_DOCTOR_BY_MOBILE_NUMBER = " SELECT * FROM doctor WHERE mobile = ? ";

	String GET_DOCTOR_BY_NAME = " SELECT * FROM doctor WHERE name LIKE ? ";

	String GET_DOCTOR_BY_EMAIL = " SELECT * FROM doctor WHERE email = ? ";

	String GET_DOCTOR_BY_EXPERTISTED = " SELECT * FROM doctor WHERE expertise like ? ";

	String GET_DOCTOR_BY_CONSULTING_FEE = " SELECT * FROM doctor WHERE fee = ? ";

	String GET_DOCTORS = "SELECT * FROM doctor  ";

	String GET_ALL_EXPERTIZED = "SELECT * FROM expertise";

	String GET_EXPERTIZED = "SELECT * FROM expertise WHERE expertise=?";

	String ADD_EXPERTIZED = "insert into expertise(expertise) values(?)";

	String GET_UNAPPROVED_EXPERTISE = "SELECT * FROM expertise WHERE approved = 0";

	String APPROVE_EXPERTISE = "update expertise SET approved  = 1";

	String INSERT_DOCTOR = "insert into doctor (name, mobile, adhaar, email, createdDate) values (?,?,?,?, NOW())";

	String GET_DOCTOR_BY_MOBILE = "Select * from doctor where mobile = ? ";

}
