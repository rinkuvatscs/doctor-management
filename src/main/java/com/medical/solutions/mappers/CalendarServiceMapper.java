package com.medical.solutions.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.medical.solutions.entity.CalendarService;
import com.medical.solutions.exceptionhandler.BadRequestException;
import com.medical.solutions.response.CalendarServiceResponse;

@Component
public class CalendarServiceMapper {
	public List<CalendarServiceResponse> mapcalendarServices(
			List<CalendarService> calendarServices) {

		if (StringUtils.isEmpty(calendarServices) || calendarServices.isEmpty()) {
			return null;
		}
		List<CalendarServiceResponse> calendarServiceResponses = new ArrayList<CalendarServiceResponse>(
				calendarServices.size());
		for (CalendarService calendarService : calendarServices) {
			calendarServiceResponses.add(mapCalendarService(calendarService));
		}

		return calendarServiceResponses;
	}

	public CalendarServiceResponse mapCalendarService(
			CalendarService calendarService) {
		CalendarServiceResponse calendarServiceResponse = new CalendarServiceResponse();
		try {
			BeanUtils.copyProperties(calendarService, calendarServiceResponse);
		} catch (BeansException beansException) {
			throw new BadRequestException(
					"Not have enough information for mapping", beansException);
		}

		return calendarServiceResponse;
	}
}
