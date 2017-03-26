package com.medical.doctor.constants;

public interface CommonToDoServiceConstants {

	String GET_TODO_FOR_PATIENT = "SELECT * FROM todoList WHERE pId = ? ";

	String UPDATE_TODO_FOR_PATIENT = "UPDATE todoList SET todoMessage=?  WHERE todoId =? ";

	String ADD_TODO_FOR_PATIENT = "INSERT into todoList (todoMessage, pId) VALUES(?, ?)";

	String GET_TODO_FOR_DOCTOR = "SELECT * FROM todoList WHERE dId = ? ";

	String UPDATE_TODO_FOR_DOCTOR = "UPDATE todoList SET todoMessage=? WHERE todoId =? ";

	String ADD_TODO_FOR_DOCTOR = "INSERT into todoList (todoMessage, dId) VALUES(?, ?)";
	
	String DELETE_TODO_FOR_PATIENT = "DELETE from todoList WHERE todoId =? ";
	
	String DELETE_TODO_FOR_DOCTOR = "DELETE from todoList  WHERE todoId =? ";

}
