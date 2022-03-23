package com.hu4.exer;

import com.hu3.util.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

/**
 * @author hu
 * @Date 2022-02-21 10:26
 * @Description
 */
public class exer1Test {


    //通用的增删改操作
    public static int update(String sql,Object ...args){
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtils.getConnection();
            ps = conn.prepareStatement(sql);
            for (int i =0;i<args.length;i++){
                ps.setObject(i+1,args[i]);
            }
            /*
            execute():如果执行的是查询操作，有返回结果，此方法返回true
                      如果执行的是增删改操作，没有返回结果，此方法返回false
            */
//            ps.execute();
            return ps.executeUpdate(); //返回的是影响的行数
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,ps);
        }
        return 0;
    }

    //从控制台向数据库的表customers中插入一条数据
    @Test
    public void testInsert(){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String name = sc.next();
        System.out.println("请输入邮箱：");
        String email = sc.next();
        System.out.println("请输入生日：");
        String birthday = sc.next();

        String sql = "insert into customers(name,email,birth) values(?,?,?)";
        int insertCount = update(sql, name, email, birthday);
        if (insertCount>0){
            System.out.println("添加成功");
        }else {
            System.out.println("添加失败");
        }

    }


}
