package com.medical.solutions.extractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.medical.solutions.entity.Contact;

public class ContactExtractor implements ResultSetExtractor<List<Contact>> {

	@Override
	public List<Contact> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<Contact> contactList = new ArrayList<Contact>();
		Contact contact = null;
		while (rs.next()) {
			contact = new Contact();
			contact.setId(rs.getInt("contactUsId"));
			contact.setName(rs.getString("name"));
			contact.setMobile(rs.getString("mobile"));
			contact.setEmail(rs.getString("email"));
			contact.setMessage(rs.getString("message"));
			contactList.add(contact);
		}
		return contactList;
	}

}
