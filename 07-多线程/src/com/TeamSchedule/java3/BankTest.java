package com.TeamSchedule.java3;

/**
 * 使用同步机制将单例模式中的懒汉式改写为线程安全的
 * @author hu
 * @create 2021-10-29 16:44
 */
public class BankTest {
    public static void main(String[] args) {
 
    }
}

class Bank{
    private Bank(){};
    private static Bank bank = null;

    public static Bank getBank(){
        if (bank == null){
            synchronized (Bank.class){
                if (bank == null){
                    bank = new Bank();
                }
            }
        }
        return bank;
    }
}

