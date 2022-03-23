package com.hu3.bean;

import java.sql.Date;

/**
 * @author hu
 * @Date 2022-02-19 16:23
 * @Description
 */
public class Order {
    private int orderid;
    private String ordername;
    private Date orderdata;

    public Order() {
    }

    public Order(int orderid, String ordername, Date orderdata) {
        this.orderid = orderid;
        this.ordername = ordername;
        this.orderdata = orderdata;
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public String getOrdername() {
        return ordername;
    }

    public void setOrdername(String ordername) {
        this.ordername = ordername;
    }

    public Date getOrderdata() {
        return orderdata;
    }

    public void setOrderdata(Date orderdata) {
        this.orderdata = orderdata;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderid=" + orderid +
                ", ordername='" + ordername + '\'' +
                ", orderdata=" + orderdata +
                '}';
    }
}
