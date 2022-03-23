package java6;

//静态代理举例
/**
 * @author hu
 * @create 2022-02-02 21:15
 */

interface ClothFactory {
    public abstract  void produceCloth();
}

//被代理类
class NikeClothFactory implements ClothFactory{

    @Override
    public void produceCloth() {
        System.out.println("耐克工厂生产一批运动服");
    }
}


//代理类
class ProxyClothFactory implements ClothFactory{
    private ClothFactory factory; //用被代理类对象进行实例化

    public ProxyClothFactory(ClothFactory factory){
        this.factory = factory;
    }

    @Override
    public void produceCloth() {
        System.out.println("代理工厂做一些准备工作");

        factory.produceCloth();

        System.out.println("代理工厂做一些后续收尾工作");

    }

}



public class StaticProxyTest {
    public static void main(String[] args) {
        //创建被代理类对象
        NikeClothFactory nike = new NikeClothFactory();

        //创建代理类对象
        ProxyClothFactory pf = new ProxyClothFactory(nike);

        pf.produceCloth();
    }
}
