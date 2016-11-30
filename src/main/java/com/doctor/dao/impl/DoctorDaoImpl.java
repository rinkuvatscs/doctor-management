package com.doctor.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.doctor.dao.DoctorDao;
import com.doctor.db.config.QueryConstants;
import com.doctor.extractor.DoctorExtractor;
import com.doctor.types.pojo.Doctor;

@Component
public class DoctorDaoImpl implements DoctorDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public String addDoctor(Doctor doctor) {
		String response = null;
		if (!isDoctorExists(doctor)) {

			List<Object> args = new ArrayList<>();
			args.add(doctor.getDoctorName());
			args.add(doctor.getDoctorNumber());
			args.add(doctor.getDoctorHomeAddress());
			args.add(doctor.getDoctorAdhaarNumber());
			args.add(doctor.getDoctorHighestDegree());
			args.add(doctor.getDoctorExpertized());
			args.add(doctor.getDoctorGovtServent());
			args.add(doctor.getDoctorOneTimeConsultingFee());
			args.add(doctor.getDoctorDaystoCheckFreeInConsultingFee());
			args.add(doctor.getDoctorShopAddress());

			int row = jdbcTemplate.update(QueryConstants.ADD_DOCTOR,
					args.toArray());
			if (row == 1) {
				response = doctor.getDoctorName() + " registered successfully";
			} else {
				response = "Sorry, " + doctor.getDoctorName()
						+ " not registered . Please try again";
			}
		} else {
			response = "Sorry, " + doctor.getDoctorName()
					+ " already registered";
		}

		return response;
	}

	@Override
	public String deleteDoctor(Integer doctorId) {
		String response = null;
		List<Object> args = new ArrayList<>();
		args.add(doctorId);
		int row = jdbcTemplate.update(QueryConstants.DELETE_DOCTOR,
				args.toArray());
		if (row == 1) {
			response = "Doctor ID " + doctorId + " deleted successfully";
		} else {
			response = "Sorry, Doctor ID " + doctorId
					+ " not exists in record. Please check again";
		}

		return response;
	}

	@Override
	public boolean isDoctorExists(Doctor doctor) {

		boolean isExist = false;
		List<String> args = new ArrayList<>();
		args.add(doctor.getDoctorNumber());
		args.add(doctor.getDoctorAdhaarNumber());
		List<Doctor> response = jdbcTemplate.query(
				QueryConstants.IS_DOCTOR_EXIST, new DoctorExtractor(),
				args.toArray());
		if (!StringUtils.isEmpty(response) && response.size() > 0) {
			isExist = true;
		}
		return isExist;
	}

	@Override
	public List<Doctor> getDoctorById(Integer id) {

		Object args[] = { id };
		List<Doctor> response = jdbcTemplate.query(
				QueryConstants.GET_DOCTOR_BY_ID, args, new DoctorExtractor());
		if (!StringUtils.isEmpty(response) && response.size() > 0) {
			return response;
		}
		return null;
	}

	@Override
	public List<Doctor> getDoctorByAdharNumber(String adharNumber) {

		Object args[] = { adharNumber };
		List<Doctor> response = jdbcTemplate.query(
				QueryConstants.GET_DOCTOR_BY_ADHAR_NUMBER,
				new DoctorExtractor(), args);
		if (!StringUtils.isEmpty(response) && response.size() > 0) {
			return response;
		}
		return null;
	}

	@Override
	public List<Doctor> getDoctorByMobileNumber(String mobileNumber) {

		Object args[] = { mobileNumber };
		List<Doctor> response = jdbcTemplate.query(
				QueryConstants.GET_DOCTOR_BY_MOBILE_NUMBER,
				new DoctorExtractor(), args);
		if (!StringUtils.isEmpty(response) && response.size() > 0) {
			return response;
		}
		return null;
	}

	@Override
	public List<Doctor> getDoctorByName(String name) {

		Object args[] = { "%" + name + "%" };
		List<Doctor> response = jdbcTemplate.query(
				QueryConstants.GET_DOCTOR_BY_NAME, new DoctorExtractor(), args);
		if (!StringUtils.isEmpty(response) && !response.isEmpty()) {
			return response;
		}
		return null;
	}

	@Override
	public List<Doctor> getDoctorByExpertisted(String expertisted) {

		Object args[] = { expertisted };
		List<Doctor> response = jdbcTemplate.query(
				QueryConstants.GET_DOCTOR_BY_EXPERTISTED,
				new DoctorExtractor(), args);
		if (!StringUtils.isEmpty(response) && !response.isEmpty()) {
			return response;
		}
		return null;
	}

	@Override
	public List<Doctor> getDoctorByConsultingFee(String consultingFee) {

		Object args[] = { consultingFee };
		List<Doctor> response = jdbcTemplate.query(
				QueryConstants.GET_DOCTOR_BY_CONSULTING_FEE,
				new DoctorExtractor(), args);
		if (!StringUtils.isEmpty(response) && !response.isEmpty()) {
			return response;
		}
		return null;
	}

	@Override
	public String updateDoctor(Doctor doctor) {

		String response = null;
		List<Object> args = new ArrayList<>();
		StringBuilder query = new StringBuilder(" UPDATE doctor_detail SET ");
		if (!StringUtils.isEmpty(doctor)) {
			if (isDoctorExists(doctor)) {
				boolean isDoctorName = false, isHomeAddress = false, isHighestDegree = false, isExpertized = false, isGovtServant = false;
				boolean IsOneTimeFees = false, isDayFreeInConsultingFee = false, isShopAddress = false;
				if (null != doctor.getDoctorName()) {
					query.append(" doctor_name = ? ");
					args.add(doctor.getDoctorName());
					isDoctorName = true;
				}
				if (null != doctor.getDoctorHomeAddress()) {
					if (isDoctorName) {
						query.append(" , doctor_homeaddress = ? ");
						args.add(doctor.getDoctorHomeAddress());
					} else {
						query.append(" doctor_homeaddress = ? ");
						args.add(doctor.getDoctorHomeAddress());
					}
					isHomeAddress = true;
				}
				if (null != doctor.getDoctorHighestDegree()) {
					if (isHomeAddress || isDoctorName) {
						query.append(", doctor_highestdegree = ? ");
						args.add(doctor.getDoctorHighestDegree());
					} else {
						query.append(" doctor_highestdegree = ? ");
						args.add(doctor.getDoctorHighestDegree());
					}
					isHighestDegree = true;
				}
				if (null != doctor.getDoctorExpertized()) {
					if (isHomeAddress || isDoctorName || isHighestDegree) {
						query.append(", doctor_expertized = ? ");
						args.add(doctor.getDoctorExpertized());
					} else {
						query.append(" doctor_expertized = ? ");
						args.add(doctor.getDoctorExpertized());
					}
					isExpertized = true;
				}
				if (null != doctor.getDoctorGovtServent()) {
					if (isHomeAddress || isDoctorName || isHighestDegree
							|| isExpertized) {
						query.append(", is_doctor_govt_servant = ? ");
						args.add(doctor.getDoctorGovtServent());
					} else {
						query.append(" is_doctor_govt_servant = ? ");
						args.add(doctor.getDoctorGovtServent());
					}
					isGovtServant = true;
				}
				if (null != doctor.getDoctorOneTimeConsultingFee()) {
					if (isHomeAddress || isDoctorName || isHighestDegree
							|| isExpertized || isGovtServant) {
						query.append(", onetime_consulting_fee = ? ");
						args.add(doctor.getDoctorOneTimeConsultingFee());
					} else {
						query.append(" onetime_consulting_fee = ? ");
						args.add(doctor.getDoctorOneTimeConsultingFee());
					}
					IsOneTimeFees = true;
				}
				if (null != doctor.getDoctorDaystoCheckFreeInConsultingFee()) {
					if (isHomeAddress || isDoctorName || isHighestDegree
							|| isExpertized || isGovtServant || IsOneTimeFees) {
						query.append(", doctor_days_to_check_free_in_consulting_fee = ? ");
						args.add(doctor
								.getDoctorDaystoCheckFreeInConsultingFee());
					} else {
						query.append(" doctor_days_to_check_free_in_consulting_fee = ? ");
						args.add(doctor
								.getDoctorDaystoCheckFreeInConsultingFee());
					}
					isDayFreeInConsultingFee = true;
				}
				if (null != doctor.getDoctorShopAddress()) {
					if (isHomeAddress || isDoctorName || isHighestDegree
							|| isExpertized || isGovtServant || IsOneTimeFees
							|| isDayFreeInConsultingFee) {
						query.append(", doctor_shop_address = ? ");
						args.add(doctor.getDoctorShopAddress());
					} else {
						query.append(" doctor_shop_address = ? ");
						args.add(doctor.getDoctorShopAddress());
					}
					isShopAddress = true;
				}
				if (isDoctorName || isHomeAddress || isHighestDegree
						|| isExpertized || isGovtServant || IsOneTimeFees
						|| isDayFreeInConsultingFee || isShopAddress) {
					if (null != doctor.getDoctorNumber()) {
						query.append(" WHERE doctor_number = ? ");
						args.add(doctor.getDoctorNumber());
					} else if (null != doctor.getDoctorAdhaarNumber()) {
						query.append(" WHERE doctor_adhaar_number = ? ");
						args.add(doctor.getDoctorAdhaarNumber());
					} else if (null != doctor.getDoctorId()) {
						query.append(" WHERE doctor_id = ? ");
						args.add(doctor.getDoctorId());
					} else {
						response = "Please Enter data to Update....!!!";
					}
				}
				if (StringUtils.isEmpty(response)) {
					int update = jdbcTemplate.update(query.toString(),
							args.toArray());
					if (update > 0) {
						response = "Doctor successfully Updated...!!!";
					} else {
						response = "There is some problem, please try again later...!!!";
					}
				}
			} else {
				response = "Doctor does not exist...!!!";
			}
		} else {
			response = "Doctor details are Empty, provide some details to update....!!!";
		}

		return response;
	}

}
