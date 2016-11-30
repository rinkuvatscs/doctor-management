package com.doctor.dao;

import java.util.List;

import com.doctor.types.pojo.Doctor;

public interface DoctorDao {

	public String addDoctor(Doctor doctor);

	public boolean isDoctorExists(Doctor doctor);

	public String deleteDoctor(Integer doctorId);
	
	public List<Doctor> getDoctorById(Integer id);
	
	public List<Doctor> getDoctorByAdharNumber(String adharNumber);
	
	public List<Doctor> getDoctorByMobileNumber(String mobileNumber);
	
	public List<Doctor> getDoctorByName(String name);
	
	public List<Doctor> getDoctorByExpertisted(String expertisted);
	
	public List<Doctor> getDoctorByConsultingFee(String consultingFee);
	
	public String updateDoctor(Doctor doctor);
}
