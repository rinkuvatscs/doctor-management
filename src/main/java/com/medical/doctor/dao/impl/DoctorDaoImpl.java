package com.medical.doctor.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.location.service.address.to.geo.response.LocationResponse;
import com.location.service.address.to.geo.service.LocationService;
import com.medical.doctor.constants.LoginQueryConstants;
import com.medical.doctor.constants.QueryConstants;
import com.medical.doctor.dao.DoctorDao;
import com.medical.doctor.entity.Doctor;
import com.medical.doctor.entity.DoctorAddress;
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
	LoginFactory loginFactory;

	@Autowired
	LocationService locationService;

	@Override
	public String addDoctor(Doctor doctor) {

		String response;
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

		String response;

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
		boolean isMobile = false;
		boolean isAadhaar = false;
		boolean isEmail = false;
		boolean isDoctorId = false;

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
		if (!StringUtils.isEmpty(response) && !response.isEmpty()) {
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
			if (!StringUtils.isEmpty(response) && !response.isEmpty()) {
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
			if (!StringUtils.isEmpty(response) && !response.isEmpty()) {
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
			if (!StringUtils.isEmpty(response) && !response.isEmpty()) {
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
			if (!StringUtils.isEmpty(response) && !response.isEmpty()) {
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
		return new ArrayList<>();
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
		return new ArrayList<>();
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
		return new ArrayList<>();
	}

	private void validateDoctor(Doctor doctor) {

		if (!StringUtils.isEmpty(doctor.getEmail())
				&& !StringUtils.isEmpty(getDoctorByEmail(doctor.getEmail()))) {
			throw new BadRequestException("Updated Email ID already registered");
		}

		if (!StringUtils.isEmpty(doctor.getAadhaarNumber())
				&& !StringUtils.isEmpty(getDoctorByAdharNumber(doctor
						.getAadhaarNumber()))) {
			throw new BadRequestException("Updated Aadhaar already registered");
		}

		if (!StringUtils.isEmpty(doctor.getMobile())
				&& !StringUtils.isEmpty(getDoctorByMobileNumber(doctor
						.getMobile()))) {
			throw new BadRequestException(
					"Updated Mobile Number already registered ");
		}
	}

	private int updateDoctorAddress(DoctorAddress doctorAddress) {
		int updateRow = 0;
		boolean updateLocations = false;
		String clinic = " clinic =  ? ";
		List<Object> args = new ArrayList<>();
		StringBuilder query = new StringBuilder("UPDATE doctorAddress SET ");

		if (null != doctorAddress.getExpertized()) {
			query.append(" expertise = ? ");
			args.add(doctorAddress.getExpertized().toLowerCase());
			updateRow = updateRow + 1;
		}
		if (null != doctorAddress.getClinicAddress()) {
			if (updateRow > 0) {
				query.append("," + clinic);
			} else {
				query.append(clinic);
			}
			args.add(doctorAddress.getClinicAddress());
			updateRow = updateRow + 1;
			updateLocations = true;
		}

		if (null != doctorAddress.getTiming()) {
			if (updateRow > 0) {
				query.append(", timing = ? ");
			} else {
				query.append(" timing = ? ");
			}
			args.add(doctorAddress.getTiming());
			updateRow = updateRow + 1;
		}

		if (null != doctorAddress.getCity()) {
			if (updateRow > 0) {
				query.append(", city = ? ");
			} else {
				query.append(" city = ? ");
			}
			args.add(doctorAddress.getCity());
			updateRow = updateRow + 1;
			updateLocations = true;
		}

		if (doctorAddress.getPin() != null) {
			if (updateRow > 0) {
				query.append(", pin = ? ");
			} else {
				query.append(" pin = ? ");
			}
			args.add(doctorAddress.getPin());
			updateRow = updateRow + 1;
			updateLocations = true;
		}

		if (null != doctorAddress.getState()) {
			if (updateRow > 0) {
				query.append(", state = ? ");
			} else {
				query.append(" state = ? ");
			}
			args.add(doctorAddress.getState());
			updateRow = updateRow + 1;
		}

		if (null != doctorAddress.getLandmark()) {
			if (updateRow > 0) {
				query.append(", landmark = ? ");
			} else {
				query.append(" landmark = ? ");
			}
			args.add(doctorAddress.getLandmark());
			updateRow = updateRow + 1;
		}

		if (updateRow > 0) {
			query.append(" , updatedDate = NOW() ");
		}
		if (updateLocations) {
			LocationResponse locationResponse = locationService
					.getGeoCodeFromAddress(createAddress(doctorAddress));
			if (locationResponse != null) {
				if (updateRow > 0) {
					query.append(", latitude = ? ");
				} else {
					query.append(" latitude = ? ");
				}
				args.add(locationResponse.getResults().get(0).getGeometry()
						.getLocation().getLat());
				updateRow = updateRow + 1;
				if (updateRow > 0) {
					query.append(", longitude = ? ");
				} else {
					query.append(" longitude = ? ");
				}
				args.add(locationResponse.getResults().get(0).getGeometry()
						.getLocation().getLng());
			}
		}

		query.append("  WHERE dId = ? ");
		args.add(doctorAddress.getDoctorId());
	    return   jdbcTemplate.update(query.toString(), args.toArray());
	}

	private String createAddress(DoctorAddress doctorAddress) {
		return doctorAddress.getClinicAddress() + ", "
				+ doctorAddress.getCity() + " ," + doctorAddress.getState()
				+ ", India";
	}

	@Override
	public String updateDoctor(DoctorAddress doctor) {

		String response;
		List<Object> args = new ArrayList<>();
		StringBuilder query = new StringBuilder("UPDATE doctor SET ");
		if (!StringUtils.isEmpty(doctor)) {

			validateDoctor(doctor);

			boolean isDoctorName = false;
			boolean isHomeAddress = false;
			boolean isHighestDegree = false;
			boolean isExpertized = false;
			boolean isGovtServant = false;
			boolean isOneTimeFees = false;
			boolean isDayFreeInConsultingFee = false;
			boolean isShopAddress = false;
			boolean isMobile = false;
			boolean isAadhaar = false;
			boolean isAge = false;
			boolean isEmail = false;
			if (null != doctor.getName()) {
				query.append(" name = ? ");
				args.add(doctor.getName());
				isDoctorName = true;
			}
			if (null != doctor.getHomeAddress()) {
				if (isDoctorName) {
					query.append(" , homeAddress = ? ");
					args.add(doctor.getHomeAddress());
				} else {
					query.append(" homeAddress = ? ");
					args.add(doctor.getHomeAddress());
				}
				isHomeAddress = true;
			}
			if (null != doctor.getHighestDegree()) {
				if (isHomeAddress || isDoctorName) {
					query.append(", highestDegree = ? ");
					args.add(doctor.getHighestDegree());
				} else {
					query.append(" highestDegree = ? ");
					args.add(doctor.getHighestDegree());
				}
				isHighestDegree = true;
			}
			if (null != doctor.getExpertized()) {
				if (isHomeAddress || isDoctorName || isHighestDegree) {
					query.append(", expertise = ? ");
					args.add(doctor.getExpertized().toLowerCase());
				} else {
					query.append(" expertise = ? ");
					args.add(doctor.getExpertized().toLowerCase());
				}
				isExpertized = true;
			}
			if (null != doctor.getIsGovernmentServent()) {
				if (isHomeAddress || isDoctorName || isHighestDegree
						|| isExpertized) {
					query.append(", gov = ? ");
					args.add(doctor.getIsGovernmentServent());
				} else {
					query.append(" gov = ? ");
					args.add(doctor.getIsGovernmentServent());
				}
				isGovtServant = true;
			}
			if (null != doctor.getOneTimeFee()) {
				if (isHomeAddress || isDoctorName || isHighestDegree
						|| isExpertized || isGovtServant) {
					query.append(", fee = ? ");
					args.add(doctor.getOneTimeFee());
				} else {
					query.append(" fee = ? ");
					args.add(doctor.getOneTimeFee());
				}
				isOneTimeFees = true;
			}
			if (null != doctor.getDaysCheckFree()) {
				if (isHomeAddress || isDoctorName || isHighestDegree
						|| isExpertized || isGovtServant || isOneTimeFees) {
					query.append(", freeDay = ? ");
					args.add(doctor.getDaysCheckFree());
				} else {
					query.append(" freeDay = ? ");
					args.add(doctor.getDaysCheckFree());
				}
				isDayFreeInConsultingFee = true;
			}
			if (null != doctor.getClinicAddress()) {
				if (isHomeAddress || isDoctorName || isHighestDegree
						|| isExpertized || isGovtServant || isOneTimeFees
						|| isDayFreeInConsultingFee) {
					query.append(", clinic = ? ");
				} else {
					query.append(" clinic = ? ");

				}
				args.add(doctor.getClinicAddress());
				isShopAddress = true;
			}

			if (null != doctor.getMobile()) {
				if (isHomeAddress || isDoctorName || isHighestDegree
						|| isExpertized || isGovtServant || isOneTimeFees
						|| isDayFreeInConsultingFee || isShopAddress) {
					query.append(", mobile = ? ");

				} else {
					query.append(" mobile = ? ");
				}
				args.add(doctor.getMobile());
				isMobile = true;
			}

			if (null != doctor.getAadhaarNumber()) {
				if (isHomeAddress || isDoctorName || isHighestDegree
						|| isExpertized || isGovtServant || isOneTimeFees
						|| isDayFreeInConsultingFee || isShopAddress
						|| isMobile) {
					query.append(", adhaar = ? ");

				} else {
					query.append(" adhaar = ? ");
				}
				args.add(doctor.getAadhaarNumber());
				isAadhaar = true;
			}

			if (null != doctor.getEmail()) {
				if (isHomeAddress || isDoctorName || isHighestDegree
						|| isExpertized || isGovtServant || isOneTimeFees
						|| isDayFreeInConsultingFee || isShopAddress
						|| isMobile || isAadhaar || isAge) {
					query.append(", email = ? ");

				} else {
					query.append(" email = ? ");
				}
				args.add(doctor.getEmail());
				isEmail = true;
			}

			boolean isGender = false;
			if (null != doctor.getGender()) {
				if (isHomeAddress || isDoctorName || isHighestDegree
						|| isExpertized || isGovtServant || isOneTimeFees
						|| isDayFreeInConsultingFee || isShopAddress
						|| isMobile || isAadhaar || isAge || isEmail) {
					query.append(", gender = ? ");

				} else {
					query.append(" gender = ? ");
				}
				args.add(doctor.getGender());
				isGender = true;
			}

			if (null != doctor.getDesc()) {
				if (isHomeAddress || isDoctorName || isHighestDegree
						|| isExpertized || isGovtServant || isOneTimeFees
						|| isDayFreeInConsultingFee || isShopAddress
						|| isMobile || isAadhaar || isAge || isEmail
						|| isGender) {
					query.append(", selfDesc = ? ");

				} else {
					query.append(" selfDesc = ?  ");
				}
				query.append(", updatedDate = NOW()");
				args.add(doctor.getDesc());
			}
			query.append("  WHERE dId = ? ");
			args.add(doctor.getDoctorId());

			int update = jdbcTemplate.update(query.toString(), args.toArray());
			if (update > 0) {

				if (updateDoctorAddress(doctor) > 0) {

					// TODO need to add later
					// loginFactory.getLoginService().addLoginDetails(doctor);

					response = "Doctor successfully Updated...!!!";
				} else {
					return "Doctor Address Details not added";
				}
			} else {
				response = "There is some problem, please try again later...!!!";
			}
		} else {
			response = "Doctor details are Empty, provide some details to update....!!!";
		}

		return response;
	}

	public int deleteDoctorByDoctorId(Doctor doctor) {
		if (!StringUtils.isEmpty(doctor.getDoctorId())
				&& getDoctorById(doctor.getDoctorId()) != null) {
			Object args[] = { doctor.getDoctorId() };
			return jdbcTemplate.update("DELETE FROM doctor WHERE DID = ? ",
					args);
		}
		return 0;
	}

	@Override
	public String deleteDoctor(Doctor doctor) {

		String response = "Please try again later";
		int delete;
		if (!StringUtils.isEmpty(doctor)) {

			if (deleteDoctorByDoctorId(doctor) > 0) {
				response = "Doctor with doctorID " + doctor.getDoctorId()
						+ " successfully Deleted";
			} else if (!StringUtils.isEmpty(doctor.getAadhaarNumber())
					&& getDoctorByAdharNumber(doctor.getAadhaarNumber()) != null) {
				Object args[] = { doctor.getAadhaarNumber() };
				delete = jdbcTemplate.update(
						"DELETE FROM doctor WHERE adhaar = ? ", args);
				if (delete > 0) {
					response = "Doctor with Aadhar Number "
							+ doctor.getAadhaarNumber()
							+ " successfully Deleted";
				}
			} else if (!StringUtils.isEmpty(doctor.getMobile())
					&& getDoctorByMobileNumber(doctor.getMobile()) != null) {
				Object args[] = { doctor.getMobile() };
				delete = jdbcTemplate.update(
						"DELETE FROM doctor WHERE mobile = ? ", args);
				if (delete > 0) {
					response = "Doctor with Mobile Number "
							+ doctor.getMobile() + " successfully Deleted";
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
		List<Doctor> response;

		if (!StringUtils.isEmpty(doctor.getAadhaarNumber())) {

			response = new ArrayList<>();
			Doctor doctorWithAadhaar = getDoctorByAdharNumber(doctor
					.getAadhaarNumber());
			if (!StringUtils.isEmpty(doctorWithAadhaar.getDoctorId())) {
				response.add(doctorWithAadhaar);
			}

			return response;
		}

		if (!StringUtils.isEmpty(doctor.getMobile())) {

			response = new ArrayList<>();
			Doctor doctorWithMoblie = getDoctorByMobileNumber(doctor
					.getMobile());
			if (!StringUtils.isEmpty(doctorWithMoblie.getDoctorId())) {
				response.add(doctorWithMoblie);
			}

			return response;
		}

		if (!StringUtils.isEmpty(doctor.getDoctorId())
				&& doctor.getDoctorId() > 0) {

			response = new ArrayList<>();
			Doctor doctorWithId = getDoctorById(doctor.getDoctorId());
			if (!StringUtils.isEmpty(doctorWithId.getDoctorId())) {
				response.add(doctorWithId);
			}

			return response;
		}

		if (!StringUtils.isEmpty(doctor.getEmail())) {

			response = new ArrayList<>();
			Doctor doctorWithEmail = getDoctorByEmail(doctor.getEmail());
			if (!StringUtils.isEmpty(doctorWithEmail.getDoctorId())) {
				response.add(doctorWithEmail);
			}

			return response;
		}

		boolean isName = false;
		boolean isGovServant = false;
		boolean isHomeAddress = false;
		boolean isExpertized = false;
		List<Object> args = new ArrayList<>();
		StringBuilder query = new StringBuilder(QueryConstants.GET_DOCTORS);

		if (!StringUtils.isEmpty(doctor)) {

			if (!StringUtils.isEmpty(doctor.getName())) {
				query.append("WHERE name like ?");
				args.add("%" + doctor.getName() + "%");
				isName = true;
			}

			if (!StringUtils.isEmpty(doctor.getIsGovernmentServent())) {

				if (isName) {
					query.append("AND gov = ?");
				} else {
					query.append("WHERE gov = ?");

				}
				args.add(doctor.getIsGovernmentServent());
				isGovServant = true;
			}

			if (!StringUtils.isEmpty(doctor.getHomeAddress())) {

				if (isName || isGovServant) {
					query.append(" AND homeAddress like ? ");
				} else {
					query.append(" WHERE homeAddress like ? ");
				}
				args.add("%" + doctor.getHomeAddress() + "%");
				isHomeAddress = true;
			}

			if (!StringUtils.isEmpty(doctor.getExpertized())) {

				if (isName || isGovServant || isHomeAddress) {
					query.append(" AND expertise like ? ");
				} else {
					query.append(" WHERE expertise like ? ");
				}
				args.add("%" + doctor.getExpertized().toLowerCase() + "%");
				isExpertized = true;
			}

			boolean isOneTime = false;
			if (!StringUtils.isEmpty(doctor.getOneTimeFee())
					&& validateNumber(doctor.getOneTimeFee()) > 0) {
				if (isName || isGovServant || isHomeAddress || isExpertized) {
					query.append("  AND fee = ? ");
				} else {
					query.append(" WHERE fee = ? ");
				}
				args.add(Integer.parseInt(doctor.getOneTimeFee()));
				isOneTime = true;
			}
			if (!StringUtils.isEmpty(doctor.getClinicAddress())) {

				if (isName || isGovServant || isHomeAddress || isExpertized
						|| isOneTime) {
					query.append(" AND clinic like ? ");
				} else {
					query.append(" WHERE clinic like ? ");
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
			return new ArrayList<>();
		}
		return response;
	}

	private int validateNumber(String number) {
		try {
			return Integer.parseInt(number);
		} catch (NumberFormatException numberFormatException) {
			return 0;
		}
	}

	@Override
	public List<String> getAllExpertized() {

		return jdbcTemplate.query(QueryConstants.GET_ALL_EXPERTIZED,
				new ExpertizedExtractor());
	}

	@Override
	public Integer addExpertisation(String expertise) {

		if (!isExpertiseExists(expertise)) {
			List<String> args = new ArrayList<>();
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
		List<String> response = jdbcTemplate.query(
				QueryConstants.GET_EXPERTIZED, new ExpertizedExtractor(),
				args.toArray());
		if (!response.isEmpty()) {
			return true;
		}
		return false;
	}

	@Override
	public List<Doctor> getRecentDoctors(Integer days) {
		List<Integer> args = new ArrayList<>();
		args.add(days);
		StringBuilder query = new StringBuilder(QueryConstants.GET_DOCTORS);
		query.append(" WHERE DATEDIFF(SYSDATE() , createdDate) <= ? ");
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
	public List<String> getUnApprovedExpertise() {
		return jdbcTemplate.query(QueryConstants.GET_UNAPPROVED_EXPERTISE,
				new ExpertizedExtractor());
	}

	/*
	 * CREATE DEFINER=`u754709029_user`@`localhost` PROCEDURE `DoctorSignUp`( IN
	 * Name VARCHAR(45), IN Mobile bigint(11), IN Aadhaar bigint(13), IN Email
	 * VARCHAR(30), IN Password VARCHAR(100), OUT DID bigint) BEGIN INSERT INTO
	 * `doctor` (name, mobile, adhaar, email) values
	 * (Name,Mobile,Aadhaar,Email); SET DID = LAST_INSERT_ID(); INSERT INTO
	 * `login` (mobile,password,adhaar,email,type,typeId,createdDate) values
	 * (Mobile,Password,Aadhaar,Email,'d',DID,CURRENT_DATE()); END
	 */

	@Override
	public Integer doctorSignUp(Doctor doctor) {

		List<Doctor> doctorsList;

		List<Object> args = new ArrayList<>();
		args.add(doctor.getName());
		args.add(doctor.getMobile());
		args.add(doctor.getAadhaarNumber());
		args.add(doctor.getEmail());
		int doctorResponse = jdbcTemplate.update(QueryConstants.INSERT_DOCTOR,
				args.toArray());
		if (doctorResponse > 0) {
			args = new ArrayList<>();
			args.add(doctor.getMobile());
			doctorsList = jdbcTemplate.query(
					QueryConstants.GET_DOCTOR_BY_MOBILE, new DoctorExtractor(),
					args.toArray());
			if (!StringUtils.isEmpty(doctorsList) && !doctorsList.isEmpty()) {

				args = new ArrayList<>();
				args.add(doctor.getMobile());
				args.add(doctor.getPassword());
				args.add(doctor.getAadhaarNumber());
				args.add(doctor.getEmail());
				args.add("d");
				args.add(doctorsList.get(0).getDoctorId());
				int resp = jdbcTemplate.update(
						LoginQueryConstants.INSERT_LOGIN, args.toArray());
				if (resp > 0) {
					args = new ArrayList<>();
					args.add(doctorsList.get(0).getDoctorId());
					jdbcTemplate.update(
							QueryConstants.INSERT_DOCTOR_ADDRESS_AT_SIGNUP, args.toArray());
					
					return doctorsList.get(0).getDoctorId();
					
				}
			}
		}
		return 0;
	}

	@Override
	public Boolean checkMobile(String mobile) {
		Object[] args = { mobile };
		List<Doctor> response = jdbcTemplate.query(
				" SELECT * FROM doctor WHERE mobile = ? ",
				new DoctorExtractor(), args);
		if (!response.isEmpty()) {
			return true;
		}
		return false;
	}

	@Override
	public Boolean checkAdhaar(String adhaar) {
		Object[] args = { adhaar };
		List<Doctor> response = jdbcTemplate.query(
				" SELECT * FROM doctor WHERE adhaar = ? ",
				new DoctorExtractor(), args);
		if (!response.isEmpty()) {
			return true;
		}
		return false;
	}

	@Override
	public Boolean checkEmail(String email) {
		Object[] args = { email };
		List<Doctor> response = jdbcTemplate.query(
				" SELECT * FROM doctor WHERE email = ? ",
				new DoctorExtractor(), args);
		if (!response.isEmpty()) {
			return true;
		}
		return false;
	}

}
