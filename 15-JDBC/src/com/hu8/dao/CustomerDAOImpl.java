package com.hu8.dao;

import com.hu3.bean.Customer;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

/**
 * @author huyongkun
 * @ClassName CustomerDAOImpl
 * @create 2022-07-17 16:47
 * @Version 1.0
 * @description: TODO
 */
public class CustomerDAOImpl extends BaseDAO<Customer> implements CustomerDAO {

    //插入
    @Override
    public void insert(Connection conn, Customer cust) {
        String sql = "insert into Customers(name, email, birth) values(?,?,?)";
        update(conn, sql, cust.getName(),cust.getEmail(),cust.getBirth());
    }
    //删除
    @Override
    public void deleteById(Connection conn, int id) {
        String sql = "delete from Customers where id = ?";
        update(conn, sql, id);
    }
    //更新
    @Override
    public void update(Connection conn, Customer cust) {
        String sql = "update Customers set name = ?, email = ?, birth = ? where id = ?";
        update(conn, sql, cust.getName(), cust.getEmail(), cust.getBirth(), cust.getId());
    }

    //查询
    @Override
    public Customer getCustomerById(Connection conn, int id) {
        String sql = "select id, name, email, birth from Customers where id = ?";
        Customer customer = Query1(conn, sql, id);
        return customer;
    }

    //返回所有记录
    @Override
    public List<Customer> getAll(Connection conn) {
        String sql = " select id, name, email, birth from Customers";
        List<Customer> list = Query2(conn, sql);
        return list;
    }

    //获取记录数
    @Override
    public Long getCount(Connection conn) {
        String sql  = "select count(*) from Customers";
        return getValue(conn, sql);
    }
    //获取最大
    @Override
    public Date getMaxBirth(Connection conn) {
        String sql = "select max(birth) from Customers";
        return getValue(conn,sql);
    }
}
