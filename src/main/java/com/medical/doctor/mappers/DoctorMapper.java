package com.medical.doctor.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.stereotype.Component;

import com.medical.doctor.entity.Doctor;
import com.medical.doctor.exceptionhandler.BadRequestException;
import com.medical.doctor.response.DoctorResponse;

@Component
public class DoctorMapper {

	public List<DoctorResponse> mapDoctors(List<Doctor> doctors) {
		List<DoctorResponse> doctorRespones = new ArrayList<DoctorResponse>(
				doctors.size());
		for (Doctor doctor : doctors) {
			doctorRespones.add(mapDoctor(doctor));
		}

		return doctorRespones;
	}

	public DoctorResponse mapDoctor(Doctor doctor) {
		DoctorResponse doctorResponse = new DoctorResponse();
		try {
			BeanUtils.copyProperties(doctor, doctorResponse);
		} catch (BeansException beansException) {
			throw new BadRequestException(
					"Doctor Do not have enough information for mapping",
					beansException);
		}

		return doctorResponse;
	}
}
