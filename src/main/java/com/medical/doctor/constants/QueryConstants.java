package com.medical.doctor.constants;

public interface QueryConstants {

	String ADD_DOCTOR = "insert into  doctor_detail(doctor_name,doctor_number,doctor_homeaddress,doctor_adhaar_number,"
			+ "doctor_highestdegree,doctor_expertized,is_doctor_govt_servant,onetime_consulting_fee,"
			+ "doctor_days_to_check_free_in_consulting_fee,doctor_shop_address,email,age,gender) values"
			+ "(?,?,?,?,?,?,?,?,?,?,?,?,?)";

	String IS_DOCTOR_EXIST = "SELECT * FROM doctor_detail WHERE ";
	
	String DELETE_DOCTOR = "delete from doctor_detail WHERE doctor_id = ?";

	String GET_DOCTOR_BY_ID = " SELECT * FROM doctor_detail WHERE doctor_id = ? ";

	String GET_DOCTOR_BY_ADHAR_NUMBER = " SELECT * FROM doctor_detail WHERE doctor_adhaar_number = ? ";

	String GET_DOCTOR_BY_MOBILE_NUMBER = " SELECT * FROM doctor_detail WHERE doctor_number = ? ";

	String GET_DOCTOR_BY_NAME = " SELECT * FROM doctor_detail WHERE doctor_name LIKE ? ";

	String GET_DOCTOR_BY_EMAIL = " SELECT * FROM doctor_detail WHERE email = ? ";

	String GET_DOCTOR_BY_EXPERTISTED = " SELECT * FROM doctor_detail WHERE doctor_expertized like ? ";

	String GET_DOCTOR_BY_CONSULTING_FEE = " SELECT * FROM doctor_detail WHERE onetime_consulting_fee = ? ";

	String GET_DOCTORS = "SELECT * FROM doctor_detail  ";
	
	//String GET_EXPERTIZED = "select * from expertized where approved ='Y' ";
	
	String GET_ALL_EXPERTIZED = "SELECT * FROM expertise";
	
	String GET_EXPERTIZED = "SELECT * FROM expertise WHERE expertise=?";
	
	
	String ADD_EXPERTIZED = "insert into expertise(expertise,approved) values(?,'P')";
	
}
