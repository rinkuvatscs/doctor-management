package com.medical.doctor.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.medical.doctor.entity.Doctor;
import com.medical.doctor.exceptionhandler.BadRequestException;
import com.medical.doctor.mappers.DoctorMapper;
import com.medical.doctor.request.DoctorRequest;
import com.medical.doctor.request.SearchDoctorRequest;
import com.medical.doctor.response.DoctorResponse;
import com.medical.doctor.response.Response;
import com.medical.doctor.service.DoctorService;

@RestController
@RequestMapping("/doctor")
@Api(basePath = "/doctor", value = "doctor", description = "Operations with Landlords", produces = "application/json")
public class DoctorController {

	@Autowired
	private DoctorService doctorService;

	@Autowired
	private DoctorMapper doctorMapper;

	@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, value = "/", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value = "add new doctor", notes = "add new doctor")
	@ApiResponses(value = {
			@ApiResponse(code = 400, message = "Fields are with validation errors"),
			@ApiResponse(code = 201, message = "") })
	public Response addDoctor(
			@RequestBody com.medical.doctor.request.DoctorRequest doctorRequest) {

		Doctor doctor = new Doctor();
		try {
			BeanUtils.copyProperties(doctorRequest, doctor);
		} catch (BeansException beansException) {
			throw new BadRequestException(
					"Doctor Do not have enough information", beansException);
		}

		if (!StringUtils.isEmpty(doctor)
				&& !StringUtils.isEmpty(doctor.getAadhaarNumber())
				&& !StringUtils.isEmpty(doctor.getMobile())) {
			return new Response(doctorService.addDoctor(doctor));
		} else {
			throw new BadRequestException(
					"Doctor Aaddhar Number and Mobile Number should not be blank");
		}
	}

	@RequestMapping(method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE, value = "/delete/{id}/id")
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "delete doctor", notes = "delete doctor")
	@ApiResponses(value = {
			@ApiResponse(code = 400, message = "Fields are with validation errors"),
			@ApiResponse(code = 201, message = "") })
	public Response deleteDoctorById(@PathVariable Integer id) {

		if (!StringUtils.isEmpty(id)) {
			Doctor doctor = new Doctor();
			doctor.setDoctorId(id);
			return new Response(doctorService.deleteDoctor(doctor));
		} else
			throw new BadRequestException("Doctor Id should not be blank");
	}

	@RequestMapping(method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE, value = "/delete/{aadhaar}/aadhaar")
	@ResponseBody
	public Response deleteDoctorByAdharNumber(@PathVariable String aadhaar) {

		if (!StringUtils.isEmpty(aadhaar)) {
			Doctor doctor = new Doctor();
			doctor.setAadhaarNumber(aadhaar);
			return new Response(doctorService.deleteDoctor(doctor));
		} else
			throw new BadRequestException(
					"Doctor Aaddhar Number should not be blank");
	}

	@RequestMapping(method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, value = "/delete")
	@ResponseBody
	public Response deleteDoctor(@RequestBody Doctor doctor) {

		return new Response(doctorService.deleteDoctor(doctor));
	}

	@RequestMapping(method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE, value = "/delete/{mobile}/mobile")
	@ResponseBody
	public Response deleteDoctorByMobileNumber(@PathVariable String mobile) {

		if (!StringUtils.isEmpty(mobile)) {
			Doctor doctor = new Doctor();
			doctor.setMobile(mobile);
			return new Response(doctorService.deleteDoctor(doctor));
		} else
			throw new BadRequestException(
					"Doctor Mobile Number should not be blank");
	}

	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, value = "/get/all")
	@ResponseBody
	public List<DoctorResponse> getDoctorByAll(
			@RequestBody SearchDoctorRequest searchDoctorRequest) {

		Doctor doctor = new Doctor();
		try {
			BeanUtils.copyProperties(searchDoctorRequest, doctor);
		} catch (BeansException beansException) {
			throw new BadRequestException(
					"Doctor Do not have enough information", beansException);
		}

		return doctorMapper.mapDoctors(doctorService.getDoctors(doctor));

	}

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/get/{id}/id")
	@ResponseBody
	public DoctorResponse getDoctorById(@PathVariable Integer id) {

		if (!StringUtils.isEmpty(id) && id.intValue() > 0) {
			return doctorMapper.mapDoctor(doctorService.getDoctorById(id
					.intValue()));
		} else {
			throw new BadRequestException("Doctor ID should not be blank");
		}
	}

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/get/{aadhaar}/aadhaar")
	@ResponseBody
	public DoctorResponse getDoctorByAdharNumber(@PathVariable String aadhaar) {

		if (!StringUtils.isEmpty(aadhaar)) {
			return doctorMapper.mapDoctor(doctorService
					.getDoctorByAdharNumber(aadhaar));
		} else {
			throw new BadRequestException(
					"Doctor AAdhar Number should not be blank");
		}

	}

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/get/{email:.+}/email")
	@ResponseBody
	public DoctorResponse getDoctorByEmail(@PathVariable String email) {

		if (!StringUtils.isEmpty(email)) {
			return doctorMapper
					.mapDoctor(doctorService.getDoctorByEmail(email));
		} else {
			throw new BadRequestException("Email should not be blank");
		}

	}

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/get/{mobile}/mobile")
	@ResponseBody
	public DoctorResponse getDoctorByMobileNumber(@PathVariable String mobile) {

		if (!StringUtils.isEmpty(mobile)) {
			return doctorMapper.mapDoctor(doctorService
					.getDoctorByMobileNumber(mobile));
		} else {
			throw new BadRequestException(
					"Doctor Mobile Number should not be blank");
		}
	}

	// Location need to be added within this operation.
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/get/{name}/name")
	@ResponseBody
	public List<DoctorResponse> getDoctorByName(@PathVariable String name) {

		if (!StringUtils.isEmpty(name)) {
			return doctorMapper.mapDoctors(doctorService.getDoctorByName(name));
		} else {
			throw new BadRequestException("Doctor Name should not be blank");
		}
	}

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/get/{expertisted}/expertisted")
	@ResponseBody
	public List<DoctorResponse> getDoctorByExpertisted(
			@PathVariable String expertisted) {

		if (!StringUtils.isEmpty(expertisted)) {
			return doctorMapper.mapDoctors(doctorService
					.getDoctorByExpertisted(expertisted));
		} else {
			throw new BadRequestException(
					"Doctor Expertisted should not be blank");
		}
	}

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/get/{fee}/fee")
	@ResponseBody
	public List<DoctorResponse> getDoctorByConsultingFee(
			@PathVariable String fee) {

		if (!StringUtils.isEmpty(fee)) {
			return doctorMapper.mapDoctors(doctorService
					.getDoctorByConsultingFee(fee));
		} else {
			throw new BadRequestException(
					"Doctor ConsultingFee should not be blank");
		}
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "update doctor", notes = "update doctor")
	@ApiResponses(value = {
			@ApiResponse(code = 400, message = "Fields are with validation errors"),
			@ApiResponse(code = 201, message = "") })
	public Response updateDoctor(@RequestBody DoctorRequest doctorRequest) {

		Doctor doctor = new Doctor();
		try {
			BeanUtils.copyProperties(doctorRequest, doctor);
		} catch (BeansException beansException) {
			throw new BadRequestException(
					"Doctor Do not have enough information", beansException);
		}
		return new Response(doctorService.updateDoctor(doctor));
	}

	@RequestMapping(method = RequestMethod.GET, value = "/intro")
	public String welcome() {

		return "Welcome to Doctor Management Tool";
	}

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/get/all/expertisation")
	@ResponseBody
	public Map<Integer, String> getAllExpertisations() {

		return doctorService.getAllExpertized();
	}

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/add/{expertise}/expertisation")
	@ResponseBody
	public Integer addExpertisation(@PathVariable String expertise) {

		if (!StringUtils.isEmpty(expertise)) {
			return doctorService.addExpertisation(expertise);
		} else {
			throw new BadRequestException("Expertisation can not be blank");
		}
	}

	/**
	 * getRecentDoctors will provide recently joined doctors
	 * 
	 * 
	 * Days already taken in Integer because this will come from UI end not will
	 * be provided by any user always will come in correct format
	 * 
	 * @param days
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/get/{days}/recentdoctors")
	@ResponseBody
	public List<DoctorResponse> getRecentDoctors(@PathVariable Integer days) {

		if (!StringUtils.isEmpty(days) && days > 0) {
			return doctorMapper
					.mapDoctors(doctorService.getRecentDoctors(days));
		} else {
			throw new BadRequestException("Doctor ID should not be blank");
		}
	}

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/get/all/unapproved/expertisation")
	@ResponseBody
	public Map<Integer, String> getAllUnApprovedExpertisations() {

		return doctorService.getUnApprovedExpertise();
	}

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/approve/{expertise}/expertisation")
	@ResponseBody
	public String addExpertisation(@PathVariable Integer expertise) {

		if (!StringUtils.isEmpty(expertise)) {
			return doctorService.approveExpertise(expertise);
		} else {
			throw new BadRequestException("Expertisation can not be blank");
		}
	}

}
