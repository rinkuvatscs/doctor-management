package com.medical.solutions.entity;

public class Cases {

	private Integer caseId;
	private Integer pId;
	private Integer dId;
	private String precaution;

	
	public Integer getCaseId() {
		return caseId;
	}
	public void setCaseId(Integer caseId) {
		this.caseId = caseId;
	}
	public Integer getpId() {
		return pId;
	}
	public void setpId(Integer pId) {
		this.pId = pId;
	}
	public Integer getdId() {
		return dId;
	}
	public void setdId(Integer dId) {
		this.dId = dId;
	}
	public String getPrecaution() {
		return precaution;
	}
	public void setPrecaution(String precaution) {
		this.precaution = precaution;
	}

	
	@Override
	public String toString() {
		return "Cases [caseId="+ caseId + ", pId=" + pId +",dId="+ dId + 
				 ", precaution=" + precaution + "]";
	}
}
