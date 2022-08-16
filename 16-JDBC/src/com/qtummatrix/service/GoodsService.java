package com.qtummatrix.service;

import java.util.List;

import com.qtummatrix.entity.Goods;

public interface GoodsService {

	/**
	 * 根据条件查询 商品信息
	 * @param goodsName 商品名称
	 * @param goodsTypeName  商品分类名称
	 * @return 商品列表信息
	 */
	List<Goods> getGoods(String goodsName,String goodsTypeName);
	
	/**
	 * 兑换商品
	 * @param userId 用户id
	 * @param goodsId 商品id
	 * @param quantity 兑换数量
	 * @return 0.用户兑换数量大于兑换商品的数量，兑换失败 
	 *         1.用户的积分余额小于兑换商品的价值，兑换失败
	 *         2.用户更新商品库存、更新余额失败、插入兑换记录失败 
	 *         3.兑换成功
	 */
	int exchangeGoods(int userId,int goodsId,int quantity);
	
}
