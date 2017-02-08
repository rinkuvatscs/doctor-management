package com.medical.doctor.request;

public class SearchDoctorRequest {

	private String aadhaarNumber;
	private int doctorId;
	private String email;
	private String mobile;

	private String name;
	private String homeAddress;
	private String expertized;
	private Boolean isGovernmentServent;
	private String oneTimeFee;
	private String clinicAddress;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "SearchDoctorRequest [name=" + name + ", homeAddress="
				+ homeAddress + ", expertized=" + expertized
				+ ", isGovernmentServent=" + isGovernmentServent
				+ ", oneTimeFee=" + oneTimeFee + ", clinicAddress="
				+ clinicAddress + "]";
	}

	public String getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}

	public String getExpertized() {
		return expertized;
	}

	public void setExpertized(String expertized) {
		this.expertized = expertized;
	}

	public Boolean getIsGovernmentServent() {
		return isGovernmentServent;
	}

	public void setIsGovernmentServent(Boolean isGovernmentServent) {
		this.isGovernmentServent = isGovernmentServent;
	}

	public String getOneTimeFee() {
		return oneTimeFee;
	}

	public void setOneTimeFee(String oneTimeFee) {
		this.oneTimeFee = oneTimeFee;
	}

	public String getClinicAddress() {
		return clinicAddress;
	}

	public void setClinicAddress(String clinicAddress) {
		this.clinicAddress = clinicAddress;
	}

	public String getAadhaarNumber() {
		return aadhaarNumber;
	}

	public void setAadhaarNumber(String aadhaarNumber) {
		this.aadhaarNumber = aadhaarNumber;
	}

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

}
