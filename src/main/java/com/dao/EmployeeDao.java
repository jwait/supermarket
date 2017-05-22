package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mapper.EmployeeMapper;
import com.pojo.Employee;
import com.pojo.EmployeeExample;
import com.pojo.EmployeeExample.Criteria;

@Repository
public class EmployeeDao {
	
	@Autowired
	private EmployeeMapper employeeMapper;
	
	public void insertEmployee(Employee employee){
		employeeMapper.insert(employee);
	}

	public void deleteEmployee(String employeeId){
		EmployeeExample example = new EmployeeExample();
		Criteria criteria = example.createCriteria();
		criteria.andEidEqualTo(employeeId);
		employeeMapper.deleteByExample(example);
	}
	
	public Employee getEmployeeById(String employeeId){
		EmployeeExample example = new EmployeeExample();
		Criteria criteria = example.createCriteria();
		criteria.andEidEqualTo(employeeId);
		List<Employee> list = employeeMapper.selectByExample(example);
		return list.get(0);
	}
	
	public List<Employee> selectEmployees(){
		EmployeeExample example = new EmployeeExample();
		List<Employee> list = employeeMapper.selectByExample(example);
		return list;
	}
	
	public void updateEmployee(Employee employee){
		employeeMapper.updateByPrimaryKey(employee);
	}
	
}
