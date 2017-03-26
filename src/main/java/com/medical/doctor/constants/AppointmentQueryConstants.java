package com.medical.doctor.constants;

public interface AppointmentQueryConstants {

	String INSERT_APPOINTMENT = "INSERT INTO appointment(dId, pId, appointmentDesc, createdDate) values (?,?,?,NOW())";

	String DELETE_APPOINTMENT = "DELETE FROM appointment where appointmentId = ?";

	String GET_APPOINTMENT_BY_PID = " SELECT * FROM appointment WHERE pId = ? ";
	
	String GET_APPOINTMENT_BY_DID = " SELECT * FROM appointment WHERE dId = ? ";
}
