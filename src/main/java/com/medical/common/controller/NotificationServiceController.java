package com.medical.common.controller;

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

import com.medical.common.entity.NotificationService;
import com.medical.common.factory.CommonFactory;
import com.medical.common.mappers.NotificationServiceMapper;
import com.medical.common.request.NotificationServiceRequest;
import com.medical.common.response.NotificationServiceResponse;
import com.medical.doctor.exceptionhandler.BadRequestException;

@RestController
@RequestMapping("/api/notification")
@Api(basePath = "/notification", value = "notification", description = "Operations with Landlords", produces = "application/json")
public class NotificationServiceController {

	private static final String COMMON_BADREQEST_MESSAGE = "Doctor Do not have enough information";

	@Autowired
	private CommonFactory commonFactory;
	@Autowired
	private NotificationServiceMapper notificationServiceMapper;

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, value = "/addNotifyforpatient")
	@ResponseBody
	public String addNotifyForPatient(@RequestBody NotificationServiceRequest notificationServiceRequest) {
		NotificationService notificationService = new NotificationService();

		if (StringUtils.isEmpty(notificationServiceRequest)
				&& StringUtils.isEmpty(notificationServiceRequest.getNotiyfMessage())) {
			throw new BadRequestException("Notification can not be null");
		} else if (notificationServiceRequest.getpId() <= 0) {
			throw new BadRequestException("Please provide valid patient Id");
		}
		try {
			BeanUtils.copyProperties(notificationServiceRequest, notificationService);
		} catch (BeansException beansException) {
			throw new BadRequestException(COMMON_BADREQEST_MESSAGE, beansException);
		}
		return commonFactory.getCommonService().addNotifyForPatient(notificationService);
	}

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/getNotifyforpatient/{pId}/pId")
	@ResponseBody
	public List<NotificationServiceResponse> getNotifyforPatient(@PathVariable int pId) {
		if (pId <= 0) {
			throw new BadRequestException("Please provide valid patient Id");
		}
		return notificationServiceMapper.mapNotifyServices(commonFactory.getCommonService().getNotifyForPatient(pId));
	}

	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, value = "/updateNotify")
	@ResponseBody
	public String updateNotify(@RequestBody NotificationServiceRequest notificationServiceRequest) {
		NotificationService notificationService = new NotificationService();
		try {
			BeanUtils.copyProperties(notificationServiceRequest, notificationService);
			if (notificationService.getpId() <= 0 && notificationService.getdId() <= 0) {
				throw new BadRequestException("Please provide valid Id");
			}
		} catch (BeansException beansException) {
			throw new BadRequestException(COMMON_BADREQEST_MESSAGE, beansException);
		}
		return commonFactory.getCommonService().updateNotify(notificationService);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, value = "/addNotifyfordoctor")
	@ResponseBody
	public String addNotifyForDoctor(@RequestBody NotificationServiceRequest notificationServiceRequest) {
		NotificationService notificationService = new NotificationService();

		if (StringUtils.isEmpty(notificationServiceRequest)
				&& StringUtils.isEmpty(notificationServiceRequest.getNotiyfMessage())) {
			throw new BadRequestException("Notification can not be null");
		} else if (notificationServiceRequest.getdId() <= 0) {
			throw new BadRequestException("Please provide valid doctor Id");
		}
		try {
			BeanUtils.copyProperties(notificationServiceRequest, notificationService);
		} catch (BeansException beansException) {
			throw new BadRequestException(COMMON_BADREQEST_MESSAGE, beansException);
		}
		return commonFactory.getCommonService().addNotifyForDoctor(notificationService);
	}

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/getNotifyfordoctor/{dId}/dId")
	@ResponseBody
	public List<NotificationServiceResponse> getNotifyforDoctor(@PathVariable int dId) {
		if (dId <= 0) {
			throw new BadRequestException("Please provide valid Doctor Id");
		}
		return notificationServiceMapper.mapNotifyServices(commonFactory.getCommonService().getNotifyForDoctor(dId));
	}
}
