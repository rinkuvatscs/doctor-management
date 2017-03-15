package com.medical.doctor.extractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.medical.doctor.entity.AdvertiseDoctor;

public class AdvertiseDoctorExtractor implements
		ResultSetExtractor<List<AdvertiseDoctor>> {

	@Override
	public List<AdvertiseDoctor> extractData(ResultSet rs) throws SQLException,
			DataAccessException {
		List<AdvertiseDoctor> advertiseDoctors = new ArrayList<AdvertiseDoctor>();
		AdvertiseDoctor advertiseDoctor = null;

		while (rs.next()) {
			advertiseDoctor = new AdvertiseDoctor();
			advertiseDoctor.setId(rs.getInt("id"));
			advertiseDoctor.setDoctorName(rs.getString("doctorName"));
			advertiseDoctor.setClinicName(rs.getString("clinicName"));
			advertiseDoctor.setClinicAddress(rs.getString("clinicAddress"));
			advertiseDoctor.setRegisteredDate(rs.getDate("registeredDate"));
			advertiseDoctors.add(advertiseDoctor);
		}

		return advertiseDoctors;
	}

}
