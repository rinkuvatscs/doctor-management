package com.medical.solutions.dao;

import com.medical.solutions.entity.Login;

public interface LoginDao {

	String validateLogin(Login login);

	String signUp(Login login);

}
