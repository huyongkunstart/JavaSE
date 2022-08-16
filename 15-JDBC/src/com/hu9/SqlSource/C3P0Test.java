package com.hu9.SqlSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.DataSources;
import org.testng.annotations.Test;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author huyongkun
 * @ClassName C3P0Test
 * @create 2022-07-18 0:49
 * @Version 1.0
 * @description: C3P0数据库连接池
 */
public class C3P0Test {
    //方式一
    @Test
    public void testGetConnection() throws PropertyVetoException, SQLException {
        //获取C3P0数据库连接池
        ComboPooledDataSource source = new ComboPooledDataSource();
        source.setDriverClass( "com.mysql.jdbc.Driver" ); //loads the jdbc driver
        source.setJdbcUrl( "jdbc:mysql://localhost:3306/test" );
        source.setUser("root");
        source.setPassword("159357");

        //通过设置相关的参数，对数据库连接池进行管理
        //设置初始时数据库连接池中的连接数
        source.setInitialPoolSize(10);

        Connection conn = source.getConnection();
        System.out.println(conn);

        //销毁c3p0数据库连接池
//        DataSources.destroy(cpds);
    }

    //方式二 使用配置文件
    @Test
    public void testGetConnection1() throws SQLException {
        ComboPooledDataSource cpds = new ComboPooledDataSource("helloc3p0");
        Connection conn = cpds.getConnection();
        System.out.println(conn);
    }
}
