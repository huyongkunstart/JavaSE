package com.hu9.SqlSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.DataSources;
import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.apache.commons.dbutils.DbUtils;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author huyongkun
 * @ClassName DJBCUtils
 * @create 2022-07-18 1:16
 * @Version 1.0
 * @description:
 */
public class JDBCUtils {



    //c3p0方式
    //数据库连接池只需要提供一个即可
    private static ComboPooledDataSource cpds = new ComboPooledDataSource("helloc3p0");
    //使用c3p0的数据库连接池技术
    public static Connection getConnection1() throws SQLException {
        Connection conn = cpds.getConnection();
        return conn;
    }





    //dbcp方式
    //使用DBCP数据库连接池技术获取数据库连接
    private static DataSource source = null;
    static{
        try {
            Properties pros = new Properties();
            InputStream is = DBCPTest.class.getClassLoader().getResourceAsStream("dbcp.properties");
            pros.load(is);
            //根据提供的BasicDataSourceFactory创建对应的DataSource对象
            source = BasicDataSourceFactory.createDataSource(pros);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static Connection getConnection2() throws Exception {
        Connection conn = source.getConnection();
        return conn;
    }



    //Druid方式
    //使用Gruid数据库连接池技术获取数据库连接
    private static DataSource sources1 = null;
    static {
        Properties pro = new Properties();
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("druid.properties");
        try {
            pro.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            sources1 = DruidDataSourceFactory.createDataSource(pro);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection3() throws Exception {
        Connection conn = source.getConnection();
        return conn;
    }




    //关闭连接和Statement的操作
    public static void closeResource(Connection conn, Statement ps){
        //5.资源的关闭
        if(ps != null){
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void closeResource(Connection conn, Statement ps, ResultSet resultSet){
        //5.资源的关闭
        if(ps != null){
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (resultSet !=null){
            try {
                resultSet.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }



    //使用DBUtils工具类关闭
    public static void closeResource1(Connection conn, Statement ps){
        try {
            DbUtils.close(conn);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            DbUtils.close(ps);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void closeResource1(Connection conn, Statement ps, ResultSet resultSet){
        DbUtils.closeQuietly(conn);
        DbUtils.closeQuietly(ps);
        DbUtils.closeQuietly(resultSet);
    }

}


