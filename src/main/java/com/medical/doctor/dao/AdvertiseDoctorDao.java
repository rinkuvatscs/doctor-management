package com.medical.doctor.dao;

import java.util.List;

import com.medical.doctor.entity.AdvertiseDoctor;

public interface AdvertiseDoctorDao {

	public List<AdvertiseDoctor> getDoctorByDate(AdvertiseDoctor advertiseDoctor);
}
