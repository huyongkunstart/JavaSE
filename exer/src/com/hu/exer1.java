package com.hu;

/**
 * @author shkstart
 * @create 2022-05-03 16:18
 * @description： 匿名类
 */
public class exer1 {
    public static void main(String[] args) {
        exer1 exer1 = new exer1();

        //1.非匿名实现类非匿名对象
        Flash flash = new Flash();
        exer1.Computer(flash);
        System.out.println("-------------------------------------------------");

        //2.非匿名实现类匿名对象
        exer1.Computer(new Printer());
        System.out.println("-------------------------------------------------");

        //3.匿名实现类 非匿名对象
        USB usb = new USB() {
            @Override
            public void start() {
                System.out.println("键盘开始工作");
            }

            @Override
            public void stop() {
                System.out.println("键盘结束工作");
            }
        };

        exer1.Computer(usb);
        System.out.println("-------------------------------------------------");

        //4.匿名实现类匿名对象
        exer1.Computer(new USB(){
            @Override
            public void start(){
                System.out.println("扩展屏开始工作");
            }
            @Override
            public void stop(){
                System.out.println("扩展屏结束工作");
            }
        });


    }



    public void Computer(USB usb){
        usb.start();
        System.out.println("开始传送数据");
        usb.stop();
    }

}





interface USB{
    public abstract void start();
    public abstract void stop();
}


class Flash implements USB{
    @Override
    public void start(){
        System.out.println("U盘开始工作");
    }

    @Override
    public void stop() {
        System.out.println("U盘结束工作");
    }
}
class Printer implements USB{
    @Override
    public void start(){
        System.out.println("打印机开始工作");
    }
    @Override
    public void stop(){
        System.out.println("打印机结束工作");
    }

}
