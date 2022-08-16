package com.hu9.SqlSource.MyPool;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * 数据库连接公共类
 * @author fucong
 *
 */
public class Dbutils {
	private static Properties properties=new Properties();
	
	static{
	
		try {
			//读取配置文件信息
			InputStream inputStream=
					Dbutils.class.getClassLoader().getResourceAsStream("dbconfig.properties");
			//将配置文件信息加载到属性对象里面
			properties.load(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 创建连接对象
	 * @return
	 */
	public static Connection getConnection(){
		String driver=properties.getProperty("Driver");
		String url=properties.getProperty("url");
		String user=properties.getProperty("user");
		String password=properties.getProperty("password");
		
		Connection connection=null;
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
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
