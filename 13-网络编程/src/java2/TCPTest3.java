package java2;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 实现TCP的网络编程
 * 例子3: 从客户端发送文件给服务端，服务端保存到本地。并返回“发送成功”给
 *       客户端。并关闭相应的连接。
 * @author hu
 * @create 2022-01-26 21:57
 */
public class TCPTest3 {
    //客户端
    @Test
    public void Client() throws IOException {
        //1.创建socket对象，指明服务端的IP和端口号
        InetAddress inet = InetAddress.getByName("127.0.0.1");
        Socket socket = new Socket(inet, 9090);

        //2.获取一个输出流用于输出数据
        OutputStream os = socket.getOutputStream();

        //3.获取BufferedInputStream流。读取文件
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("1.jpg"));

        //4.数据的读取和写入
        byte[] bytes = new byte[1024];
        int len;
        while ((len = bis.read(bytes)) != -1){
            os.write(bytes,0,len);
        }
        //关闭数据的输出
        socket.shutdownOutput();

        //5.接收到来自服务器端的数据，并显示到控制台
        InputStream is = socket.getInputStream();
        ByteArrayOutputStream bais = new ByteArrayOutputStream();
        byte[] bytes1 = new byte[5];
        int len2;
        while ((len2 = is.read(bytes)) != -1){
            bais.write(bytes,0,len2);
        }
        System.out.println(bais.toString());

        //6.资源关闭
        bais.close();
        is.close();
        bis.close();
        os.close();
        socket.close();

    }

    //服务端
    @Test
    public void Server() throws IOException {
        //1.创建服务器端的ServerSocket，指明自己的端口号
        ServerSocket ss = new ServerSocket(9090);
        //2.调用accept()表示接受来自客户端的socket
        Socket socket = ss.accept();
        //3.获取输入流
        InputStream is = socket.getInputStream();
        //4.获取BufferedOutputStream流，写入文件
        BufferedOutputStream  bos = new BufferedOutputStream(new FileOutputStream(new File("1-2.jpg")));

        //5.数据的读取和写入
        byte[] bytes = new byte[1024];
        int len;
        while ((len = is.read(bytes)) != -1){
            bos.write(bytes,0,len);
        }
        System.out.println("接收到来自"+socket.getInetAddress().getHostAddress()+"的数据");
        System.out.println("文件传输完毕");
        //6.服务器端给予客户端反馈
        OutputStream os = socket.getOutputStream();
        os.write("服务端：文件我已经收到".getBytes());


        //7.资源的关闭
        os.close();
        bos.close();
        is.close();
        socket.close();
        ss.close();

    }


}


