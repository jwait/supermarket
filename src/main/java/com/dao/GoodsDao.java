package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mapper.GoodsMapper;
import com.pojo.Goods;
import com.pojo.GoodsExample;
import com.pojo.GoodsExample.Criteria;

@Repository
public class GoodsDao {

	@Autowired
	private GoodsMapper goodsMapper;
	
	public Goods getGoodsById(int goodsId){
		return goodsMapper.selectByPrimaryKey(goodsId);
	}

	public Goods getGoodsByName(String goodsName){
		GoodsExample example = new GoodsExample();
		Criteria criteria = example.createCriteria();
		criteria.andNameEqualTo(goodsName);
		criteria.andIsdeleteEqualTo("N");
		List<Goods> list = goodsMapper.selectByExample(example);
		if(list == null || list.size() == 0){
			return null;
		}
		return list.get(0);
	}

	public List<Goods> selectGoods(){
		GoodsExample example = new GoodsExample();
		Criteria criteria = example.createCriteria();
		criteria.andIsdeleteEqualTo("N");
		return goodsMapper.selectByExample(example);
	}

	public int updateGoods(Goods goods){
		return goodsMapper.updateByPrimaryKeySelective(goods);
	}

	public int deleteGoodsById(int goodsId){
		Goods goods = getGoodsById(goodsId);
		goods.setIsdelete("Y");
		return goodsMapper.updateByPrimaryKeySelective(goods);
	}

	public int insertGoods(Goods goods){
		return goodsMapper.insertSelective(goods);
	}
}
