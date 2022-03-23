package java3;

import org.junit.Test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * UDP协议的网络编程
 *
 * @author hu
 * @create 2022-01-26 22:41
 */
public class UDPTest {
    //发送端
    @Test
    public void sender() throws IOException {
        DatagramSocket socket = new DatagramSocket();

        String str = "我是UDP方式发送的导弹";
        byte[] bytes = str.getBytes();
        InetAddress inet = InetAddress.getLocalHost();
        DatagramPacket packet = new DatagramPacket(bytes,0,bytes.length,inet,9090);

        socket.send(packet);

        socket.close();

    }

    //接收端
    @Test
    public void receiver() throws IOException {
        DatagramSocket socket = new DatagramSocket(9090);
        byte[] bytes = new byte[100];
        DatagramPacket packet = new DatagramPacket(bytes,0,bytes.length);

        socket.receive(packet);

        System.out.println(new String(packet.getData(),0,packet.getLength()));
        socket.close();

    }

}
