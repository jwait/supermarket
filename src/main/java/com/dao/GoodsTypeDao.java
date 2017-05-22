package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mapper.GoodsTypeMapper;
import com.pojo.GoodsType;
import com.pojo.GoodsTypeExample;
import com.pojo.GoodsTypeExample.Criteria;

@Repository
public class GoodsTypeDao {
	
	@Autowired
	private GoodsTypeMapper goodsTypeMapper;
	
	public GoodsType getGoodsTypeById(int goodsTypeId){
		return goodsTypeMapper.selectByPrimaryKey(goodsTypeId);
	}

	public GoodsType getGoodsTypeByName(String goodsTypeName){
		GoodsTypeExample example = new GoodsTypeExample();
		Criteria criteria = example.createCriteria();
		criteria.andNameEqualTo(goodsTypeName);
		List<GoodsType> list = goodsTypeMapper.selectByExample(example);
		return list.get(0);
	}

	public List<GoodsType> selectGoodsTypes(){
		GoodsTypeExample example = new GoodsTypeExample();
		return goodsTypeMapper.selectByExample(example);
	}
}
