package com.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mapper.GoodsSumMapper;
import com.pojo.GoodsSum;

@Repository
public class GoodsSumDao {
	
	@Autowired
	private GoodsSumMapper goodsSumMapper;
	
	public GoodsSum getGoodsSumById(int goodsId){
		return goodsSumMapper.selectByPrimaryKey(goodsId);
	}

	public void updateGoodsSum(GoodsSum goodsSum){
		goodsSumMapper.updateByPrimaryKey(goodsSum);
	}

	public void insertSum(GoodsSum goodsSum){
		goodsSumMapper.insert(goodsSum);
	}
}
