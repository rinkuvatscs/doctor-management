package com.medical.solutions.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.medical.solutions.dao.AdvertiseDoctorDao;
import com.medical.solutions.dao.ContactDao;
import com.medical.solutions.entity.AdvertiseDoctor;
import com.medical.solutions.entity.Contact;
import com.medical.solutions.entity.Email;
import com.medical.solutions.enums.MiscEnum;
import com.medical.solutions.service.MiscService;

@Service
public class MiscUsingRestCallImpl implements MiscService {

	@Autowired
	private ContactDao contactDao;

	@Autowired
	private AdvertiseDoctorDao advertiseDoctorDao;

	@Override
	public String sendMail(Email email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MiscEnum getMiscEnum() {
		return MiscEnum.THROUGH_RESTTEMPLATE;
	}

	@Override
	public String SingleTo_MultipleCC(Email email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String addContact(Contact responseContact) {
		String response = null;
		if (!StringUtils.isEmpty(responseContact)) {
			response = contactDao.addContact(responseContact);
		}
		return response;
	}

	@Override
	public Contact getContact(String email) {
		return contactDao.getContact(email);
	}

	@Override
	public String updateContact(Contact contact) {
		return contactDao.updateContact(contact);
	}

	@Override
	public List<Contact> getAll(Contact contact) {
		return contactDao.getAll(contact);
	}

	@Override
	public List<AdvertiseDoctor> getDoctorByDate(AdvertiseDoctor advertiseDoctor) {
		return advertiseDoctorDao.getDoctorByDate(advertiseDoctor);
	}

}
