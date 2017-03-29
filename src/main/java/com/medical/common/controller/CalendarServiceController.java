package com.medical.common.controller;

import io.swagger.annotations.Api;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.medical.common.entity.CalendarService;
import com.medical.common.entity.MessageService;
import com.medical.common.entity.TodoListService;
import com.medical.common.factory.CommonFactory;
import com.medical.common.mappers.CalendarServiceMapper;
import com.medical.common.request.CalendarServiceRequest;
import com.medical.common.response.CalendarServiceResponse;
import com.medical.doctor.exceptionhandler.BadRequestException;

@RestController
@RequestMapping("/api/calendar")
@Api(basePath = "/calendar", value = "calendar", description = "Operations with Landlords", produces = "application/json")
public class CalendarServiceController {
	private static final String COMMON_BADREQEST_MESSAGE = "Not have enough information";

	@Autowired
	private CommonFactory commonFactory;
	@Autowired
	private CalendarServiceMapper calendarServiceMapper;

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, value = "/addCalendarForPatient")
	@ResponseBody
	public String addCalendarEventForPatient(
			@RequestBody CalendarServiceRequest calendarServiceRequest) {
		CalendarService calendarService = new CalendarService();

		if (StringUtils.isEmpty(calendarServiceRequest)
				&& StringUtils.isEmpty(calendarServiceRequest
						.getCalendarTitle())) {
			throw new BadRequestException("Canlendar title can not be null");
		} else if (calendarServiceRequest.getpId() <= 0) {
			throw new BadRequestException("Please provide valid patient Id");
		}
		try {
			BeanUtils.copyProperties(calendarServiceRequest, calendarService);
		} catch (BeansException beansException) {
			throw new BadRequestException(COMMON_BADREQEST_MESSAGE,
					beansException);
		}
		return commonFactory.getCommonService().addCalendarEventForPatient(
				calendarService);
	}

	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, value = "/updateCalendarForPatient")
	@ResponseBody
	public String updateCalendarEventForPatient(
			@RequestBody CalendarServiceRequest calendarServiceRequest) {
		CalendarService calendarService = new CalendarService();
		try {
			BeanUtils.copyProperties(calendarServiceRequest, calendarService);
			if (calendarService.getCalendarId() <= 0) {
				throw new BadRequestException(
						"Please provide valid calendar Id");
			}
		} catch (BeansException beansException) {
			throw new BadRequestException(COMMON_BADREQEST_MESSAGE,
					beansException);
		}
		return commonFactory.getCommonService().updateCalendarEventForPatient(
				calendarService);
	}
	
	/*/Need to do work /*/
	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, value = "/deleteCalendarforPatient")
	@ResponseBody
	public String deleteCalendarEventForPatient(
			@RequestBody CalendarServiceRequest calendarServiceRequest) {
		CalendarService calendarService = new CalendarService();
		try {
			BeanUtils.copyProperties(calendarServiceRequest, calendarService);
			if (calendarService.getCalendarId() <= 0) {
				throw new BadRequestException(
						"Please provide valid calendar Id");
			}
		} catch (BeansException beansException) {
			throw new BadRequestException(COMMON_BADREQEST_MESSAGE,
					beansException);
		}
		return commonFactory.getCommonService().deleteCalendarEventForPatient(
				calendarService);
	}

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/getCalendarForPatient/{pId}/pId")
	@ResponseBody
	public List<CalendarServiceResponse> getCalendarEventForPatient(
			@PathVariable int pId) {
		if (pId <= 0) {
			throw new BadRequestException("Please provide valid Patient Id");
		}
		return calendarServiceMapper.mapcalendarServices(commonFactory
				.getCommonService().getCalendarEventForPatient(pId));
	}

}
