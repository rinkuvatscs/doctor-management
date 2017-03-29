package com.medical.solutions.service;

import com.medical.solutions.entity.Doctor;
import com.medical.solutions.entity.Login;
import com.medical.solutions.enums.LoginEnum;

public interface LoginService {

	public int addLoginDetails(Doctor doctor) ;
	
	public LoginEnum getLoginEnum() ;

	public String validateLogin(Login login);
	
	public String signUp(Login login);
}
