package com.hu8.dao;

import com.hu3.util.JDBCUtils;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

/**
 * @author huyongkun
 * @ClassName BaseDAO
 * @create 2022-07-17 15:58
 * @Version 1.0
 * @description: 封装了针对于数据表的通用的操作
 */
public abstract class BaseDAO<T>{
    private Class<T> clazz = null;

    //获取当前BaseDAO的子类继承的父类中的泛型
    {
        Type genericSuperclass = this.getClass().getGenericSuperclass();
        ParameterizedType paramType = (ParameterizedType) genericSuperclass;

        Type[] actualTypeArguments = paramType.getActualTypeArguments(); //获取父类的泛型
        clazz = (Class<T>) actualTypeArguments[0]; //泛型的第一个参数
    }

    //通用的增删改操作
    public int update(Connection conn, String sql, Object ...args){
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


    //通用的查询操作,查询一条记录的
    public T Query1(Connection conn, String sql, Object ...args){
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


            if (rs.next()){
                T t = clazz.newInstance();
                for (int i = 0; i < rsmd.getColumnCount(); i++) {
                    Object columnvalue = rs.getObject(i + 1);
                    String columnLabel = rsmd.getColumnLabel(i + 1);
                    Field df = clazz.getDeclaredField(columnLabel);
                    df.setAccessible(true);
                    df.set(t,columnvalue);
                }
                return t;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtils.closeResource(null, ps, rs);
        }
        return null;
    }


    //通用的查询操作，查询多条记录的
    public List<T> Query2(Connection conn, String sql, Object ...args){
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


    //用于查询特殊值得通用的方法
    public <E> E getValue(Connection conn, String sql, Object ...args){
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            //填充占位符
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i+1, args[i]);
            }
            rs = ps.executeQuery();
            if(rs.next()){
                return (E)rs.getObject(1);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtils.closeResource(null, ps, rs);
        }
        return null;
    }
}
