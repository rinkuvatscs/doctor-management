package com.medical.doctor.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.medical.doctor.dao.AdvertiseDoctorDao;
import com.medical.doctor.dao.ContactDao;
import com.medical.doctor.entity.AdvertiseDoctor;
import com.medical.doctor.entity.Contact;
import com.medical.doctor.entity.Email;
import com.medical.doctor.enums.MiscEnum;
import com.medical.doctor.service.MiscService;

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
	public Contact getContact() {
		return contactDao.getContact();
	}

	@Override
	public String updateContact(Contact contact) {
		return contactDao.updateContact(contact);
	}

	@Override
	public List<Contact> getAll() {
		return contactDao.getAll();
	}

	@Override
	public List<AdvertiseDoctor> getDoctorByDate(AdvertiseDoctor advertiseDoctor) {
		return advertiseDoctorDao.getDoctorByDate(advertiseDoctor);
	}

}
