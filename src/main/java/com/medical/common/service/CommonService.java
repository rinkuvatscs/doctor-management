package com.medical.common.service;

import java.util.List;

import com.medical.common.entity.MessageService;
import com.medical.common.entity.NotificationService;
import com.medical.common.entity.TodoListService;
import com.medical.common.enums.CommonServiceEnum;

public interface CommonService {
	
	public CommonServiceEnum getCommonService();

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

	public List<TodoListService> getToDOListForPateint(int pId);

	public String addToDoListForPatient(TodoListService todoListService);

	public String updateToDoListForPatient(TodoListService todoListService);

	public String deleteToDoListForPatient(TodoListService todoListService);

	public List<TodoListService> getToDOListForDoctor(int dId);

	public String addToDoListForDoctor(TodoListService todoListService);

	public String updateToDoListForDoctor(TodoListService todoListService);

	public String deleteToDoListForDoctor(TodoListService todoListService);
}
