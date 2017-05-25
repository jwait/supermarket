package com.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.OrderDao;
import com.dao.OrderStatusDao;
import com.pojo.Order;
import com.pojo.OrderStatus;
import com.service.OrderService;

@Service("orderService")
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderDao orderDao;
	
	@Autowired
	private OrderStatusDao orderStatusDao;

	@Override
	public List<Order> selectOrders() {
		return orderDao.selectOrders();
	}

	@Override
	public int ship(HttpServletRequest request, HttpServletResponse response) {
		String orderNum = request.getParameter("orderNum");
		Order order = orderDao.getOrderByNum(orderNum);
		OrderStatus orderStatus = orderStatusDao.getOrderStatusById(3);
		order.setOrderStatus(orderStatus);
		return orderDao.updateOrder(order);
	}

	@Override
	public int deleteOrder(HttpServletRequest request, HttpServletResponse response) {
		String orderNum = request.getParameter("orderNum");
		Order order = orderDao.getOrderByNum(orderNum);
		order.setIsdelete("Y");
		return orderDao.updateOrder(order);
	}
	
}
