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
				"SELECT * FROM message WHERE pId = ? && status = FALSE",
				new CommonExtractor(), args);
		if (!StringUtils.isEmpty(response) && !response.isEmpty()) {
			return response;
		}
		return null;
	}

	@Override
	public String updateMessageForPatient(MessageService messageService) {
		String response = null;
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
		String response = null;
		Object[] args = { messageService.getMessage(), messageService.getpId() };
		int res = JdbcTemplate.update(
				"INSERT INTO message(message, pId) VALUES(?, ?)", args);
		if (res > 0) {
			response = "Message Successfully inserted..!!!";
		} else {
			response = "Please insert message..!!";
		}
		return response;
	}

}
