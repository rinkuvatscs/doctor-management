package com.medical.solutions.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.medical.solutions.constants.MessageServiceConstants;
import com.medical.solutions.constants.NotificationServiceConstants;
import com.medical.solutions.constants.ToDoServiceConstants;
import com.medical.solutions.dao.CommonDao;
import com.medical.solutions.entity.CalendarService;
import com.medical.solutions.entity.MessageService;
import com.medical.solutions.entity.NotificationService;
import com.medical.solutions.entity.TodoListService;
import com.medical.solutions.extractor.CalendarServiceExtractor;
import com.medical.solutions.extractor.MessageServiceExtractor;
import com.medical.solutions.extractor.NotificationServiceExtractor;
import com.medical.solutions.extractor.ToDoTaskServiceExtractor;

@Repository
public class CommonDaoImpl implements CommonDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<MessageService> getMessageForPatient(int pId) {
		Object[] args = { pId };
		List<MessageService> response = jdbcTemplate.query(
				MessageServiceConstants.GET_MESSAGE_FOR_PATIENT,
				new MessageServiceExtractor(), args);
		if (!StringUtils.isEmpty(response) && !response.isEmpty()) {
			return response;
		}
		return null;
	}

	@Override
	public String updateMessage(MessageService messageService) {
		String response;
		if (!StringUtils.isEmpty(messageService)) {
			Object[] args = { messageService.getMessageId() };
			int res = jdbcTemplate.update(
					MessageServiceConstants.UPDATE_MESSAGE, args);
			if (res > 0) {
				response = "Message successfully read";
			} else {
				response = "Unread Message";
			}
		} else {
			response = "Unread Message , please check..!!!";
		}
		return response;
	}

	@Override
	public String addMessageForPatient(MessageService messageService) {
		String response;
		Object[] args = { messageService.getMessage(), messageService.getpId() };
		int res = jdbcTemplate.update(
				MessageServiceConstants.INSERT_MESSAGE_INTO_PATIENT, args);
		if (res > 0) {
			response = "Message Successfully inserted..!!!";
		} else {
			response = "Try again later..!!";
		}
		return response;
	}

	@Override
	public List<MessageService> getMessageForDoctor(int dId) {
		Object[] args = { dId };
		List<MessageService> response = jdbcTemplate.query(
				MessageServiceConstants.GET_MESSAGE_FOR_DOCTOR,
				new MessageServiceExtractor(), args);
		if (!StringUtils.isEmpty(response) && !response.isEmpty()) {
			return response;
		}
		return null;
	}

	@Override
	public String addMessageForDoctor(MessageService messageService) {
		String response;
		Object[] args = { messageService.getMessage(), messageService.getdId() };
		int res = jdbcTemplate.update(
				MessageServiceConstants.INSERT_MESSAGE_INTO_DOCTOR, args);
		if (res > 0) {
			response = "Message Successfully inserted..!!!";
		} else {
			response = "Try again later..!!";
		}
		return response;
	}

	@Override
	public List<NotificationService> getNotifyForPatient(int pId) {
		Object[] args = { pId };
		List<NotificationService> response = jdbcTemplate.query(
				NotificationServiceConstants.GET_NOTIFICATION_FOR_PATIENT,
				new NotificationServiceExtractor(), args);
		if (!StringUtils.isEmpty(response) && !response.isEmpty()) {
			return response;
		}
		return null;
	}

	@Override
	public String updateNotify(NotificationService notificationService) {
		String response;
		if (!StringUtils.isEmpty(notificationService)) {
			Object[] args = { notificationService.getNotifyId() };
			int res = jdbcTemplate.update(
					NotificationServiceConstants.UPDATE_NOTIFICATION, args);
			if (res > 0) {
				response = "Notification message successfully read";
			} else {
				response = "Unread Notification";
			}
		} else {
			response = "Unread Notification , please check..!!!";
		}
		return response;
	}

	@Override
	public String addNotifyForPatient(NotificationService notificationService) {
		String response;
		Object[] args = { notificationService.getNotiyfMessage(),
				notificationService.getpId() };
		int res = jdbcTemplate.update(
				NotificationServiceConstants.INSERT_NOTIFICATION_INTO_PATIENT,
				args);
		if (res > 0) {
			response = "Notification message Successfully inserted..!!!";
		} else {
			response = "Try again later..!!";
		}
		return response;
	}

	@Override
	public List<NotificationService> getNotifyForDoctor(int dId) {
		Object[] args = { dId };
		List<NotificationService> response = jdbcTemplate.query(
				NotificationServiceConstants.GET_NOTIFICATION_FOR_DOCTOR,
				new NotificationServiceExtractor(), args);
		if (!StringUtils.isEmpty(response) && !response.isEmpty()) {
			return response;
		}
		return null;
	}

	@Override
	public String addNotifyForDoctor(NotificationService notificationService) {
		String response;
		Object[] args = { notificationService.getNotiyfMessage(),
				notificationService.getdId() };
		int res = jdbcTemplate.update(
				NotificationServiceConstants.INSERT_NOTIFICATION_INTO_DOCTOR,
				args);
		if (res > 0) {
			response = "Notification message Successfully inserted..!!!";
		} else {
			response = "Try again later..!!";
		}
		return response;
	}

	/*****************************************************
	 **************** ToDo Service
	 *****************************************************/

	@Override
	public List<TodoListService> getToDOListForPateint(int pId) {
		Object[] args = { pId };
		List<TodoListService> response = jdbcTemplate.query(
				ToDoServiceConstants.GET_TODO_FOR_PATIENT,
				new ToDoTaskServiceExtractor(), args);
		if (!StringUtils.isEmpty(response) && !response.isEmpty()) {
			return response;
		}
		return null;
	}

	@Override
	public String addToDoListForPatient(TodoListService todoListService) {
		String response;
		Object[] args = { todoListService.getTodoMessage(),
				todoListService.getpId() };
		int res = jdbcTemplate.update(
				ToDoServiceConstants.ADD_TODO_FOR_PATIENT, args);
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
			Object[] args = { todoListService.getTodoMessage(),
					todoListService.getTodoId() };
			int res = jdbcTemplate.update(
					ToDoServiceConstants.UPDATE_TODO_FOR_PATIENT, args);
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
		List<TodoListService> response = jdbcTemplate.query(
				ToDoServiceConstants.GET_TODO_FOR_DOCTOR,
				new ToDoTaskServiceExtractor(), args);
		if (!StringUtils.isEmpty(response) && !response.isEmpty()) {
			return response;
		}
		return null;
	}

	@Override
	public String addToDoListForDoctor(TodoListService todoListService) {
		String response;
		Object[] args = { todoListService.getTodoMessage(),
				todoListService.getdId() };
		int res = jdbcTemplate.update(ToDoServiceConstants.ADD_TODO_FOR_DOCTOR,
				args);
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
			Object[] args = { todoListService.getTodoMessage(),
					todoListService.getTodoId() };
			int res = jdbcTemplate.update(
					ToDoServiceConstants.UPDATE_TODO_FOR_DOCTOR, args);
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
			int res = jdbcTemplate.update(
					ToDoServiceConstants.DELETE_TODO_FOR_PATIENT, args);
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
			int res = jdbcTemplate.update(
					ToDoServiceConstants.DELETE_TODO_FOR_DOCTOR, args);
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

	/*****************************************************
	 **************** Calendar Service
	 *****************************************************/
	@Override
	public String addCalendarEventForPatient(CalendarService calendarService) {
		String response;
		if (!StringUtils.isEmpty(calendarService)) {
			Object[] args = { calendarService.getCalendarEventId(),
					calendarService.getCalendarTitle(),
					calendarService.getStartDate(),
					calendarService.getEndDate(), calendarService.getpId() };
			int res = jdbcTemplate
					.update("INSERT INTO calendar( calendarEventId, calendarTitle, startDate, endDate, pId) VALUES(?,?,?,?,?)",
							args);
			if (res > 0) {
				response = "Successfully created calendar Event.!!!";
			} else {
				response = "Try again later..!!!";
			}
		} else {
			response = "Try again later..!!!";
		}
		return response;
	}

	@Override
	public String updateCalendarEventForPatient(CalendarService calendarService) {
		String response;
		if (!StringUtils.isEmpty(calendarService)) {
			Object[] args = { calendarService.getCalendarTitle(),
					calendarService.getStartDate(),
					calendarService.getEndDate(),
					calendarService.getCalendarId() };
			int res = jdbcTemplate
					.update("UPDATE calendar SET calendarTitle = ?, startDate = ?, endDate = ? WHERE calendarId =?",
							args);
			if (res > 0) {
				response = "Successfully calendar updated..!!!";
			} else {
				response = "Try again later..!!!";
			}
		} else {
			response = "Try again later..!!!";
		}
		return response;
	}

	@Override
	public String deleteCalendarEventForPatient(CalendarService calendarService) {
		String response;
		if (!StringUtils.isEmpty(calendarService)) {
			Object[] args = { calendarService.getCalendarId() };
			int res = jdbcTemplate.update(
					"delete from calendar where calendarId=?", args);
			if (res > 0) {
				response = "Successfully calendar deleted..!!!";
			} else {
				response = "Try again later..!!!";
			}
		} else {
			response = "Try again later..!!!";
		}
		return response;
	}

	@Override
	public List<CalendarService> getCalendarEventForPatient(int pId) {
		Object[] args = { pId };
		List<CalendarService> response = jdbcTemplate.query(
				"SELECT * FROM calendar WHERE pId=?",
				new CalendarServiceExtractor(), args);
		if (!StringUtils.isEmpty(response) && !response.isEmpty()) {
			/*
			 * for(CalendarService calendarService : response){ Date startDate =
			 * formatDate(calendarService.getStartDate().toString(),
			 * calendarService.getStartTime().toString());
			 * calendarService.setStartDate(startDate); Date endDate =
			 * formatDate(calendarService.getEndDate().toString(),
			 * calendarService.getEndTime().toString());
			 * calendarService.setEndDate(endDate); }
			 */
			return response;
		}
		return null;
	}

	/*
	 * private Date formatDate(String date1, String date2) {
	 * 
	 * String startDate = date1 + " " + date2; SimpleDateFormat sdf = new
	 * SimpleDateFormat("yyyy-M-dd HH:m"); try { return sdf.parse(startDate); }
	 * catch (ParseException e) { e.printStackTrace(); } return null; }
	 */
}
