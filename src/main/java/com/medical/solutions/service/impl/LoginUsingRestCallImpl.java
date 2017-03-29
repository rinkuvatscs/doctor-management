package com.medical.solutions.service.impl;

import org.springframework.stereotype.Service;

import com.medical.solutions.entity.Doctor;
import com.medical.solutions.entity.Login;
import com.medical.solutions.enums.LoginEnum;
import com.medical.solutions.service.LoginService;

@Service
public class LoginUsingRestCallImpl implements LoginService {

	@Override
	public int addLoginDetails(Doctor doctor) {
		// TODO Auto-generated method stub
		System.out.println("Temp");
		return 0;
	}

	@Override
	public LoginEnum getLoginEnum() {
		return LoginEnum.THROUGH_RESTTEMPLATE;
	}

	@Override
	public String validateLogin(Login login) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String signUp(Login login) {
		// TODO Auto-generated method stub
		return null;
	}

}
