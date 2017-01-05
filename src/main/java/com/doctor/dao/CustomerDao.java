package com.doctor.dao;

import com.doctor.types.pojo.Customer;

public interface CustomerDao {

	public String addCustomer(Customer customer);

	public boolean isCustomerExists(Customer customer);

}
