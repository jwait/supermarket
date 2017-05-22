package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.service.EmployeeService;

@Controller
public class LoginController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping("/login.action")
	public String login(HttpServletRequest request, HttpServletResponse response){
		String login = employeeService.login(request, response);
		return login;
	}
	
}
