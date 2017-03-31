package com.medical.solutions.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.medical.solutions.entity.MessageService;
import com.medical.solutions.exceptionhandler.BadRequestException;
import com.medical.solutions.response.MessageServiceResponse;

@Component
public class MessageServiceMapper {

	public List<MessageService> mapMessageServices(
			List<MessageService> messageServices) {

		if (StringUtils.isEmpty(messageServices) || messageServices.isEmpty()) {
			return null;
		}
		List<MessageService> messageServiceResponses = new ArrayList<>(
				messageServices.size());
		for (MessageService messageService : messageServices) {
			messageServiceResponses.add(mapMessageService(messageService));
		}

		return messageServiceResponses;
	}

	public MessageService mapMessageService(MessageService messageServices) {
		MessageService messageService = new MessageService();
		try {
			BeanUtils.copyProperties(messageServices, messageService);
		} catch (BeansException beansException) {
			throw new BadRequestException(
					"Doctor Do not have enough information for mapping",
					beansException);
		}

		return messageService;
	}

}