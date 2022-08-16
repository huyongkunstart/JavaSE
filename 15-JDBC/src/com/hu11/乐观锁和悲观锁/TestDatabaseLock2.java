package com.hu11.乐观锁和悲观锁;

import com.hu3.util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;


/**
 * 悲观锁和乐观锁测试
 * @author fucong
 *
 */
public class TestDatabaseLock2 {

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			new Thread4(1).start();
		}
	}
}

/**
 * 悲观锁：
 * 1)先对共享资源加锁，再进行业务操作
 * 2)禁用事务的自动提交
 * 3)悲观锁的实现：select ... from 表名 where ... for update
 * @author fucong
 *
 */
class Thread2 extends Thread{

	private int id;
	
	public Thread2(int id) {
		this.id=id;
	}

	@Override
	public void run() {
		buyGoods(id);
	}
	
	//购买商品
	public void buyGoods(int id){
		Connection connection=null;
		PreparedStatement statement=null;
		ResultSet resultSet=null;
		
		try {
			connection= JDBCUtils.getConnection();
			connection.setAutoCommit(false);
			statement=connection.prepareStatement("select state from t_goods where id=? for update");
			statement.setInt(1, id);
			resultSet=statement.executeQuery();
			
			if(resultSet.next() && resultSet.getInt("state")==0){
				
				statement=connection.prepareStatement("insert into t_orders(goods_id) values(?)");
				statement.setInt(1,id);
				int count2=statement.executeUpdate();
			
				statement=connection.prepareStatement("update t_goods set state=1 where id=?");
				statement.setInt(1, id);
				int count1=statement.executeUpdate();

				if(count1>0 && count2>0){
					System.out.println("购买成功");
				}
				else{
					throw new MyException("购买失败，商品已经售出");
				}
			}
			else{
				System.out.println("购买失败，商品已经售出");
			}
		
			connection.commit();			
		
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
			JDBCUtils.closeResource(connection, statement, resultSet);
		}
	}
	
}

/**
 * 乐观锁
 * 1) 先进行业务操作，在更新数据时再获取锁
 * 2) 实现方式：在需要加锁的数据上增加一个版本号或者是时间戳
 * 3) 在更新数据时，会判断版本号或者时间戳有没有变化，如果有变化，
 * 说明该记录被其它的线程修改过，如果没有变化，说明该记录没有被其它
 * 线程修改过
 * @author fucong
 *
 */
class Thread3 extends Thread{

	private int id;

	public Thread3(int id) {
		this.id=id;
	}

	@Override
	public void run() {
		buyGoods(id);
	}

	//购买商品
	public void buyGoods(int id){
		Connection connection=null;
		PreparedStatement statement=null;
		ResultSet resultSet=null;
		int state = 0;
		int version = 0;
		try {
			connection= JDBCUtils.getConnection();
			connection.setAutoCommit(false);
			statement=connection.prepareStatement("select state,version from t_goods where id=?");
			statement.setInt(1, id);
			resultSet=statement.executeQuery();

			if(resultSet.next()){
				state = resultSet.getInt("state");
				version = resultSet.getInt("version");
			}
			if(state==0){
				//先更新
				statement=connection.prepareStatement("update t_goods set state=1,version = version+1 where id=? and version = ?");
				statement.setInt(1, id);
				statement.setInt(2,version);

				int count1=statement.executeUpdate();

				statement=connection.prepareStatement("insert into t_orders(goods_id) values(?)");
				statement.setInt(1,id);
				int count2=statement.executeUpdate();



				if(count1>0 && count2>0){
					System.out.println("购买成功");
				}
				else{
					throw new MyException("购买失败，商品已经售出");
				}
			}
			else{
				System.out.println("购买失败，商品已经售出");
			}

			connection.commit();

		} catch (Exception e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		finally{
			JDBCUtils.closeResource(connection, statement, resultSet);
		}
	}

}



class Thread4 extends Thread{
	
	private int id;
	
	public Thread4(int id) {
		this.id=id;
	}

	@Override
	public void run() {
		buyGoods(id);
	}
	
	//购买商品
	public void buyGoods(int id){
		Connection connection=null;
		PreparedStatement statement=null;
		ResultSet resultSet=null;
		int state=0;
		Timestamp version=null;
		
		try {
			connection=JDBCUtils.getConnection();
			connection.setAutoCommit(false);
			statement=connection.prepareStatement("select state,createtime from t_goods where id=?");
			statement.setInt(1, id);
			resultSet=statement.executeQuery();
			if(resultSet.next()){
				state=resultSet.getInt("state");
				version=resultSet.getTimestamp("createtime");
			}
			
			if(state==0){
				statement=connection.prepareStatement("update t_goods set state=1 where id=? and createtime=?");
				statement.setInt(1, id);
				statement.setTimestamp(2, version);
				int count1=statement.executeUpdate();
				
				statement=connection.prepareStatement("insert into t_orders(goods_id) values(?)");
				statement.setInt(1,id);
				int count2=statement.executeUpdate();

				if(count1>0 && count2>0){
					System.out.println("购买成功");
				}
				else{
					throw new MyException("购买失败，商品已经售出");
				}
			}
			else{
				System.out.println("购买失败，商品已经售出");
			}
		
			connection.commit();			
		
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
			JDBCUtils.closeResource(connection, statement, resultSet);
		}
	}
	
}
