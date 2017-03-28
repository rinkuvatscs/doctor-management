package com.medical.common.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.medical.common.entity.CalendarService;
import com.medical.common.response.CalendarServiceResponse;
import com.medical.doctor.exceptionhandler.BadRequestException;

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
