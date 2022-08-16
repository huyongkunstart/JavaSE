package com.qtummatrix.entity;

import java.math.BigDecimal;

/**
 * 商品实体
 * @author fucong
 *
 */
public class Goods {

	private int id;
	private int goodsTypeId;
	private String goodsTypeName;
	private String goodsName;
	private BigDecimal price;
	private int exchangePoints;
	private int stock;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getGoodsTypeId() {
		return goodsTypeId;
	}
	public void setGoodsTypeId(int goodsTypeId) {
		this.goodsTypeId = goodsTypeId;
	}
	public String getGoodsTypeName() {
		return goodsTypeName;
	}
	public void setGoodsTypeName(String goodsTypeName) {
		this.goodsTypeName = goodsTypeName;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public int getExchangePoints() {
		return exchangePoints;
	}
	public void setExchangePoints(int exchangePoints) {
		this.exchangePoints = exchangePoints;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	@Override
	public String toString() {
		return "Goods [id=" + id + ", goodsTypeId=" + goodsTypeId
				+ ", goodsTypeName=" + goodsTypeName + ", goodsName="
				+ goodsName + ", price=" + price + ", exchangePoints="
				+ exchangePoints + ", stock=" + stock + "]";
	}
	
	
}
