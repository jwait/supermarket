package com.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mapper.OrderStatusMapper;
import com.pojo.OrderStatus;

@Repository
public class OrderStatusDao {
	
	@Autowired
	private OrderStatusMapper orderStatusMapper;
	
	public OrderStatus getOrderStatusById(int orderStatusId){
		return orderStatusMapper.selectByPrimaryKey(orderStatusId);
	}
}
