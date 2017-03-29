/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medical.solutions.extractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.medical.solutions.entity.Login;

/**
 *
 * @author Preeti
 */
public class LoginExtractor implements ResultSetExtractor<List<Login>> {

	List<Login> loginList = new ArrayList<>();

	@Override
	public List<Login> extractData(ResultSet rs) throws SQLException,
			DataAccessException {
		Login login;

		while (rs.next()) {
			login = new Login();
			login.setEmail(rs.getString("email"));
//			login.setLastLogin(rs.getDate("last_login"));
			login.setMobile(rs.getString("mobile"));
			login.setPassword(rs.getString("Password"));
//			login.setStatus(rs.getString("status"));
			login.setType(rs.getString("type"));
			loginList.add(login);
		}
		return loginList;
	}

}