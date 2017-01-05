package com.doctor.types.pojo;

public class Doctor {

	// doctor_id,doctor_name,doctor_number,doctor_home_address,doctor_adhar_number,doctor_highestdegree,
	// doctor_expertizeed,is_doctor_govt_servent,doctor_one_time_consulting_fee,doctor_days_to_check_free_in_consuting_fee,doctor_shop_address
	private Integer doctorId;
	private String doctorName;
	private String doctorNumber;
	private String doctorHomeAddress;
	private String doctorAdhaarNumber;
	private String doctorHighestDegree;
	private String doctorExpertized;
	private Boolean doctorGovtServent;
	private String doctorOneTimeConsultingFee;
	private Integer doctorDaystoCheckFreeInConsultingFee;
	private String doctorShopAddress;

	public Integer getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Integer doctorId) {
		this.doctorId = doctorId;
	}

	public String getDoctorNumber() {
		return doctorNumber;
	}

	public void setDoctorNumber(String doctorNumber) {
		this.doctorNumber = doctorNumber;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getDoctorHomeAddress() {
		return doctorHomeAddress;
	}

	public void setDoctorHomeAddress(String doctorHomeAddress) {
		this.doctorHomeAddress = doctorHomeAddress;
	}

	public String getDoctorAdhaarNumber() {
		return doctorAdhaarNumber;
	}

	public void setDoctorAdhaarNumber(String doctorAdhaarNumber) {
		this.doctorAdhaarNumber = doctorAdhaarNumber;
	}

	public String getDoctorHighestDegree() {
		return doctorHighestDegree;
	}

	public void setDoctorHighestDegree(String doctorHighestDegree) {
		this.doctorHighestDegree = doctorHighestDegree;
	}

	public String getDoctorExpertized() {
		return doctorExpertized;
	}

	public void setDoctorExpertized(String doctorExpertized) {
		this.doctorExpertized = doctorExpertized;
	}

	public Boolean getDoctorGovtServent() {
		return doctorGovtServent;
	}

	public void setDoctorGovtServent(Boolean doctorGovtServent) {
		this.doctorGovtServent = doctorGovtServent;
	}

	public String getDoctorOneTimeConsultingFee() {
		return doctorOneTimeConsultingFee;
	}

	public void setDoctorOneTimeConsultingFee(String doctorOneTimeConsultingFee) {
		this.doctorOneTimeConsultingFee = doctorOneTimeConsultingFee;
	}

	public Integer getDoctorDaystoCheckFreeInConsultingFee() {
		return doctorDaystoCheckFreeInConsultingFee;
	}

	public void setDoctorDaystoCheckFreeInConsultingFee(
			Integer doctorDaystoCheckFreeInConsultingFee) {
		this.doctorDaystoCheckFreeInConsultingFee = doctorDaystoCheckFreeInConsultingFee;
	}

	public String getDoctorShopAddress() {
		return doctorShopAddress;
	}

	public void setDoctorShopAddress(String doctorShopAddress) {
		this.doctorShopAddress = doctorShopAddress;
	}

}
