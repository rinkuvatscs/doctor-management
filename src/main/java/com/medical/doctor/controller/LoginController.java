package com.medical.doctor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.medical.doctor.factory.LoginFactory;
import com.medical.doctor.request.LoginRequest;
import com.medical.doctor.response.LoginResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/login")
@Api(basePath = "/login", value = "loginmanagement", description = "Operations with Landlords", produces = "application/json")
public class LoginController {

//	@Autowired
//	private LoginService loginService;
	@Autowired
	private LoginFactory LoginFactory;

	@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, value = "/signup", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Signup for login", notes = "Signup for login")
	@ApiResponses(value = { @ApiResponse(code = 400, message = "Fields are with validation errors"),
			@ApiResponse(code = 201, message = "") })
	public ResponseEntity<LoginResponse> addLogin(@RequestBody LoginRequest loginRequest) {
		LoginResponse loginResponse = new LoginResponse();
		String response = LoginFactory.getLoginService().validateLogin(loginRequest);
		loginResponse.setMessage(response);
		return new ResponseEntity<LoginResponse>(loginResponse, HttpStatus.OK);
	}
	
	/*@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, value = "/", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value = "validate login", notes = "validate login")
	@ApiResponses(value = { @ApiResponse(code = 400, message = "Fields are with validation errors"),
			@ApiResponse(code = 201, message = "") })
	public ResponseEntity<LoginResponse> validateLogin(@RequestBody LoginRequest loginRequest) {
		LoginResponse loginResponse = new LoginResponse();
		String response = loginService.validateLogin(loginRequest);
		loginResponse.setMessage(response);
		return new ResponseEntity<LoginResponse>(loginResponse, HttpStatus.OK);
	}*/

}
