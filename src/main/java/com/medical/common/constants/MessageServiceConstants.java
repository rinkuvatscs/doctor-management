package com.medical.common.constants;

public interface MessageServiceConstants {

	String INSERT_MESSAGE_INTO_PATIENT = "INSERT INTO message(message, pId) VALUES(?, ?)";

	String INSERT_MESSAGE_INTO_DOCTOR = "INSERT INTO message(message, dId) VALUES(?, ?)";

	String UPDATE_MESSAGE = "UPDATE message SET status=1 WHERE messageId = ? ";

	String GET_MESSAGE_FOR_PATIENT = "SELECT * FROM message WHERE pId = ? and status = false";

	String GET_MESSAGE_FOR_DOCTOR = "SELECT * FROM message WHERE dId = ? and status = false";

}
