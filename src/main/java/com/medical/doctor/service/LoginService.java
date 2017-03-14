package com.medical.doctor.service;

import com.medical.doctor.entity.Doctor;
import com.medical.doctor.entity.Login;
import com.medical.doctor.enums.LoginEnum;

public interface LoginService {

	public int addLoginDetails(Doctor doctor) ;
	
	public LoginEnum getLoginEnum() ;

	public String validateLogin(Login login);
	
	public String signUp(Login login);
}
