package com.doctor.controller;

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

import com.doctor.exceptionhandler.BadRequestException;
import com.doctor.response.Response;
import com.doctor.service.DoctorService;
import com.doctor.types.entity.Doctor;

@RestController
@RequestMapping("/doctor")
@Api(basePath = "/doctor", value = "doctor", description = "Operations with Landlords", produces = "application/json")
public class DoctorController {

	@Autowired
	private DoctorService doctorService;

	@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, value = "/", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value = "add new doctor", notes = "add new doctor")
	@ApiResponses(value = {
			@ApiResponse(code = 400, message = "Fields are with validation errors"),
			@ApiResponse(code = 201, message = "") })
	public Response addDoctor(@RequestBody Doctor doctor) {

		if (!StringUtils.isEmpty(doctor)
				&& !StringUtils.isEmpty(doctor.getAadhaarNumber())
				&& !StringUtils.isEmpty(doctor.getMobile())) {
			return new Response(doctorService.addDoctor(doctor));
		} else {
			throw new BadRequestException(
					"Doctor Aaddhar Number and Mobile Number should not be blank");
		}
	}

	@RequestMapping(method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE, value = "/deletedoctorById/{doctorId}")
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
			throw new BadRequestException("Doctor Id should not be blank");
	}

	@RequestMapping(method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE, value = "/deletedoctorByAdharNumber/{doctorAdharNumber}")
	@ResponseBody
	public Response deleteDoctorByAdharNumber(
			@PathVariable String doctorAdharNumber) {
		if (!StringUtils.isEmpty(doctorAdharNumber)) {
			Doctor doctor = new Doctor();
			doctor.setAadhaarNumber(doctorAdharNumber);
			return new Response(doctorService.deleteDoctor(doctor));
		} else
			throw new BadRequestException(
					"Doctor Aaddhar Number should not be blank");
	}

	@RequestMapping(method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, value = "/deletedoctor")
	@ResponseBody
	public Response deleteDoctor(@RequestBody Doctor doctor) {

		return new Response(doctorService.deleteDoctor(doctor));
	}

	@RequestMapping(method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE, value = "/deletedoctorByMobileNumber/{doctorMobileNumber}")
	@ResponseBody
	public Response deleteDoctorByMobileNumber(
			@PathVariable String doctorMobileNumber) {
		if (!StringUtils.isEmpty(doctorMobileNumber)) {
			Doctor doctor = new Doctor();
			doctor.setMobile(doctorMobileNumber);
			return new Response(doctorService.deleteDoctor(doctor));
		} else
			throw new BadRequestException(
					"Doctor Mobile Number should not be blank");
	}

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/getdoctorbyid/{doctorId}")
	@ResponseBody
	public Doctor getDoctorById(@PathVariable Integer doctorId) {

		if (!StringUtils.isEmpty(doctorId) && doctorId.intValue() > 0) {
			return doctorService.getDoctorById(doctorId.intValue());
		} else {
			throw new BadRequestException("Doctor ID should not be blank");
		}
	}

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/getdoctorbyadharNumber/{adharNumber}")
	@ResponseBody
	public Doctor getDoctorByAdharNumber(@PathVariable String adharNumber) {
		if (!StringUtils.isEmpty(adharNumber)) {
			return doctorService.getDoctorByAdharNumber(adharNumber);
		} else {
			throw new BadRequestException(
					"Doctor AAdhar Number should not be blank");
		}

	}

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/getdoctorbymobilenumber/{mobileNumber}")
	@ResponseBody
	public Doctor getDoctorByMobileNumber(@PathVariable String mobileNumber) {

		if (!StringUtils.isEmpty(mobileNumber)) {
			return doctorService.getDoctorByMobileNumber(mobileNumber);
		} else {
			throw new BadRequestException(
					"Doctor Mobile Number should not be blank");
		}
	}

	// Location need to be added within this operation.
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/getdoctorbyname/{name}")
	@ResponseBody
	public List<Doctor> getDoctorByName(@PathVariable String name) {

		if (!StringUtils.isEmpty(name)) {
			return doctorService.getDoctorByName(name);
		} else {
			throw new BadRequestException("Doctor Name should not be blank");
		}
	}

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/getdoctorbyexpertisted/{expertisted}")
	@ResponseBody
	public List<Doctor> getDoctorByExpertisted(@PathVariable String expertisted) {

		if (!StringUtils.isEmpty(expertisted)) {
			return doctorService.getDoctorByExpertisted(expertisted);
		} else {
			throw new BadRequestException(
					"Doctor Expertisted should not be blank");
		}
	}

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/getdoctorbyconsultingfee/{consultingfee}")
	@ResponseBody
	public List<Doctor> getDoctorByConsultingFee(
			@PathVariable String consultingfee) {

		if (!StringUtils.isEmpty(consultingfee)) {
			return doctorService.getDoctorByConsultingFee(consultingfee);
		} else {
			throw new BadRequestException(
					"Doctor ConsultingFee should not be blank");
		}
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/updatedoctor", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "update doctor", notes = "update doctor")
	@ApiResponses(value = {
			@ApiResponse(code = 400, message = "Fields are with validation errors"),
			@ApiResponse(code = 201, message = "") })
	public Response updateDoctor(@RequestBody Doctor doctor) {

		return new Response(doctorService.updateDoctor(doctor));
	}

	@RequestMapping(method = RequestMethod.GET, value = "/")
	public String welcome() {
		return "Welcome to Doctor Management Tool";
	}

}
