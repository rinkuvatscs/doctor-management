package com.medical.doctor.service;

import com.medical.doctor.entity.Doctor;
import com.medical.doctor.enums.LoginEnum;
import com.medical.doctor.request.LoginRequest;

public interface LoginService {

	public int addLoginDetails(Doctor doctor) ;
	
	public LoginEnum getLoginEnum() ;

	public String validateLogin(LoginRequest loginRequest);
	
	public String signUp(LoginRequest loginRequest);
}
