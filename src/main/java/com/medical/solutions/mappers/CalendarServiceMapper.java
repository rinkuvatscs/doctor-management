package com.medical.solutions.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.medical.solutions.entity.CalendarService;
import com.medical.solutions.exceptionhandler.BadRequestException;

@Component
public class CalendarServiceMapper {
	public List<CalendarService> mapcalendarServices(
			List<CalendarService> calendarServices) {

		if (StringUtils.isEmpty(calendarServices) || calendarServices.isEmpty()) {
			return null;
		}
		List<CalendarService> calendarServiceResponses = new ArrayList<>(
				calendarServices.size());
		for (CalendarService calendarService : calendarServices) {
			calendarServiceResponses.add(mapCalendarService(calendarService));
		}

		return calendarServiceResponses;
	}

	public CalendarService mapCalendarService(
			CalendarService calendarService) {
		CalendarService calendarServiceResponse = new CalendarService();
		try {
			BeanUtils.copyProperties(calendarService, calendarServiceResponse);
		} catch (BeansException beansException) {
			throw new BadRequestException(
					"Not have enough information for mapping", beansException);
		}

		return calendarServiceResponse;
	}
}
