package com.medical.common.factory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.medical.common.enums.CommonServiceEnum;
import com.medical.common.service.CommonService;

@Component
public class CommonFactory {

	@Autowired
	private List<CommonService> commonServices;

	@Value("${isRestCall:NO}")
	private String isRestCall;

	public CommonService getCommonService() {

		CommonService tempCommonService = null;

		for (CommonService commonService : commonServices) {

			if ("YES".equalsIgnoreCase(isRestCall)) {

				if (CommonServiceEnum.THROUGH_RESTTEMPLATE.equals(commonService.getCommonService())) {
					tempCommonService = commonService;
					break;
				}

			} else if ("NO".equalsIgnoreCase(isRestCall)) {
				if (CommonServiceEnum.DIRECT_DATABASE.equals(commonService.getCommonService())) {
					tempCommonService = commonService;
					break;
				}
			}

		}

		return tempCommonService;

	}
}
