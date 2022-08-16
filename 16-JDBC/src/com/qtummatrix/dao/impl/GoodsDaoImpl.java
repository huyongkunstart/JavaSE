package com.qtummatrix.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.qtummatrix.dao.GoodsDao;
import com.qtummatrix.entity.Goods;
import com.qtummatrix.utils.DruidUtils;

public class GoodsDaoImpl implements GoodsDao {
	
	Connection connection=null;
	PreparedStatement statement=null;
	ResultSet resultSet=null;

	@Override
	public List<Goods> getGoods(String goodsName, String goodsTypeName) {
		List<Goods> goodsList=new ArrayList<Goods>();
		Goods goods=null;
		try {
			connection=DruidUtils.getConnection();
			String sql="select goods.*,goods_type.type_name from goods,goods_type where goods.goods_type_id=goods_type.id";
			//商品名称和商品分类名称都不为空
			if((goodsName!=null && !goodsName.equals(""))
			&& (goodsTypeName!=null && !goodsTypeName.equals(""))){
				sql+=" and goods.goods_name like ? and goods_type.type_name=?";
			}
			//商品名称为不为空和商品分类名称为空
			if((goodsName!=null && !goodsName.equals(""))
				&& (goodsTypeName==null || goodsTypeName.equals(""))){
				sql+=" and goods.goods_name like ?";
			}
			//商品名称为空和商品分类名称不为空
			if((goodsName==null || goodsName.equals(""))
				&& (goodsTypeName!=null && !goodsTypeName.equals(""))){
				sql+=" and goods_type.type_name=?";
			}
			
			statement=connection.prepareStatement(sql);
			
			//商品名称和商品分类名称都不为空
			if((goodsName!=null && !goodsName.equals(""))
			&& (goodsTypeName!=null && !goodsTypeName.equals(""))){
				statement.setString(1, goodsName);
				statement.setString(2, goodsTypeName);
			}
			//商品名称为不为空和商品分类名称为空
			if((goodsName!=null && !goodsName.equals(""))
				&& (goodsTypeName==null || goodsTypeName.equals(""))){
				statement.setString(1, goodsName);
			}
			//商品名称为空和商品分类名称不为空
			if((goodsName==null || goodsName.equals(""))
					&& (goodsTypeName!=null && !goodsTypeName.equals(""))){
				statement.setString(1, goodsTypeName);
			}
			resultSet=statement.executeQuery();
			while(resultSet.next()){
				goods=new Goods();
				goods.setId(resultSet.getInt("id"));
				goods.setGoodsName(resultSet.getString("goods_name"));
				goods.setGoodsTypeName(resultSet.getString("type_name"));
				goods.setGoodsTypeId(resultSet.getInt("goods_type_id"));
				goods.setStock(resultSet.getInt("stock"));
				goods.setExchangePoints(resultSet.getInt("exchange_points"));
				goods.setPrice(resultSet.getBigDecimal("price"));
				goodsList.add(goods);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			DruidUtils.close(connection, statement, resultSet);
		}
		
		return goodsList;
	}

	@Override
	public int exchangeGoods(int userId, int goodsId, int quantity) {
		try {
			connection=DruidUtils.getConnection();
			connection.setAutoCommit(false);
			//更新商品库存
			statement=connection.prepareStatement("");
			statement.setInt(1, userId);
			int count1=statement.executeUpdate();
			
			//插入兑换记录
			statement=connection.prepareStatement("");
			statement.setInt(1, userId);
			int count2=statement.executeUpdate();
			
            //更新用户余额
			statement=connection.prepareStatement("");
			statement.setInt(1, userId);
			int count3=statement.executeUpdate();
			
			connection.commit();
			
			if(count1>0 && count2>0 && count3>0){
				return 3;
			}
			else{
				throw new Exception("用户更新商品库存、更新余额失败、插入兑换记录失败 ");
			}
			
		
		} catch (Exception e) {
			e.printStackTrace();
			try {
				connection.rollback();
				return 2;
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		finally{
			DruidUtils.close(connection, statement, resultSet);
		}
		
		return 0;
	}

	@Override
	public Goods getGoodsById(int goodsId) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
