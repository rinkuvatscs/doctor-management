package com.medical.doctor.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medical.doctor.dao.LoginDao;
import com.medical.doctor.entity.Doctor;
import com.medical.doctor.entity.Login;
import com.medical.doctor.enums.LoginEnum;
import com.medical.doctor.request.LoginRequest;
import com.medical.doctor.service.LoginService;

@Service
public class LoginUsingDatabaseImpl implements LoginService {

	@Autowired
	private LoginDao loginDao;
	
	@Override
	public int addLoginDetails(Doctor doctor) {
		// TODO Auto-generated method stub
		System.out.println("Temp");
		return 0;
	}
	
	@Override
	public String validateLogin(Login login) {
		return loginDao.validateLogin(login);
	}

	@Override
	public LoginEnum getLoginEnum() {
		return LoginEnum.DIRECT_DATABASE;
	}

	@Override
	public String signUp(Login login) {
		// TODO Auto-generated method stub
		return null;
	}

}
