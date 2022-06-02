package com.TeamSchedule;

/**
 * @author shkstart
 * @create 2022-05-10 13:07
 * @description： 生产者消费者问题
 */
public class exer5 {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Producer producer = new Producer(clerk);
        Consumer consumer = new Consumer(clerk);
        Thread t1 = new Thread(producer);
        Thread t2 = new Thread(consumer);
        t1.setName("生产者");
        t2.setName("消费者");
        t1.start();
        t2.start();
    }
}




//店员
class Clerk{
    private int productCount = 0;
    //生产产品
    public synchronized void produceProduct(){
        if(productCount < 20){
            productCount++;
            System.out.println(Thread.currentThread().getName() + "开始生产第"+productCount+"个产品");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            notify();
        }else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //消费产品
    public synchronized void consumerProduct(){
        if(productCount > 0){
            System.out.println(Thread.currentThread().getName()+"开始消费第"+productCount+"个产品");
            productCount--;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            notify();
        }else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

//生产者
class Producer implements Runnable{
    private Clerk clerk;
    public Producer(Clerk clerk){
        this.clerk =clerk;
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"开始生产产品。。。。");
        for (int i = 0; i < 100; i++) {
            clerk.produceProduct();
        }
    }
}

//消费者
class Consumer implements Runnable{
    private Clerk clerk;
    public Consumer(Clerk clerk){
        this.clerk =clerk;
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"开始消费产品。。。。");
        for (int i = 0; i < 100; i++) {
            clerk.consumerProduct();
        }
    }
}
