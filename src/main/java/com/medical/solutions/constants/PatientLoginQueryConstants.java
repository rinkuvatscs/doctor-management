package com.medical.solutions.constants;

public interface PatientLoginQueryConstants {

	String IS_EXIST = "SELECT * FROM login ";

	String ADD_DOCTOR = "INSERT INTO login (mobile,Password,adhaar,email,type,createdDate,updatedDate) values (?,?,?,?,?,NOW(),NOW())";

	String INSERT_LOGIN = "insert into login (mobile,password,adhaar,email,type,typeId,createdDate) values (?,?,?,?,?,?, NOW())";
}
