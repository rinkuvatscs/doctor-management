package com.medical.doctor.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.medical.doctor.entity.Login;
import com.medical.doctor.exceptionhandler.BadRequestException;
import com.medical.doctor.factory.LoginFactory;
import com.medical.doctor.request.LoginRequest;
import com.medical.doctor.response.LoginResponse;

@RestController
@RequestMapping("/api/login")
@Api(basePath = "/login", value = "loginmanagement", description = "Operations with Landlords", produces = "application/json")
public class LoginController {

	@Autowired
	private LoginFactory loginFactory;

	@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, value = "/signup", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Signup for login", notes = "Signup for login")
	@ApiResponses(value = { @ApiResponse(code = 400, message = "Fields are with validation errors"),
			@ApiResponse(code = 201, message = "") })
	public LoginResponse addLogin(@RequestBody LoginRequest loginRequest) {
		
		Login login = new Login();
		try {
			BeanUtils.copyProperties(loginRequest, login);
		} catch (BeansException beansException) {
			throw new BadRequestException(
					"Login Do not have enough information", beansException);
		}
		if(!StringUtils.isEmpty(login) && !StringUtils.isEmpty(login.getUsername()) && !StringUtils.isEmpty(login.getPassword())){
			return new LoginResponse(loginFactory.getLoginService().validateLogin(login));	
		}else{
			throw new BadRequestException(
					"Login Username and Password should not be blank");
		}
		
	}
}
