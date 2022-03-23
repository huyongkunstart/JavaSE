package com.hu3.preparedstatement.curd;

import com.hu3.bean.Cusomer;
import com.hu3.util.JDBCUtils;
import org.junit.Test;

import java.lang.reflect.Field;
import java.sql.*;

/**
 * @author hu
 * @Date 2022-02-19 15:03
 * @Description 针对customers表的查询操作 和 针对customers表的通用的查询操作
 */
public class CustomerForQuery {
    @Test
    public void testQueryForCustomers(){
        String sql = "select id,name,birth,email from customers where id = ?";
        Cusomer cusomer = QueryForCustomers(sql, 13);
        System.out.println(cusomer);
    }

    //针对customers表的通用的查询操作
    public static Cusomer QueryForCustomers(String sql , Object ...args){
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
            //获取结果集的元数据：ResultSetMetaData
            ResultSetMetaData rsmd = rs.getMetaData();
            //通过ResultSetMetaData获取结果集中的列数
            int columnCount = rsmd.getColumnCount();

            if(rs.next()){
                Cusomer cust = new Cusomer();
                //处理结果集一行数据中的每一列
                for (int i = 0; i < columnCount; i++) {
                    //获取列值
                    Object columValue = rs.getObject(i + 1);
                    //获取每个列的列名
//                    String columnName = rsmd.getColumnName(i + 1);
                    //获取列的别名
                    String columnLabel = rsmd.getColumnLabel(i + 1);
                    //给cust对象指定的columnName属性，赋值为columnValue： 通过反射
                    Field field = Cusomer.class.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(cust,columValue);
                }
                return cust;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //资源的关闭
            JDBCUtils.closeResource(conn,ps,rs);

        }

        return null;

    }




    //customers表的查询操作
    @Test
    public void testQurty(){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select id,name,email,birth from customers where id = ?";
            ps = conn.prepareStatement(sql);

            ps.setObject(1,1);

            //执行并返回结果集
            resultSet = ps.executeQuery();
            //处理结果集
            //next():判断结果集的下一条是否有数据，如果有数据返回true，并且指针下移，没有数据指针不下移
            if(resultSet.next()){
                //获取当前这条数据的各个字段值
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String email = resultSet.getString(3);
                Date birth = resultSet.getDate(4);
                //方式一
    //            System.out.println("id = "+id+",name = "+name+",emai = "+email+",birth = "+birth);
                //方式二 数组
    //            Object[] data = new Object[]{id,name,email,birth};

                //方式三 将数据封装成一个对象
                Cusomer cusomer = new Cusomer(id, name, email, birth);
                System.out.println(cusomer);

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            JDBCUtils.closeResource(conn,ps,resultSet);
        }
    }


}
