package com.medical.common.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.medical.common.dao.CommonToDoDao;
import com.medical.common.extractor.CommonToDoServiceExtractor;
import com.medical.doctor.constants.CommonToDoServiceConstants;
import com.medical.doctor.entity.TodoListService;

@Repository
class CommonToDoDaoImpl implements CommonToDoDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<TodoListService> getToDOListForPateint(int pId) {
		Object[] args = { pId };
		List<TodoListService> response = jdbcTemplate.query(CommonToDoServiceConstants.GET_TODO_FOR_PATIENT,
				new CommonToDoServiceExtractor(), args);
		if (!StringUtils.isEmpty(response) && !response.isEmpty()) {
			return response;
		}
		return null;
	}

	@Override
	public String addToDoListForPatient(TodoListService todoListService) {
		String response;
		Object[] args = { todoListService.getTodoMessage(), todoListService.getpId() };
		int res = jdbcTemplate.update(CommonToDoServiceConstants.ADD_TODO_FOR_PATIENT, args);
		if (res > 0) {
			response = "To do List insert successfully";
		} else {
			response = "Try again later..!!!!";
		}
		return response;
	}

	@Override
	public String updateToDoListForPatient(TodoListService todoListService) {
		String response;
		if (!StringUtils.isEmpty(todoListService)) {
			Object[] args = { todoListService.getTodoMessage(), todoListService.getTodoId() };
			int res = jdbcTemplate.update(CommonToDoServiceConstants.UPDATE_TODO_FOR_PATIENT, args);
			if (res > 0) {
				response = "To do List successfully updated..!!!";
			} else {
				response = "try again later";
			}
		} else {
			response = "Not updated , please check..!!!";
		}
		return response;
	}

	@Override
	public List<TodoListService> getToDOListForDoctor(int dId) {
		Object[] args = { dId };
		List<TodoListService> response = jdbcTemplate.query(CommonToDoServiceConstants.GET_TODO_FOR_DOCTOR,
				new CommonToDoServiceExtractor(), args);
		if (!StringUtils.isEmpty(response) && !response.isEmpty()) {
			return response;
		}
		return null;
	}

	@Override
	public String addToDoListForDoctor(TodoListService todoListService) {
		String response;
		Object[] args = { todoListService.getTodoMessage(), todoListService.getdId() };
		int res = jdbcTemplate.update(CommonToDoServiceConstants.ADD_TODO_FOR_DOCTOR, args);
		if (res > 0) {
			response = "To do List insert successfully";
		} else {
			response = "Try again later..!!!!";
		}
		return response;
	}

	@Override
	public String updateToDoListForDoctor(TodoListService todoListService) {
		String response;
		if (!StringUtils.isEmpty(todoListService)) {
			Object[] args = { todoListService.getTodoMessage(), todoListService.getTodoId() };
			int res = jdbcTemplate.update(CommonToDoServiceConstants.UPDATE_TODO_FOR_DOCTOR, args);
			if (res > 0) {
				response = "To do List successfully updated..!!!";
			} else {
				response = "try again later";
			}
		} else {
			response = "Not updated , please check..!!!";
		}
		return response;
	}

	@Override
	public String deleteToDoListForPatient(TodoListService todoListService) {
		String response;
		if (!StringUtils.isEmpty(todoListService)) {
			Object[] args = { todoListService.getTodoId() };
			int res = jdbcTemplate.update(CommonToDoServiceConstants.DELETE_TODO_FOR_PATIENT, args);
			if (res > 0) {
				response = "To do list Successfully deleted..!!!";
			} else {
				response = "try again later..!!!";
			}
		} else {
			response = "not deleted , please check ..!!!";
		}
		return response;
	}

	@Override
	public String deleteToDoListForDoctor(TodoListService todoListService) {
		String response;
		if (!StringUtils.isEmpty(todoListService)) {
			Object[] args = { todoListService.getTodoId() };
			int res = jdbcTemplate.update(CommonToDoServiceConstants.DELETE_TODO_FOR_DOCTOR, args);
			if (res > 0) {
				response = "To do list Successfully deleted..!!!";
			} else {
				response = "try again later..!!!";
			}
		} else {
			response = "not deleted , please check ..!!!";
		}
		return response;
	}

}
