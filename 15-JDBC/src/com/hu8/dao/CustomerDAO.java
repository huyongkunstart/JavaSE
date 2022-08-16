package com.hu8.dao;

import com.hu3.bean.Customer;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

/**
 * @author huyongkun
 * @ClassName CustomerDAO
 * @create 2022-07-17 16:28
 * @Version 1.0
 * @description: 此接口用于规范针对于customers表的常用操作
 */
public interface CustomerDAO {

    /*
     * @Author huyongkun
     * @Date 16:37 2022/7/17
     * @Param [conn, cust]
     * @return void
     * @Description //添加一条记录
     **/
    public abstract void insert(Connection conn, Customer cust);

    /*
     * @Author huyongkun
     * @Date 16:38 2022/7/17
     * @Param [conn, id]
     * @return void
     * @Description //根据id，删除表中的一条记录
     **/
    void deleteById(Connection conn, int id);

    /*
     * @Author huyongkun
     * @Date 16:40 2022/7/17
     * @Param [conn, cust]
     * @return void
     * @Description //针对内存中的cust对象，去修改数据表中指定的记录
     **/
    void update(Connection conn, Customer cust);


    /*
     * @Author huyongkun
     * @Date 16:41 2022/7/17
     * @Param [conn, id]
     * @return void
     * @Description //针对指定id查询得到对应的Customer对象
     **/
    Customer getCustomerById(Connection conn, int id);

    /*
     * @Author huyongkun
     * @Date 16:43 2022/7/17
     * @Param [conn]
     * @return java.util.List<com.hu3.bean.Cusomer>
     * @Description //查询表中所有记录构成的集合
     **/
    List<Customer> getAll(Connection conn);

    /*
     * @Author huyongkun
     * @Date 16:44 2022/7/17
     * @Param [conn]
     * @return java.lang.Long
     * @Description //返回表中有多少记录
     **/
    Long getCount(Connection conn);

    /*
     * @Author huyongkun
     * @Date 16:45 2022/7/17
     * @Param [conn]
     * @return java.sql.Date
     * @Description //返回数据表中最大的生日
     **/
    Date getMaxBirth(Connection conn);

}
