package com.medical.doctor.request;

public class NotificationServiceRequest {

	private int notifyId;
	private String notiyfMessage;
	private int pId;
	private int dId;
	private boolean status;

	public int getNotifyId() {
		return notifyId;
	}

	public void setNotifyId(int notifyId) {
		this.notifyId = notifyId;
	}

	public String getNotiyfMessage() {
		return notiyfMessage;
	}

	public void setNotiyfMessage(String notiyfMessage) {
		this.notiyfMessage = notiyfMessage;
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public int getdId() {
		return dId;
	}

	public void setdId(int dId) {
		this.dId = dId;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "NotificationService [notifyId=" + notifyId + ", notiyfMessage="
				+ notiyfMessage + ", pId=" + pId + ", dId=" + dId + ", status="
				+ status + "]";
	}
}
