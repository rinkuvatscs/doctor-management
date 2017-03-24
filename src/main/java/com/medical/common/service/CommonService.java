package com.medical.common.service;

import java.util.List;

import com.medical.doctor.entity.MessageService;
import com.medical.doctor.entity.NotificationService;

public interface CommonService {

	public List<MessageService> getMessageForPatient(int pId);

	public String updateMessage(MessageService messageService);

	public String addMessageForPatient(MessageService messageService);

	public List<MessageService> getMessageForDoctor(int dId);

	public String addMessageForDoctor(MessageService messageService);
	
	public List<NotificationService> getNotifyForPatient(int pId);

	public String updateNotify(NotificationService notificationService);

	public String addNotifyForPatient(NotificationService notificationService);

	public List<NotificationService> getNotifyForDoctor(int dId);

	public String addNotifyForDoctor(NotificationService notificationService);
}
