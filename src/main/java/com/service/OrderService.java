package com.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pojo.Order;

public interface OrderService {
	
	List<Order> selectOrders();

	int ship(HttpServletRequest request, HttpServletResponse response);

	int deleteOrder(HttpServletRequest request, HttpServletResponse response);
}
