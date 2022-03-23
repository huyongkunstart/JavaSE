package java2;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 实现TCP的网络编程
 * 例子1：客户端发送信息给服务端，服务端将数据显示在控制台上
 *
 * @author hu
 * @create 2022-01-26 17:09
 */
public class TCPTest1 {
    //客户端
    @Test
    public void test1(){
        Socket socket = null;
        OutputStream os = null;
        try {
            //1.创建socket对象，指明服务器端的IP和端口号
            InetAddress inet = InetAddress.getByName("127.0.0.1");
            socket = new Socket(inet,8899);

            //2.获取一个输出流，用于输出数据
            os = socket.getOutputStream();

            //3.写出数据的操作
            os.write("你好，我是客户端mm".getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.资源的关闭
            if(os != null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //服务端
    @Test
    public void test2(){
        ServerSocket ss = null;
        Socket socket = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;
        try {
            //1.创建服务器端的ServerSocket，指明自己的端口号
            ss = new ServerSocket(8899);

            //2.调用accept()表示接受来自客户端的socket
            socket = ss.accept();

            //3.获取输入流
            is = socket.getInputStream();

            //可能会有乱码
//        byte[] bytes = new byte[20];
//        int len;
//        while ((len = is.read(bytes)) != null){
//            String s = new String(bytes, 0,len);
//            System.out.print(s);
//        }

            //4.读取输入流中的数据
            baos = new ByteArrayOutputStream();
            byte[] bytes = new byte[5];
            int len;
            while ((len = is.read(bytes)) != -1){
                baos.write(bytes,0,len); //baos对象流不会直接翻译成字符，等结束再一起翻译成字符
            }
            System.out.println(baos.toString());
            System.out.println("收到来自"+socket.getInetAddress().getHostName()+"的数据");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            if(baos != null){
                //5.关闭资源
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(is != null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(ss != null){
                try {
                    ss.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }





}
