package java4;

import org.junit.Test;

import java.io.*;

/**
 * 一：处理流的之二：转换流的使用
 * 1.转换流：属于字符流
 *  InputStreamReader ：将一个字节的输入流转化为字符的输入流
 *  OutputStreamWriter ： 将一个字符的输出流转化为字节的输出流
 * 2.作用：提供字节流与字符流之间的转换
 *
 * 3.解码： 字节、字节数组  ----> 字符数组、字符串
 *   编码： 字符数组、字符串 ----> 字节、字节数组
 *
 * 4.字符集
 *  常见的编码表
 *  ASCII：美国标准信息交换码。用一个字节的7位可以表示。
 *  ISO8859-1：拉丁码表。欧洲码表。 用一个字节的8位表示。
 *  GB2312：中国的中文编码表。最多两个字节编码所有字符
 *  GBK：中国的中文编码表升级，融合了更多的中文文字符号。最多两个字节编码
 *  Unicode：国际标准码，融合了目前人类使用的所有字符。为每个字符分配唯一的字符码。所有的文字都用两个字节来表示。
 *  UTF-8：变长的编码方式，可用1-4个字节来表示一个字符。
 *
 * @author hu
 * @create 2022-01-25 15:11
 */
public class InputStreamReaderTest {
    @Test
    public void InputStreamReader() throws IOException {
        FileInputStream fs = new FileInputStream("dbcp.txt");
//        InputStreamReader isr = new InputStreamReader(fs);//使用系统默认的字符集
        //参数2指明了字符集，具体使用那个字符集，取决于文件dbcp.txt保存时使用的字符集
        InputStreamReader isr = new InputStreamReader(fs,"UTF-8");

        char[] cbuf = new char[20];
        int len;
        while ((len = isr.read(cbuf)) != -1){
            String s = new String(cbuf, 0, len);
            System.out.print(s);
        }

        if(isr != null){
            isr.close();
        }
    }

    //综合使用InputStreamReader和 OutputStreamWriter
    //将dbcp文件由uft-8转为gbk编码
    @Test
    public void test2() throws IOException {
        InputStreamReader isr = new InputStreamReader(new FileInputStream("dbcp.txt"),"UTF-8");
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("dbcp_bak.txt"), "gbk");

        char[] chars = new char[20];
        int len;
        while ((len = isr.read(chars)) != -1){
            osw.write(chars,0,len);
        }

        if(isr != null){
            isr.close();
        }
        if(osw != null){
            osw.close();
        }

    }
    @Test
    public void test1(){
//        FileInputStream  FileOutputStream   FileReader  FileWriter 节点流
//        BufferedInputStream  BufferedOutputStream BufferedReader BufferedWriter  处理流
//        InputStreamReader   OutputStreamWriter
    }

}
