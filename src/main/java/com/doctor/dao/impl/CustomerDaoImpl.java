package com.doctor.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.doctor.dao.CustomerDao;
import com.doctor.types.pojo.Customer;

public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	private JdbcTemplate JdbcTemplate;

	@Override
	public String addCustomer(Customer customer) {

		String response = null;
		if (!isCustomerExists(customer)) {
			List<Object> args = new ArrayList<>();
			args.add(customer.getCustName());
			args.add(customer.getCustZip());
			args.add(customer.getCustAddress());
			args.add(customer.getCustAdharNumber());
			args.add(customer.getCustEmail());
			args.add(customer.getCustMobileNumber());
			// TODO need to add SQL query.
			int row = JdbcTemplate.update("", args.toArray());
			if (row == 1) {
				response = "Customer " + customer.getCustName()
						+ " successfully registered...!";
			} else {
				response = "Sorry, " + customer.getCustName()
						+ " not registered . Please try again";
			}
		} else {
			response = "Customer " + customer.getCustName()
					+ " already exist...!";
		}
		return response;
	}

	@Override
	public boolean isCustomerExists(Customer customer) {

		return false;
	}

}
