package java5;

import org.junit.Test;

import java.io.*;
import java.util.Scanner;

/**
 * 其他流的使用
 * 1.标准的输入，输出流
 * 2，打印流
 * 3. 数据流
 *
 * @author hu
 * @create 2022-01-25 16:10
 */
public class OtherStreamTest {
    /*
    1.标准的输入、输出流
    1.1
    System.in : 标准的输入流，默认从键盘输入   注意：按照字节进行读取，是InputStream的实例对象
    System.out： 标准的输出流，默认从控制台输出   是PrintStream的实例对象 ,也是字节流
    1.2
    System类的 setIn(InputStream is) / setOut(PrintStream ps) 方式重新指定输入和输出流

    1.3练习
    从键盘输入字符串，要求将读取到的整行字符串转成大写输出。然后继续
    进行输入操作，直至当输入“e”或者“exit”时，退出程序。
    方法一：使用Scanner实现
    方法二：使用System.in实现.  System.in ---> 转换流 ---> BufferedReader的readLine()
     */

    public static void main(String [] args){
        BufferedReader br = null;
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            br = new BufferedReader(isr);
            while (true){
                System.out.println("请输入字符串：");
                String data = br.readLine();
                if(data.equalsIgnoreCase("exit") || data.equalsIgnoreCase("e")){
                    System.out.println("程序结束");
                    break;
                }
                String upperCase = data.toUpperCase();
                System.out.println(upperCase);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(br != null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    //从键盘读取一串文字，写入到文件
    @Test
    public void test1() throws IOException {
        //读取： System.in 是InptuStream字节流对象，
        // 1.所以先转换为字符流对象，控制台输入的编码是utf8，
        //为什么要转换为字符流呢？   字节流操作文本内容可能会出现乱码的情况
        InputStream is = System.in;
        InputStreamReader isr = new InputStreamReader(is,"utf8");
        // 2.最后再由缓冲流读取在控制台输入的字符串
        BufferedReader br = new BufferedReader(isr);

        //拿到输入的字符串
        String s = br.readLine();
        //使用文件流写入到文件
        FileWriter fw = new FileWriter("E:\\Desktop\\test\\a\\asd.txt");
        fw.write(s);
        fw.flush(); //刷新缓冲区，写入文件
        //控制台输出输入的字符串 //System.out 是PrintStream的对象，
        // PrintStream是OutputStream和FileOutputStream的子类
        System.out.println(s);
    }

    @Test
    public void test11() throws Exception {
        //读取： System.in 是InptuStream字节流对象，
        // 1.所以先转换为字符流对象，控制台输入的编码是utf8，
        //为什么要转换为字符流呢？   字节流操作文本内容可能会出现乱码的情况
        InputStream is = System.in;
        InputStreamReader isr = new InputStreamReader(is,"utf8");
        // 2.最后再由缓冲流读取在控制台输入的字符串
        BufferedReader br = new BufferedReader(isr);

        //拿到输入的字符串
        String s = br.readLine();
        FileOutputStream fw = new FileOutputStream("E:\\Desktop\\text.txt");
        PrintStream ps = new PrintStream(fw, true);
        System.setOut(ps);
        System.out.println(s); //不打印控制台，写入到文件中
    }

    /*
    2.打印流：printStream 和 PrintWriter
    2.1 提供了一系列重载的print() 和 println()
    2.2 练习

     */
    @Test
    public void test2(){
        PrintStream ps = null;
        try {
            FileOutputStream fos = new FileOutputStream(new File("E:\\Desktop\\text.txt"));
            // 创建打印输出流,设置为自动刷新模式(写入换行符或字节 '\n' 时都会刷新输出缓冲区)
            ps = new PrintStream(fos, true);
            if (ps != null) {// 把标准输出流(控制台输出)改成文件
                System.setOut(ps);
            }
            for (int i = 0; i <= 255; i++) { // 输出ASCII字符
                System.out.print((char) i);
                if (i % 50 == 0) { // 每50个数据一行
                    System.out.println(); // 换行
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                ps.close();
            }
        }
    }

    /*
     3.数据流
     3.1  DataInputStream 和 DataOutputStream
     3.2 作用：用于读取或写出基本数据类型的变量或字符串
     */
    //将内存中的字符串、基本数据类型的变量写出到文件中
    @Test
    public void test3() throws IOException {
        DataOutputStream dos = new DataOutputStream(new FileOutputStream("data.txt"));
        dos.writeUTF("胡永坤");
        dos.flush();//刷新操作，将内存中的数据写入文件
        dos.writeInt(123);
        dos.flush();
        dos.writeBoolean(true);
        dos.flush();

        dos.close();
    }
    //将文件中存储的基本数据类型变量和字符串读取到内存中，保存在变量中
    //注意点： 读取不同类型的数据的顺序要与当初写入文件时，保存的数据的顺序一致
    @Test
    public void test4() throws IOException {
        DataInputStream dis = new DataInputStream(new FileInputStream("data.txt"));
        String name = dis.readUTF();
        int age = dis.readInt();
        boolean ismale = dis.readBoolean();
        System.out.println("name="+name);
        System.out.println("age="+age);
        System.out.println("ismale="+ismale);
        dis.close();
    }


}
