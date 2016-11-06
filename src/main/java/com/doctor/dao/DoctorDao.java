package com.doctor.dao;

import com.doctor.types.pojo.Doctor;

public interface DoctorDao {

	public String addDoctor(Doctor doctor);

	public boolean isDoctorExists(Doctor doctor);

	public String deleteDoctor(Integer doctorId);
}
