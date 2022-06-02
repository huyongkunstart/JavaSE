package com.TeamSchedule;

/**
 * @author shkstart
 * @create 2022-05-03 16:31
 * @description： 代理模式
 */
public class exer2 {
    public static void main(String[] args) {
        ProxyServer proxyServer = new ProxyServer(new Server());
        proxyServer.Brown();
    }
}

interface NetWork{
    public abstract void Brown();
}

//被代理类
class Server implements NetWork{

    @Override
    public void Brown() {
        System.out.println("我是被代理类");
    }
}

//代理类
class ProxyServer implements NetWork{

    public NetWork netWork;

    public ProxyServer(NetWork netWork){
        this.netWork = netWork;
    }
    public void check(){
        System.out.println("我是代理类");
    }

    @Override
    public void Brown() {
        check();
        netWork.Brown();
    }
}