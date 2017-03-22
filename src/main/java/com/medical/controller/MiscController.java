package com.medical.controller;

import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.medical.doctor.entity.AdvertiseDoctor;
import com.medical.doctor.entity.Contact;
import com.medical.doctor.entity.Email;
import com.medical.doctor.exceptionhandler.BadRequestException;
import com.medical.doctor.factory.MiscFactory;
import com.medical.doctor.response.Response;

@RestController
@RequestMapping("/api/misc")
@Api(basePath = "/misc", value = "misc", description = "Operations with Landlords", produces = "application/json")
public class MiscController {

	@Autowired
	private MiscFactory miscFactory;

	@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, value = "/singleto", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value = "add new email", notes = "add new email")
	@ApiResponses(value = {
			@ApiResponse(code = 400, message = "Fields are with validation errors"),
			@ApiResponse(code = 201, message = "") })
	public Response sendEmail_SingleTO(
			@RequestBody com.medical.doctor.request.MiscEmailRequest miscEmailRequest) {

		Email email = new Email();
		try {
			BeanUtils.copyProperties(miscEmailRequest, email);
		} catch (BeansException beansException) {
			throw new BadRequestException("Email address is not correct",
					beansException);
		}

		if (!StringUtils.isEmpty(email) && !StringUtils.isEmpty(email.getTo())
				&& !StringUtils.isEmpty(email.getMessage())) {
			return new Response(miscFactory.getMiscService().sendMail(email));
		} else {
			throw new BadRequestException(
					"Receiver's address and message can't be blank");
		}
	}

	@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, value = "/singletomultiplecc", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value = "add new email", notes = "add new email")
	@ApiResponses(value = {
			@ApiResponse(code = 400, message = "Fields are with validation errors"),
			@ApiResponse(code = 201, message = "") })
	public Response emailSingleTO_MultipleCC(
			@RequestBody com.medical.doctor.request.MiscEmailRequest miscEmailRequest) {

		Email email = new Email();
		try {
			BeanUtils.copyProperties(miscEmailRequest, email);
		} catch (BeansException beansException) {
			throw new BadRequestException("Email address is not correct",
					beansException);
		}

		if (!StringUtils.isEmpty(email) && !StringUtils.isEmpty(email.getTo())
				&& !StringUtils.isEmpty(email.getMessage())) {
			return new Response(miscFactory.getMiscService()
					.SingleTo_MultipleCC(email));
		} else {
			throw new BadRequestException(
					"Receiver's address and message can't be blank");
		}
	}

	// controller for contact service affected from contactUs page of UI

	@RequestMapping(value = "/addContact", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public String AddContact(@RequestBody Contact contact) {
		String response = miscFactory.getMiscService().addContact(contact);
		return response;
	}

	@RequestMapping(value = "/getContact", method = RequestMethod.GET)
	public Contact getContact() {
		return miscFactory.getMiscService().getContact();
	}

	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public List<Contact> getAll() {

		return miscFactory.getMiscService().getAll();
	}

	@RequestMapping(value = "/updateContact", method = RequestMethod.PUT)
	public String updateContent(@RequestBody Contact contact) {

		return miscFactory.getMiscService().updateContact(contact);
	}

	// controller for advertise doctor in front page of UI

	@RequestMapping("/advertiseDoctor")
	public List<AdvertiseDoctor> test() {
		AdvertiseDoctor advertiseDoctor = new AdvertiseDoctor();
		advertiseDoctor.setId(1);
		advertiseDoctor.setDoctorName("Mahima");
		advertiseDoctor.setClinicName("ABC");
		advertiseDoctor.setClinicAddress("Delhi");
		List<AdvertiseDoctor> response = miscFactory.getMiscService()
				.getDoctorByDate(advertiseDoctor);
		return response;

	}
}
