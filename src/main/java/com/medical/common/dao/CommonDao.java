package com.medical.common.dao;

import java.util.List;

import com.medical.doctor.entity.MessageService;

public interface CommonDao {

	public List<MessageService> getMessageForPatient(int pId);
	
	public  String updateMessageForPatient(MessageService messageService);
	
	public String addMessageForPatient(MessageService messageService);
}
