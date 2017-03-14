package com.medical.doctor.service.impl;

import org.springframework.stereotype.Service;

import com.medical.doctor.entity.Email;
import com.medical.doctor.enums.MiscEnum;
import com.medical.doctor.service.MiscService;

@Service
public class MiscUsingRestCallImpl implements MiscService {

	@Override
	public String sendMail(Email email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MiscEnum getMiscEnum() {
		return MiscEnum.THROUGH_RESTTEMPLATE;
	}

	@Override
	public String SingleTo_MultipleCC(Email email) {
		// TODO Auto-generated method stub
		return null;
	}

}
