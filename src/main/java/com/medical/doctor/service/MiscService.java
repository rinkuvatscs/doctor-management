package com.medical.doctor.service;

import com.medical.doctor.entity.Email;
import com.medical.doctor.enums.MiscEnum;

public interface MiscService {

	public String sendMail(Email email);
	
	public String SingleTo_MultipleCC(Email email);

	public MiscEnum getMiscEnum();
}
