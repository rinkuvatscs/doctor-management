package com.medical.solutions.dao;

import java.util.List;

import com.medical.solutions.entity.AdvertiseDoctor;

public interface AdvertiseDoctorDao {

	public List<AdvertiseDoctor> getDoctorByDate(AdvertiseDoctor advertiseDoctor);
}
