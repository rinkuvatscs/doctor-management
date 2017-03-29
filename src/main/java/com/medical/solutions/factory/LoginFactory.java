package com.medical.solutions.factory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.medical.solutions.enums.LoginEnum;
import com.medical.solutions.service.LoginService;

@Component
public class LoginFactory {

	@Autowired
	private List<LoginService> loginServiceList;

	@Value("${isRestCall:NO}")
	private String isRestCall;

	public LoginService getLoginService() {

		LoginService tempLoginService = null;

		for (LoginService loginService : loginServiceList) {

			if ("YES".equalsIgnoreCase(isRestCall)) {

				if (LoginEnum.THROUGH_RESTTEMPLATE.equals(loginService
						.getLoginEnum())) {
					tempLoginService = loginService;
					break;
				}

			} else if ("NO".equalsIgnoreCase(isRestCall)) {
				if (LoginEnum.DIRECT_DATABASE.equals(loginService
						.getLoginEnum())) {
					tempLoginService = loginService;
					break;
				}
			}

		}

		return tempLoginService;

	}

}
