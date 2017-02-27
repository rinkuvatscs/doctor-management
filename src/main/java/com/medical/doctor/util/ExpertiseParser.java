package com.medical.doctor.util;

public class ExpertiseParser {

	public static String[] parseExpertise(String expertise) {
		return expertise.split(",");
	}
}
