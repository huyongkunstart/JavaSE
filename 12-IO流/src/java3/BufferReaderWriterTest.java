package java3;

import org.junit.Test;

import java.io.*;

/**
 * 缓冲流的使用:
 * BufferedReader
 * BufferedWriter
 * @author hu
 * @create 2022-01-24 22:43
 */
public class BufferReaderWriterTest {
    @Test
    public void BufferTest(){
        /*//1.创建文件对象
        File srcfile = new File("dbcp.txt");
        File descfile = new File("dbcp1.txt");

        //2.创建流对象
        //2.1 创建节点流对象 FileReader FileWriter
        FileReader fr = new FileReader(srcfile);
        FileWriter fw = new FileWriter(descfile);
        //2.2 创建处理流（缓冲流对象） BufferedReader BufferedWriter
        BufferedReader br = new BufferedReader(fr);
        BufferedWriter bw = new BufferedWriter(fw);*/

        //合并
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            br = new BufferedReader(new FileReader(new File("dbcp.txt")));
            bw = new BufferedWriter(new FileWriter(new File("dbcp1.txt")));

            //读写数据
            //方式一：char[]数组
            /*char[] chars = new char[5];
            int len;
            while ((len = br.read(chars)) != -1){
                bw.write(chars,0,len);
            }*/

            //方式二 使用String 一行一行读取
            String data;
            while ((data = br.readLine()) != null){
                //换行方法一
//                bw.write(data+"\n");//data中不包含换行符
                //换行方法二
                bw.write(data);
                bw.newLine();

            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //资源关闭
            if(br != null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(bw != null){
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
