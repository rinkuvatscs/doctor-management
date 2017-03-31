package com.medical.solutions.controller;

import io.swagger.annotations.Api;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.medical.solutions.entity.TodoListService;
import com.medical.solutions.exceptionhandler.BadRequestException;
import com.medical.solutions.factory.CommonFactory;
import com.medical.solutions.mappers.TodoTaskServiceMapper;
import com.medical.solutions.request.ToDoListServiceRequest;
import com.medical.solutions.response.ToDoListServiceResponse;

@RestController
@RequestMapping("/api/todo")
@Api(basePath = "/todo", value = "todo", description = "Operations with Landlords", produces = "application/json")
public class TodoTaskController {

	private static final String COMMON_BADREQEST_MESSAGE = "To do List Do not have enough information";

	@Autowired
	private CommonFactory commonFactory;
	@Autowired
	private TodoTaskServiceMapper todoTaskServiceMapper;

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, value = "/addToDoListforpatient")
	@ResponseBody
	public ToDoListServiceResponse addToDoListForPatient(
			@RequestBody ToDoListServiceRequest toDoListServiceRequest) {
		TodoListService todoListService = new TodoListService();

		if (StringUtils.isEmpty(toDoListServiceRequest)
				&& StringUtils.isEmpty(toDoListServiceRequest.getTodoMessage())) {
			throw new BadRequestException("To Do List can not be null");
		} else if (toDoListServiceRequest.getpId() <= 0) {
			throw new BadRequestException("Please provide valid patient Id");
		}
		try {
			BeanUtils.copyProperties(toDoListServiceRequest, todoListService);
		} catch (BeansException beansException) {
			throw new BadRequestException(COMMON_BADREQEST_MESSAGE,
					beansException);
		}
		return new ToDoListServiceResponse(commonFactory.getCommonService().addToDoListForPatient(
				todoListService));
	}

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/gettodoListforpatient/{pId}/pId")
	@ResponseBody
	public List<TodoListService> getToDoListforPatient(
			@PathVariable int pId) {
		if (pId <= 0) {
			throw new BadRequestException("Please provide valid patient Id");
		}
		return todoTaskServiceMapper.mapTodoListService(commonFactory
				.getCommonService().getToDOListForPateint(pId));
	}

	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, value = "/updatetodoListforPatient")
	@ResponseBody
	public ToDoListServiceResponse updateToDoListForPatient(
			@RequestBody ToDoListServiceRequest toDoListServiceRequest) {
		TodoListService todoListService = new TodoListService();
		try {
			BeanUtils.copyProperties(toDoListServiceRequest, todoListService);
			if (todoListService.getTodoId() <= 0) {
				throw new BadRequestException("Please provide valid Id");
			}
		} catch (BeansException beansException) {
			throw new BadRequestException(COMMON_BADREQEST_MESSAGE,
					beansException);
		}
		return new ToDoListServiceResponse(commonFactory.getCommonService().updateToDoListForPatient(
				todoListService));
	}

	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, value = "/deletetodoListforPatient")
	@ResponseBody
	public ToDoListServiceResponse deleteToDoListForPatient(
			@RequestBody ToDoListServiceRequest toDoListServiceRequest) {
		TodoListService todoListService = new TodoListService();
		try {
			BeanUtils.copyProperties(toDoListServiceRequest, todoListService);
			if (todoListService.getTodoId() <= 0) {
				throw new BadRequestException("Please provide valid Id");
			}
		} catch (BeansException beansException) {
			throw new BadRequestException(COMMON_BADREQEST_MESSAGE,
					beansException);
		}
		return new ToDoListServiceResponse(commonFactory.getCommonService().deleteToDoListForPatient(
				todoListService));
	}

	/******************* To do list for Doctor ******************/
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, value = "/addToDoListfordoctor")
	@ResponseBody
	public ToDoListServiceResponse addToDoListForDoctor(
			@RequestBody ToDoListServiceRequest toDoListServiceRequest) {
		TodoListService todoListService = new TodoListService();

		if (StringUtils.isEmpty(toDoListServiceRequest)
				&& StringUtils.isEmpty(toDoListServiceRequest.getTodoMessage())) {
			throw new BadRequestException("To Do List can not be null");
		} else if (toDoListServiceRequest.getdId() <= 0) {
			throw new BadRequestException("Please provide valid doctor Id");
		}
		try {
			BeanUtils.copyProperties(toDoListServiceRequest, todoListService);
		} catch (BeansException beansException) {
			throw new BadRequestException(COMMON_BADREQEST_MESSAGE,
					beansException);
		}
		return new ToDoListServiceResponse(commonFactory.getCommonService().addToDoListForDoctor(
				todoListService));
	}

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/gettodoListfordoctor/{dId}/dId")
	@ResponseBody
	public List<TodoListService> getToDoListforDoctor(
			@PathVariable int dId) {
		if (dId <= 0) {
			throw new BadRequestException("Please provide valid doctor Id");
		}
		return todoTaskServiceMapper.mapTodoListService(commonFactory
				.getCommonService().getToDOListForDoctor(dId));
	}

	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, value = "/updatetodoListfordoctor")
	@ResponseBody
	public ToDoListServiceResponse updateToDoListforDoctor(
			@RequestBody ToDoListServiceRequest toDoListServiceRequest) {
		TodoListService todoListService = new TodoListService();
		try {
			BeanUtils.copyProperties(toDoListServiceRequest, todoListService);
			if (todoListService.getTodoId() <= 0) {
				throw new BadRequestException("Please provide valid Id");
			}
		} catch (BeansException beansException) {
			throw new BadRequestException(COMMON_BADREQEST_MESSAGE,
					beansException);
		}
		return new ToDoListServiceResponse(commonFactory.getCommonService().updateToDoListForDoctor(
				todoListService));
	}

	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, value = "/deletetodoListforDoctor")
	@ResponseBody
	public ToDoListServiceResponse deleteToDoListForDoctor(
			@RequestBody ToDoListServiceRequest toDoListServiceRequest) {
		TodoListService todoListService = new TodoListService();
		try {
			BeanUtils.copyProperties(toDoListServiceRequest, todoListService);
			if (todoListService.getTodoId() <= 0) {
				throw new BadRequestException("Please provide valid Id");
			}
		} catch (BeansException beansException) {
			throw new BadRequestException(COMMON_BADREQEST_MESSAGE,
					beansException);
		}
		return new ToDoListServiceResponse(commonFactory.getCommonService().deleteToDoListForDoctor(
				todoListService));
	}

}
