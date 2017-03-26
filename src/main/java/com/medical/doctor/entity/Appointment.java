package com.medical.doctor.entity;

import java.util.Date;

public class Appointment {

	private Integer appointmentId;
	private Integer dId;
	private Integer pId;
	private String appointmentDesc;
	private Date createdDate;

	public Integer getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(Integer appointmentId) {
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

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Override
	public String toString() {
		return "Appointment [appointmentId=" + appointmentId + ", dId=" + dId + ", pId=" + pId + ", appointmentDesc="
				+ appointmentDesc + ", createdDate=" + createdDate + "]";
	}

}
