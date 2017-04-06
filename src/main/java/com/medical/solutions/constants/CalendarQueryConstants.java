package com.medical.solutions.constants;

public interface CalendarQueryConstants {

	String ADD_CALENDAR_EVENT_BY_PATIENT = "INSERT INTO calendar( calendarEventId, calendarTitle, startDate, endDate, pId) VALUES(?,?,?,?,?)";

	String GET_CALENDAR_EVENT_BY_PATIENT = "SELECT * FROM calendar WHERE pId=?";

	String UPDATE_CALENDAR_EVENT_BY_PATIENT = "UPDATE calendar SET calendarTitle = ?, startDate = ?, endDate = ? WHERE calendarId =?";

	String DELETE_CALENDAR_EVENT_BY_PATIENT = "delete from calendar where calendarId=?";

	String ADD_CALENDAR_EVENT_BY_DOCTOR = "INSERT INTO calendar(calendarEventId, calendarTitle, startDate, endDate, dId) VALUES(?,?,?,?,?)";

	String GET_CALENDAR_EVENT_BY_DOCTOR = "SELECT * FROM calendar WHERE dId=?";
}
