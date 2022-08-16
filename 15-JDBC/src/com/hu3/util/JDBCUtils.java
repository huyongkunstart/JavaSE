package com.hu3.util;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
/**
 * 操作数据库的工具类
 * @author hu
 * @create 2022-02-18 16:15
 */
public class JDBCUtils {

    
    //获取数据库连接
    public static Connection getConnection() throws Exception{
        //1.读取配置文件中的基本信息
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");
        Properties ps = new Properties();
        ps.load(is);

        String user = ps.getProperty("user");
        String password = ps.getProperty("password");
        String url = ps.getProperty("url");
        String driverClass = ps.getProperty("driverClass");

        //加载驱动
        Class.forName(driverClass);

        //获取连接
        Connection conn = DriverManager.getConnection(url, user, password);

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

    //通用的增删改操作
    public static void update(String sql,Object ...args){
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtils.getConnection();
            ps = conn.prepareStatement(sql);
            for (int i =0;i<args.length;i++){
                ps.setObject(i+1,args[i]);
            }
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,ps);
        }
    }

    //通用的查询操作，多条返回值
    public static <T> List<T> Query(Class<T> clazz, String sql, Object ...args){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i+1, args[i]);
            }

            rs = ps.executeQuery();

            ResultSetMetaData rsmd = rs.getMetaData();
            ArrayList<T> list = new ArrayList<>();

            while (rs.next()){
                T t = clazz.newInstance();
                for (int i = 0; i < rsmd.getColumnCount(); i++) {
                    Object columnvalue = rs.getObject(i + 1);
                    String columnLabel = rsmd.getColumnLabel(i + 1);
                    Field df = clazz.getDeclaredField(columnLabel);
                    df.setAccessible(true);
                    df.set(t,columnvalue);
                }
                list.add(t);
            }
            return list;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtils.closeResource(conn, ps, rs);
        }
        return null;
    }


    //批量插入方式 设置连接不允许提交数据
    public void testInsert3() throws Exception{
        long start = System.currentTimeMillis();
        Connection conn = JDBCUtils.getConnection();
        //设置不允许自动提交数据
        conn.setAutoCommit(false);
        String sql = "insert into goods(name) values(?)";
        PreparedStatement ps = conn.prepareStatement(sql);


        for (int i = 0; i < 20000; i++) {
            ps.setObject(1,"name_"+i);

            //1."攒"sql
            ps.addBatch();
            if(i%500 == 0){
                //2.执行batch
                ps.executeBatch();
                //3.清空batch
                ps.clearBatch();
            }
        }
        //提交数据
        conn.commit();
        long end = System.currentTimeMillis();
        System.out.println("花费的时间为："+(end-start));  //花费的时间为：558
        JDBCUtils.closeResource(conn,ps);
    }
}
