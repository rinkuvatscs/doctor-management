package com.medical.solutions.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.medical.solutions.constants.MiscQueryConstants;
import com.medical.solutions.dao.ContactDao;
import com.medical.solutions.entity.Contact;
import com.medical.solutions.extractor.ContactExtractor;

@Component
public class ContactDaoImpl implements ContactDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public String addContact(Contact contact) {
		String response = null;
		if (!StringUtils.isEmpty(contact)) {
			Object args[] = { contact.getName(), contact.getMobile(), contact.getEmail(), contact.getMessage() };
			int add = jdbcTemplate.update(MiscQueryConstants.ADD_CONTENT, args);
			if (add > 0) {
				response = "Successfully inserted";
			} else {
				response = "unable to insert it";
			}
		}
		return response;
	}

	@Override
	public Contact getContact(String email) {
		Object[] args = { email };
		List<Contact> contacts = jdbcTemplate.query(MiscQueryConstants.GET_CONTENT, new ContactExtractor(), args);
		if (!contacts.isEmpty()) {
			return contacts.get(0);
		}
		return new Contact();
	}

	@Override
	public String updateContact(Contact contact) {
		String response = null;
		if (!StringUtils.isEmpty(contact)) {
			Object args[] = { contact.getName(), contact.getMobile(), contact.getMessage(), contact.getEmail() };
			int add = jdbcTemplate.update(MiscQueryConstants.UPDATE_CONTENT, args);
			if (add > 0) {
				response = "Successfully Updated";
			} else {
				response = "unable to insert it";
			}
		}
		return response;
	}

	@Override
	public List<Contact> getAll(Contact contact) {
		Object[] args = { contact.getId(), contact.getName(), contact.getMobile(), contact.getEmail(),
				contact.getMessage() };
		List<Contact> response = jdbcTemplate.query(MiscQueryConstants.GET_ALL, new ContactExtractor(), args);
		return response;
	}

}
