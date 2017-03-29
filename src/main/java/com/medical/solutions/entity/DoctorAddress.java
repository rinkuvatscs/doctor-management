package com.medical.solutions.entity;

import java.math.BigInteger;


public class DoctorAddress extends Doctor {

	private String timing ;
	private String city;
	private String state ;
	private BigInteger pin ;
	private String landmark ;
	private float latitude ;
	private float longitude ;
	
	public String getTiming() {
		return timing;
	}
	public void setTiming(String timing) {
		this.timing = timing;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public BigInteger getPin() {
		return pin;
	}
	public void setPin(BigInteger pin) {
		this.pin = pin;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	public String getLandmark() {
		return landmark;
	}
	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}
	public float getLatitude() {
		return latitude;
	}
	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}
	public float getLongitude() {
		return longitude;
	}
	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}
	
	@Override
	public String toString() {
		return "DoctorAddress [timing=" + timing + ", city=" + city
				+ ", state=" + state + ", pin=" + pin + ", landmark="
				+ landmark + ", latitude=" + latitude + ", longitude="
				+ longitude + "]";
	}
		
	
	
}
