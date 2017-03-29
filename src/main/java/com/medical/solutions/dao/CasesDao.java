package com.medical.solutions.dao;

import com.medical.solutions.entity.Cases;

public interface CasesDao {
	
	public String createCase(Cases cases);
	
	public String closeCase(Integer caseId);
	
	public String reopenCase(Integer caseId);

	public String updateCase(Cases cases);

	

}
