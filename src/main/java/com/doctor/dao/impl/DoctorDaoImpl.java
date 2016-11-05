package com.doctor.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.doctor.dao.DoctorDao;
import com.doctor.types.pojo.Doctor;

@Component
public class DoctorDaoImpl implements DoctorDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	private String addDoctorSQL = "insert into  doctor_detail(doctor_name,doctor_number,doctor_homeaddress,doctor_adhaar_number,doctor_highestdegree,doctor_expertized,is_doctor_govt_servant,onetime_consulting_fee,doctor_days_to_check_free_in_consuting_fee,doctor_shop_address)"
			+ " values" + "(?,?,?,?,?,?,?,?,?,?)";

	@Override
	public String addDoctor(Doctor doctor) {
	
		int row = jdbcTemplate.update(addDoctorSQL,
				new Object[] { doctor.getDoctorName(), doctor.getDoctorNumber(), doctor.getDoctorHomeAddress(),
						doctor.getDoctorAdhaarNumber(), doctor.getDoctorHighestDegree(), doctor.getDoctorExpertized(),
						doctor.getDoctorGovtServent(), doctor.getDoctorOneTimeConsultingFee(),
						doctor.getDoctorDaystoCheckFreeInConsultingFee(), doctor.getDoctorShopAddress() });
		if (row == 1)
			return "SUCCESS";
		else
			return "FAILURE";
	}

}
