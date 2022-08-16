package com.qtummatrix.service.impl;

import java.util.List;

import com.qtummatrix.dao.GoodsDao;
import com.qtummatrix.dao.UserDao;
import com.qtummatrix.dao.impl.GoodsDaoImpl;
import com.qtummatrix.dao.impl.UserDaoImpl;
import com.qtummatrix.entity.Goods;
import com.qtummatrix.entity.User;
import com.qtummatrix.service.GoodsService;

public class GoodsServiceImpl implements GoodsService {
	
	private static GoodsDao goodsDao;
	private static UserDao userDao;
	
	public synchronized static GoodsDao getGoodsInstance(){
		if(goodsDao==null){
			goodsDao=new GoodsDaoImpl();
		}
		return goodsDao;
	}
	
	public synchronized static UserDao getUserInstance(){
		if(userDao==null){
			userDao=new UserDaoImpl();
		}
		return userDao;
	}
	
	@Override
	public List<Goods> getGoods(String goodsName, String goodsTypeName) {	
		return getGoodsInstance().getGoods(goodsName, goodsTypeName);
	}

	@Override
	public int exchangeGoods(int userId, int goodsId, int quantity) {
		int result=0;
		User user=userDao.getUserById(userId);
		//判断用户积分余额是否足够
		
		//判断可兑换商品的数量是否足够
		Goods goods=goodsDao.getGoodsById(goodsId);
		
		//实现兑换商品
		result=getGoodsInstance().exchangeGoods(userId, goodsId, quantity);
		
		return result;
	}

	
}
