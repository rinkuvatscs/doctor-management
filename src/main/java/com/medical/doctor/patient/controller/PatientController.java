package com.medical.doctor.patient.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.medical.doctor.exceptionhandler.BadRequestException;
import com.medical.doctor.patient.entity.Patient;
import com.medical.doctor.patient.response.PatientResponse;
import com.medical.doctor.patient.service.PatientService;

@RestController
@RequestMapping("/api/patient")
@Api(basePath = "/patient", value = "patient", description = "Operations with Landlords", produces = "application/json")
public class PatientController {

	@Autowired
	private PatientService patientService;

	@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, value = "/", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value = "add new patient", notes = "add new patient")
	@ApiResponses(value = { @ApiResponse(code = 400, message = "Fields are with validation errors"),
			@ApiResponse(code = 201, message = "") })
	public PatientResponse addPatient(@RequestBody Patient patient) {

		if (!StringUtils.isEmpty(patient) && !StringUtils.isEmpty(patient.getAdhaar())
				&& !StringUtils.isEmpty(patient.getMobile()) && !StringUtils.isEmpty(patient.getEmail())) {
			return new PatientResponse(patientService.addpatient(patient));
		} else {
			throw new BadRequestException("patient Aadhar Number,Mobile Number and Email Id should not be blank");
		}

	}

	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, value = "/get/{aadhaar}/aadhaar")
	@ResponseBody
	public Patient getPatientByAdharNumber(@PathVariable String aadharNumber) {
		if (!StringUtils.isEmpty(aadharNumber)) {
			return patientService.getpatientByAdharNumber(aadharNumber);
		} else {
			throw new BadRequestException("patient Aadhar Number should not be blank");
		}

	}

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/get/{mobile}/mobile")
	@ResponseBody
	public Patient getPatientByMobile(@PathVariable String mobile) {
		if (!StringUtils.isEmpty(mobile)) {
			return patientService.getpatientByMobileNumber(mobile);
		} else {
			throw new BadRequestException("patient Mobile Number should not be blank");
		}

	}

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/get/{id}/id")
	@ResponseBody
	public Patient getPatientByPatientId(@PathVariable String patientId) {
		if (!StringUtils.isEmpty(patientId)) {
			Integer patientIdInt = 0;
			try {
				patientIdInt = Integer.parseInt(patientId);
			} catch (NumberFormatException numberFormatException) {
				throw new BadRequestException("patient ID should not be Alpanumeric. It Should be Number only");
			}
			return patientService.getpatientById(patientIdInt);
		} else {
			throw new BadRequestException("patient ID should not be blank");
		}

	}

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/get/{email:.+}/email")
	@ResponseBody
	public Patient getPatientByEmail(@PathVariable String email) {
		if (!StringUtils.isEmpty(email)) {
			return patientService.getpatientByEmail(email);
		} else {
			throw new BadRequestException("patient Email should not be blank");
		}

	}

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/get/{name}/name")
	@ResponseBody
	public List<Patient> getPatientByName(@PathVariable String name) {
		if (!StringUtils.isEmpty(name)) {
			return patientService.getpatientByName(name);
		} else {
			throw new BadRequestException("patient Name should not be blank");
		}

	}

	@RequestMapping(method = RequestMethod.PUT, value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "update patient", notes = "update patient")
	@ApiResponses(value = { @ApiResponse(code = 400, message = "Fields are with validation errors"),
			@ApiResponse(code = 201, message = "") })
	public PatientResponse updatePatient(@RequestBody Patient patient) {

		return new PatientResponse(patientService.updatepatient(patient));
	}

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
