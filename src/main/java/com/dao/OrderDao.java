package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mapper.OrderMapper;
import com.pojo.Order;
import com.pojo.OrderExample;
import com.pojo.OrderExample.Criteria;

@Repository
public class OrderDao {
	
	@Autowired
	private OrderMapper orderMapper;
	
	public List<Order> selectOrders(){
		OrderExample example = new OrderExample();
		Criteria criteria = example.createCriteria();
		criteria.andIsdeleteEqualTo("N");
		return orderMapper.selectByExample(example);
	}

	public Order getOrderByNum(String orderNum){
		OrderExample example = new OrderExample();
		Criteria criteria = example.createCriteria();
		criteria.andOrderNumEqualTo(orderNum);
		criteria.andIsdeleteEqualTo("N");
		List<Order> list = orderMapper.selectByExample(example);
		if (list == null || list.size() == 0){
			return null;
		}
		return list.get(0);
	}

	public int updateOrder(Order order){
		return orderMapper.updateByPrimaryKey(order);
	}
}
