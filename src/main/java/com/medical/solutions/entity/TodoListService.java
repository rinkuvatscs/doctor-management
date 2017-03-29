package com.medical.solutions.entity;

public class TodoListService {

	private int dId;
	private int pId;
	private int todoId;
	private String todoMessage;

	public int getdId() {
		return dId;
	}

	public void setdId(int dId) {
		this.dId = dId;
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public int getTodoId() {
		return todoId;
	}

	public void setTodoId(int todoId) {
		this.todoId = todoId;
	}

	public String getTodoMessage() {
		return todoMessage;
	}

	public void setTodoMessage(String todoMessage) {
		this.todoMessage = todoMessage;
	}

	@Override
	public String toString() {
		return "TodoListService [dId=" + dId + ", pId=" + pId + ", todoId=" + todoId + ", todoMessage=" + todoMessage
				+ "]";
	}
}
