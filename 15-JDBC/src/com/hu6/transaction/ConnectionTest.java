package com.hu6.transaction;

import com.hu3.util.JDBCUtils;
import org.testng.annotations.Test;

import java.sql.Connection;

/**
 * @author huyongkun
 * @ClassName ConnectionTest
 * @create 2022-07-17 14:45
 * @Version 1.0
 * @description: TODO
 */
public class ConnectionTest {
    @Test
    public void testGetConnection() throws Exception {
        Connection conn = JDBCUtils.getConnection();
        System.out.println(conn);
    }
}
