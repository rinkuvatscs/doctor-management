package com.medical.solutions.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.medical.solutions.entity.NotificationService;
import com.medical.solutions.exceptionhandler.BadRequestException;

@Component
public class NotificationServiceMapper {

	public List<NotificationService> mapNotifyServices(
			List<NotificationService> notificationServices) {

		if (StringUtils.isEmpty(notificationServices)
				|| notificationServices.isEmpty()) {
			return null;
		}
		List<NotificationService> serviceResponses = new ArrayList<>(
				notificationServices.size());
		for (NotificationService notificationService : notificationServices) {
			serviceResponses.add(mapNotifyService(notificationService));
		}

		return serviceResponses;
	}

	public NotificationService mapNotifyService(
			NotificationService notificationService) {
		NotificationService notificationServiceResponse = new NotificationService();
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
