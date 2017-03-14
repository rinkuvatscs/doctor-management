package com.medical.doctor.controller;

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

import com.medical.doctor.entity.Email;
import com.medical.doctor.exceptionhandler.BadRequestException;
import com.medical.doctor.factory.MiscFactory;
import com.medical.doctor.response.Response;

@RestController
@RequestMapping("/misc")
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
			throw new BadRequestException("Receiver's address and message can't be blank");
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
			return new Response(miscFactory.getMiscService().SingleTo_MultipleCC(email));
		} else {
			throw new BadRequestException("Receiver's address and message can't be blank");
		}
	}
}
