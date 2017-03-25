package com.medical.doctor.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.medical.doctor.constants.CasesQueryConstants;
import com.medical.doctor.dao.CasesDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.medical.doctor.entity.Cases;
import com.medical.doctor.exceptionhandler.BadRequestException;

@Repository
public class CasesDaoImpl implements CasesDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public String createCase(Cases cases) {
		
		List<Object> args = new ArrayList<>();
		args.add(cases.getpId());
		args.add(cases.getdId());
		args.add(cases.getPrecaution());
		int row = jdbcTemplate.update(CasesQueryConstants.INSERT_CASE, args.toArray());
		if (row > 0)
		{
			return "Case Created";
		}
		else {
			return "Case Not created";
		}
	}
	
	@Override
	public String closeCase(Integer caseId) {
		
		if(!StringUtils.isEmpty(caseId)){
			Object args[] = { caseId };
			int row = jdbcTemplate.update(CasesQueryConstants.CLOSE_CASE, args);
			if (row > 0){
				return "Case Closed";
			}
			else {
				return "CaseID Does not exists";
			}
		}
		else{
			return "CaseID is NULL";
		}
			
	}

	@Override
	public String reopenCase(Integer caseId) {

		if(!StringUtils.isEmpty(caseId)){
			Object args[] = { caseId };
			int row = jdbcTemplate.update(CasesQueryConstants.REOPEN_CASE, args);
			if (row > 0){
				return "Case Reopned";
			}
			else {
				return "CaseID does not exists";
			}
		}
		else{
			return "CaseID is NULL";
		}
	}

	

}
