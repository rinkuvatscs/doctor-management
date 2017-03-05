package com.medical.doctor.constants;

public interface QueryConstants {

	String ADD_DOCTOR = "insert into  DOCTOR(Name,MobileNo,AdhaarNo,"
			+ "Email) values"
			+ "(?,?,?,?)";

	String IS_DOCTOR_EXIST = "SELECT * FROM DOCTOR WHERE ";
	
	String DELETE_DOCTOR = "delete from DOCTOR WHERE DID = ?";

	String GET_DOCTOR_BY_ID = " SELECT * FROM DOCTOR WHERE DID = ? ";

	String GET_DOCTOR_BY_ADHAR_NUMBER = " SELECT * FROM DOCTOR WHERE AdhaarNo = ? ";

	String GET_DOCTOR_BY_MOBILE_NUMBER = " SELECT * FROM DOCTOR WHERE MobileNo = ? ";

	String GET_DOCTOR_BY_NAME = " SELECT * FROM DOCTOR WHERE Name LIKE ? ";

	String GET_DOCTOR_BY_EMAIL = " SELECT * FROM DOCTOR WHERE Email = ? ";

	String GET_DOCTOR_BY_EXPERTISTED = " SELECT * FROM DOCTOR WHERE Expertizes like ? ";

	String GET_DOCTOR_BY_CONSULTING_FEE = " SELECT * FROM DOCTOR WHERE ConsultingFees = ? ";

	String GET_DOCTORS = "SELECT * FROM DOCTOR  ";
	
	//String GET_EXPERTIZED = "select * from expertized where approved ='Y' ";
	
	String GET_ALL_EXPERTIZED = "SELECT * FROM Expertise";
	
	String GET_EXPERTIZED = "SELECT * FROM Expertise WHERE Expertise=?";
	
	
	String ADD_EXPERTIZED = "insert into Expertise(Expertise,Approved) values(?,'true')";
	
}
