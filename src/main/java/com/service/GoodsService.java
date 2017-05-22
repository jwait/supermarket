package com.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pojo.Goods;

public interface GoodsService {
	
	List<Goods> selectGoods();

	String chGoods(HttpServletRequest request, HttpServletResponse response);

	String deleteGoodsById(HttpServletRequest request, HttpServletResponse response);
}
