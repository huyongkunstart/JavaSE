package com.qtummatrix.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import org.omg.CORBA.COMM_FAILURE;

import com.qtummatrix.dao.LoginDao;
import com.qtummatrix.entity.User;
import com.qtummatrix.utils.DruidUtils;

public class LoginDaoImpl implements LoginDao{
	Connection connection=null;
	PreparedStatement statement=null;
	ResultSet resultSet=null;
	
	@Override
	public User login(String username, String password) {

		User user=null;
		try {
			connection=DruidUtils.getConnection();
			
			/**
			 * SQL注入攻击：就是通过给SQL语句传递参数，达到改变SQL语句结构，从而对系统进行侵入或者破坏
			 * PreparedStatement传入的SQL语句是经过预编译的
			 */
			String sql="select * from user_info where username=? and password=?";
			statement=connection.prepareStatement(sql);
			statement.setString(1, username);
			statement.setString(2, password);
			resultSet=statement.executeQuery();
			if(resultSet.next()){
				user=new User();
				user.setId(resultSet.getInt("id"));
				user.setUsername(resultSet.getString("username"));
				user.setPassword(resultSet.getString("password"));
				user.setPoints(resultSet.getInt("points"));
				user.setCreateTime(resultSet.getTimestamp("createTime"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			DruidUtils.close(connection, statement, resultSet);
		}
		return user;
	}

	@Override
	public int loginOut(int userId) {
		int count=0;
		try {
			connection=DruidUtils.getConnection();
			//查询用户最新的登录记录
			String sql="select user_id,max(login_time) loginTime from login where user_id=?"
					+ " group by user_id";
			statement=connection.prepareStatement(sql);
			statement.setInt(1, userId);
			resultSet=statement.executeQuery();
			if(resultSet.next()){
				Timestamp loginTime=resultSet.getTimestamp("loginTime");
				statement=connection.prepareStatement("update login set loginout_time=now() "
						+ "where user_id=? and login_time=?");
				statement.setInt(1, userId);
				statement.setTimestamp(2, loginTime);
				count=statement.executeUpdate();
				if(count>0){
					System.out.println("退出");
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return count;
	}

	@Override
	public boolean writeLoginLog(int userId) {
		try {
			connection=DruidUtils.getConnection();
			String sql="insert into login(user_id,login_time) values(?,now())";
			statement=connection.prepareStatement(sql);
			statement.setInt(1, userId);
			int count=statement.executeUpdate();
			if(count>0){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			DruidUtils.close(connection, statement, resultSet);
		}
		return false;
	}

	@Override
	public int getLoginCount(int userId) {
		int count=0;
		try {
			connection=DruidUtils.getConnection();
			String sql="select count(id) total from login where user_id=? "
					+ "and DATE_FORMAT(login_time,'%Y-%m-%d')=curdate()";
			statement=connection.prepareStatement(sql);
			statement.setInt(1, userId);
			resultSet=statement.executeQuery();
			if(resultSet.next()){
				count=resultSet.getInt("total");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			DruidUtils.close(connection, statement, resultSet);
		}
		return count;
	}

	@Override
	public int sign(int userId) {
		try {
			connection=DruidUtils.getConnection();
			connection.setAutoCommit(false);
			String sql="select ifnull(count(id),0) total from sign where user_id=? and DATE_FORMAT(sign_time,'%Y-%m_%d')=curdate()";
			statement=connection.prepareStatement(sql);
			statement.setInt(1, userId);
			resultSet=statement.executeQuery();
			
			if(resultSet.next()){
				if(resultSet.getInt("total")>0){
					System.out.println("用户已经签到过");
					return 2;
				}
				else if(resultSet.getInt("total")==0){
					statement=connection.prepareStatement("insert into sign(user_id,sign_time,sign_point)"
							+ " values(?,now(),10)");
					statement.setInt(1, userId);
					int count1=statement.executeUpdate();
					
					statement=connection.prepareStatement("update user_info set points=points+10 where id=?");
					statement.setInt(1, userId);
					int count2=statement.executeUpdate();
					
					connection.commit();
					
					if(count1>0 && count2>0){
						return 1;
					}
					else{
						throw new Exception("用户签到失败");
					}
				}
			}
		
			

		} catch (Exception e) {
			e.printStackTrace();
			try {
				connection.rollback();
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

	
}
