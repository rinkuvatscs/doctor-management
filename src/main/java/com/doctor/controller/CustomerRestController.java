package com.doctor.controller;

import io.swagger.annotations.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.doctor.dao.CustomerDao;
import com.doctor.types.pojo.Customer;

@RestController
@RequestMapping("/customer-management")
@Api(basePath = "/customer-management", value = "customermanagement", description = "Operations with Landlords", produces = "application/json")
public class CustomerRestController {

	@Autowired
	private CustomerDao customerDao;

	@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/addcustomer", method = RequestMethod.POST)
	@ResponseBody
	public Response addCustomer(@RequestBody Customer customer) {

		return new Response(customerDao.addCustomer(customer));
	}
}
