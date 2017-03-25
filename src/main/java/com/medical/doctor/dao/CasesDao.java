package com.medical.doctor.dao;

import com.medical.doctor.entity.Cases;

public interface CasesDao {
	
	public String createCase(Cases cases);
	
	public String closeCase(Integer caseId);
	
	public String reopenCase(Integer caseId);

	

}
