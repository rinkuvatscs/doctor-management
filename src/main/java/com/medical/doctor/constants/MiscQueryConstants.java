package com.medical.doctor.constants;

public interface MiscQueryConstants {

	public static final String ADD_CONTENT = "INSERT INTO contactUs (contactUsId, name, mobile, email, message) VALUES (0, ?, ?, ?, ?)";

	public static final String GET_CONTENT = " SELECT * FROM contactUs where email=? ";

	public static final String GET_ALL = "SELECT * FROM contactUs ";
	//where close =1;

	public static final String UPDATE_CONTENT = "UPDATE contactUs SET name = ?,  mobile = ?, message = ? WHERE email = ?";

	public static final String GET_ADVERTISE_DOCTOR = " SELECT * FROM mahima.doctor WHERE registeredDate >=  ? ";
}
