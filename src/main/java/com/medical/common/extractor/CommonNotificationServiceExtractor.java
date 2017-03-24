package com.medical.common.extractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.medical.doctor.entity.MessageService;
import com.medical.doctor.entity.NotificationService;

public class CommonNotificationServiceExtractor implements
		ResultSetExtractor<List<NotificationService>> {

	@Override
	public List<NotificationService> extractData(ResultSet rs)
			throws SQLException, DataAccessException {
		List<NotificationService> notificationServices = new ArrayList<NotificationService>();
		NotificationService notificationService;

		while (rs.next()) {
			notificationService = new NotificationService();
			notificationService.setNotifyId(rs.getInt("notifyId"));
			notificationService.setNotiyfMessage(rs.getString("notifyMessage"));
			notificationService.setdId(rs.getInt("dId"));
			notificationService.setpId(rs.getInt("pId"));
			notificationService.setStatus(rs.getBoolean("status"));
			notificationServices.add(notificationService);
		}
		return notificationServices;
	}
}
