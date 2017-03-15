package com.medical.doctor.entity;

import java.util.List;

public class Email {

	private String to;
	private List<String> multiple_to;
	private String cc;
	private List<String> multiple_cc;
	private String bcc;
	private String message;
	private String messageSubject;

	public String getMessageSubject() {
		return messageSubject;
	}

	public void setMessageSubject(String messageSubject) {
		this.messageSubject = messageSubject;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getCc() {
		return cc;
	}

	public void setCc(String cc) {
		this.cc = cc;
	}

	public String getBcc() {
		return bcc;
	}

	public void setBcc(String bcc) {
		this.bcc = bcc;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<String> getMultiple_to() {
		return multiple_to;
	}

	public void setMultiple_to(List<String> multiple_to) {
		this.multiple_to = multiple_to;
	}

	public List<String> getMultiple_cc() {
		return multiple_cc;
	}

	public void setMultiple_cc(List<String> multiple_cc) {
		this.multiple_cc = multiple_cc;
	}

	@Override
	public String toString() {
		return "Email [to=" + to + ", multiple_to=" + multiple_to + ", cc="
				+ cc + ", multiple_cc=" + multiple_cc + ", bcc=" + bcc
				+ ", message=" + message + ", messageSubject=" + messageSubject
				+ "]";
	}

}
