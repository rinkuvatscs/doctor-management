package com.medical.solutions.dao.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.medical.solutions.constants.MiscQueryConstants;
import com.medical.solutions.dao.AdvertiseDoctorDao;
import com.medical.solutions.entity.AdvertiseDoctor;
import com.medical.solutions.extractor.AdvertiseDoctorExtractor;
@Component
public class AdvertiseDoctorDaoImpl implements AdvertiseDoctorDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<AdvertiseDoctor> getDoctorByDate(AdvertiseDoctor advertiseDoctor) {
		String date = dateChange();
		System.out.println(date);
		Object[] args = { date };
		List<AdvertiseDoctor> response = jdbcTemplate.query(MiscQueryConstants.GET_ADVERTISE_DOCTOR, args,
				new AdvertiseDoctorExtractor());
		if (response.size() > 0) {
			return response;
		} else {
			System.out.println("No Data");
			return null;
		}
	}

	public String dateChange() {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.DATE, -10);
		Date date = cal.getTime();
		String dateToString = sdf.format(date);
		return dateToString;
	}

}
