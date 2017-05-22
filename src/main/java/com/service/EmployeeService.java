package com.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pojo.Employee;

public interface EmployeeService {
	
	List<Employee> getEmployees();
	
	Employee getEmployeeById(String employeeId);

	void updateEmployee(Employee employee);

	void deleteEmployee(String employeeId);

	void insertEmployee(Employee employee);

	/**
	 * 
	 * @param request
	 * @param response
	 * @return 跳转的页面
	 */
	String login(HttpServletRequest request, HttpServletResponse response);

	void updatePersonalInfo(HttpServletRequest request, HttpServletResponse response);

	String chPassword(HttpServletRequest request, HttpServletResponse response);

	void deleteEmployee(HttpServletRequest request, HttpServletResponse response);

	void chEmployee(HttpServletRequest request, HttpServletResponse response);}
