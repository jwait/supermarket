package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dao.GoodsTypeDao;
import com.pojo.Goods;
import com.pojo.GoodsType;
import com.service.GoodsService;

@Controller
public class GoodsController {
	
	@Autowired
	private GoodsService goodsService;
	
	@Autowired
	private GoodsTypeDao goodsTypeDao;
	
	@RequestMapping("/showGoods")
	public String showGoods(HttpServletRequest request, HttpServletResponse response){
		List<Goods> goodsList = goodsService.selectGoods();
		List<GoodsType> goodsTypesList = goodsTypeDao.selectGoodsTypes();
		request.setAttribute("goods", goodsList);
		request.setAttribute("goodsTypes", goodsTypesList);
		return "goods";
	}
	
	@RequestMapping("/chGoods")
	public void chGoods(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String result = goodsService.chGoods(request, response);
		PrintWriter out = response.getWriter();
		out.write(result);
		out.close();
	}
	
	@RequestMapping("/deleteGoods")
	public void deleteGoods(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String result = goodsService.deleteGoodsById(request, response);
		PrintWriter out = response.getWriter();
		out.write(result);
		out.close();
	}
	
}
