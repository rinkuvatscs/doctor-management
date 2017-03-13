package com.medical.doctor.service.impl;

import org.springframework.stereotype.Service;

import com.medical.doctor.entity.Doctor;
import com.medical.doctor.enums.LoginEnum;
import com.medical.doctor.request.LoginRequest;
import com.medical.doctor.service.LoginService;

@Service
public class LoginUsingRestCallImpl implements LoginService{

	@Override
	public int addLoginDetails(Doctor doctor) {
		// TODO Auto-generated method stub
		System.out.println("Temp"); 
		return 0;
	}

	@Override
	public LoginEnum getLoginEnum() {
		return LoginEnum.THROUGH_RESTTEMPLATE ;
	}

	@Override
	public String validateLogin(LoginRequest loginRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String signUp(LoginRequest loginRequest) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
