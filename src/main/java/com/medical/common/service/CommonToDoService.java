package com.medical.common.service;

import java.util.List;

import com.medical.doctor.entity.TodoListService;

public interface CommonToDoService {

	public List<TodoListService> getToDOListForPateint(int pId);
	
	public String addToDoListForPatient(TodoListService todoListService);
	
	public String updateToDoListForPatient(TodoListService todoListService);
	
	public String deleteToDoListForPatient(TodoListService todoListService);
	
	public List<TodoListService> getToDOListForDoctor(int dId);

	public String addToDoListForDoctor(TodoListService todoListService);

	public String updateToDoListForDoctor(TodoListService todoListService);
	
	public String deleteToDoListForDoctor(TodoListService todoListService);
}
