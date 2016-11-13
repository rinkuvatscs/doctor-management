package com.doctor.dao;

import java.util.List;

import com.doctor.types.pojo.Doctor;

public interface DoctorDao {

	public String addDoctor(Doctor doctor);

	public boolean isDoctorExists(Doctor doctor);

	public String deleteDoctor(Integer doctorId);
	
	public Doctor getDoctorById(Integer id);
	
	public Doctor getDoctorByAdharNumber(String adharNumber);
	
	public Doctor getDoctorByMobileNumber(String mobileNumber);
	
	public List<Doctor> getDoctorByName(String name);
}
