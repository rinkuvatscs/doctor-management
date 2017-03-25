package com.medical.doctor.service;

import com.medical.doctor.entity.Cases;

public interface CasesService {
	
	public String createCase(Cases cases);
	public String closeCase(Integer caseId);
	public String reopenCase(Integer caseId);
	public String updateCase(Cases cases);
	

}
