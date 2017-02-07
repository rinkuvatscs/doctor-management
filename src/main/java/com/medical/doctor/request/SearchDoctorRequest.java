package com.medical.doctor.request;

public class SearchDoctorRequest {

	private String name;
	private String homeAddress;
	private String expertized;
	private Boolean isGovernmentServent;
	private String oneTimeFee;
	private String clinicAddress;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SearchDoctorRequest [name=" + name + ", homeAddress="
				+ homeAddress + ", expertized=" + expertized
				+ ", isGovernmentServent=" + isGovernmentServent
				+ ", oneTimeFee=" + oneTimeFee + ", clinicAddress="
				+ clinicAddress + "]";
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the homeAddress
	 */
	public String getHomeAddress() {
		return homeAddress;
	}

	/**
	 * @param homeAddress
	 *            the homeAddress to set
	 */
	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}

	/**
	 * @return the expertized
	 */
	public String getExpertized() {
		return expertized;
	}

	/**
	 * @param expertized
	 *            the expertized to set
	 */
	public void setExpertized(String expertized) {
		this.expertized = expertized;
	}

	/**
	 * @return the isGovernmentServent
	 */
	public Boolean getIsGovernmentServent() {
		return isGovernmentServent;
	}

	/**
	 * @param isGovernmentServent
	 *            the isGovernmentServent to set
	 */
	public void setIsGovernmentServent(Boolean isGovernmentServent) {
		this.isGovernmentServent = isGovernmentServent;
	}

	/**
	 * @return the oneTimeFee
	 */
	public String getOneTimeFee() {
		return oneTimeFee;
	}

	/**
	 * @param oneTimeFee
	 *            the oneTimeFee to set
	 */
	public void setOneTimeFee(String oneTimeFee) {
		this.oneTimeFee = oneTimeFee;
	}

	/**
	 * @return the clinicAddress
	 */
	public String getClinicAddress() {
		return clinicAddress;
	}

	/**
	 * @param clinicAddress
	 *            the clinicAddress to set
	 */
	public void setClinicAddress(String clinicAddress) {
		this.clinicAddress = clinicAddress;
	}
}
