package com.hu1.connection;

import com.hu3.bean.Cusomer;
import com.hu3.util.JDBCUtils;
import org.testng.annotations.Test;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author shkstart
 * @create 2022-03-04 16:36
 * Document: 通用的
 */
public class Test1 {


    //通用的增删改操作
    public void testUpdate1(String sql,Object ...args){
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            //获取连接
            conn = JDBCUtils.getConnection();
            //预处理sql
            ps = conn.prepareStatement(sql);
            //填充占位符
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i+1,args[i]);
            }
            //执行sql指令
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            JDBCUtils.closeResource(conn,ps);
        }
    }


    //通用的查询操作:查询一条
    public <T> T testQuery(Class<T> clazz,String sql,Object ...args){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            //获取连接
            conn = JDBCUtils.getConnection();
            //预执行sql
            ps = conn.prepareStatement(sql);
            //填充占位符
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i+1,args[i]);
            }
            //执行sql指令
            rs = ps.executeQuery();
            //获取结果集的元数据
            ResultSetMetaData rsmd = rs.getMetaData();

            if (rs.next()){
                T t = clazz.newInstance();
                for (int i = 0; i < rsmd.getColumnCount(); i++) {
                    //获取字段的值
                    Object columnvalue = rs.getObject(i + 1);
                    //获取字段别名
                    String columnLabel = rsmd.getColumnLabel(i + 1);

                    //通过反射，给t对象赋值
                    Field field = clazz.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(t,columnvalue);
                }
                return t;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            JDBCUtils.closeResource(conn,ps,rs);
        }
        return null;
    }


    //查询任意表的多条记录
    public <T> List<T> TestQuery2(Class<T> clazz,String sql,Object ...args){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            //获取连接
             conn = JDBCUtils.getConnection();
            //预处理sql语句
             ps = conn.prepareStatement(sql);
            //填充占位符
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i+1,args[i]);
            }

            //执行sql语句
             rs = ps.executeQuery();
            //获取结果集的元数据
            ResultSetMetaData rsmd = rs.getMetaData();
            //创建List集合
            List<T> list = new ArrayList<>();

            while (rs.next()){
                T t = clazz.newInstance();
                for (int i = 0; i < rsmd.getColumnCount(); i++) {
                    //获取字段值
                    Object columnvalue = rs.getObject(i + 1);
                    //获取字段别名
                    String columnLabel = rsmd.getColumnLabel(i + 1);

                    //通过反射 给属性赋值
                    Field field = clazz.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(t,columnvalue);
                }

                list.add(t);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            JDBCUtils.closeResource(conn,ps,rs);
        }
        return null;
    }




    //测试
    @Test
    public void test1(){
        String sql = "select id,name,email,birth from customers where id < ?";

        List<? extends Cusomer> cusomers = TestQuery2(Cusomer.class, sql, 5);
        Iterator<? extends Cusomer> iterator = cusomers.iterator();
        while (iterator.hasNext()){
            Cusomer next = iterator.next();
            System.out.println(next);
        }
    }




}
