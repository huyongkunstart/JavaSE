package com.hu.test3;

/**
 * @author shkstart
 * @create 2022-05-06 8:46
 * @description：
 */
public class AccountTest {
    public static void main(String[] args) {
        Account account = new Account(1111,10000);
        AccountThread t1 = new AccountThread(account);
        AccountThread t2 = new AccountThread(account);
        t1.setName("t1");
        t2.setName("t2");

        t1.start();
        t2.start();
    }
}
