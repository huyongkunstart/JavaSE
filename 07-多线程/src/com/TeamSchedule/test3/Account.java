package com.TeamSchedule.test3;

/**
 * @author shkstart
 * @create 2022-05-06 8:40
 * @description： 不使用线程同步机制，多线程对同一账户取款，出现线程安全问题
 */
public class Account {
    private int id;
    private double balance;

    public Account() {
    }

    public Account(int id, double balance) {
        this.id = id;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    public void withdraw(double money){
        //取款之前的余额
        double befor = balance;
        //取款之后的余额
        double after = befor - money;

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //更新余额
        balance = after;
    }
}


class AccountThread extends Thread{
    private Account acc;

    public AccountThread(Account acc) {
        this.acc = acc;
    }

    @Override  
    public void run() {
        acc.withdraw(5000);
        System.out.println(acc.getId()+"成功取款5000元，余额为"+acc.getBalance());
    }
}