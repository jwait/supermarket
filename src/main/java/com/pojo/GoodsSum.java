package com.pojo;

public class GoodsSum {
    private Integer id;

    private Integer sum;

    private Integer goodsId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public GoodsSum() {
		// TODO Auto-generated constructor stub
	}
    
    public GoodsSum(Integer sum, Integer goodsId) {
		super();
		this.sum = sum;
		this.goodsId = goodsId;
	}

	public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }
}