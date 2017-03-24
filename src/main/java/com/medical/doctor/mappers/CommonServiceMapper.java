package com.medical.doctor.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.medical.doctor.entity.MessageService;
import com.medical.doctor.entity.NotificationService;
import com.medical.doctor.exceptionhandler.BadRequestException;
import com.medical.doctor.response.MessageServiceResponse;
import com.medical.doctor.response.NotificationServiceResponse;

@Component
public class CommonServiceMapper {

	public List<MessageServiceResponse> mapMessageServices(
			List<MessageService> messageServices) {

		if (StringUtils.isEmpty(messageServices) || messageServices.isEmpty()) {
			return null;
		}
		List<MessageServiceResponse> messageServiceResponses = new ArrayList<MessageServiceResponse>(
				messageServices.size());
		for (MessageService messageService : messageServices) {
			messageServiceResponses.add(mapMessageService(messageService));
		}

		return messageServiceResponses;
	}

	public MessageServiceResponse mapMessageService(
			MessageService messageService) {
		MessageServiceResponse messageServiceResponse = new MessageServiceResponse();
		try {
			BeanUtils.copyProperties(messageService, messageServiceResponse);
		} catch (BeansException beansException) {
			throw new BadRequestException(
					"Doctor Do not have enough information for mapping",
					beansException);
		}

		return messageServiceResponse;
	}

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
					"Doctor Do not have enough information for mapping",
					beansException);
		}

		return notificationServiceResponse;
	}
}
