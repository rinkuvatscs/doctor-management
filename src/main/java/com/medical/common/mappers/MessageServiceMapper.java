package com.medical.common.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.medical.common.entity.MessageService;
import com.medical.doctor.exceptionhandler.BadRequestException;
import com.medical.doctor.response.MessageServiceResponse;

@Component
public class MessageServiceMapper {

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

}