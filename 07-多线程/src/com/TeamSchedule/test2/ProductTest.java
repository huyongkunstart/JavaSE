package com.TeamSchedule.test2;

/**
 *     生产者/消费者问题
 * 生产者(Productor)将产品交给店员(Clerk)，而消费者(Customer)从店员处
 * 取走产品，店员一次只能持有固定数量的产品(比如:20），如果生产者试图
 * 生产更多的产品，店员会叫生产者停一下，如果店中有空位放产品了再通
 * 知生产者继续生产；如果店中没有产品了，店员会告诉消费者等一下，如
 * 果店中有产品了再通知消费者来取走产品
 * @author hu
 * @create 2021-11-03 13:27
 */


//店员
class Clerk{
    private int productCount = 0;
    //生产产品
    public synchronized void produceProduct() {
        if(productCount < 20){
            productCount++;
            System.out.println(Thread.currentThread().getName()+":开始生产第"+productCount+"个产品");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            notify();
        }else{
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    //消费产品
    public synchronized void consumeProduct() {
        if(productCount > 0 ){
            System.out.println(Thread.currentThread().getName()+":开始消费第"+productCount+"个产品");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            productCount--;
            notify();
        }else{
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

//生产者
class Producer extends Thread{
    private  Clerk clerk;
    public Producer(Clerk clerk){
        this.clerk=clerk;
    }
    @Override
    public void run() {
        System.out.println(getName()+":开始生产产品。。。");

        for (int i = 0; i < 100; i++) {
            clerk.produceProduct();
        }

    }
}

//消费者
class Consumer extends Thread{
    private Clerk clerk;
    public Consumer(Clerk clerk){
        this.clerk=clerk;
    }

    @Override
    public void run() {
        System.out.println(getName()+":开始消费产品。。。");

        for (int i = 0; i < 100; i++) {
            clerk.consumeProduct();
        }
    }
}


public class ProductTest {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();

        Producer p1 = new Producer(clerk);
        Consumer c1 = new Consumer(clerk);
        p1.setName("生产者1");
        c1.setName("消费者2");
        p1.start();
        c1.start();

    }
}
