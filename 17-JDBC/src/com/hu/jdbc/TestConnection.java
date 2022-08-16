package com.hu.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author huyongkun
 * @ClassName TestConnection
 * @create 2022-08-08 0:39
 * @Version 1.0
 * @description: 连接数据库
 */
public class TestConnection {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        String url ="jdbc:mysql://localhost:3306/fruitdb";
        String user ="root";
        String password ="159357";
        Connection conn = DriverManager.getConnection(url, user, password);
        System.out.println(conn);
    }
}
