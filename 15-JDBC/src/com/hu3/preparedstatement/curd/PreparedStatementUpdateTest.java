package com.hu3.preparedstatement.curd;

import com.hu3.util.JDBCUtils;
import org.junit.Test;

import java.io.InputStream;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Properties;

/**
 * @author hu
 * @create 2022-02-18 14:39
 */
//使用PreparedStatement来替换Statement，实现对数据表的增删改查操作
//增删改；查
public class PreparedStatementUpdateTest {

    //测试update方法
    @Test
    public void testUpdate(){
        String sql = "delete from customers where id = ?";
        update(sql,20);
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

    //向customers表中添加一条记录
    @Test
    public void testInsert(){
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            //1.获取连接
            InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");
            Properties pros = new Properties();
            pros.load(is);

            String user = pros.getProperty("user");
            String password = pros.getProperty("password");
            String url = pros.getProperty("url");
            String driverClass = pros.getProperty("driverClass");

            Class.forName(driverClass);

            conn = DriverManager.getConnection(url, user, password);

            //2.预编译sql语句，返回PreparedStatement的实例
            String sql = "insert into customers(name,email,birth) values(?,?,?)";//?:占位符
            ps = conn.prepareStatement(sql);

            //3.填充占位符
            ps.setString(1,"哪吒");
            ps.setString(2,"nezha@gmail.com");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date date = sdf.parse("1000-01-12");
            ps.setDate(3,new Date(date.getTime()));

            //4.执行sql操作
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //5.资源的关闭
            if(ps != null){
                try {
                    ps.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }

        }
    }


    //修改customer表的一条记录
    @Test
    public void PreparedStatementUpdateTest(){
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            //1,获取数据库连接
            conn = JDBCUtils.getConnection();
            //2.预编译sql语句，返回PreparedStatement实例
            String sql = "update customers set name=? where id=?";
            ps = conn.prepareStatement(sql);
            //3.填充占位符
            ps.setObject(1,"莫扎特");
            ps.setObject(2,18);
            //4.执行
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //5.资源的关闭
            JDBCUtils.closeResource(conn,ps);
        }


    }

    //删除一条记录
    @Test
    public void PreparedStatementDeleteTets(){
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "delete from customers where id = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,19);
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,ps);
        }
    }





}
