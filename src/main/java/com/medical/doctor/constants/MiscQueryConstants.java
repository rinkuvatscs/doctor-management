package com.medical.doctor.constants;

public interface MiscQueryConstants {

	public static final String ADD_CONTENT = "INSERT INTO contact (id, name, email, mobile, message) VALUES (0, ?, ?, ?, ?)";

	public static final String GET_CONTENT = " SELECT * FROM contact where email='abc@mail.com'";

	public static final String GET_ALL = "SELECT * FROM contact ";

	public static final String UPDATE_CONTENT = "UPDATE contact SET name = ?,  mobile = ?, message = ? WHERE email = ?";
	
	public static final String GET_ADVERTISE_DOCTOR = " SELECT * FROM mahima.doctor WHERE registeredDate >=  ? ";
}
