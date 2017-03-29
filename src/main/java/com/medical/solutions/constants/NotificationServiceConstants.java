package com.medical.solutions.constants;

public interface NotificationServiceConstants {

	String INSERT_NOTIFICATION_INTO_PATIENT = "INSERT INTO notification(notifyMessage, pId) VALUES(?, ?)";

	String INSERT_NOTIFICATION_INTO_DOCTOR = "INSERT INTO notification(notifyMessage, dId) VALUES(?, ?)";

	String UPDATE_NOTIFICATION = "UPDATE notification SET status=1 WHERE notifyId = ? ";

	String GET_NOTIFICATION_FOR_PATIENT = "SELECT * FROM notification WHERE pId = ? and status = false";

	String GET_NOTIFICATION_FOR_DOCTOR = "SELECT * FROM notification WHERE dId = ? and status = false";
}
