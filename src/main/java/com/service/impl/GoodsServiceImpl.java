package com.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.GoodsDao;
import com.dao.GoodsSumDao;
import com.dao.GoodsTypeDao;
import com.pojo.Goods;
import com.pojo.GoodsType;
import com.service.GoodsService;

@Service("goodsService")
public class GoodsServiceImpl implements GoodsService {
	
	@Autowired
	private GoodsDao goodsDao;
	
	@Autowired 
	private GoodsSumDao goodsSumDao;
	
	@Autowired
	private GoodsTypeDao goodsTypeDao;
	
	@Override
	public List<Goods> selectGoods() {
		return goodsDao.selectGoods();
	}

	@Override
	public String chGoods(HttpServletRequest request, HttpServletResponse response) {
		double goodsPrice;
		double goodsDiscount;
		int sum;
		int goodsExpiryDate;
		try {
			goodsPrice = Double.parseDouble(request.getParameter("goodsPrice"));
			goodsDiscount = Double.parseDouble(request.getParameter("goodsDiscount"));
			sum = Integer.parseInt(request.getParameter("goodsSum"));
			goodsExpiryDate = Integer.parseInt(request.getParameter("goodsExpiryDate"));
		} catch (NumberFormatException e) {
			return "error";
		}
		String goodsName = request.getParameter("goodsName");
		String goodsTypeName = request.getParameter("goodsType");
		String goodsCreatDate = request.getParameter("goodsCreatDate");
		String goodsProducer = request.getParameter("goodsProducer");
		String goodsSize = request.getParameter("goodsSize");
		Goods goods = goodsDao.getGoodsByName(goodsName);
		if(goods != null){
			Integer id = goods.getId();
			goods.setPrice(goodsPrice);
			goods.setDiscount(goodsDiscount);
			goods.setSize(goodsSize);
			if(goodsSumDao.getGoodsSumById(id) != null){
				goodsSumDao.updateGoodsSum(id, sum);
			} else {
				goodsSumDao.insertSum(id, sum);
			}
			goodsDao.updateGoods(goods);
			return "update";
		} else {
			Goods goods2 = new Goods();
			goods2.setName(goodsName);
			goods2.setPrice(goodsPrice);
			goods2.setDiscount(goodsDiscount);
			goods2.setSize(goodsSize);
			goods2.setCreateDate(goodsCreatDate);
			goods2.setProducer(goodsProducer);
			goods2.setExpiryDate(goodsExpiryDate);
			
			GoodsType goodsType = goodsTypeDao.getGoodsTypeByName(goodsTypeName);
			goods2.setGoodsType(goodsType);
			
			int goodsId = goodsDao.insertGoods(goods);
			goodsSumDao.insertSum(goodsId, sum);
			return "insert";
		}
	}

	@Override
	public String deleteGoodsById(HttpServletRequest request, HttpServletResponse response) {
		String goodsId = request.getParameter("id");
		goodsDao.deleteGoodsById(Integer.parseInt(goodsId));
		return "success";
	}

}
