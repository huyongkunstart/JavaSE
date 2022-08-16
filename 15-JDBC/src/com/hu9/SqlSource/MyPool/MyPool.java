package com.hu9.SqlSource.MyPool;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Properties;
import java.util.logging.Logger;

/**
 * @author huyongkun
 * @ClassName MyPool
 * @create 2022-07-19 14:35
 * @Version 1.0
 * @description: 手写连接池
 */
public class MyPool implements DataSource {
    private static Properties properties = new Properties();
    private static LinkedList<Connection> pool = new LinkedList<Connection>();
    private static String url;
    private static String user;
    private static String password;
    static {
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");
        try {
            properties.load(is);
            user = properties.getProperty("user");
            password = properties.getProperty("password");
            url = properties.getProperty("url");
            String driverClass = properties.getProperty("driverClass");

            Class.forName(driverClass);

            //连接池中的连接对象数量是由三个方面决定的：CPU，磁盘，网络
            //连接数量 = cpu核心数 * 2 + 有效磁盘数
            //初始10个连接
            for (int i = 0;i< 10;i++){
                Connection conn = DriverManager.getConnection(url, user, password);
                pool.add(conn);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //从连接池中获取连接对象
    @Override
    public Connection getConnection() throws SQLException {
        //当数据库的连接数为0时，临时创建3个连接对象
        if(pool.size() == 0){
            for (int i = 0; i < 3; i++) {
                Connection conn = DriverManager.getConnection(url, user, password);
                pool.add(conn);
            }
        }
        Connection conn = pool.remove(0);
        System.out.println("从连接池中获取一个连接，池中还剩"+pool.size()+"个连接");
        return conn;
    }
    //返还 连接对象到连接池
    public void returnConnection(Connection connection, Statement statement, ResultSet resultSet){
        if(statement != null){
            try {
                statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(resultSet != null){
            try {
                resultSet.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        try {
            if(connection != null && !connection.isClosed()){
                pool.add(connection);
                System.out.println("返还了一个连接对象，连接池中还剩:"+pool.size()+"个连接对象");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return null;
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        return null;
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {

    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {

    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return 0;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }
}
