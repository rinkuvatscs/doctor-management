package com.medical.doctor.constants;

public interface CasesQueryConstants {
	
	String INSERT_CASE ="insert into cases(pId, dId, precaution, createdDate, closed) values (?,?,?,NOW(),1)" ;
	
	String CLOSE_CASE = "UPDATE cases SET closed=0 WHERE caseId =?";
	
	String REOPEN_CASE ="UPDATE cases SET closed=1 WHERE caseId =?";
	
	String UPDATE_CASE ="UPDATE cases SET dId = ?, precaution =?, closed=1 WHERE caseId =?";

}
