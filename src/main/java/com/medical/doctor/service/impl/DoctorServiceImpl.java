package com.medical.doctor.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medical.doctor.dao.DoctorDao;
import com.medical.doctor.entity.Doctor;
import com.medical.doctor.service.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorDao doctorDao;

    @Override
    public String addDoctor(Doctor doctor) {

        return doctorDao.addDoctor(doctor);
    }

    @Override
    public String deleteDoctor(Integer doctorId) {

        return doctorDao.deleteDoctor(doctorId);
    }

    @Override
    public Doctor getDoctorById(Integer id) {

        return doctorDao.getDoctorById(id);

    }

    @Override
    public Doctor getDoctorByEmail(String email) {

        return doctorDao.getDoctorByEmail(email);

    }

    @Override
    public Doctor getDoctorByAdharNumber(String adharNumber) {

        return doctorDao.getDoctorByAdharNumber(adharNumber);
    }

    @Override
    public Doctor getDoctorByMobileNumber(String mobileNumber) {

        return doctorDao.getDoctorByMobileNumber(mobileNumber);

    }

    @Override
    public List<Doctor> getDoctorByName(String name) {

        return doctorDao.getDoctorByName(name);
    }

    @Override
    public List<Doctor> getDoctorByExpertisted(String expertisted) {

        return doctorDao.getDoctorByExpertisted(expertisted);
    }

    @Override
    public List<Doctor> getDoctorByConsultingFee(String consultingFee) {

        return doctorDao.getDoctorByConsultingFee(consultingFee);
    }

    @Override
    public String updateDoctor(Doctor doctor) {

        return doctorDao.updateDoctor(doctor);
    }

    @Override
    public String deleteDoctor(Doctor doctor) {

        return doctorDao.deleteDoctor(doctor);
    }

    @Override
    public List<Doctor> getDoctors(Doctor doctor) {

        return doctorDao.getDoctors(doctor);
    }

    @Override
    public Map<Integer, String> getAllExpertized() {

        return doctorDao.getAllExpertized();
    }

    @Override
    public Integer addExpertisation(String expertise) {

        return doctorDao.addExpertisation(expertise);
    }

    @Override
    public boolean isExpertiseExists(String expertise) {

        return doctorDao.isExpertiseExists(expertise);

    }

}
