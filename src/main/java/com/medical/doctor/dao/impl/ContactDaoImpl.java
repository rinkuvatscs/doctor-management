package com.medical.doctor.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.medical.doctor.constants.MiscQueryConstants;
import com.medical.doctor.dao.ContactDao;
import com.medical.doctor.entity.Contact;
import com.medical.doctor.extractor.ContactExtractor;
@Component
public class ContactDaoImpl implements ContactDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public String addContact(Contact contact) {
		String response = null;
		if (!StringUtils.isEmpty(contact)){
			Object args[] = { contact.getName(), contact.getEmail(), contact.getMobile(),
					contact.getMessage() };
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
	public Contact getContact() {
		List<Contact> contacts = jdbcTemplate.query(MiscQueryConstants.GET_CONTENT, new ContactExtractor());
		if (!contacts.isEmpty()) {
			return contacts.get(0);
		}
		return new Contact();
	}

	@Override
	public String updateContact(Contact contact) {
		String response = null;
		if (!StringUtils.isEmpty(contact)) {
			Object args[] = { contact.getName(), contact.getMobile(),
					contact.getMessage(), contact.getEmail() };
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
	public List<Contact> getAll() {
		List<Contact> contact = jdbcTemplate.query(MiscQueryConstants.GET_ALL, new ContactExtractor());
		return contact;
	}

}
