package com.doctor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.doctor.dao.DoctorDao;
import com.doctor.types.pojo.Doctor;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
@RequestMapping(value = "/doctor-management", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(basePath = "/doctor-management", value = "doctormanagement", description = "Operations with Landlords", produces = "application/json")
public class DoctorRestController {

	@Autowired
	private DoctorDao doctorDao;
	
	@RequestMapping(method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,value = "/addDoctor")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "add new doctor", notes = "add new doctor")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Fields are with validation errors"),
            @ApiResponse(code = 201, message = "") })	
	public String addDoctor(@RequestBody Doctor doctor) {

		String response = doctorDao.addDoctor(doctor);
	    return response;
	    		
	}
	
	

	/*@RequestMapping(value = "/checkDB", produces = MediaType.APPLICATION_JSON_VALUE)
	public String checkDB() {

		String response = null;
		
		response = jdbcTemplate.queryForObject("select curdate() from dual", String.class);
		System.out.println("Date Checking "+response);
		return response;
	}
*/	
	
	
}
