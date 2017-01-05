package com.doctor.extractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.doctor.types.pojo.Customer;

public class CustomerExtractor implements ResultSetExtractor<List<Customer>> {

	@Override
	public List<Customer> extractData(ResultSet rs) throws SQLException,
			DataAccessException {

		return null;
	}

}
