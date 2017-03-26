package com.medical.doctor.service;

import java.util.List;

import com.medical.doctor.entity.AdvertiseDoctor;
import com.medical.doctor.entity.Contact;
import com.medical.doctor.entity.Email;
import com.medical.doctor.enums.MiscEnum;

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
