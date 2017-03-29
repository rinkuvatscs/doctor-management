package com.medical.solutions.constants;

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
	//TODO nedd to modify
	String GET_DOCTOR_BY_AND_EXPERTISTED = "SELECT id, ( 3959 * acos( cos( radians(37) ) * cos( radians( lat ) ) * cos( radians( lng )"
			+ " - radians(-122) ) + sin( radians(37) ) * sin( radians( lat ) ) ) )"
			+ " AS distance FROM markers HAVING distance < 25 ORDER BY distance LIMIT 0 , 20";
	
	String GET_DOCTOR_BY_CONSULTING_FEE = " SELECT * FROM doctor WHERE fee = ? ";

	String GET_DOCTORS = "SELECT * FROM doctor  ";

	String GET_ALL_EXPERTIZED = "SELECT * FROM expertise";

	String GET_EXPERTIZED = "SELECT * FROM expertise WHERE expertise=?";

	String ADD_EXPERTIZED = "insert into expertise(expertise) values(?)";

	String GET_UNAPPROVED_EXPERTISE = "SELECT * FROM expertise WHERE approved = 0";

	String APPROVE_EXPERTISE = "update expertise SET approved  = 1";

	String INSERT_DOCTOR = "insert into doctor (name, mobile, adhaar, email, createdDate) values (?,?,?,?, NOW())";

	String GET_DOCTOR_BY_MOBILE = "Select * from doctor where mobile = ? ";

	String INSERT_DOCTOR_ADDRESS_AT_SIGNUP = "insert into doctorAddress(dId,createdDate) values(?,NOW()) ";

}
