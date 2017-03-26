package com.medical.doctor.dao;

import java.util.List;

import com.medical.doctor.entity.Contact;


public interface ContactDao {

	public String addContact(Contact contact);

	public Contact getContact(String email);

	public String updateContact(Contact contact);
	
	public List<Contact> getAll(Contact contact);
}
