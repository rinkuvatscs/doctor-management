package com.medical.doctor.dao;

import com.medical.doctor.request.LoginRequest;

public interface LoginDao {

	String validateLogin(LoginRequest loginRequest);

	String signUp(LoginRequest loginRequest);

}
