package com.medical.doctor.service.impl;

import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
public class MiscUsingDatabaseImpl implements MiscService {

	@Value("${mail.smtp.auth}")
	private String smtp;
	@Value("${mail.smtp.auth.enable}")
	private String smtpEnable;
	@Value("${mail.smtp.starttls}")
	private String starttls;
	@Value("${mail.smtp.starttls.enable}")
	private String starttlsEnable;
	@Value("${mail.smtp.host}")
	private String host;
	@Value("${mail.smtp.host.url}")
	private String hostUrl;
	@Value("${mail.smtp.port}")
	private String port;
	@Value("${mail.smtp.port.number}")
	private String portNumber;
	@Value("${mail.username}")
	private String username;
	@Value("${password}")
	private String password;

	// final String username = "aviralmittal@srydada.96.lt";
	// final String password = "aviral";

	@Autowired
	private ContactDao contactDao;

	@Autowired
	private AdvertiseDoctorDao advertiseDoctorDao;

	@Override
	public String sendMail(Email email) {

		Session session = getSession();
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));

			if (!StringUtils.isEmpty(email.getTo())) {
				message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email.getTo()));
			}
			if (!StringUtils.isEmpty(email.getMessageSubject())) {
				message.setSubject(email.getMessageSubject());
			}
			message.setText(email.getMessage());
			Transport.send(message);
			System.out.println("Done");
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
		return null;
	}

	@Override
	public String SingleTo_MultipleCC(Email email) {

		Session session = getSession();
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			if (!StringUtils.isEmpty(email.getTo())) {
				message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email.getTo()));
			}
			if (!StringUtils.isEmpty(email.getMessageSubject())) {
				message.setSubject(email.getMessageSubject());
			}
			if (!StringUtils.isEmpty(email.getMultiple_cc()) && !email.getMultiple_cc().isEmpty()) {

				InternetAddress[][] addresses = new InternetAddress[email.getMultiple_cc().size()][email
						.getMultiple_cc().size()];
				for (int i = 0; i < email.getMultiple_cc().size(); i++) {
					addresses[i] = InternetAddress.parse(email.getMultiple_cc().get(i));
				}
				for (InternetAddress[] internetAddress : addresses) {
					message.setRecipients(Message.RecipientType.CC, internetAddress);
				}
			}
			message.setText(email.getMessage());
			Transport.send(message);
			System.out.println("Done");
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
		return null;
	}

	private Session getSession() {

		Properties props = new Properties();
		props.put(smtp, smtpEnable);
		props.put(starttls, starttlsEnable);
		props.put(host, hostUrl);
		props.put(port, portNumber);

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		return session;
	}

	@Override
	public MiscEnum getMiscEnum() {
		return MiscEnum.DIRECT_DATABASE;
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
