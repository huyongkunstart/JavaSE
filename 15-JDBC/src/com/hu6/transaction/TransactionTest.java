package com.hu6.transaction;

import com.hu3.util.JDBCUtils;
import org.testng.annotations.Test;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author huyongkun
 * @ClassName TransactionTest
 * @create 2022-07-17 14:48
 * @Version 1.0
 * @description: TODO
 */
public class TransactionTest {

    /*
    针对于数据表user_table来说:
    AA用户给BB用户转账100
    update user_table set balance = balance - 100 where user = 'AA';
    update user_table set balance = balance + 100 where user = 'BB';
     */
    @Test
    public void test1(){
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql1 = "update user_table set balance = balance - 100 where user = ?";
            update(conn, sql1,"AA");
            //出现异常
            //...
            String sql2 = "update user_table set balance = balance + 100 where user = ?";
            update(conn, sql1,"BB");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //方式二
    @Test
    public void test2(){
        Connection conn = null;

        try {
            conn = JDBCUtils.getConnection();
            System.out.println(conn.getAutoCommit()); //true
            // 关闭自动提交
            conn.setAutoCommit(false);

            String sql1 = "update user_table set balance = balance - 100 where user = ?";
            update(conn, sql1,"AA");
            //出现异常
            //...
            String sql2 = "update user_table set balance = balance + 100 where user = ?";
            update(conn, sql1,"BB");

            System.out.println("转账成功");

            conn.commit();

        }catch (Exception e){
            e.printStackTrace();
            try {
                assert conn != null;
                conn.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }finally {
            try {
                conn.setAutoCommit(true);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            JDBCUtils.closeResource(conn, null);
        }
    }


    //通用的增删改操作
    public static int update(Connection conn, String sql, Object ...args){
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            for (int i =0;i<args.length;i++){
                ps.setObject(i+1,args[i]);
            }
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.closeResource(null,ps);
        }
        return 0;
    }




    //---------------------------------------------------------------------------------------
    //隔离级别
    @Test
    public void testtransactionSelect() throws Exception {
        Connection conn = JDBCUtils.getConnection();
        //获取当前连接的隔离级别
        System.out.println(conn.getTransactionIsolation());
        //设置数据库的隔离级别
        conn.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
        //取消自动提交数据
        conn.setAutoCommit(false);

    }
    //通用的查询操作，多条返回值
    public static <T> List<T> Query(Connection conn, Class<T> clazz, String sql, Object ...args){
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
            JDBCUtils.closeResource(null, ps, rs);
        }
        return null;
    }




}
