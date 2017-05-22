package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mapper.OrderItemsMapper;
import com.pojo.OrderItems;
import com.pojo.OrderItemsExample;

@Repository
public class OrderItemsDao {

	@Autowired
	private OrderItemsMapper orderItemsMapper;
	
	public List<OrderItems> selectOrderItems(){
		OrderItemsExample example = new OrderItemsExample();
		return orderItemsMapper.selectByExample(example);
	}
}
