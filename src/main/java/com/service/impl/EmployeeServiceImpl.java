package com.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.EmployeeDao;
import com.dao.EmployeeLimitDao;
import com.pojo.Employee;
import com.pojo.EmployeeLimit;
import com.service.EmployeeService;
import com.utils.Utils;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDao employeeDao;
	
	@Autowired
	private EmployeeLimitDao employeeLimitDao;
	
	@Override
	public List<Employee> getEmployees() {
		List<Employee> list = employeeDao.selectEmployees();
		return list;
	}

	@Override
	public Employee getEmployeeById(String employeeId) {
		return employeeDao.getEmployeeById(employeeId);
	}
	
	@Override
	public void updateEmployee(Employee employee) {
		employeeDao.updateEmployee(employee);
	}

	@Override
	public void insertEmployee(Employee employee) {
		employeeDao.insertEmployee(employee);
	}
	
	@Override
	public void deleteEmployee(String employeeId) {
		employeeDao.deleteEmployee(employeeId);
	}

	@Override
	public String login(HttpServletRequest request, HttpServletResponse response) {
		String password = request.getParameter("password");
		String limit = request.getParameter("limit");
		String employeeId = request.getParameter("employeeId");
		
		Employee employee = getEmployeeById(employeeId);
		if(employee == null || !employee.getPassword().equals(password)){
			Utils.printScript(response, "ID或者密码不正确");
		} else if(employeeLimitDao.getLimitById(employee.getEmployeeLimitId()).getLevel().equals(limit)){
			request.getSession().setAttribute("employee", employee);
			return "index";
		} else{
			Utils.printScript(response, "类别不正确");
		}
		return null;
	}

	@Override
	public void updatePersonalInfo(HttpServletRequest request, HttpServletResponse response) {
		String newName = request.getParameter("newName");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		Employee employee = (Employee) request.getSession().getAttribute("employee");
	
		employee.setName(newName);
		employee.setEmail(email);
		employee.setPhone(phone);
		updateEmployee(employee);
		request.getSession().setAttribute("employee", employee);
	}

	@Override
	public String chPassword(HttpServletRequest request, HttpServletResponse response) {
		String oldPassword = request.getParameter("oldPassword");
		String newPassword = request.getParameter("newPassword");
		String secondPassword = request.getParameter("secondPassword");
		
		Employee employee = (Employee) request.getSession().getAttribute("employee");
		
		if(oldPassword == null || oldPassword.trim().equals("")){
			return "请输入旧密码";
		}
		if(newPassword == null || newPassword.trim().equals("")){
			return "请输入新密码";
		}
		if(secondPassword == null || secondPassword.trim().equals("")){
			return "请再次输入密码";
		}
		if(!employee.getPassword().equals(oldPassword)){
			return "密码不正确";
		} else{
			if(newPassword.equals(secondPassword)){
				employee.setPassword(newPassword);
				employeeDao.updateEmployee(employee);
				return "密码修改成功";
			} else{
				return "输入的密码不一致";
			}
		}
	}

	@Override
	public void deleteEmployee(HttpServletRequest request, HttpServletResponse response) {
		String employeeId = request.getParameter("id");
		deleteEmployee(employeeId);
	}

	@Override
	public void chEmployee(HttpServletRequest request, HttpServletResponse response) {
		String employeeId = request.getParameter("employeeId");
		String employeeName = request.getParameter("employee");
		String employeePhone = request.getParameter("employeePhone");
		String employeeEmail = request.getParameter("employeeEmail");
		String employeeLimit = request.getParameter("employeeLimit");
		Employee employee = getEmployeeById(employeeId);
		
		if(employee != null){
			employee.setEid(employeeId);
			employee.setName(employeeName);
			employee.setEmail(employeeEmail);
			employee.setPhone(employeePhone);
			Integer limitId = employeeLimitDao.getEmployeeLimitByLevel(employeeLimit).getId();
			employee.setEmployeeLimitId(limitId);
			updateEmployee(employee);
		} else {
			Integer id = employeeLimitDao.getEmployeeLimitByLevel(employeeLimit).getId();
			Employee employee2 = new Employee();
			employee2.setEid(employeeId);
			employee2.setName(employeeName);
			employee2.setEmail(employeeEmail);
			employee2.setPhone(employeePhone);
			employee2.setEmployeeLimitId(id);
			insertEmployee(employee2);
		}
	}


}
