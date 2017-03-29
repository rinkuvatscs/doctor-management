package com.medical.solutions.service;

import java.util.List;

import com.medical.solutions.entity.AdvertiseDoctor;
import com.medical.solutions.entity.Contact;
import com.medical.solutions.entity.Email;
import com.medical.solutions.enums.MiscEnum;

public interface MiscService {

	public String sendMail(Email email);

	public String SingleTo_MultipleCC(Email email);

	public MiscEnum getMiscEnum();

	public String addContact(Contact contact);

	public Contact getContact(String email);

	public String updateContact(Contact contact);

	public List<Contact> getAll(Contact contact);

	public List<AdvertiseDoctor> getDoctorByDate(AdvertiseDoctor advertiseDoctor);

}
