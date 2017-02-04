package com.medical.doctor.response;

public class DoctorResponse {

	private Integer doctorId;
	private String name;
	private String mobile;
	private String homeAddress;
	private String aadhaarNumber;
	private String highestDegree;
	private String expertized;
	private Boolean isGovernmentServent;
	private String oneTimeFee;
	private Integer daysCheckFree;
	private String clinicAddress;
	private String email;
	private String gender ;
	private int age;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}


	public Integer getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Integer doctorId) {
		this.doctorId = doctorId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}

	public String getAadhaarNumber() {
		return aadhaarNumber;
	}

	public void setAadhaarNumber(String aadhaarNumber) {
		this.aadhaarNumber = aadhaarNumber;
	}

	public String getHighestDegree() {
		return highestDegree;
	}

	public void setHighestDegree(String highestDegree) {
		this.highestDegree = highestDegree;
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

	public Integer getDaysCheckFree() {
		return daysCheckFree;
	}

	public void setDaysCheckFree(Integer daysCheckFree) {
		this.daysCheckFree = daysCheckFree;
	}

	public String getClinicAddress() {
		return clinicAddress;
	}

	public void setClinicAddress(String clinicAddress) {
		this.clinicAddress = clinicAddress;
	}

	@Override
	public String toString() {
		return "Doctor [doctorId=" + doctorId + ", name=" + name + ", mobile="
				+ mobile + ", homeAddress=" + homeAddress + ", aadhaarNumber="
				+ aadhaarNumber + ", highestDegree=" + highestDegree
				+ ", expertized=" + expertized + ", isGovernmentServent="
				+ isGovernmentServent + ", oneTimeFee=" + oneTimeFee
				+ ", daysCheckFree=" + daysCheckFree + ", clinicAddress="
				+ clinicAddress + "]";
	}

}
