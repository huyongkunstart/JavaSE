package com.qtummatrix.dao;

import java.util.List;

import com.qtummatrix.entity.Goods;

/**
 * 商品管理模块数据访问层
 * @author fucong
 *
 */
public interface GoodsDao {

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
	
	/**
	 * 更加商品id查询商品信息
	 * @param goodsId 商品id
	 * @return 返回商品信息
	 */
	Goods getGoodsById(int goodsId);
	
}
