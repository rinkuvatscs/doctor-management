package com.doctor.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

	@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/adddoctor", method = RequestMethod.POST)
	@ResponseBody
	public DoctorResponse addDoctor(@RequestBody Doctor doctor) {

		return new DoctorResponse(doctorDao.addDoctor(doctor));
	}

	@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/deletedoctorById/{doctorId}")
	@ResponseBody
	public DoctorResponse deleteDoctorById(@PathVariable Integer doctorId) {
		if (!StringUtils.isEmpty(doctorId)){
			Doctor doctor = new Doctor();
			doctor.setDoctorId(doctorId);
			return new DoctorResponse(doctorDao.deleteDoctor(doctor));
		}
		else
			return new DoctorResponse();
	}

	@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/deletedoctorByAdharNumber/{doctorAdharNumber}")
	@ResponseBody
	public DoctorResponse deleteDoctorByAdharNumber(@PathVariable String adharNumber) {
		if (!StringUtils.isEmpty(adharNumber)) {
			Doctor doctor = new Doctor();
			doctor.setDoctorAdhaarNumber(adharNumber);
			return new DoctorResponse(doctorDao.deleteDoctor(doctor));
		} else
			return new DoctorResponse();
	}
	
	@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/deletedoctorByMobileNumber/{doctorMobileNumber}")
	@ResponseBody
	public DoctorResponse deleteDoctorByMobileNumber(@PathVariable String mobileNumber) {
		if (!StringUtils.isEmpty(mobileNumber)) {
			Doctor doctor = new Doctor();
			doctor.setDoctorNumber(mobileNumber);
			return new DoctorResponse(doctorDao.deleteDoctor(doctor));
		} else
			return new DoctorResponse();
	}

	@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/getdoctorbyid/{doctorId}")
	@ResponseBody
	public List<Doctor> getDoctorById(@PathVariable Integer doctorId) {

		if (!StringUtils.isEmpty(doctorId) && doctorId.intValue() > 0)
			return doctorDao.getDoctorById(doctorId.intValue());
		else
			return null;
	}

	@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/getdoctorbyadharNumber/{adharNumber}")
	@ResponseBody
	public List<Doctor> getDoctorByAdharNumber(@PathVariable String adharNumber) {

		List<Doctor> doctors = new ArrayList<Doctor>();
		if (!StringUtils.isEmpty(adharNumber))
			doctors = doctorDao.getDoctorByAdharNumber(adharNumber);
		return doctors;
	}

	@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/getdoctorbymobilenumber/{mobileNumber}")
	@ResponseBody
	public List<Doctor> getDoctorByMobileNumber(@PathVariable String mobileNumber) {

		List<Doctor> doctors = new ArrayList<Doctor>();
		if (!StringUtils.isEmpty(mobileNumber))
			doctors = doctorDao.getDoctorByMobileNumber(mobileNumber);
		return doctors;
	}

	// Location need to be added within this operation.
	@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/getdoctorbyname/{name}")
	@ResponseBody
	public List<Doctor> getDoctorByName(@PathVariable String name) {

		List<Doctor> doctors = new ArrayList<Doctor>();
		if (!StringUtils.isEmpty(name))
			doctors = doctorDao.getDoctorByName(name);
		return doctors;
	}

	@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/getdoctorbyexpertisted/{expertisted}")
	@ResponseBody
	public List<Doctor> getDoctorByExpertisted(@PathVariable String expertisted) {

		List<Doctor> doctors = new ArrayList<Doctor>();
		if (!StringUtils.isEmpty(expertisted))
			doctors = doctorDao.getDoctorByExpertisted(expertisted);
		return doctors;
	}

	@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/getdoctorbyconsultingfee/{consultingfee}")
	@ResponseBody
	public List<Doctor> getDoctorByConsultingFee(@PathVariable String consultingfee) {

		List<Doctor> doctors = new ArrayList<Doctor>();
		if (!StringUtils.isEmpty(consultingfee))
			doctors = doctorDao.getDoctorByConsultingFee(consultingfee);
		return doctors;
	}

	@RequestMapping(value = "/updatedoctor", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public DoctorResponse updateDoctor(@RequestBody Doctor doctor) {

		return new DoctorResponse(doctorDao.updateDoctor(doctor));
	}

	@RequestMapping("/")
	public String welcome() {
		return "Welcome to Doctor Management Tool";
	}

}
