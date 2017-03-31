package com.medical.solutions.extractor;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.ResultSetExtractor;

import com.medical.solutions.entity.Appointment;
import com.medical.solutions.entity.Patient;

public class AppointmentExtractor implements
		ResultSetExtractor<List<Appointment>> {

	@Override
	public List<Appointment> extractData(ResultSet rs) throws SQLException {

		List<Appointment> appointments = new ArrayList<>();
		Appointment appointment;
		ResultSetMetaData rsmd = rs.getMetaData();
		while (rs.next()) {
			appointment = new Appointment();
			appointment.setAppointmentDesc(rs.getString("appointmentDesc"));
			appointment.setAppointmentId(rs.getInt("appointmentId"));
			appointment.setCreatedDate(rs.getDate("createdDate"));
			appointment.setdId(rs.getInt("dId"));
			appointment.setpId(rs.getInt("pId"));

			Patient patient = new Patient();
			for (int i = 6; i <= rsmd.getColumnCount(); i++) {
				if ("name".equals(rsmd.getColumnName(i))) {
					patient.setName(rs.getString("name"));
				} else if ("mobile".equals(rsmd.getColumnName(i))) {
					patient.setMobile(rs.getString("mobile"));
				} else if ("email".equals(rsmd.getColumnName(i))) {
					patient.setEmail(rs.getString("email"));
				} else if ("allergies".equals(rsmd.getColumnName(i))) {
					patient.setAllergies(rs.getString("allergies"));
				} else if ("gender".equals(rsmd.getColumnName(i))) {
					patient.setGender(rs.getString("gender"));
				} else if ("dob".equals(rsmd.getColumnName(i))) {
					patient.setDOB(rs.getDate("dob"));
				} else if ("profilePicPath".equals(rsmd.getColumnName(i))) {
					patient.setProfilePicPath(rs.getString("profilePicPath"));
				}
			}
			appointment.setPatient(patient);
			appointments.add(appointment);
		}
		return appointments;
	}

}
