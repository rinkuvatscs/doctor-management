package com.medical.doctor.patient.controller;

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

import com.medical.doctor.exceptionhandler.BadRequestException;
import com.medical.doctor.patient.entity.PatientLogin;
import com.medical.doctor.patient.factory.PatientLoginFactory;
import com.medical.doctor.patient.request.PatientLoginRequest;
import com.medical.doctor.patient.response.PatientLoginResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/patientLogin")
@Api(basePath = "/patientLogin", value = "patientLogin", description = "Operations with Landlords", produces = "application/json")
public class PatientLoginController {

	@Autowired
	private PatientLoginFactory patientLoginFactory;

	@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, value = "/signUp", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Signup for login", notes = "Signup for login")
	@ApiResponses(value = { @ApiResponse(code = 400, message = "Fields are with validation errors"),
			@ApiResponse(code = 201, message = "") })
	public PatientLoginResponse addLogin(@RequestBody PatientLoginRequest patientLoginRequest) {

		PatientLogin patientLogin = new PatientLogin();

		try {
			BeanUtils.copyProperties(patientLoginRequest, patientLogin);
		} catch (BeansException beansException) {
			throw new BadRequestException("Login Do not have enough information", beansException);
		}

		if (!StringUtils.isEmpty(patientLogin) && !StringUtils.isEmpty(patientLogin.getUsername())
				&& !StringUtils.isEmpty(patientLogin.getPassword())) {
			return new PatientLoginResponse(patientLoginFactory.getPatientLoginService().validateLogin(patientLogin));
		} else {
			throw new BadRequestException("Login Username and Password should not be blank");
		}
	}
}
