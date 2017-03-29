package com.medical.solutions.service;

import com.medical.solutions.entity.Cases;

public interface CasesService {
	
	public String createCase(Cases cases);
	public String closeCase(Integer caseId);
	public String reopenCase(Integer caseId);
	public String updateCase(Cases cases);
	

}
