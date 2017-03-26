package com.medical.common.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medical.common.dao.CommonToDoDao;
import com.medical.common.service.CommonToDoService;
import com.medical.doctor.entity.TodoListService;

@Service
public class CommonToDoServiceImpl implements CommonToDoService {

	@Autowired
	private CommonToDoDao commonToDoDao;

	@Override
	public List<TodoListService> getToDOListForPateint(int pId) {
		return commonToDoDao.getToDOListForPateint(pId);
	}

	@Override
	public String addToDoListForPatient(TodoListService todoListService) {
		return commonToDoDao.addToDoListForPatient(todoListService);
	}

	@Override
	public String updateToDoListForPatient(TodoListService todoListService) {
		return commonToDoDao.updateToDoListForPatient(todoListService);
	}

	@Override
	public List<TodoListService> getToDOListForDoctor(int dId) {
		return commonToDoDao.getToDOListForDoctor(dId);
	}

	@Override
	public String addToDoListForDoctor(TodoListService todoListService) {
		return commonToDoDao.addToDoListForDoctor(todoListService);
	}

	@Override
	public String updateToDoListForDoctor(TodoListService todoListService) {
		return commonToDoDao.updateToDoListForDoctor(todoListService);
	}

	@Override
	public String deleteToDoListForPatient(TodoListService todoListService) {
		return commonToDoDao.deleteToDoListForPatient(todoListService);
	}

	@Override
	public String deleteToDoListForDoctor(TodoListService todoListService) {
		return commonToDoDao.deleteToDoListForDoctor(todoListService);
	}

}
