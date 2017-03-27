package com.medical.common.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medical.common.dao.CommonDao;
import com.medical.common.entity.MessageService;
import com.medical.common.entity.NotificationService;
import com.medical.common.entity.TodoListService;
import com.medical.common.enums.CommonServiceEnum;
import com.medical.common.service.CommonService;

@Service
public class CommonServiceUsingDBImpl implements CommonService {

	@Autowired
	private CommonDao commonDao;

	@Override
	public List<MessageService> getMessageForPatient(int pId) {
		return commonDao.getMessageForPatient(pId);
	}

	@Override
	public String updateMessage(MessageService messageService) {
		return commonDao.updateMessage(messageService);
	}

	@Override
	public String addMessageForPatient(MessageService messageService) {
		return commonDao.addMessageForPatient(messageService);
	}

	@Override
	public List<MessageService> getMessageForDoctor(int dId) {
		return commonDao.getMessageForDoctor(dId);
	}

	@Override
	public String addMessageForDoctor(MessageService messageService) {
		return commonDao.addMessageForDoctor(messageService);
	}
	
	/*****************************************
	 * Notofication Service
	 *****************************************************/

	@Override
	public List<NotificationService> getNotifyForPatient(int pId) {
		return commonDao.getNotifyForPatient(pId);
	}

	@Override
	public String updateNotify(NotificationService notificationService) {
		return commonDao.updateNotify(notificationService);
	}

	@Override
	public String addNotifyForPatient(NotificationService notificationService) {
		return commonDao.addNotifyForPatient(notificationService);
	}

	@Override
	public List<NotificationService> getNotifyForDoctor(int dId) {
		return commonDao.getNotifyForDoctor(dId);
	}

	@Override
	public String addNotifyForDoctor(NotificationService notificationService) {
		return commonDao.addNotifyForDoctor(notificationService);
	}

	/*****************************************
	 * ToDo Service
	 *****************************************************/

	@Override
	public List<TodoListService> getToDOListForPateint(int pId) {
		return commonDao.getToDOListForPateint(pId);
	}

	@Override
	public String addToDoListForPatient(TodoListService todoListService) {
		return commonDao.addToDoListForPatient(todoListService);
	}

	@Override
	public String updateToDoListForPatient(TodoListService todoListService) {
		return commonDao.updateToDoListForPatient(todoListService);
	}

	@Override
	public List<TodoListService> getToDOListForDoctor(int dId) {
		return commonDao.getToDOListForDoctor(dId);
	}

	@Override
	public String addToDoListForDoctor(TodoListService todoListService) {
		return commonDao.addToDoListForDoctor(todoListService);
	}

	@Override
	public String updateToDoListForDoctor(TodoListService todoListService) {
		return commonDao.updateToDoListForDoctor(todoListService);
	}

	@Override
	public String deleteToDoListForPatient(TodoListService todoListService) {
		return commonDao.deleteToDoListForPatient(todoListService);
	}

	@Override
	public String deleteToDoListForDoctor(TodoListService todoListService) {
		return commonDao.deleteToDoListForDoctor(todoListService);
	}

	@Override
	public CommonServiceEnum getCommonService() {

		return CommonServiceEnum.DIRECT_DATABASE;
	}
}
