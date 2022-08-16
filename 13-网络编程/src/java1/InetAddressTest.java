package java1;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 通讯要素一：IP和端口号
 * 1.域名 ： www.baidu.com
 * 2. 本地回路地址： 127.0.0.1 对应着域名：Localhost
 *
 * 实例化InetAddress：两个方法：getByName(String host) / getLocalHost()
 * //获取域名方法 getHostName() 获取IP地址 getHostAddress()
 *
 * @author hu
 * @create 2022-01-26 16:21
 */
public class InetAddressTest {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress address1 = InetAddress.getByName("110.242.68.3");
        System.out.println(address1);

        InetAddress address2 = InetAddress.getByName("www.baidu.com");
        System.out.println(address2);

        InetAddress address3 = InetAddress.getByName("localhost");
        System.out.println(address3);

        //直接获取本机IP地址
        InetAddress localhost = InetAddress.getLocalHost();
        System.out.println(localhost);


        System.out.println("----------------------------------");
        //获取域名方法 getHostName() 获取IP地址 getHostAddress()
        System.out.println(address3.getHostName());
        System.out.println(address3.getHostAddress());


    }
}
