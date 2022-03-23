package java2;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**实现TCP的网络编程
 * 例子2：客户端发送文件给服务端，服务端将文件保存在本地。
 *
 * @author hu
 * @create 2022-01-26 20:02
 */
public class TCPTest2 {

    //客户端
    @Test
    public void Client(){
        Socket socket = null;
        OutputStream os = null;
        BufferedInputStream bis = null;
        try {
            //1.创建socket对象，指明服务端的IP和端口号
            InetAddress inet = InetAddress.getByName("127.0.0.1");
            socket = new Socket(inet, 9090);

            //2.获取一个输出流用于输出数据
            os = socket.getOutputStream();

            //3.获取BufferedInputStream流。读取文件
            bis = new BufferedInputStream(new FileInputStream("1.jpg"));

            //4.数据的读取和写入
            byte[] bytes = new byte[1024];
            int len;
            while ((len = bis.read(bytes)) != -1){
                os.write(bytes,0,len);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(bis != null){
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
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
    public void Server(){
        ServerSocket ss = null;
        Socket socket = null;
        InputStream is = null;
        BufferedOutputStream bos = null;
        try {
            //1.创建服务器端的ServerSocket，指明自己的端口号
            ss = new ServerSocket(9090);
            //2.调用accept()表示接受来自客户端的socket
            socket = ss.accept();
            //3.获取输入流
            is = socket.getInputStream();
            //4.获取BufferedOutputStream流，写入文件
            bos = new BufferedOutputStream(new FileOutputStream(new File("1-1.jpg")));

            //5.数据的读取和写入
            byte[] bytes = new byte[1024];
            int len;
            while ((len = is.read(bytes)) != -1){
                bos.write(bytes,0,len);
                System.out.println("接收到来自"+socket.getInetAddress().getHostAddress()+"的数据");
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(bos != null){
                try {
                    bos.close();
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
