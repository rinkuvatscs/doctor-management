package com.medical.common.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medical.common.dao.CommonDao;
import com.medical.common.service.CommonService;
import com.medical.doctor.entity.MessageService;

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

}
