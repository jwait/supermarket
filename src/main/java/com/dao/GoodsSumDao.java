package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mapper.GoodsSumMapper;
import com.pojo.GoodsSum;
import com.pojo.GoodsSumExample;
import com.pojo.GoodsSumExample.Criteria;

@Repository
public class GoodsSumDao {
	
	@Autowired
	private GoodsSumMapper goodsSumMapper;
	
	public GoodsSum getGoodsSumById(int goodsId){
		GoodsSumExample goodsSumExample = new GoodsSumExample();
		Criteria criteria = goodsSumExample.createCriteria();
		criteria.andGoodsIdEqualTo(goodsId);
		List<GoodsSum> list = goodsSumMapper.selectByExample(goodsSumExample);
		if(list == null || list.size() == 0){
			return null;
		}
		return list.get(0);
	}

	public void updateGoodsSum(Integer goodsId, Integer sum){
		GoodsSumExample example = new GoodsSumExample();
		Criteria criteria = example.createCriteria();
		criteria.andGoodsIdEqualTo(goodsId);
		GoodsSum goodsSum = goodsSumMapper.selectByExample(example).get(0);
		goodsSum.setSum(sum);
		goodsSumMapper.updateByPrimaryKey(goodsSum);
	}

	public void insertSum(GoodsSum goodsSum){
		goodsSumMapper.insertSelective(goodsSum);
	}
}
