package com.medical.solutions.constants;

public interface AppointmentQueryConstants {

	String INSERT_APPOINTMENT = "INSERT INTO appointment(dId, pId, appointmentDate, appointmentDesc, createdDate) values (?,?,?,?,NOW())";

	String DELETE_APPOINTMENT = "DELETE FROM appointment where appointmentId = ?";

	String GET_APPOINTMENT_BY_PID = " SELECT APP.appointmentId, APP.pId, APP.dId, APP.appointmentDate, APP.appointmentDesc, APP.createdDate, DOC.name, DOC.mobile, "
			+ " DOC.email, DOC.gender, DOC.dob, DOC.profilePicPath, docAddress.latitude, docAddress.longitude from u754709029_doc.appointment AS APP "
			+ " INNER JOIN u754709029_doc.doctor AS DOC ON APP.dId = DOC.dId "
			+ " INNER JOIN u754709029_doc.doctorAddress AS docAddress ON DOC.dId = docAddress.dId WHERE APP.pId = ? ";

	String GET_APPOINTMENT_BY_DID = " SELECT * FROM appointment WHERE dId = ? ";

	String GET_APPOINTMENT_FOR_DOCTORS_BY_DID = "SELECT APP.appointmentId, APP.pId, APP.dId, APP.appointmentDate, APP.appointmentDesc, APP.createdDate, PAT.name, PAT.mobile, PAT.email, "
			+ "PAT.allergies, PAT.gender, PAT.dob, PAT.profilePicPath from u754709029_doc.appointment AS APP INNER JOIN u754709029_doc.patient AS PAT "
			+ "ON APP.pId = PAT.pId WHERE APP.dId = ? ";
}
