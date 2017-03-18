package com.medical.doctor.patient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;

import com.medical.doctor.patient.entity.Patient;
import com.medical.doctor.exceptionhandler.BadRequestException;
import com.medical.doctor.patient.service.PatientService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/patient")
@Api(basePath = "/patient", value = "patient", description = "Operations with Landlords", produces = "application/json")
public class PatientController {

	@Autowired
	private PatientService patientService;

	@RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, value = "/signUp")
	public Integer patientSignUp(@RequestBody Patient patient) {
		if (!StringUtils.isEmpty(patient) && !patient.getName().isEmpty() && patient.getEmail().isEmpty()
				&& patient.getMobile().isEmpty() && patient.getAdhaar().isEmpty() && patient.getPassword().isEmpty()) {
			return patientService.patientSignUp(patient);
		} else {
			throw new BadRequestException("Patient SignUp details should not be blank");
		}
	}

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/checkAdhaar/{adhaar}")
	public Boolean checkAdhaar(@PathVariable String adhaar) {
		System.out.println(adhaar);
		return patientService.checkMobile(adhaar);
	}

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/checkEmail/{email}")
	public Boolean checkEmail(@PathVariable String email) {
		System.out.println(email);
		return patientService.checkMobile(email);
	}

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/checkMobile/{mobile}")
	public Boolean checkMobile(@PathVariable String mobile) {
		System.out.println(mobile);
		return patientService.checkMobile(mobile);
	}

}
