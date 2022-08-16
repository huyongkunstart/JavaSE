package com.hu10.dbUtils;

import com.hu3.bean.Customer;
import com.hu9.SqlSource.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.*;
import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @author huyongkun
 * @ClassName QueryRunnerTest
 * @create 2022-07-18 2:07
 * @Version 1.0
 * @description: commons-dbutils是Apache组织提供的一个开源JDBC工具类库，封装了针对于数据库的增删改查操作
 *
 */
public class QueryRunnerTest {
    //插入一条记录
    @Test
    public void testInsert() throws Exception{
        QueryRunner runner = new QueryRunner();
        Connection conn = JDBCUtils.getConnection3();
        String sql = "insert into customers(name,email,birth) values(?,?,?)";
        int a = runner.update(conn, sql, "小李子", "小李子@126.com", "1949-12-12");
        if(a > 0){
            System.out.println("添加成功");
        }else{
            System.out.println("添加失败");
        }
        conn.close();
    }

    //删除一条数据
    @Test
    public void testdelete() throws Exception{
        QueryRunner runner = new QueryRunner();
        Connection conn = JDBCUtils.getConnection3();
        String sql = "delete from customers where id = ?";
        int update = runner.update(conn, sql, 21);
        if(update > 0){
            System.out.println("删除成功");
        }else{
            System.out.println("删除失败");
        }
        conn.close();
    }

    //查询一条记录
    @Test
    public void testQuery1() throws Exception{
        QueryRunner runner = new QueryRunner();
        Connection conn = JDBCUtils.getConnection3();
        String sql = "select id,name, email, birth from customers where id = ?";
        BeanHandler<Customer> customers = new BeanHandler<Customer>(Customer.class);
        Customer customer = runner.query(conn, sql, customers, 18);
        System.out.println(customer);
        conn.close();
    }

    //查询多条记录
    @Test
    public void testQuery2() throws Exception{
        QueryRunner runner = new QueryRunner();
        Connection conn = JDBCUtils.getConnection3();
        String sql = "select id,name,email,birth from customers";
        BeanListHandler<Customer> customer = new BeanListHandler<Customer>(Customer.class);

        List<Customer> query = runner.query(conn, sql, customer);
        query.forEach(System.out::println);
        conn.close();
    }


    //MapHandler的使用
    @Test
    public void testMapHandler() throws Exception{
        QueryRunner runner = new QueryRunner();
        Connection conn = JDBCUtils.getConnection3();
        String sql = "select id,name,email,birth from customers where id = ?";
        MapHandler mapHandler = new MapHandler();
        Map<String, Object> query = runner.query(conn, sql, mapHandler, 20);
        System.out.println(query);
    }

    //MapListHandler的使用
    @Test
    public void testMapListHandler() throws Exception{
        QueryRunner runner = new QueryRunner();
        Connection conn = JDBCUtils.getConnection3();
        String sql = "select id,name,email,birth from customers";
        MapListHandler mapListHandler = new MapListHandler();
        List<Map<String, Object>> query = runner.query(conn, sql, mapListHandler);
        query.forEach(System.out::println);
    }

    //ScalarHandler的使用
    @Test
    public void testScalarHandler() throws Exception{
        QueryRunner runner = new QueryRunner();
        Connection conn = JDBCUtils.getConnection3();
        String sql = "select max(birth)from customers";
        ScalarHandler scalarHandler = new ScalarHandler();
        Object query = runner.query(conn, sql, scalarHandler);
        System.out.println(query);
    }


    //自定义ResultSetHandler的实现类
    @Test
    public void testResultSetHandler() throws Exception{
        QueryRunner runner = new QueryRunner();
        Connection conn = JDBCUtils.getConnection3();
        String sql = "select id,name,email,birth from customers where id = ?";

        //自定义ResultSetHandler
        ResultSetHandler<Customer> r = new ResultSetHandler<Customer>() {
            //仿BeanHandler
            @Override
            public Customer handle(ResultSet resultSet) throws SQLException {
                if(resultSet.next()){
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String email = resultSet.getString("email");
                    Date birth = resultSet.getDate("birth");
                    return new Customer(id,name,email,birth);
                }
                return null;
            }
        };

        Customer query = runner.query(conn, sql, r, 8);
        System.out.println(query);
    }

}
