package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mapper.EmployeeLimitMapper;
import com.pojo.EmployeeLimit;
import com.pojo.EmployeeLimitExample;
import com.pojo.EmployeeLimitExample.Criteria;

@Repository
public class EmployeeLimitDao {
	
	@Autowired
	private EmployeeLimitMapper employeeLimitMapper;
	
	public EmployeeLimit getLimitById(int id){
		return employeeLimitMapper.selectByPrimaryKey(id);
	}
	
	public EmployeeLimit getEmployeeLimitByLevel(String level){
		EmployeeLimitExample example = new EmployeeLimitExample();
		Criteria criteria = example.createCriteria();
		criteria.andLevelEqualTo(level);
		List<EmployeeLimit> list = employeeLimitMapper.selectByExample(example);
		return list.get(0);
	}
	
}
