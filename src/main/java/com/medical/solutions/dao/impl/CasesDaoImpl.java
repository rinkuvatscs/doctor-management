package com.medical.solutions.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.medical.solutions.constants.CasesQueryConstants;
import com.medical.solutions.dao.CasesDao;
import com.medical.solutions.entity.Cases;

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
		int row = jdbcTemplate.update(CasesQueryConstants.INSERT_CASE,
				args.toArray());
		if (row > 0) {
			return "Case Created";
		} else {
			return "Case Not created";
		}
	}

	@Override
	public String closeCase(Integer caseId) {

		if (!StringUtils.isEmpty(caseId)) {
			Object args[] = { caseId };
			int row = jdbcTemplate.update(CasesQueryConstants.CLOSE_CASE, args);
			if (row > 0) {
				return "Case Closed";
			} else {
				return "CaseID Does not exists";
			}
		} else {
			return "CaseID is NULL";
		}

	}

	@Override
	public String reopenCase(Integer caseId) {

		if (!StringUtils.isEmpty(caseId)) {
			Object args[] = { caseId };
			int row = jdbcTemplate
					.update(CasesQueryConstants.REOPEN_CASE, args);
			if (row > 0) {
				return "Case Reopned";
			} else {
				return "CaseID does not exists";
			}
		} else {
			return "CaseID is NULL";
		}
	}

	@Override
	public String updateCase(Cases cases) {

		List<Object> args = new ArrayList<>();
		args.add(cases.getdId());
		args.add(cases.getPrecaution());
		args.add(cases.getCaseId());
		int row = jdbcTemplate.update(CasesQueryConstants.UPDATE_CASE,
				args.toArray());
		if (row > 0) {
			return "Case Updated";
		} else {
			return "Case Not Updated";
		}
	}

}
