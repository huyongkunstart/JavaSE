package com.hu3.preparedstatement.curd;

import com.hu3.bean.Order;
import com.hu3.util.JDBCUtils;
import org.junit.Test;

import java.lang.reflect.Field;
import java.sql.*;

/**
 * @author hu
 * @Date 2022-02-19 16:15
 * @Description 针对order表的查询操作
 */
//针对于表的字段名与类的属性名不相同的情况：
    //1.必须声明sql时，使用类的属性名来命名字段的别名
    //2.使用ResultSetMetaData时，需要使用getColumnLabel()来替换getColumnName()，获取列的别名
    //没有取别名需要使用getColumnLabel（）获取的是列名
public class OrderForQuery {
    @Test
    public void testQuery1(){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();

            String sql = "select order_id,order_name,order_date from `order` where order_id = ?";
            ps = conn.prepareStatement(sql);
            ps.setObject(1,1);


            rs = ps.executeQuery();
            if(rs.next()){
                int id = (int)rs.getObject(1);
                String name =(String)rs.getObject(2);
                Date date = (Date) rs.getObject(3);
                Order order = new Order(id, name, date);
                System.out.println(order);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,ps,rs);
        }

    }


    //查询order表
    public static Order orderForQuery(String sql,Object ...args){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i+1,args[i]);
            }
            rs = ps.executeQuery();

            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            if (rs.next()){
                Order order = new Order();
                for (int i = 0; i < columnCount; i++) {
                    //获取每个列的列名
//                    String columnName = rsmd.getColumnName(i + 1);
                    //获取列的别名
                    String columnLabel = rsmd.getColumnLabel(i + 1);
                    //获取每个列的列值
                    Object columnValue = rs.getObject(i + 1);
                    ////给order对象指定的columnName属性，赋值为columnValue： 通过反射
                    Field field = Order.class.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(order,columnValue);
                }
                return order;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,ps,rs);
        }

        return null;
    }

    //数据库表的字段名和创建的类的属性名不一致，就导致了反射不能得到类的属性
    //解决方法是改变表的字段名，从查询语句中改变
    @Test
    public  void testorderForQuery(){
        String sql = "select order_id orderid,order_name ordername,order_date orderdata from `order` where order_id = ?";
        Order order = orderForQuery(sql, 1);
        System.out.println(order);
    }


}
