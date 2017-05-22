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
		List<Goods> list = goodsMapper.selectByExample(example);
		return list.get(0);
	}

	public List<Goods> selectGoods(){
		GoodsExample example = new GoodsExample();
		return goodsMapper.selectByExample(example);
	}

	public void updateGoods(Goods goods){
		goodsMapper.updateByPrimaryKey(goods);
	}

	public void deleteGoodsById(int goodsId){
		goodsMapper.deleteByPrimaryKey(goodsId);
	}

	public void insertGoods(Goods goods){
		goodsMapper.insert(goods);
	}
}
