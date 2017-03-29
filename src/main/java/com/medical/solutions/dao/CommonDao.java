package com.medical.solutions.dao;

import java.util.List;

import com.medical.solutions.entity.CalendarService;
import com.medical.solutions.entity.MessageService;
import com.medical.solutions.entity.NotificationService;
import com.medical.solutions.entity.TodoListService;

public interface CommonDao {

	public List<MessageService> getMessageForPatient(int pId);

	public String updateMessage(MessageService messageService);

	public String addMessageForPatient(MessageService messageService);

	public List<MessageService> getMessageForDoctor(int dId);

	public String addMessageForDoctor(MessageService messageService);

	public List<NotificationService> getNotifyForPatient(int pId);

	public String updateNotify(NotificationService notificationService);

	public String addNotifyForPatient(NotificationService notificationService);

	public List<NotificationService> getNotifyForDoctor(int dId);

	public String addNotifyForDoctor(NotificationService notificationService);

	public List<TodoListService> getToDOListForPateint(int pId);

	public String addToDoListForPatient(TodoListService todoListService);

	public String updateToDoListForPatient(TodoListService todoListService);

	public String deleteToDoListForPatient(TodoListService todoListService);

	public List<TodoListService> getToDOListForDoctor(int dId);

	public String addToDoListForDoctor(TodoListService todoListService);

	public String updateToDoListForDoctor(TodoListService todoListService);

	public String deleteToDoListForDoctor(TodoListService todoListService);

	public String addCalendarEventForPatient(CalendarService calendarService);

	public String updateCalendarEventForPatient(CalendarService calendarService);

	public String deleteCalendarEventForPatient(CalendarService calendarService);

	public List<CalendarService> getCalendarEventForPatient(int pId);
}
