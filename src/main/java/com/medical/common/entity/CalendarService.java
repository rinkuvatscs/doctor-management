package com.medical.common.entity;

import java.util.Date;

public class CalendarService {

	private int calendarId;
	private int calendarEventId;
	private String calendarTitle;
	private Date startDate;
	private Date startTime;
	private Date endDate;
	private Date endTime;
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
	
	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	@Override
	public String toString() {
		return "CalendarService [calendarId=" + calendarId
				+ ", calendarEventId=" + calendarEventId + ", calendarTitle="
				+ calendarTitle + ", startDate=" + startDate + ", endDate="
				+ endDate + ", pId=" + pId + ", dId=" + dId + "]";
	}

}
