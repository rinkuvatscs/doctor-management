package com.doctor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.doctor.dao.DoctorDao;
import com.doctor.types.pojo.Doctor;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/doctor-management")
@Api(basePath = "/doctor-management", value = "doctormanagement", description = "Operations with Landlords", produces = "application/json")
public class DoctorRestController {

	@Autowired
	private DoctorDao doctorDao;

	@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/adddoctor")
	@ResponseBody
	public DoctorResponse addDoctor(@RequestBody Doctor doctor) {

		return new DoctorResponse(doctorDao.addDoctor(doctor));
	}

	@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/deletedoctor/{doctorId}")
	@ResponseBody
	public DoctorResponse deleteDoctor(@PathVariable Integer doctorId) {
		if (!StringUtils.isEmpty(doctorId) && doctorId.intValue() > 0)
			return new DoctorResponse(doctorDao.deleteDoctor(doctorId.intValue()));
		else
			return new DoctorResponse();
	}

	@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/getdoctor/{doctorId}")
	@ResponseBody
	public Doctor getDoctorById(@PathVariable Integer doctorId) {

		if (!StringUtils.isEmpty(doctorId) && doctorId.intValue() > 0)
			return doctorDao.getDoctorById(doctorId.intValue());
		else
			return new Doctor();
	}

	@RequestMapping("/")
	public String welcome() {
		return "Welcome to Doctor Management Tool";
	}

}
