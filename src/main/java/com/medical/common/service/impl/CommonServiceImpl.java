package com.medical.common.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medical.common.dao.CommonDao;
import com.medical.common.service.CommonService;
import com.medical.doctor.entity.MessageService;
import com.medical.doctor.entity.NotificationService;

@Service
public class CommonServiceImpl implements CommonService {

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

}
