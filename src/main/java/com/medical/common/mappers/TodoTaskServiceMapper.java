package com.medical.common.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.medical.common.entity.TodoListService;
import com.medical.common.response.ToDoListServiceResponse;
import com.medical.doctor.exceptionhandler.BadRequestException;
@Component
public class TodoTaskServiceMapper {

	public List<ToDoListServiceResponse> mapTodoListService(List<TodoListService> todoListServices) {

		if (StringUtils.isEmpty(todoListServices) || todoListServices.isEmpty()) {
			return null;
		}
		List<ToDoListServiceResponse> toDoListServiceResponses = new ArrayList<ToDoListServiceResponse>(
				todoListServices.size());
		for (TodoListService todoListService : todoListServices) {
			toDoListServiceResponses.add(mapTodoListService(todoListService));
		}

		return toDoListServiceResponses;
	}

	public ToDoListServiceResponse mapTodoListService(TodoListService todoListService) {
		ToDoListServiceResponse toDoListServiceResponse = new ToDoListServiceResponse();
		try {
			BeanUtils.copyProperties(todoListService, toDoListServiceResponse);
		} catch (BeansException beansException) {
			throw new BadRequestException("Todo List Do not have enough information for mapping", beansException);
		}

		return toDoListServiceResponse;
	}

}
