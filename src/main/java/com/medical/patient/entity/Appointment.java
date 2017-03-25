package com.medical.patient.entity;

public class Appointment {
	private Integer appointmentId;
	private Integer dId;
	private Integer pId;
	private String appointmentDesc ;
	public Integer getAppoinmentId() {
		return appointmentId;
	}
	public void setAppoinmentId(Integer appointmentId) {
		this.appointmentId = appointmentId;
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
	
	public String getAppointmentDesc() {
		return appointmentDesc;
	}
	public void setAppointmentDesc(String appointmentDesc) {
		this.appointmentDesc = appointmentDesc;
	}
		
	@Override
	public String toString() {
		return "Appointment [appointmentId="+ appointmentId + ", dId=" + dId +",pId="+ pId + 
				 ", appointmentDesc=" + appointmentDesc + "]";
	}

}
