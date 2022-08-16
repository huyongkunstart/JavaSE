package com.qtummatrix.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

/**
 * Druid连接池
 * @author fucong
 *
 */
public class DruidUtils {
	private static Properties properties=new Properties();
	private static DataSource dataSource=null;
	static{
		try {
			InputStream inputStream=DruidUtils.class.getClassLoader()
					.getResourceAsStream("druidconfig.properties");
			properties.load(inputStream);
			dataSource=DruidDataSourceFactory.createDataSource(properties);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
	/**
	 * 获取连接对象
	 * @return
	 */
	public static Connection getConnection(){
		Connection connection=null;
		try {
			connection = dataSource.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	
	/**
	 * 释放资源
	 * @param connection
	 * @param statement
	 * @param resultSet
	 */
	public static void close(Connection connection,Statement statement,ResultSet resultSet){
		try{
			if(resultSet!=null){
				resultSet.close();
			}
			if(statement!=null){
				statement.close();
			}
			if(connection!=null){
				connection.close();
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
