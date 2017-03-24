package com.medical.doctor.dao;

import java.util.List;

import com.medical.doctor.entity.Doctor;

public interface DoctorDao {

    public String addDoctor(Doctor doctor);

    public boolean isDoctorExists(Doctor doctor);

    public String deleteDoctor(Integer doctorId);

    public List<Doctor> getDoctors(Doctor doctor);

    public Doctor getDoctorById(Integer id);

    public Doctor getDoctorByEmail(String email);

    public Doctor getDoctorByAdharNumber(String adharNumber);

    public Doctor getDoctorByMobileNumber(String mobileNumber);

    public List<Doctor> getDoctorByName(String name);

    public List<Doctor> getDoctorByExpertisted(String expertisted);

    public List<Doctor> getDoctorByConsultingFee(String consultingFee);

    public String updateDoctor(Doctor doctor);

    public String deleteDoctor(Doctor doctor);

    public List<String> getAllExpertized();

    public Integer addExpertisation(String expertise);
    
    public String approveExpertise(Integer expertise);
    
    public List<String> getUnApprovedExpertise() ;
    
    public boolean isExpertiseExists(String expertise);
    
    public List<Doctor> getRecentDoctors(Integer days);
    
    public Integer doctorSignUp(Doctor doctor);
    
    public Boolean checkMobile(String mobile);
    
    public Boolean checkAdhaar(String adhaar);
    
    public Boolean checkEmail(String email);
}
