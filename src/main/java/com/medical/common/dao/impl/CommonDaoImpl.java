package com.medical.common.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.medical.common.dao.CommonDao;
import com.medical.common.extractor.CommonExtractor;
import com.medical.common.extractor.CommonNotificationServiceExtractor;
import com.medical.doctor.constants.CommonServiceConstants;
import com.medical.doctor.entity.MessageService;
import com.medical.doctor.entity.NotificationService;

@Repository
public class CommonDaoImpl implements CommonDao {

	@Autowired
	private JdbcTemplate JdbcTemplate;

	@Override
	public List<MessageService> getMessageForPatient(int pId) {
		Object[] args = { pId };
		List<MessageService> response = JdbcTemplate.query(
				CommonServiceConstants.GET_MESSAGE_FOR_PATIENT,
				new CommonExtractor(), args);
		if (!StringUtils.isEmpty(response) && !response.isEmpty()) {
			return response;
		}
		return null;
	}

	@Override
	public String updateMessage(MessageService messageService) {
		String response;
		if (!StringUtils.isEmpty(messageService)) {
			Object[] args = { messageService.getMessageId() };
			int res = JdbcTemplate.update(
					CommonServiceConstants.UPDATE_MESSAGE, args);
			if (res > 0) {
				response = "Message successfully read";
			} else {
				response = "Unread Message";
			}
		} else {
			response = "Unread Message , please check..!!!";
		}
		return response;
	}

	@Override
	public String addMessageForPatient(MessageService messageService) {
		String response;
		Object[] args = { messageService.getMessage(), messageService.getpId() };
		int res = JdbcTemplate.update(
				CommonServiceConstants.INSERT_MESSAGE_INTO_PATIENT, args);
		if (res > 0) {
			response = "Message Successfully inserted..!!!";
		} else {
			response = "Try again later..!!";
		}
		return response;
	}

	@Override
	public List<MessageService> getMessageForDoctor(int dId) {
		Object[] args = { dId };
		List<MessageService> response = JdbcTemplate.query(
				CommonServiceConstants.GET_MESSAGE_FOR_DOCTOR,
				new CommonExtractor(), args);
		if (!StringUtils.isEmpty(response) && !response.isEmpty()) {
			return response;
		}
		return null;
	}

	@Override
	public String addMessageForDoctor(MessageService messageService) {
		String response;
		Object[] args = { messageService.getMessage(), messageService.getdId() };
		int res = JdbcTemplate.update(
				CommonServiceConstants.INSERT_MESSAGE_INTO_DOCTOR, args);
		if (res > 0) {
			response = "Message Successfully inserted..!!!";
		} else {
			response = "Try again later..!!";
		}
		return response;
	}

	@Override
	public List<NotificationService> getNotifyForPatient(int pId) {
		Object[] args = { pId };
		List<NotificationService> response = JdbcTemplate.query(
				CommonServiceConstants.GET_NOTIFICATION_FOR_PATIENT,
				new CommonNotificationServiceExtractor(), args);
		if (!StringUtils.isEmpty(response) && !response.isEmpty()) {
			return response;
		}
		return null;
	}

	@Override
	public String updateNotify(NotificationService notificationService) {
		String response;
		if (!StringUtils.isEmpty(notificationService)) {
			Object[] args = { notificationService.getNotifyId() };
			int res = JdbcTemplate.update(
					CommonServiceConstants.UPDATE_NOTIFICATION, args);
			if (res > 0) {
				response = "Notification message successfully read";
			} else {
				response = "Unread Notification";
			}
		} else {
			response = "Unread Notification , please check..!!!";
		}
		return response;
	}

	@Override
	public String addNotifyForPatient(NotificationService notificationService) {
		String response;
		Object[] args = { notificationService.getNotiyfMessage(),
				notificationService.getpId() };
		int res = JdbcTemplate.update(
				CommonServiceConstants.INSERT_NOTIFICATION_INTO_PATIENT, args);
		if (res > 0) {
			response = "Notification message Successfully inserted..!!!";
		} else {
			response = "Try again later..!!";
		}
		return response;
	}

	@Override
	public List<NotificationService> getNotifyForDoctor(int dId) {
		Object[] args = { dId };
		List<NotificationService> response = JdbcTemplate.query(
				CommonServiceConstants.GET_NOTIFICATION_FOR_DOCTOR,
				new CommonNotificationServiceExtractor(), args);
		if (!StringUtils.isEmpty(response) && !response.isEmpty()) {
			return response;
		}
		return null;
	}

	@Override
	public String addNotifyForDoctor(NotificationService notificationService) {
		String response;
		Object[] args = { notificationService.getNotiyfMessage(),
				notificationService.getdId() };
		int res = JdbcTemplate.update(
				CommonServiceConstants.INSERT_NOTIFICATION_INTO_DOCTOR, args);
		if (res > 0) {
			response = "Notification message Successfully inserted..!!!";
		} else {
			response = "Try again later..!!";
		}
		return response;
	}

}
