package com.medical.doctor.service;

import java.util.List;

import com.medical.doctor.entity.Doctor;
import com.medical.doctor.entity.DoctorAddress;

public interface DoctorService {

    public String addDoctor(Doctor doctor);

    public String deleteDoctor(Integer doctorId);

    public Doctor getDoctorById(Integer id);

    public Doctor getDoctorByAdharNumber(String adharNumber);

    public Doctor getDoctorByMobileNumber(String mobileNumber);

    public List<Doctor> getDoctorByName(String name);

    public Doctor getDoctorByEmail(String email);

    public List<Doctor> getDoctorByExpertisted(String expertisted);

    public List<Doctor> getDoctorByConsultingFee(String consultingFee);

    List<Doctor> getDoctors(Doctor doctor);

    public String updateDoctor(DoctorAddress doctor);

    public String deleteDoctor(Doctor doctor);

    public List<String> getAllExpertized();

    public Integer addExpertisation(String expertise);

    public boolean isExpertiseExists(String expertise);
    
    public List<Doctor> getRecentDoctors(Integer days) ;
    
    public String approveExpertise(Integer expertise);
    
    public List<String> getUnApprovedExpertise() ;
    
    public Integer doctorSignUp(Doctor doctor);
    
    public Boolean checkMobile(String mobile);
    
    public Boolean checkAdhaar(String adhaar);
    
}
