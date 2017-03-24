package com.medical.common.service;

import java.util.List;

import com.medical.doctor.entity.MessageService;

public interface CommonService {

	public List<MessageService> getMessageForPatient(int pId);

	public String updateMessage(MessageService messageService);

	public String addMessageForPatient(MessageService messageService);

	public List<MessageService> getMessageForDoctor(int dId);

	public String addMessageForDoctor(MessageService messageService);
}
