package com.medical.solutions.controller;

import io.swagger.annotations.Api;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.medical.solutions.entity.MessageService;
import com.medical.solutions.exceptionhandler.BadRequestException;
import com.medical.solutions.factory.CommonFactory;
import com.medical.solutions.mappers.MessageServiceMapper;
import com.medical.solutions.request.MessageServiceRequest;
import com.medical.solutions.response.MessageServiceResponse;

@RestController
@RequestMapping("/api/message")
@Api(basePath = "/message", value = "message", description = "Operations with Landlords", produces = "application/json")
public class MessageController {

	private static final String COMMON_BADREQEST_MESSAGE = "Doctor Do not have enough information";

	@Autowired
	private CommonFactory commonFactory;
	@Autowired
	private MessageServiceMapper messgaeServiceMapper;

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, value = "/addmessageforpatient")
	@ResponseBody
	public MessageServiceResponse addMessageForPatient(
			@RequestBody MessageServiceRequest messageServiceRequest) {
		MessageService messageService = new MessageService();

		if (StringUtils.isEmpty(messageServiceRequest)
				&& StringUtils.isEmpty(messageServiceRequest.getMessage())) {
			throw new BadRequestException("Message can not be null");
		} else if (messageServiceRequest.getpId() <= 0) {
			throw new BadRequestException("Please provide valid patient Id");
		}
		try {
			BeanUtils.copyProperties(messageServiceRequest, messageService);
		} catch (BeansException beansException) {
			throw new BadRequestException(COMMON_BADREQEST_MESSAGE,
					beansException);
		}
		return new MessageServiceResponse(commonFactory.getCommonService().addMessageForPatient(
				messageService));
	}

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/getmessageforpatient/{pId}/pId")
	@ResponseBody
	public List<MessageService> getMessageforPatient(
			@PathVariable int pId) {
		if (pId <= 0) {
			throw new BadRequestException("Please provide valid patient Id");
		}
		return messgaeServiceMapper.mapMessageServices(commonFactory
				.getCommonService().getMessageForPatient(pId));
	}

	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, value = "/updatemessage")
	@ResponseBody
	public MessageServiceResponse updateMessage(
			@RequestBody MessageServiceRequest messageServiceRequest) {
		MessageService messages = new MessageService();
		try {
			BeanUtils.copyProperties(messageServiceRequest, messages);
			if (messages.getMessageId() <= 0) {
				throw new BadRequestException("Please provide valid message Id");
			}
		} catch (BeansException beansException) {
			throw new BadRequestException(COMMON_BADREQEST_MESSAGE,
					beansException);
		}
		return new MessageServiceResponse(commonFactory.getCommonService().updateMessage(messages));
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, value = "/addmessagefordoctor")
	@ResponseBody
	public MessageServiceResponse addMessageForDoctor(
			@RequestBody MessageServiceRequest messageServiceRequest) {
		MessageService messageService = new MessageService();

		if (StringUtils.isEmpty(messageServiceRequest)
				&& StringUtils.isEmpty(messageServiceRequest.getMessage())) {
			throw new BadRequestException("Message can not be null");
		} else if (messageServiceRequest.getdId() <= 0) {
			throw new BadRequestException("Please provide valid doctor Id");
		}
		try {
			BeanUtils.copyProperties(messageServiceRequest, messageService);
		} catch (BeansException beansException) {
			throw new BadRequestException(COMMON_BADREQEST_MESSAGE,
					beansException);
		}
		return new MessageServiceResponse(commonFactory.getCommonService().addMessageForDoctor(
				messageService));
	}

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/getmessagefordoctor/{dId}/dId")
	@ResponseBody
	public List<MessageService> getMessageforDoctor(
			@PathVariable int dId) {
		if (dId <= 0) {
			throw new BadRequestException("Please provide valid Doctor Id");
		}
		return messgaeServiceMapper.mapMessageServices(commonFactory
				.getCommonService().getMessageForDoctor(dId));
	}
}
