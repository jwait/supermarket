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
	
	public int insertEmployee(Employee employee){
		employee.setPassword("123456");
		employee.setIsdelete("N");
		return employeeMapper.insert(employee);
	}

	public int deleteEmployee(Employee employee){
		employee.setIsdelete("Y");;
		return employeeMapper.updateByPrimaryKey(employee);
	}
	
	public Employee getEmployeeById(String employeeId){
		EmployeeExample example = new EmployeeExample();
		Criteria criteria = example.createCriteria();
		criteria.andEidEqualTo(employeeId);
		criteria.andIsdeleteEqualTo("N");
		List<Employee> list = employeeMapper.selectByExample(example);
		if(list == null || list.size() == 0){
			return null;
		}
		return list.get(0);
	}
	
	public List<Employee> selectEmployees(){
		EmployeeExample example = new EmployeeExample();
		Criteria criteria = example.createCriteria();
		criteria.andIsdeleteEqualTo("N");
		List<Employee> list = employeeMapper.selectByExample(example);
		return list;
	}
	
	public int updateEmployee(Employee employee){
		return employeeMapper.updateByPrimaryKey(employee);
	}
	
}
