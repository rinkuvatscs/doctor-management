package com.medical.common.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.medical.common.dao.CommonDao;
import com.medical.common.extractor.CommonExtractor;
import com.medical.doctor.entity.MessageService;

@Repository
public class CommonDaoImpl implements CommonDao {

	@Autowired
	private JdbcTemplate JdbcTemplate;

	@Override
	public List<MessageService> getMessageForPatient(int pId) {
		Object[] args = { pId };
		List<MessageService> response = JdbcTemplate.query(
				"SELECT * FROM message WHERE pId = ? && status = false",
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
					"UPDATE message SET status=1 WHERE messageId = ? ", args);
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
				"INSERT INTO message(message, pId) VALUES(?, ?)", args);
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
				"SELECT * FROM message WHERE dId = ? && status = false",
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
				"INSERT INTO message(message, dId) VALUES(?, ?)", args);
		if (res > 0) {
			response = "Message Successfully inserted..!!!";
		} else {
			response = "Try again later..!!";
		}
		return response;
	}

}
