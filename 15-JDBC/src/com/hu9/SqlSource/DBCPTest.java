package com.hu9.SqlSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.testng.annotations.Test;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author huyongkun
 * @ClassName DBCPTest
 * @create 2022-07-18 1:22
 * @Version 1.0
 * @description: 测试DBCP数据库连接池
 */
public class DBCPTest {

    //方式一
    @Test
    public void testGetConnection() throws SQLException {
        //创建了DBCP的数据库连接池
        BasicDataSource source = new BasicDataSource();

        //设置基本信息
        source.setDriverClassName("com.mysql.jdbc.Driver");
        source.setUrl("jdbc:mysql:///test");
        source.setUsername("root");
        source.setPassword("159357");

        //还可以设置其它涉及数据库连接池管理的相关属性
        source.setInitialSize(10);
        source.setMaxActive(10);

        Connection conn = source.getConnection();
        System.out.println(conn);

    }

    //方式二 使用配置文件
    @Test
    public void testGetConnection1() throws Exception {
        Properties pro = new Properties();
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("dbcp.properties");
        pro.load(is);
        DataSource source = BasicDataSourceFactory.createDataSource(pro);

        Connection conn = source.getConnection();
        System.out.println(conn);
    }

}
