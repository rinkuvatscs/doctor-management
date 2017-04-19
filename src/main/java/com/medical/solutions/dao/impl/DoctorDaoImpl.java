package com.medical.solutions.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.medical.solutions.constants.LoginQueryConstants;
import com.medical.solutions.constants.QueryConstants;
import com.medical.solutions.dao.DoctorDao;
import com.medical.solutions.entity.Doctor;
import com.medical.solutions.exceptionhandler.BadRequestException;
import com.medical.solutions.extractor.DoctorExtractor;
import com.medical.solutions.extractor.ExpertizedExtractor;
import com.medical.solutions.factory.LoginFactory;
import com.medical.solutions.location.response.LocationResponse;
import com.medical.solutions.location.service.LocationService;
import com.medical.solutions.util.LoginEncrypt;

@Component
public class DoctorDaoImpl implements DoctorDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	LoginFactory loginFactory;

	@Autowired
	LocationService locationService;

	/*
	 * @Override public String addDoctor(Doctor doctor) { String response; if
	 * (!isDoctorExists(doctor)) {
	 * 
	 * List<Object> args = new ArrayList<>(); args.add(doctor.getName() == null
	 * ? DEFAULT : doctor.getName()); args.add(doctor.getMobile() == null ?
	 * DEFAULT : doctor.getMobile()); args.add(doctor.getAadhaarNumber() == null
	 * ? DEFAULT : doctor .getAadhaarNumber()); args.add(doctor.getEmail() ==
	 * null ? DEFAULT : doctor.getEmail()); int row =
	 * jdbcTemplate.update(QueryConstants.ADD_DOCTOR, args.toArray()); if (row
	 * == 1) { response = doctor.getName() + " registered successfully"; } else
	 * { response = "Sorry, " + doctor.getName() +
	 * " not registered . Please try again"; } } else { response = "Sorry, " +
	 * doctor.getName() + " already registered"; } return response; }
	 */
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

	/*
	 * @Override public boolean isDoctorExists(Doctor doctor) {
	 * 
	 * boolean isExist = false; boolean isMobile = false; boolean isAadhaar =
	 * false; boolean isEmail = false; boolean isDoctorId = false; List<Object>
	 * args = new ArrayList<>(); StringBuilder query = new
	 * StringBuilder(QueryConstants.IS_DOCTOR_EXIST);
	 * 
	 * if (!StringUtils.isEmpty(doctor.getMobile())) {
	 * query.append(" MobileNo = ? "); args.add(doctor.getMobile()); isMobile =
	 * true; } if (!StringUtils.isEmpty(doctor.getAadhaarNumber())) { if
	 * (isMobile) { query.append(" or AdhaarNo = ? "); } else {
	 * query.append(" AdhaarNo = ? "); } args.add(doctor.getAadhaarNumber());
	 * isAadhaar = true; }
	 * 
	 * if (!StringUtils.isEmpty(doctor.getEmail())) { if (isMobile || isAadhaar)
	 * { query.append(" or Email = ? "); } else { query.append(" Email = ? "); }
	 * args.add(doctor.getEmail()); isEmail = true; }
	 * 
	 * if (!StringUtils.isEmpty(doctor.getdId())) { if (isMobile || isAadhaar ||
	 * isEmail) { query.append(" or DID = ? "); } else {
	 * query.append(" DID = ? "); } args.add(doctor.getdId()); isDoctorId =
	 * true; }
	 * 
	 * if (!isMobile && !isEmail && !isDoctorId && !isAadhaar) { throw new
	 * BadRequestException( "Please provide enough detail for Doctor"); }
	 * List<Doctor> response = jdbcTemplate.query(query.toString(), new
	 * DoctorExtractor(), args.toArray()); if (!StringUtils.isEmpty(response) &&
	 * !response.isEmpty()) { isExist = true; } return isExist; }
	 */
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

	private int appendDoctorCity(int updateRow, Doctor doctor,
			StringBuilder query, List<Object> args) {
		if (null != doctor.getCity()) {
			if (updateRow > 0) {
				query.append(", city = ? ");
			} else {
				query.append(" city = ? ");
			}
			args.add(doctor.getCity());
			return updateRow + 1;
		}
		return updateRow;
	}

	private int appendDoctorPin(int updateRow, Doctor doctor,
			StringBuilder query, List<Object> args) {
		if (null != doctor.getPin()) {
			if (updateRow > 0) {
				query.append(", pin = ? ");
			} else {
				query.append(" pin = ? ");
			}
			args.add(doctor.getPin());
			return updateRow + 1;
		}
		return updateRow;
	}

	private int appendDoctorState(int updateRow, Doctor doctor,
			StringBuilder query, List<Object> args) {
		if (null != doctor.getState()) {
			if (updateRow > 0) {
				query.append(", state = ? ");
			} else {
				query.append(" state = ? ");
			}
			args.add(doctor.getState());
			return updateRow + 1;
		}
		return updateRow;
	}

	private int appendDoctorLandMark(int updateRow, Doctor doctor,
			StringBuilder query, List<Object> args) {
		if (null != doctor.getLandmark()) {
			if (updateRow > 0) {
				query.append(", landmark = ? ");
			} else {
				query.append(" landmark = ? ");
			}
			args.add(doctor.getLandmark());
			return updateRow + 1;
		}
		return updateRow;
	}

	private int appendDoctorLatitdueAndLogitude(int updateRow,
			LocationResponse locationResponse, StringBuilder query,
			List<Object> args) {
		if (null != locationResponse.getResults().get(0).getGeometry()
				.getLocation().getLat()
				&& null != locationResponse.getResults().get(0).getGeometry()
						.getLocation().getLng()) {
			if (updateRow > 0) {
				query.append(", latitude = ? ");
			} else {
				query.append(" latitude = ? ");
			}
			args.add(locationResponse.getResults().get(0).getGeometry()
					.getLocation().getLat());

			query.append(", longitude = ? ");
			args.add(locationResponse.getResults().get(0).getGeometry()
					.getLocation().getLng());
			return updateRow + 1;
		}
		return updateRow;
	}

	private int updateDoctorAddress(Doctor doctor) {
		int updateRow = 0;
		int tempUpdateRow;
		boolean updateLocations = false;
		List<Object> args = new ArrayList<>();
		StringBuilder query = new StringBuilder("UPDATE doctorAddress SET ");
		updateRow = appendDoctorExpertized(updateRow, doctor, query, args);
		updateRow = appendDoctorExpertized(updateRow, doctor, query, args);
		tempUpdateRow = appendDoctorCity(updateRow, doctor, query, args);
		if (tempUpdateRow > updateRow) {
			updateLocations = true;
			updateRow = tempUpdateRow;
		}
		if (!updateLocations) {
			tempUpdateRow = appendDoctorPin(updateRow, doctor, query, args);
			if (tempUpdateRow > updateRow) {
				updateLocations = true;
				updateRow = tempUpdateRow;
			}
		} else {
			updateRow = appendDoctorPin(tempUpdateRow, doctor, query, args);
		}
		updateRow = appendDoctorState(updateRow, doctor, query, args);
		updateRow = appendDoctorLandMark(updateRow, doctor, query, args);
		if (updateRow > 0) {
			query.append(" , updatedDate = NOW() ");
		}
		if (updateLocations) {
			LocationResponse locationResponse = locationService
					.getGeoCodeFromAddress(createAddress(doctor));
			if (locationResponse != null) {
				appendDoctorLatitdueAndLogitude(updateRow, locationResponse,
						query, args);
			}
		}
		query.append("  WHERE dId = ? ");
		args.add(doctor.getdId());
		return jdbcTemplate.update(query.toString(), args.toArray());
	}

	private String createAddress(Doctor doctor) {
		return doctor.getClinicAddress() + ", " + doctor.getCity() + " ,"
				+ doctor.getState() + ", India";
	}

	private int appendDoctorName(Doctor doctor, StringBuilder query,
			List<Object> args) {
		if (null != doctor.getName()) {
			query.append(" name = ? ");
			args.add(doctor.getName());
			return 1;
		}
		return 0;
	}

	private int appendDoctorHomeAddress(int updateRow, Doctor doctor,
			StringBuilder query, List<Object> args) {
		if (null != doctor.getHomeAddress()) {
			if (updateRow > 0) {
				query.append(" , homeAddress = ? ");
			} else {
				query.append(" homeAddress = ? ");
			}
			args.add(doctor.getHomeAddress());
			return updateRow + 1;
		}
		return updateRow;
	}

	private int appendDoctorHighestDegree(int updateRow, Doctor doctor,
			StringBuilder query, List<Object> args) {
		if (null != doctor.getHighestDegree()) {
			if (updateRow > 0) {
				query.append(", highestDegree = ? ");
			} else {
				query.append(" highestDegree = ? ");
			}
			args.add(doctor.getHighestDegree());
			return updateRow + 1;
		}
		return updateRow;
	}

	private int appendDoctorExpertized(int updateRow, Doctor doctor,
			StringBuilder query, List<Object> args) {
		if (null != doctor.getExpertized()) {
			if (updateRow > 0) {
				query.append(", expertise = ? ");
			} else {
				query.append(" expertise = ? ");
			}
			args.add(doctor.getExpertized().toLowerCase());
			return updateRow + 1;
		}
		return updateRow;
	}

	private int appendDoctorIsGovernmentServent(int updateRow, Doctor doctor,
			StringBuilder query, List<Object> args) {
		if (null != doctor.getIsGovernmentServent()) {
			if (updateRow > 0) {
				query.append(", gov = ? ");
			} else {
				query.append(" gov = ? ");
			}
			args.add(doctor.getIsGovernmentServent());
			return updateRow + 1;
		}
		return updateRow;
	}

	private int appendDoctorOneTimeFee(int updateRow, Doctor doctor,
			StringBuilder query, List<Object> args) {
		if (null != doctor.getOneTimeFee()) {
			if (updateRow > 0) {
				query.append(", fee = ? ");
			} else {
				query.append(" fee = ? ");
			}
			args.add(doctor.getOneTimeFee());
			return updateRow + 1;
		}
		return updateRow;
	}

	private int appendDoctorDaysCheckFree(int updateRow, Doctor doctor,
			StringBuilder query, List<Object> args) {
		if (null != doctor.getDaysCheckFree()) {
			if (updateRow > 0) {
				query.append(", freeDay = ? ");
			} else {
				query.append(" freeDay = ? ");
			}
			args.add(doctor.getDaysCheckFree());
			return updateRow + 1;
		}
		return updateRow;
	}

	private int appendDoctorClinicAddress(int updateRow, Doctor doctor,
			StringBuilder query, List<Object> args) {
		if (null != doctor.getClinicAddress()) {
			if (updateRow > 0) {
				query.append(", clinic = ? ");
			} else {
				query.append(" clinic = ? ");
			}
			args.add(doctor.getClinicAddress());
			return updateRow + 1;
		}
		return updateRow;
	}

	private int appendDoctorMobile(int updateRow, Doctor doctor,
			StringBuilder query, List<Object> args) {
		if (null != doctor.getMobile()) {
			if (updateRow > 0) {
				query.append(", mobile = ? ");
			} else {
				query.append(" mobile = ? ");
			}
			args.add(doctor.getMobile());
			return updateRow + 1;
		}
		return updateRow;
	}

	private int appendDoctorAadhaarNumber(int updateRow, Doctor doctor,
			StringBuilder query, List<Object> args) {
		if (null != doctor.getAadhaarNumber()) {
			if (updateRow > 0) {
				query.append(", adhaar = ? ");
			} else {
				query.append(" adhaar = ? ");
			}
			args.add(doctor.getAadhaarNumber());
			return updateRow + 1;
		}
		return updateRow;
	}

	private int appendDoctorEmail(int updateRow, Doctor doctor,
			StringBuilder query, List<Object> args) {
		if (null != doctor.getEmail()) {
			if (updateRow > 0) {
				query.append(", email = ? ");
			} else {
				query.append(" email = ? ");
			}
			args.add(doctor.getEmail());
			return updateRow + 1;
		}
		return updateRow;
	}

	private int appendDoctorGender(int updateRow, Doctor doctor,
			StringBuilder query, List<Object> args) {
		if (null != doctor.getGender()) {
			if (updateRow > 0) {
				query.append(", gender = ? ");
			} else {
				query.append(" gender = ? ");
			}
			args.add(doctor.getGender());
			return updateRow + 1;
		}
		return updateRow;
	}

	private int appendDoctorDesc(int updateRow, Doctor doctor,
			StringBuilder query, List<Object> args) {
		if (null != doctor.getDesc()) {
			if (updateRow > 0) {
				query.append(", selfDesc = ? ");
			} else {
				query.append(" selfDesc = ?  ");
			}
			query.append(", updatedDate = NOW()");
			args.add(doctor.getDesc());
			return updateRow + 1;
		}
		return updateRow;
	}

	private int appendDoctorTiming(int updateRow, Doctor doctor,
			StringBuilder query, List<Object> args) {
		if (null != doctor.getTiming()) {
			if (updateRow > 0) {
				query.append(", timing = ? ");
			} else {
				query.append(" timing = ? ");
			}
			args.add(doctor.getTiming());
			return updateRow + 1;
		}
		return updateRow;
	}

	private int appendDoctorProfilePicPath(int updateRow, Doctor doctor,
			StringBuilder query, List<Object> args) {
		if (null != doctor.getProfilePath()) {
			if (updateRow > 0) {
				query.append(", profilePicPath = ? ");
			} else {
				query.append(" profilePicPath = ? ");
			}
			args.add(doctor.getProfilePath());
			return updateRow + 1;
		}
		return updateRow;
	}

	private int appendDoctorDOB(int updateRow, Doctor doctor,
			StringBuilder query, List<Object> args) {
		if (null != doctor.getDOB()) {
			if (updateRow > 0) {
				query.append(", dob = ? ");
			} else {
				query.append(" dob = ? ");
			}
			args.add(doctor.getDOB());
			return updateRow + 1;
		}
		return updateRow;
	}

	@Override
	public String updateDoctor(Doctor doctor) {

		int updateRow = 0;
		String response;
		List<Object> args = new ArrayList<>();
		StringBuilder query = new StringBuilder("UPDATE doctor SET ");
		if (!StringUtils.isEmpty(doctor)) {

			validateDoctor(doctor);

			updateRow = updateRow + appendDoctorName(doctor, query, args);
			updateRow = appendDoctorHomeAddress(updateRow, doctor, query, args);
			updateRow = appendDoctorHighestDegree(updateRow, doctor, query,
					args);
			updateRow = appendDoctorExpertized(updateRow, doctor, query, args);
			updateRow = appendDoctorIsGovernmentServent(updateRow, doctor,
					query, args);
			updateRow = appendDoctorOneTimeFee(updateRow, doctor, query, args);
			updateRow = appendDoctorDaysCheckFree(updateRow, doctor, query,
					args);
			updateRow = appendDoctorClinicAddress(updateRow, doctor, query,
					args);
			updateRow = appendDoctorMobile(updateRow, doctor, query, args);
			updateRow = appendDoctorAadhaarNumber(updateRow, doctor, query,
					args);
			updateRow = appendDoctorEmail(updateRow, doctor, query, args);
			updateRow = appendDoctorGender(updateRow, doctor, query, args);
			updateRow = appendDoctorDesc(updateRow, doctor, query, args);
			updateRow = appendDoctorTiming(updateRow, doctor, query, args);
			updateRow = appendDoctorProfilePicPath(updateRow, doctor, query,
					args);
			appendDoctorDOB(updateRow, doctor, query, args);

			query.append("  WHERE dId = ? ");
			args.add(doctor.getdId());

			int update = jdbcTemplate.update(query.toString(), args.toArray());
			if (update > 0) {

				if (updateDoctorAddress(doctor) > 0) {
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
		if (!StringUtils.isEmpty(doctor.getdId())
				&& getDoctorById(doctor.getdId()) != null) {
			Object args[] = { doctor.getdId() };
			return jdbcTemplate.update("DELETE FROM doctor WHERE DID = ? ",
					args);
		}
		return 0;
	}

	@Override
	public String deleteDoctor(Doctor doctor) {
		String response = "Please try again later";
		String success = " successfully Deleted";
		int delete;
		if (!StringUtils.isEmpty(doctor)) {
			if (deleteDoctorByDoctorId(doctor) > 0) {
				response = "Doctor with doctorID " + doctor.getdId() + success;
			} else if (!StringUtils.isEmpty(doctor.getAadhaarNumber())
					&& getDoctorByAdharNumber(doctor.getAadhaarNumber()) != null) {
				Object args[] = { doctor.getAadhaarNumber() };
				delete = jdbcTemplate.update(
						"DELETE FROM doctor WHERE adhaar = ? ", args);
				if (delete > 0) {
					response = "Doctor with Aadhar Number "
							+ doctor.getAadhaarNumber() + success;
				}
			} else if (!StringUtils.isEmpty(doctor.getMobile())
					&& getDoctorByMobileNumber(doctor.getMobile()) != null) {
				Object args[] = { doctor.getMobile() };
				delete = jdbcTemplate.update(
						"DELETE FROM doctor WHERE mobile = ? ", args);
				if (delete > 0) {
					response = "Doctor with Mobile Number "
							+ doctor.getMobile() + success;
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

	private List<Doctor> getDoctorsByAadhaarNumber(Doctor doctor) {
		List<Doctor> response = new ArrayList<>();
		Doctor doctorWithAadhaar = getDoctorByAdharNumber(doctor
				.getAadhaarNumber());
		if (!StringUtils.isEmpty(doctorWithAadhaar.getdId())) {
			response.add(doctorWithAadhaar);
		}
		return response;

	}

	private List<Doctor> getDoctorsByMobile(Doctor doctor) {
		List<Doctor> response = new ArrayList<>();
		Doctor doctorWithMoblie = getDoctorByMobileNumber(doctor.getMobile());
		if (!StringUtils.isEmpty(doctorWithMoblie.getdId())) {
			response.add(doctorWithMoblie);
		}
		return response;
	}

	private List<Doctor> getDoctorsByDoctorId(Doctor doctor) {
		List<Doctor> response = new ArrayList<>();
		Doctor doctorWithId = getDoctorById(doctor.getdId());
		if (!StringUtils.isEmpty(doctorWithId.getdId())) {
			response.add(doctorWithId);
		}
		return response;
	}

	private List<Doctor> getDoctorsByEmail(Doctor doctor) {
		List<Doctor> response = new ArrayList<>();
		Doctor doctorWithEmail = getDoctorByEmail(doctor.getEmail());
		if (!StringUtils.isEmpty(doctorWithEmail.getdId())) {
			response.add(doctorWithEmail);
		}
		return response;
	}

	private int appendDoctorNameWithLike(int updateRow, Doctor doctor,
			StringBuilder query, List<Object> args) {
		if (!StringUtils.isEmpty(doctor.getName())) {
			query.append("WHERE name like ?");
			args.add("%" + doctor.getName() + "%");
			return updateRow + 1;
		}
		return updateRow;
	}

	private int appendDoctorHomeAddressWithLike(int updateRow, Doctor doctor,
			StringBuilder query, List<Object> args) {
		if (!StringUtils.isEmpty(doctor.getHomeAddress())) {
			if (updateRow > 0) {
				query.append(" AND homeAddress like ? ");
			} else {
				query.append(" WHERE homeAddress like ? ");
			}
			args.add("%" + doctor.getHomeAddress() + "%");
			return updateRow + 1;
		}
		return updateRow;
	}

	private int appendDoctorExpertiseWithLike(int updateRow, Doctor doctor,
			StringBuilder query, List<Object> args) {
		if (!StringUtils.isEmpty(doctor.getExpertized())) {
			if (updateRow > 0) {
				query.append(" AND expertise like ? ");
			} else {
				query.append(" WHERE expertise like ? ");
			}
			args.add("%" + doctor.getExpertized().toLowerCase() + "%");
			return updateRow + 1;
		}
		return updateRow;
	}

	private int appendDoctorClinicWithLike(int updateRow, Doctor doctor,
			StringBuilder query, List<Object> args) {
		if (!StringUtils.isEmpty(doctor.getClinicAddress())) {
			if (updateRow > 0) {
				query.append(" AND clinic like ? ");
			} else {
				query.append(" WHERE clinic like ? ");
			}
			args.add("%" + doctor.getClinicAddress() + "%");
			return updateRow + 1;
		}
		return updateRow;
	}

	@Override
	public List<Doctor> getDoctors(Doctor doctor) {
		int rowupdate = 0;
		if (doctor.getAadhaarNumber() != null) {
			return getDoctorsByAadhaarNumber(doctor);
		}
		if (!StringUtils.isEmpty(doctor.getMobile())) {
			return getDoctorsByMobile(doctor);
		}
		if (!StringUtils.isEmpty(doctor.getdId()) && doctor.getdId() > 0) {
			return getDoctorsByDoctorId(doctor);
		}
		if (!StringUtils.isEmpty(doctor.getEmail())) {
			return getDoctorsByEmail(doctor);
		}
		List<Object> args = new ArrayList<>();
		StringBuilder query = new StringBuilder(QueryConstants.GET_DOCTORS);

		if (!StringUtils.isEmpty(doctor)) {

			rowupdate = appendDoctorNameWithLike(rowupdate, doctor, query, args);
			rowupdate = appendDoctorIsGovernmentServent(rowupdate, doctor,
					query, args);
			rowupdate = appendDoctorHomeAddressWithLike(rowupdate, doctor,
					query, args);
			rowupdate = appendDoctorExpertiseWithLike(rowupdate, doctor, query,
					args);
			rowupdate = appendDoctorOneTimeFee(rowupdate, doctor, query, args);
			appendDoctorClinicWithLike(rowupdate, doctor, query, args);

			return jdbcTemplate.query(query.toString(), new DoctorExtractor(),
					args.toArray());

		} else {
			throw new BadRequestException(
					"PLease provide proper detail for Doctor");
		}
	}

	/*
	 * private int validateNumber(String number) { try { return
	 * Integer.parseInt(number); } catch (NumberFormatException
	 * numberFormatException) { return 0; } }
	 */

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
				args.add(LoginEncrypt.encrypt(doctor.getPassword(),"medicalsolutions@aaspaasdoctor"));
				args.add(doctor.getAadhaarNumber());
				args.add(doctor.getEmail());
				args.add("d");
				args.add(doctorsList.get(0).getdId());
				int resp = jdbcTemplate.update(
						LoginQueryConstants.INSERT_LOGIN, args.toArray());
				if (resp > 0) {
					args = new ArrayList<>();
					args.add(doctorsList.get(0).getdId());
					jdbcTemplate.update(
							QueryConstants.INSERT_DOCTOR_ADDRESS_AT_SIGNUP,
							args.toArray());

					return doctorsList.get(0).getdId();
				}
			}
		}
		return 0;
	}
}
