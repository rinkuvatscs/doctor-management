package com.medical.common.service;

import java.util.List;

import com.medical.doctor.entity.MessageService;

public interface CommonService {

	public List<MessageService> getMessageForPatient(int pId);
	
	public  String updateMessageForPatient(MessageService messageService);
	
	public String addMessageForPatient(MessageService messageService);
}
