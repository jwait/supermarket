package com.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.GoodsDao;
import com.dao.GoodsSumDao;
import com.dao.GoodsTypeDao;
import com.pojo.Goods;
import com.pojo.GoodsSum;
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
		
		List<Goods> list = goodsDao.selectGoods();
		int goodsId;
		for (Goods goods : list) {
			goodsId = goods.getId();
			GoodsSum goodsSum = goodsSumDao.getGoodsSumById(goodsId);
			goods.setGoodsSum(goodsSum);
		}
		return list;
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
		String goodsDesc = request.getParameter("goodsDesc");
		Goods goods = goodsDao.getGoodsByName(goodsName);
		if(goods != null){
			Integer id = goods.getId();
			goods.setPrice(goodsPrice);
			goods.setDiscount(goodsDiscount);
			goods.setSize(goodsSize);
			goods.setDesc(goodsDesc);
			if(goodsSumDao.getGoodsSumById(id) != null){
				goodsSumDao.updateGoodsSum(id, sum);
			} else {
				GoodsSum goodsSum = new GoodsSum(sum, id);
				goodsSumDao.insertSum(goodsSum);
			}
			goodsDao.updateGoods(goods);
			return "update";
		} else {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date date = null;
			try {
				date = format.parse(goodsCreatDate);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			insertGoods(goodsPrice, goodsDiscount, sum, goodsExpiryDate, goodsName, goodsTypeName, date, goodsProducer, goodsSize, goodsDesc);
			return "insert";
		}
	}
	
	private void insertGoods(double goodsPrice, double goodsDiscount, int goodsSum, int goodsExpiryDate,
			String goodsName, String goodsType, Date goodsCreatDate, String goodsProducer, String goodsSize, String goodsDesc) {
		Goods goods = new Goods(goodsName, goodsPrice, goodsDiscount, goodsCreatDate, goodsExpiryDate, goodsProducer, goodsSize, goodsDesc);
		goods.setGoodsType(goodsTypeDao.getGoodsTypeByName(goodsType));
		goodsDao.insertGoods(goods);
		int goodsId = goods.getId();
		GoodsSum sum = new GoodsSum(goodsSum, goodsId);
		goodsSumDao.insertSum(sum);
	}

	@Override
	public String deleteGoodsById(HttpServletRequest request, HttpServletResponse response) {
		String goodsId = request.getParameter("id");
		goodsDao.deleteGoodsById(Integer.parseInt(goodsId));
		return "success";
	}

}
