package com.medical.doctor.request;

public class LocationServiceRequest {
	private long langitude;
	private long latidude;
	private String address;
	
	public long getLangitude() {
		return langitude;
	}
	public void setLangitude(long langitude) {
		this.langitude = langitude;
	}
	public long getLatidude() {
		return latidude;
	}
	public void setLatidude(long latidude) {
		this.latidude = latidude;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "LocationServiceRequest [langitude=" + langitude + ", latidude="
				+ latidude + ", address=" + address + "]";
	}
}
