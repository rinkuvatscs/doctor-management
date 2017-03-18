package com.medical.doctor.patient.factory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.medical.doctor.enums.LoginEnum;
import com.medical.doctor.patient.enums.PatientLoginEnum;
import com.medical.doctor.patient.service.PatientLoginService;

@Component
public class PatientLoginFactory {

	@Autowired
	private List<PatientLoginService> patientLoginServiceList;

	@Value("${isRestCall:NO}")
	private String isRestCall;

	public PatientLoginService getPatientLoginService() {

		PatientLoginService service = null;

		for (PatientLoginService loginService : patientLoginServiceList) {

			if ("YES".equalsIgnoreCase(isRestCall)) {
				if (PatientLoginEnum.THROUGH_RESTTEMPLATE.equals(loginService.getLoginEnum())) {
					service = loginService;
					break;
				}
			} else if ("NO".equalsIgnoreCase(isRestCall)) {
				if (LoginEnum.DIRECT_DATABASE.equals(loginService.getLoginEnum())) {
					service = loginService;
					break;
				}
			}
		}
		return service;
	}
}
