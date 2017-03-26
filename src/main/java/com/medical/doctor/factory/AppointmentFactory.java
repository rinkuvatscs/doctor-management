package com.medical.doctor.factory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.medical.doctor.enums.AppointmentEnum;
import com.medical.doctor.service.AppointmentService;

@Component
public class AppointmentFactory {

	@Autowired
	private List<AppointmentService> appointmentServices;

	@Value("${isRestCall:NO}")
	private String isRestCall;

	public AppointmentService getAppointmentService() {

		AppointmentService tempAppointmentService = null;

		for (AppointmentService appointmentService : appointmentServices) {

			if ("YES".equalsIgnoreCase(isRestCall)) {

				if (AppointmentEnum.THROUGH_RESTTEMPLATE.equals(appointmentService.getAppointmentEnum())) {
					tempAppointmentService = appointmentService;
					break;
				}

			} else if ("NO".equalsIgnoreCase(isRestCall)) {
				if (AppointmentEnum.DIRECT_DATABASE.equals(appointmentService.getAppointmentEnum())) {
					tempAppointmentService = appointmentService;
					break;
				}
			}

		}

		return tempAppointmentService;

	}
}
