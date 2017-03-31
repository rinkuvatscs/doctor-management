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

import com.medical.solutions.entity.NotificationService;
import com.medical.solutions.exceptionhandler.BadRequestException;
import com.medical.solutions.factory.CommonFactory;
import com.medical.solutions.mappers.NotificationServiceMapper;
import com.medical.solutions.request.NotificationServiceRequest;
import com.medical.solutions.response.NotificationServiceResponse;

@RestController
@RequestMapping("/api/notification")
@Api(basePath = "/notification", value = "notification", description = "Operations with Landlords", produces = "application/json")
public class NotificationController {

	private static final String COMMON_BADREQEST_MESSAGE = "Doctor Do not have enough information";

	@Autowired
	private CommonFactory commonFactory;
	@Autowired
	private NotificationServiceMapper notificationServiceMapper;

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, value = "/addNotifyforpatient")
	@ResponseBody
	public NotificationServiceResponse addNotifyForPatient(
			@RequestBody NotificationServiceRequest notificationServiceRequest) {
		NotificationService notificationService = new NotificationService();

		if (StringUtils.isEmpty(notificationServiceRequest)
				&& StringUtils.isEmpty(notificationServiceRequest
						.getNotiyfMessage())) {
			throw new BadRequestException("Notification can not be null");
		} else if (notificationServiceRequest.getpId() <= 0) {
			throw new BadRequestException("Please provide valid patient Id");
		}
		try {
			BeanUtils.copyProperties(notificationServiceRequest,
					notificationService);
		} catch (BeansException beansException) {
			throw new BadRequestException(COMMON_BADREQEST_MESSAGE,
					beansException);
		}
		return new NotificationServiceResponse(commonFactory.getCommonService()
				.addNotifyForPatient(notificationService));
	}

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/getNotifyforpatient/{pId}/pId")
	@ResponseBody
	public List<NotificationService> getNotifyforPatient(@PathVariable int pId) {
		if (pId <= 0) {
			throw new BadRequestException("Please provide valid patient Id");
		}
		return notificationServiceMapper.mapNotifyServices(commonFactory
				.getCommonService().getNotifyForPatient(pId));
	}

	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, value = "/updateNotify")
	@ResponseBody
	public NotificationServiceResponse updateNotify(
			@RequestBody NotificationServiceRequest notificationServiceRequest) {
		NotificationService notificationService = new NotificationService();
		try {
			BeanUtils.copyProperties(notificationServiceRequest,
					notificationService);
			if (notificationService.getNotifyId() <= 0) {
				throw new BadRequestException("Please provide valid Id");
			}
		} catch (BeansException beansException) {
			throw new BadRequestException(COMMON_BADREQEST_MESSAGE,
					beansException);
		}
		return new NotificationServiceResponse(commonFactory.getCommonService()
				.updateNotify(notificationService));
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, value = "/addNotifyfordoctor")
	@ResponseBody
	public NotificationServiceResponse addNotifyForDoctor(
			@RequestBody NotificationServiceRequest notificationServiceRequest) {
		NotificationService notificationService = new NotificationService();

		if (StringUtils.isEmpty(notificationServiceRequest)
				&& StringUtils.isEmpty(notificationServiceRequest
						.getNotiyfMessage())) {
			throw new BadRequestException("Notification can not be null");
		} else if (notificationServiceRequest.getdId() <= 0) {
			throw new BadRequestException("Please provide valid doctor Id");
		}
		try {
			BeanUtils.copyProperties(notificationServiceRequest,
					notificationService);
		} catch (BeansException beansException) {
			throw new BadRequestException(COMMON_BADREQEST_MESSAGE,
					beansException);
		}
		return new NotificationServiceResponse(commonFactory.getCommonService()
				.addNotifyForDoctor(notificationService));
	}

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/getNotifyfordoctor/{dId}/dId")
	@ResponseBody
	public List<NotificationService> getNotifyforDoctor(@PathVariable int dId) {
		if (dId <= 0) {
			throw new BadRequestException("Please provide valid Doctor Id");
		}
		return notificationServiceMapper.mapNotifyServices(commonFactory
				.getCommonService().getNotifyForDoctor(dId));
	}
}
