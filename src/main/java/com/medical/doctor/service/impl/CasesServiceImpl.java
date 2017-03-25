package com.medical.doctor.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medical.doctor.dao.CasesDao;
import com.medical.doctor.entity.Cases;
import com.medical.doctor.service.CasesService;

@Service
public class CasesServiceImpl implements CasesService {

	@Autowired
	private CasesDao casesDao;
	
	@Override
	public String createCase(Cases cases) {

		return casesDao.createCase(cases);
	}
	
	@Override
	public String closeCase(Integer caseId) {

		return casesDao.closeCase(caseId);
	}

	@Override
	public String reopenCase(Integer caseId) {

		return casesDao.reopenCase(caseId);
	}

	@Override
	public String updateCase(Cases cases) {
	
		return casesDao.updateCase(cases);
	}

	

}
