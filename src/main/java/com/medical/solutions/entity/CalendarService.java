package com.medical.solutions.entity;

import java.util.Date;

public class CalendarService {

	private int calendarId;
	private int calendarEventId;
	private String calendarTitle;
	private Date startDate;
	private Date endDate;
	private int pId;
	private int dId;

	public int getCalendarId() {
		return calendarId;
	}

	public void setCalendarId(int calendarId) {
		this.calendarId = calendarId;
	}

	public int getCalendarEventId() {
		return calendarEventId;
	}

	public void setCalendarEventId(int calendarEventId) {
		this.calendarEventId = calendarEventId;
	}

	public String getCalendarTitle() {
		return calendarTitle;
	}

	public void setCalendarTitle(String calendarTitle) {
		this.calendarTitle = calendarTitle;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public int getdId() {
		return dId;
	}

	public void setdId(int dId) {
		this.dId = dId;
	}

	@Override
	public String toString() {
		return "CalendarService [calendarId=" + calendarId + ", calendarEventId=" + calendarEventId + ", calendarTitle="
				+ calendarTitle + ", startDate=" + startDate + ", endDate=" + endDate + ", pId=" + pId + ", dId=" + dId
				+ "]";
	}

}
