package com.medical.common.extractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.ResultSetExtractor;

import com.medical.common.entity.TodoListService;

public class ToDoTaskServiceExtractor implements ResultSetExtractor<List<TodoListService>> {

	@Override
	public List<TodoListService> extractData(ResultSet rs) throws SQLException {

		List<TodoListService> todoListServices = new ArrayList<>();

		TodoListService todoListService;
		while (rs.next()) {
			todoListService = new TodoListService();
			todoListService.setTodoId(rs.getInt("todoId"));
			todoListService.setTodoMessage(rs.getString("todoMessage"));
			todoListService.setdId(rs.getInt("dId"));
			todoListService.setpId(rs.getInt("pId"));
			todoListServices.add(todoListService);
		}
		return todoListServices;
	}
}
