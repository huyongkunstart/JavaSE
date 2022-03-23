package java4;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author hu
 * @create 2022-01-26 23:29
 */
public class URLTest {
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://192.168.1.100:8080/helloworld/index.jsp#a?username=shkstart&password=123");

        //常用方法
//        public String getProtocol( ) 获取该URL的协议名
        System.out.println(url.getProtocol());
//        public String getHost( ) 获取该URL的主机名
        System.out.println(url.getHost());
//        public String getPort( ) 获取该URL的端口号
        System.out.println(url.getPort());
//        public String getPath( ) 获取该URL的文件路径
        System.out.println(url.getPath());
//        public String getFile( ) 获取该URL的文件名
        System.out.println(url.getFile());
//        public String getQuery( ) 获取该URL的查询名
        System.out.println(url.getQuery());


    }
}
