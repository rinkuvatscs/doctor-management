package com.medical.solutions.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.medical.solutions.entity.NotificationService;
import com.medical.solutions.exceptionhandler.BadRequestException;
import com.medical.solutions.response.NotificationServiceResponse;

@Component
public class NotificationServiceMapper {

	public List<NotificationServiceResponse> mapNotifyServices(
			List<NotificationService> notificationServices) {

		if (StringUtils.isEmpty(notificationServices)
				|| notificationServices.isEmpty()) {
			return null;
		}
		List<NotificationServiceResponse> serviceResponses = new ArrayList<NotificationServiceResponse>(
				notificationServices.size());
		for (NotificationService notificationService : notificationServices) {
			serviceResponses.add(mapNotifyService(notificationService));
		}

		return serviceResponses;
	}

	public NotificationServiceResponse mapNotifyService(
			NotificationService notificationService) {
		NotificationServiceResponse notificationServiceResponse = new NotificationServiceResponse();
		try {
			BeanUtils.copyProperties(notificationService,
					notificationServiceResponse);
		} catch (BeansException beansException) {
			throw new BadRequestException(
					"Not have enough information for mapping", beansException);
		}

		return notificationServiceResponse;
	}
}
