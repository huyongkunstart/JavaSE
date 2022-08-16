package com.hu9.SqlSource.MyPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


/**
 * @author huyongkun
 * @ClassName TestMyPool
 * @create 2022-07-19 15:16
 * @Version 1.0
 * @description: TODO
 */
public class TestMyPool {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        MyPool myPool = new MyPool();

        try {
            conn = myPool.getConnection();
            ps = conn.prepareStatement("select * from userinfo where username = ?");
            ps.setObject(1,"张三");
            rs = ps.executeQuery();
            while (rs.next()){
                //...
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            myPool.returnConnection(conn,ps,rs);
        }
    }
}
