package com.doctor.controller;

import io.swagger.annotations.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.doctor.dao.DoctorDao;
import com.doctor.types.pojo.Doctor;


@RestController
@RequestMapping("/doctor-management")
@Api(basePath = "/doctor-management", value = "doctormanagement", description = "Operations with Landlords", produces = "application/json")
public class DoctorRestController {

	@Autowired
	private DoctorDao doctorDao;
	
	@RequestMapping(
			produces = MediaType.APPLICATION_JSON_VALUE, value = "/adddoctor")
	@ResponseBody
	public DoctorResponse addDoctor(@RequestBody Doctor doctor) {

		return new DoctorResponse(doctorDao.addDoctor(doctor)) ;
	}
	
	
	
	@RequestMapping("/")
	public String welcome(){
		return "Welcome to Doctor Management Tool" ;
	}
	
	
	
}
