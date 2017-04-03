package com.medical.solutions.controller;

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

import com.medical.solutions.entity.Appointment;
import com.medical.solutions.exceptionhandler.BadRequestException;
import com.medical.solutions.factory.AppointmentFactory;
import com.medical.solutions.response.AppointmentResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/appointment")
@Api(basePath = "/appointment", value = "appointment", description = "Operations with Landlords", produces = "application/json")
public class AppointmentController {

	@Autowired
	private AppointmentFactory appointmentFactory;

	@RequestMapping(method = RequestMethod.POST, value = "/appointment/make", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "make appointment", notes = "make appointment")
	public AppointmentResponse makeAppointment(@RequestBody Appointment makeAppointment) {

		if (StringUtils.isEmpty(makeAppointment)) {
			throw new BadRequestException("Please provide data");
		} else if (StringUtils.isEmpty(makeAppointment.getdId()) || makeAppointment.getdId() <= 0) {
			throw new BadRequestException("Please provide valid Doctor Id");
		} else if (StringUtils.isEmpty(makeAppointment.getpId()) || makeAppointment.getpId() <= 0) {
			throw new BadRequestException("Please provide valid Patient Id");
		} else if (StringUtils.isEmpty(makeAppointment.getAppointmentDesc())) {
			throw new BadRequestException("Please provide appointment description");
		}

		return new AppointmentResponse(appointmentFactory.getAppointmentService().makeAppointment(makeAppointment));
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/appointment/cancel/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public AppointmentResponse cancelAppointment(@PathVariable Integer id) {

		if (id == null || id <= 0) {
			throw new BadRequestException("Please provide valid Id");
		}
		return new AppointmentResponse(appointmentFactory.getAppointmentService().cancelAppoinment(id));
	}

	@RequestMapping(method = RequestMethod.GET, value = "/appointment/{pId}/patient", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "view appointment", notes = "view appointment")
	public List<Appointment> viewAppointmentByPatient(@PathVariable Integer pId) {

		if (pId == null || pId <= 0) {
			throw new BadRequestException("Please provide valid Id");
		}
		return appointmentFactory.getAppointmentService().viewAppointment(pId);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/appointment/{dId}/doctor", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "view appointment", notes = "view appointment for Doctor")
	public List<Appointment> viewAppointmentForDoctor(@PathVariable Integer dId) {

		if (dId == null || dId <= 0) {
			throw new BadRequestException("Please provide valid Id");
		}
		return appointmentFactory.getAppointmentService().viewAppointmentForDoctor(dId);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/appointment/{dId}/doctorBydId", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "view appointment", notes = "view appointment for Doctor with patient profile")
	public List<Appointment> viewAppointmentForDoctorWithPatientProfile(@PathVariable Integer dId) {

		if (dId == null || dId <= 0) {
			throw new BadRequestException("Please provide valid Id");
		}
		return appointmentFactory.getAppointmentService().doctorAppointmentWithPatientProfile(dId);
	}
	
}
