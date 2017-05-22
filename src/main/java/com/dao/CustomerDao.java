package com.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mapper.CustomerMapper;
import com.pojo.Customer;

@Repository
public class CustomerDao {
	
	@Autowired
	private CustomerMapper customerMapper;
	
	public Customer getCustomerById(int customerId){
		return customerMapper.selectByPrimaryKey(customerId);
	}
}
