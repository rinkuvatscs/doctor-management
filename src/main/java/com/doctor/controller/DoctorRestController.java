package com.doctor.controller;

import io.swagger.annotations.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doctor.types.pojo.Doctor;


@RestController
@RequestMapping("/doctor")
@Api(description = "Doctor management API")
public class DoctorRestController {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@RequestMapping(value = "/addDoctor", produces = MediaType.APPLICATION_JSON_VALUE)
	public String addDoctor(Doctor doctor) {

		String response = null;
		
		
		return response;
	}
	
	
	@RequestMapping(value = "/checkDB", produces = MediaType.APPLICATION_JSON_VALUE)
	public String checkDB() {

		String response = null;
		
		response = jdbcTemplate.queryForObject("select curdate() from dual", String.class);
		System.out.println("Date Checking "+response);
		return response;
	}
	
	
	
}
