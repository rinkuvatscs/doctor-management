package com.medical.doctor.constants;

public interface CommonServiceConstants {

	String INSERT_MESSAGE_INTO_PATIENT = "INSERT INTO message(message, pId) VALUES(?, ?)";

	String INSERT_MESSAGE_INTO_DOCTOR = "INSERT INTO message(message, dId) VALUES(?, ?)";

	String UPDATE_MESSAGE = "UPDATE message SET status=1 WHERE messageId = ? ";

	String GET_MESSAGE_FOR_PATIENT = "SELECT * FROM message WHERE pId = ? && status = false";

	String GET_MESSAGE_FOR_DOCTOR = "SELECT * FROM message WHERE dId = ? && status = false";

	String INSERT_NOTIFICATION_INTO_PATIENT = "INSERT INTO notification(notifyMessage, pId) VALUES(?, ?)";

	String INSERT_NOTIFICATION_INTO_DOCTOR = "INSERT INTO notification(notifyMessage, dId) VALUES(?, ?)";

	String UPDATE_NOTIFICATION = "UPDATE notification SET status=1 WHERE notifyId = ? ";

	String GET_NOTIFICATION_FOR_PATIENT = "SELECT * FROM notification WHERE pId = ? && status = false";

	String GET_NOTIFICATION_FOR_DOCTOR = "SELECT * FROM notification WHERE dId = ? && status = false";
}
