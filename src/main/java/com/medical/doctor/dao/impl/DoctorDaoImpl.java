package com.medical.doctor.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.medical.doctor.constants.QueryConstants;
import com.medical.doctor.dao.DoctorDao;
import com.medical.doctor.entity.Doctor;
import com.medical.doctor.exceptionhandler.BadRequestException;
import com.medical.doctor.extractor.DoctorExtractor;
import com.medical.doctor.extractor.ExpertizedExtractor;
import com.medical.doctor.factory.LoginFactory;

@Component
public class DoctorDaoImpl implements DoctorDao {

	private static final String DEFAULT = "NA";

	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	LoginFactory loginFactory ;

	@Override
	public String addDoctor(Doctor doctor) {

		String response = null;
		if (!isDoctorExists(doctor)) {

			List<Object> args = new ArrayList<>();
			args.add(doctor.getName() == null ? DEFAULT : doctor.getName());
			args.add(doctor.getMobile() == null ? DEFAULT : doctor.getMobile());
			args.add(doctor.getAadhaarNumber() == null ? DEFAULT : doctor
					.getAadhaarNumber());
			args.add(doctor.getEmail() == null ? DEFAULT : doctor.getEmail());
			int row = jdbcTemplate.update(QueryConstants.ADD_DOCTOR,
					args.toArray());
			if (row == 1) {
				response = doctor.getName() + " registered successfully";
			} else {
				response = "Sorry, " + doctor.getName()
						+ " not registered . Please try again";
			}
		} else {
			response = "Sorry, " + doctor.getName() + " already registered";
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
		boolean isMobile = false, isAadhaar = false, isEmail = false, isDoctorId = false;

		List<Object> args = new ArrayList<>();
		StringBuffer query = new StringBuffer(QueryConstants.IS_DOCTOR_EXIST);

		if (!StringUtils.isEmpty(doctor.getMobile())) {
			query.append(" MobileNo = ? ");
			args.add(doctor.getMobile());
			isMobile = true;
		}
		if (!StringUtils.isEmpty(doctor.getAadhaarNumber())) {
			if (isMobile) {
				query.append(" or AdhaarNo = ? ");
			} else {
				query.append(" AdhaarNo = ? ");
			}
			args.add(doctor.getAadhaarNumber());
			isAadhaar = true;
		}

		if (!StringUtils.isEmpty(doctor.getEmail())) {
			if (isMobile || isAadhaar) {
				query.append(" or Email = ? ");
			} else {
				query.append(" Email = ? ");
			}
			args.add(doctor.getEmail());
			isEmail = true;
		}

		if (!StringUtils.isEmpty(doctor.getDoctorId())) {
			if (isMobile || isAadhaar || isEmail) {
				query.append(" or DID = ? ");
			} else {
				query.append(" DID = ? ");
			}
			args.add(doctor.getDoctorId());
			isDoctorId = true;
		}

		if (!isMobile && !isEmail && !isDoctorId && !isAadhaar) {
			throw new BadRequestException(
					"Please provide enough detail for Doctor");
		}
		List<Doctor> response = jdbcTemplate.query(query.toString(),
				new DoctorExtractor(), args.toArray());
		if (!StringUtils.isEmpty(response) && response.size() > 0) {
			isExist = true;
		}
		return isExist;
	}

	@Override
	public Doctor getDoctorById(Integer id) {

		if (!StringUtils.isEmpty(id)) {
			Object args[] = { id };
			List<Doctor> response = jdbcTemplate.query(
					QueryConstants.GET_DOCTOR_BY_ID, args,
					new DoctorExtractor());
			if (!StringUtils.isEmpty(response) && response.size() > 0) {
				return response.get(0);
			}
		}
		return new Doctor();
	}

	@Override
	public Doctor getDoctorByEmail(String email) {

		if (!StringUtils.isEmpty(email)) {
			Object args[] = { email };
			List<Doctor> response = jdbcTemplate.query(
					QueryConstants.GET_DOCTOR_BY_EMAIL, args,
					new DoctorExtractor());
			if (!StringUtils.isEmpty(response) && response.size() > 0) {
				return response.get(0);
			}
		}
		return new Doctor();
	}

	@Override
	public Doctor getDoctorByAdharNumber(String adharNumber) {

		if (!StringUtils.isEmpty(adharNumber)) {
			Object args[] = { adharNumber };
			List<Doctor> response = jdbcTemplate.query(
					QueryConstants.GET_DOCTOR_BY_ADHAR_NUMBER,
					new DoctorExtractor(), args);
			if (!StringUtils.isEmpty(response) && response.size() > 0) {
				return response.get(0);
			}
		}
		return new Doctor();
	}

	@Override
	public Doctor getDoctorByMobileNumber(String mobileNumber) {

		if (!StringUtils.isEmpty(mobileNumber)) {
			Object args[] = { mobileNumber };
			List<Doctor> response = jdbcTemplate.query(
					QueryConstants.GET_DOCTOR_BY_MOBILE_NUMBER,
					new DoctorExtractor(), args);
			if (!StringUtils.isEmpty(response) && response.size() > 0) {
				return response.get(0);
			}
		}
		return new Doctor();
	}

	@Override
	public List<Doctor> getDoctorByName(String name) {

		if (!StringUtils.isEmpty(name)) {
			Object args[] = { "%" + name + "%" };
			List<Doctor> response = jdbcTemplate.query(
					QueryConstants.GET_DOCTOR_BY_NAME, new DoctorExtractor(),
					args);
			if (!StringUtils.isEmpty(response) && !response.isEmpty()) {
				return response;
			}
		}
		return new ArrayList<Doctor>();
	}

	@Override
	public List<Doctor> getDoctorByExpertisted(String expertisted) {

		if (!StringUtils.isEmpty(expertisted)) {
			Object args[] = { "%" + expertisted + "%" };
			List<Doctor> response = jdbcTemplate.query(
					QueryConstants.GET_DOCTOR_BY_EXPERTISTED,
					new DoctorExtractor(), args);
			if (!StringUtils.isEmpty(response) && !response.isEmpty()) {
				return response;
			}
		}
		return new ArrayList<Doctor>();
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
		return new ArrayList<Doctor>();
	}

	@Override
	public String updateDoctor(Doctor doctor) {

		String response = null;
		List<Object> args = new ArrayList<>();
		StringBuilder query = new StringBuilder("UPDATE doctor_detail SET ");
		if (!StringUtils.isEmpty(doctor)) {

			if (!StringUtils.isEmpty(doctor.getEmail())
					&& !StringUtils
							.isEmpty(getDoctorByEmail(doctor.getEmail()))) {
				throw new BadRequestException(
						"Updated Email ID already registered");
			}

			if (!StringUtils.isEmpty(doctor.getAadhaarNumber())
					&& !StringUtils.isEmpty(getDoctorByAdharNumber(doctor
							.getAadhaarNumber()))) {
				throw new BadRequestException(
						"Updated Aadhaar already registered");
			}

			if (!StringUtils.isEmpty(doctor.getMobile())
					&& !StringUtils.isEmpty(getDoctorByMobileNumber(doctor
							.getMobile()))) {
				throw new BadRequestException(
						"Updated Mobile Number already registered ");
			}

			boolean isDoctorName = false, isHomeAddress = false, isHighestDegree = false, isExpertized = false, isGovtServant = false;
			boolean IsOneTimeFees = false, isDayFreeInConsultingFee = false, isShopAddress = false, isMobile = false, isAadhaar = false, isAge = false, isEmail = false;
			if (null != doctor.getName()) {
				query.append(" Name = ? ");
				args.add(doctor.getName());
				isDoctorName = true;
			}
			if (null != doctor.getHomeAddress()) {
				if (isDoctorName) {
					query.append(" , HomeAddress = ? ");
					args.add(doctor.getHomeAddress());
				} else {
					query.append(" HomeAddress = ? ");
					args.add(doctor.getHomeAddress());
				}
				isHomeAddress = true;
			}
			if (null != doctor.getHighestDegree()) {
				if (isHomeAddress || isDoctorName) {
					query.append(", HighestDegree = ? ");
					args.add(doctor.getHighestDegree());
				} else {
					query.append(" HighestDegree = ? ");
					args.add(doctor.getHighestDegree());
				}
				isHighestDegree = true;
			}
			if (null != doctor.getExpertized()) {
				if (isHomeAddress || isDoctorName || isHighestDegree) {
					query.append(", Expertizes = ? ");
					args.add(doctor.getExpertized().toLowerCase());
				} else {
					query.append(" Expertizes = ? ");
					args.add(doctor.getExpertized().toLowerCase());
				}
				isExpertized = true;
			}
			if (null != doctor.getIsGovernmentServent()) {
				if (isHomeAddress || isDoctorName || isHighestDegree
						|| isExpertized) {
					query.append(", Goverment = ? ");
					args.add(doctor.getIsGovernmentServent());
				} else {
					query.append(" Goverment = ? ");
					args.add(doctor.getIsGovernmentServent());
				}
				isGovtServant = true;
			}
			// TODO will work
			if (null != doctor.getOneTimeFee()) {
				if (isHomeAddress || isDoctorName || isHighestDegree
						|| isExpertized || isGovtServant) {
					query.append(", ConsultingFees = ? ");
					args.add(doctor.getOneTimeFee());
				} else {
					query.append(" ConsultingFees = ? ");
					args.add(doctor.getOneTimeFee());
				}
				IsOneTimeFees = true;
			}
			if (null != doctor.getDaysCheckFree()) {
				if (isHomeAddress || isDoctorName || isHighestDegree
						|| isExpertized || isGovtServant || IsOneTimeFees) {
					query.append(", FreeDayConsulting = ? ");
					args.add(doctor.getDaysCheckFree());
				} else {
					query.append(" FreeDayConsulting = ? ");
					args.add(doctor.getDaysCheckFree());
				}
				isDayFreeInConsultingFee = true;
			}
			if (null != doctor.getClinicAddress()) {
				if (isHomeAddress || isDoctorName || isHighestDegree
						|| isExpertized || isGovtServant || IsOneTimeFees
						|| isDayFreeInConsultingFee) {
					query.append(", ClinicAddress = ? ");
				} else {
					query.append(" ClinicAddress = ? ");

				}
				args.add(doctor.getClinicAddress());
				isShopAddress = true;
			}

			if (null != doctor.getMobile()) {
				if (isHomeAddress || isDoctorName || isHighestDegree
						|| isExpertized || isGovtServant || IsOneTimeFees
						|| isDayFreeInConsultingFee || isShopAddress) {
					query.append(", MobileNo = ? ");

				} else {
					query.append(" MobileNo = ? ");
				}
				args.add(doctor.getMobile());
				isMobile = true;
			}

			if (null != doctor.getAadhaarNumber()) {
				if (isHomeAddress || isDoctorName || isHighestDegree
						|| isExpertized || isGovtServant || IsOneTimeFees
						|| isDayFreeInConsultingFee || isShopAddress
						|| isMobile) {
					query.append(", AdhaarNo = ? ");

				} else {
					query.append(" AdhaarNo = ? ");
				}
				args.add(doctor.getAadhaarNumber());
				isAadhaar = true;
			}

			

			if (null != doctor.getEmail()) {
				if (isHomeAddress || isDoctorName || isHighestDegree
						|| isExpertized || isGovtServant || IsOneTimeFees
						|| isDayFreeInConsultingFee || isShopAddress
						|| isMobile || isAadhaar || isAge) {
					query.append(", Email = ? ");

				} else {
					query.append(" Email = ? ");
				}
				args.add(doctor.getEmail());
				isEmail = true;
			}

			if (null != doctor.getGender()) {
				if (isHomeAddress || isDoctorName || isHighestDegree
						|| isExpertized || isGovtServant || IsOneTimeFees
						|| isDayFreeInConsultingFee || isShopAddress
						|| isMobile || isAadhaar || isAge || isEmail) {
					query.append(", gender = ? ");

				} else {
					query.append(" gender = ? ");
				}
				args.add(doctor.getGender());
			}

			query.append(" WHERE DID = ? ");
			args.add(doctor.getDoctorId());

			int update = jdbcTemplate.update(query.toString(), args.toArray());
			if (update > 0) {
				//TODO need to Address details into addres table 
				//TODO need to Login details into Login Table
				//TODO Login table details calling functions i am adding with dummy impletations using factory pattern
				// that will be decided by LoginFactory class which class needs to call .
				
				loginFactory.getLoginService().addLoginDetails(doctor);
				
				response = "Doctor successfully Updated...!!!";
			} else {
				response = "There is some problem, please try again later...!!!";
			}
		} else {
			response = "Doctor details are Empty, provide some details to update....!!!";
		}

		return response;
	}

	@Override
	public String deleteDoctor(Doctor doctor) {

		String response = null;
		int delete;
		if (!StringUtils.isEmpty(doctor)) {
			if (!StringUtils.isEmpty(doctor.getDoctorId())
					&& getDoctorById(doctor.getDoctorId()) != null) {
				Object args[] = { doctor.getDoctorId() };
				delete = jdbcTemplate.update(
						"DELETE FROM doctor_detail WHERE DID = ? ", args);
				if (delete > 0) {
					response = "Doctor with Doctor ID " + doctor.getDoctorId()
							+ " successfully Deleted";
				} else {
					response = "Please try again later";
				}
			} else if (!StringUtils.isEmpty(doctor.getAadhaarNumber())
					&& getDoctorByAdharNumber(doctor.getAadhaarNumber()) != null) {
				Object args[] = { doctor.getAadhaarNumber() };
				delete = jdbcTemplate
						.update("DELETE FROM doctor_detail WHERE AdhaarNo = ? ",
								args);
				if (delete > 0) {
					response = "Doctor with Aadhar Number "
							+ doctor.getAadhaarNumber()
							+ " successfully Deleted";
				} else {
					response = "Please try again later";
				}
			} else if (!StringUtils.isEmpty(doctor.getMobile())
					&& getDoctorByMobileNumber(doctor.getMobile()) != null) {
				Object args[] = { doctor.getMobile() };
				delete = jdbcTemplate.update(
						"DELETE FROM doctor_detail WHERE MobileNo = ? ",
						args);
				if (delete > 0) {
					response = "Doctor with Mobile Number "
							+ doctor.getMobile() + " successfully Deleted";
				} else {
					response = "Please try again later";
				}
			} else {
				throw new BadRequestException(
						"Please provide valid Doctor Id or Doctor Adhar Number or Doctor Mobile Number.");
			}
		} else {
			throw new BadRequestException(
					"Doctor can not be deleted without details");

		}
		return response;
	}

	@Override
	public List<Doctor> getDoctors(Doctor doctor) {

		List<Doctor> response = null;

		if (!StringUtils.isEmpty(doctor.getAadhaarNumber())) {

			response = new ArrayList<Doctor>();
			Doctor doctorWithAadhaar = getDoctorByAdharNumber(doctor
					.getAadhaarNumber());
			if (!StringUtils.isEmpty(doctorWithAadhaar.getDoctorId())) {
				response.add(doctorWithAadhaar);
			}

			return response;
		}

		if (!StringUtils.isEmpty(doctor.getMobile())) {

			response = new ArrayList<Doctor>();
			Doctor doctorWithMoblie = getDoctorByMobileNumber(doctor
					.getMobile());
			if (!StringUtils.isEmpty(doctorWithMoblie.getDoctorId())) {
				response.add(doctorWithMoblie);
			}

			return response;
		}

		if (!StringUtils.isEmpty(doctor.getDoctorId())
				&& doctor.getDoctorId() > 0) {

			response = new ArrayList<Doctor>();
			Doctor doctorWithId = getDoctorById(doctor.getDoctorId());
			if (!StringUtils.isEmpty(doctorWithId.getDoctorId())) {
				response.add(doctorWithId);
			}

			return response;
		}

		if (!StringUtils.isEmpty(doctor.getEmail())) {

			response = new ArrayList<Doctor>();
			Doctor doctorWithEmail = getDoctorByEmail(doctor.getEmail());
			if (!StringUtils.isEmpty(doctorWithEmail.getDoctorId())) {
				response.add(doctorWithEmail);
			}

			return response;
		}

		boolean isName = false, isGovServant = false, isHomeAddress = false, isExpertized = false;
		List<Object> args = new ArrayList<>();
		StringBuffer query = new StringBuffer(QueryConstants.GET_DOCTORS);

		if (!StringUtils.isEmpty(doctor)) {

			if (!StringUtils.isEmpty(doctor.getName())) {
				query.append("WHERE Name like ?");
				args.add("%" + doctor.getName() + "%");
				isName = true;
			}

			if (!StringUtils.isEmpty(doctor.getIsGovernmentServent())) {

				if (isName) {
					query.append("AND Goverment = ?");
				} else {
					query.append("WHERE Goverment = ?");

				}
				args.add(doctor.getIsGovernmentServent());
				isGovServant = true;
			}

			if (!StringUtils.isEmpty(doctor.getHomeAddress())) {

				if (isName || isGovServant) {
					query.append(" AND HomeAddress like ? ");
				} else {
					query.append(" WHERE HomeAddress like ? ");
				}
				args.add("%" + doctor.getHomeAddress() + "%");
				isHomeAddress = true;
			}

			if (!StringUtils.isEmpty(doctor.getExpertized())) {

				if (isName || isGovServant || isHomeAddress) {
					query.append(" AND Expertizes like ? ");
				} else {
					query.append(" WHERE Expertizes like ? ");
				}
				args.add("%" + doctor.getExpertized() + "%");
				isExpertized = true;
			}

			boolean isOneTime = false;
			if (!StringUtils.isEmpty(doctor.getOneTimeFee())) {

				if (isName || isGovServant || isHomeAddress || isExpertized) {
					query.append("  AND ConsultingFees = ? ");
				} else {
					query.append(" WHERE ConsultingFees = ? ");
				}
				args.add(doctor.getOneTimeFee());
				isOneTime = true;
			}

			if (!StringUtils.isEmpty(doctor.getClinicAddress())) {

				if (isName || isGovServant || isHomeAddress || isExpertized
						|| isOneTime) {
					query.append(" AND ClinicAddress like ? ");
				} else {
					query.append(" WHERE ClinicAddress like ? ");
				}
				args.add("%" + doctor.getClinicAddress() + "%");
			}

			response = jdbcTemplate.query(query.toString(),
					new DoctorExtractor(), args.toArray());

		} else {
			throw new BadRequestException(
					"PLease provide proper detail for Doctor");
		}

		if (null == response) {
			return new ArrayList<Doctor>();
		}
		return response;
	}

	@Override
	public Map<Integer, String> getAllExpertized() {

		return jdbcTemplate.query(QueryConstants.GET_ALL_EXPERTIZED,
				new ExpertizedExtractor());
	}

	@Override
	public Integer addExpertisation(String expertise) {

		if (!isExpertiseExists(expertise)) {
			List<String> args = new ArrayList<String>();
			args.add(expertise.toLowerCase());
			return jdbcTemplate.update(QueryConstants.ADD_EXPERTIZED,
					args.toArray());
		} else {
			return -1;
		}
	}

	@Override
	public boolean isExpertiseExists(String expertise) {

		List<String> args = new ArrayList<>();
		args.add(expertise.toLowerCase());
		Map<Integer, String> response = jdbcTemplate.query(
				QueryConstants.GET_EXPERTIZED, new ExpertizedExtractor(),
				args.toArray());
		if (!response.isEmpty()) {
			return true;
		}
		return false;
	}

	@Override
	public List<Doctor> getRecentDoctors(Integer days) {
		List<String> args = new ArrayList<>();
		args.add(String.valueOf(days));
		StringBuffer query = new StringBuffer(QueryConstants.GET_DOCTORS);
		query.append(" WHERE SYSDATE() - registered_date<= ? ");

		return jdbcTemplate.query(query.toString(), new DoctorExtractor(),
				args.toArray());
	}

	@Override
	public String approveExpertise(Integer expertise) {
		int update = jdbcTemplate.update(QueryConstants.APPROVE_EXPERTISE);
		if (update > 0) {
			return expertise + " approved successfully";
		} else {
			return expertise + " not approved";
		}
	}

	@Override
	public Map<Integer, String> getUnApprovedExpertise() {
		return jdbcTemplate.query(QueryConstants.GET_UNAPPROVED_EXPERTISE,
				new ExpertizedExtractor());
	}

}
