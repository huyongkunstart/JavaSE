package com.TeamSchedule.test1;

/**
 * 银行有一个账户。
 * 有两个储户分别向同一个账户存3000元，每次存1000，存3次。每次存完打
 * 印账户余额。
 * @author hu
 * @create 2021-11-03 10:38
 */

class Account{
    private double balance;

    public Account(double balance) {
        this.balance=balance;
    }
    //存钱
    public synchronized void deposit(double amt){
        try {
            Thread.sleep(5000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        if(amt>0){
            balance+=amt;
            System.out.println(Thread.currentThread().getName()+":存钱成功，余额为："+balance);
        }


    }
}

class Customer extends Thread{
    private Account acct;
    public Customer(Account acct){
        this.acct=acct;
    }
    @Override
    public void run() {

        for (int i = 0; i < 3; i++) {
            acct.deposit(1000);
        }
    }
}

public class AccountTest {
    public static void main(String[] args) throws InterruptedException {
        Account acct = new Account(0);
        Customer c1 = new Customer(acct);
        Customer c2 = new Customer(acct);
        c1.setName("甲");
        c2.setName("乙");

        c1.start();
        c2.start();
    }
}
