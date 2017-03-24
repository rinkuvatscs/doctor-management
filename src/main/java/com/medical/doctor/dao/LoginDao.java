package com.medical.doctor.dao;

import com.medical.doctor.entity.Login;

public interface LoginDao {

	String validateLogin(Login login);

	String signUp(Login login);

}
