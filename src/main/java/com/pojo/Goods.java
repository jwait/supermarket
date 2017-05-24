package com.pojo;

import java.sql.Date;

public class Goods {
    private Integer id;

    private String name;

    private Double price;

    private Double discount;

    private String createDate;

    private Integer expiryDate;

    private String size;

    private String producer;

    private Integer goodsTypeId;

    private String desc;

    private String isdelete;
    
    private GoodsType goodsType;
    
    private GoodsSum goodsSum;
    
    public Goods() {
    	super();
    }
    
    public Goods(String name, double price, double discount, String createDate, int expiryDate, String producer,
			String size) {
		super();
		this.name = name;
		this.price = price;
		this.discount = discount;
		this.createDate = createDate;
		this.expiryDate = expiryDate;
		this.producer = producer;
		this.size = size;
	}
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public Integer getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Integer expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size == null ? null : size.trim();
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer == null ? null : producer.trim();
    }

    public Integer getGoodsTypeId() {
        return goodsTypeId;
    }

    public void setGoodsTypeId(Integer goodsTypeId) {
        this.goodsTypeId = goodsTypeId;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc == null ? null : desc.trim();
    }

    public String getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(String isdelete) {
        this.isdelete = isdelete == null ? null : isdelete.trim();
    }

	public GoodsType getGoodsType() {
		return goodsType;
	}

	public void setGoodsType(GoodsType goodsType) {
		this.goodsType = goodsType;
	}

	public GoodsSum getGoodsSum() {
		return goodsSum;
	}

	public void setGoodsSum(GoodsSum goodsSum) {
		this.goodsSum = goodsSum;
	}
    
}