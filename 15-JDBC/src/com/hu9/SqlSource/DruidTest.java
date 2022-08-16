package com.hu9.SqlSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.sun.xml.internal.bind.v2.model.core.ID;
import org.testng.annotations.Test;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author huyongkun
 * @ClassName DruidTest
 * @create 2022-07-18 1:46
 * @Version 1.0
 * @description: TODO
 */
public class DruidTest {
    @Test
    public void getConnection() throws Exception {
        Properties pro = new Properties();
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("druid.properties");
        pro.load(is);

        DataSource ds = DruidDataSourceFactory.createDataSource(pro);
        Connection conn = ds.getConnection();
        System.out.println(conn);

    }

    @Test
    public void aaa() throws Exception{
        Properties pro = new Properties();
        InputStream rs = ClassLoader.getSystemClassLoader().getResourceAsStream("druid.properties");
        pro.load(rs);
        DataSource dataSource = DruidDataSourceFactory.createDataSource(pro);
        Connection conn = dataSource.getConnection();
        System.out.println(conn);
    }
}
