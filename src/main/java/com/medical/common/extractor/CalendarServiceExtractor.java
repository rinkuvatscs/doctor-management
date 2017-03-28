package com.medical.common.extractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.medical.common.entity.CalendarService;

public class CalendarServiceExtractor implements
		ResultSetExtractor<List<CalendarService>> {

	@Override
	public List<CalendarService> extractData(ResultSet rs) throws SQLException,
			DataAccessException {
		List<CalendarService> calendarServices = new ArrayList<CalendarService>();
		CalendarService calendarService;
		while (rs.next()) {
			calendarService = new CalendarService();
			calendarService.setCalendarId(rs.getInt("calendarId"));
			calendarService.setCalendarEventId(rs.getInt("calendarEventId"));
			calendarService.setCalendarTitle(rs.getString("calendarTitle"));
			calendarService.setStartDate(rs.getTimestamp("startDate"));
//			calendarService.setStartTime(rs.getTime("startDate"));
			calendarService.setEndDate(rs.getDate("endDate"));
//			calendarService.setEndTime(rs.getTime("endDate"));
			calendarService.setpId(rs.getInt("pId"));
			calendarService.setdId(rs.getInt("dId"));
			calendarServices.add(calendarService);
		}
		return calendarServices;
	}

}
