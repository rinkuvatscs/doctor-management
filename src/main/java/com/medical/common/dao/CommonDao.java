package com.medical.common.dao;

import java.util.List;

import com.medical.doctor.entity.MessageService;

public interface CommonDao {

	public List<MessageService> getMessageForPatient(int pId);

	public String updateMessage(MessageService messageService);

	public String addMessageForPatient(MessageService messageService);

	public List<MessageService> getMessageForDoctor(int dId);

	public String addMessageForDoctor(MessageService messageService);
}
