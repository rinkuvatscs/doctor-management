package com.medical.solutions.response;

public class ToDoListServiceResponse {

	private String todoMessage;

	public ToDoListServiceResponse(String todoMessage) {
		super();
		this.todoMessage = todoMessage;
	}

	public String getTodoMessage() {
		return todoMessage;
	}

	public void setTodoMessage(String todoMessage) {
		this.todoMessage = todoMessage;
	}

}
