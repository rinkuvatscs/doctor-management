package com.doctor.controller;

import java.util.ArrayList;
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

import com.doctor.service.DoctorService;
import com.doctor.types.pojo.Doctor;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/doctor-management")
@Api(basePath = "/doctor-management", value = "doctormanagement", description = "Operations with Landlords", produces = "application/json")
public class DoctorRestController {

	@Autowired
	private DoctorService doctorService;

	@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, value = "/adddoctor", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "add new doctor", notes = "add new doctor")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Fields are with validation errors"),
            @ApiResponse(code = 201, message = "") })	
	public Response addDoctor(@RequestBody Doctor doctor) {

		return new Response(doctorService.addDoctor(doctor));
	}

	@RequestMapping(method = RequestMethod.DELETE
			,produces = MediaType.APPLICATION_JSON_VALUE, value = "/deletedoctorById/{doctorId}")
	@ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "delete doctor", notes = "delete doctor")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Fields are with validation errors"),
            @ApiResponse(code = 201, message = "") })	
	public Response deleteDoctorById(@PathVariable Integer doctorId) {
		if (!StringUtils.isEmpty(doctorId)) {
			Doctor doctor = new Doctor();
			doctor.setDoctorId(doctorId);
			return new Response(doctorService.deleteDoctor(doctor));
		} else
			return new Response();
	}

	@RequestMapping(method = RequestMethod.DELETE,produces = MediaType.APPLICATION_JSON_VALUE, value = "/deletedoctorByAdharNumber/{doctorAdharNumber}")
	@ResponseBody
	public Response deleteDoctorByAdharNumber(@PathVariable String doctorAdharNumber) {
		if (!StringUtils.isEmpty(doctorAdharNumber)) {
			Doctor doctor = new Doctor();
			doctor.setDoctorAdhaarNumber(doctorAdharNumber);
			return new Response(doctorService.deleteDoctor(doctor));
		} else
			return new Response();
	}

	@RequestMapping(method = RequestMethod.DELETE,consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, value = "/deletedoctor")
	@ResponseBody
	public Response deleteDoctor(@RequestBody Doctor doctor) {

		return new Response(doctorService.deleteDoctor(doctor));
	}

	@RequestMapping(method = RequestMethod.DELETE,produces = MediaType.APPLICATION_JSON_VALUE, value = "/deletedoctorByMobileNumber/{doctorMobileNumber}")
	@ResponseBody
	public Response deleteDoctorByMobileNumber(@PathVariable String doctorMobileNumber) {
		if (!StringUtils.isEmpty(doctorMobileNumber)) {
			Doctor doctor = new Doctor();
			doctor.setDoctorNumber(doctorMobileNumber);
			return new Response(doctorService.deleteDoctor(doctor));
		} else
			return new Response();
	}

	@RequestMapping(method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE, value = "/getdoctorbyid/{doctorId}")
	@ResponseBody
	public Doctor getDoctorById(@PathVariable Integer doctorId) {

		if (!StringUtils.isEmpty(doctorId) && doctorId.intValue() > 0)
			return doctorService.getDoctorById(doctorId.intValue());
		else
			return null;
	}

	@RequestMapping(method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE, value = "/getdoctorbyadharNumber/{adharNumber}")
	@ResponseBody
	public Doctor getDoctorByAdharNumber(@PathVariable String adharNumber) {
		// if (!StringUtils.isEmpty(adharNumber))
		Doctor doctors = doctorService.getDoctorByAdharNumber(adharNumber);
		return doctors;
	}

	@RequestMapping(method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE, value = "/getdoctorbymobilenumber/{mobileNumber}")
	@ResponseBody
	public Doctor getDoctorByMobileNumber(@PathVariable String mobileNumber) {

		Doctor doctors = null;
		// if (!StringUtils.isEmpty(mobileNumber))
		doctors = doctorService.getDoctorByMobileNumber(mobileNumber);
		return doctors;
	}

	// Location need to be added within this operation.
	@RequestMapping(method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE, value = "/getdoctorbyname/{name}")
	@ResponseBody
	public List<Doctor> getDoctorByName(@PathVariable String name) {

		List<Doctor> doctors = new ArrayList<Doctor>();
		if (!StringUtils.isEmpty(name))
			doctors = doctorService.getDoctorByName(name);
		return doctors;
	}

	@RequestMapping(method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE, value = "/getdoctorbyexpertisted/{expertisted}")
	@ResponseBody
	public List<Doctor> getDoctorByExpertisted(@PathVariable String expertisted) {

		List<Doctor> doctors = new ArrayList<Doctor>();
		if (!StringUtils.isEmpty(expertisted))
			doctors = doctorService.getDoctorByExpertisted(expertisted);
		return doctors;
	}

	@RequestMapping(method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE, value = "/getdoctorbyconsultingfee/{consultingfee}")
	@ResponseBody
	public List<Doctor> getDoctorByConsultingFee(@PathVariable String consultingfee) {

		List<Doctor> doctors = new ArrayList<Doctor>();
		if (!StringUtils.isEmpty(consultingfee))
			doctors = doctorService.getDoctorByConsultingFee(consultingfee);
		return doctors;
	}

	@RequestMapping(method = RequestMethod.PUT,value = "/updatedoctor", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "update doctor", notes = "update doctor")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Fields are with validation errors"),
            @ApiResponse(code = 201, message = "") })	
	public Response updateDoctor(@RequestBody Doctor doctor) {

		return new Response(doctorService.updateDoctor(doctor));
	}

	@RequestMapping(method = RequestMethod.GET,value="/")
	public String welcome() {
		return "Welcome to Doctor Management Tool";
	}

}
