package java3;

import org.junit.Test;

import java.io.*;

/**
 * 处理流之一：缓冲流的使用
 * 1.缓冲流：
 * BufferedInputStream
 * BufferedOutputStream
 * BufferedReader
 * BufferedWriter
 * 2.作用 ： 提升流的读取、写入的速度
 *
 * 3.处理流：就是“套接“在已有的流的基础上
 *
 * @author hu
 * @create 2022-01-24 22:14
 */
public class BufferTest {
    //BufferedInputStream,BufferedOutputStream测试
    //实现非文本文件的复制
    @Test
    public void BufferedStreamTest(){
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            //1.造文件对象
            File srcfile = new File("1.jpg");
            File descfile = new File("111.jpg");

            //2.造流对象
            //2.1创建节点流流对象
            FileInputStream fs = new FileInputStream(srcfile);
            FileOutputStream fos = new FileOutputStream(descfile);
            //2.2创造处理流（缓冲流）对象
            bis = new BufferedInputStream(fs);
            bos = new BufferedOutputStream(fos);

            //3.复制的细节：读取，写入
            byte[] bytes = new byte[10];
            int len;
            while ((len = fs.read(bytes)) != -1){
                fos.write(bytes,0,len);
//                fos.flush();//刷新缓冲区
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.资源关闭
            //要求：先关闭外层的流，再关闭内层的流
            if(bis != null){
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(bos != null){
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            //说明：在关闭外层流的同时，内层流也会自动关闭
            //fs.close();
            //fos.close();
        }
    }


    //文件复制方法  此处省略：效果比直接使用节点流快
    public static void CopyTest(String srcPath,String descPath){
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            //1.造文件对象
            File srcfile = new File(srcPath);
            File descfile = new File(descPath);

            //2.造流对象
            //2.1创建节点流流对象
            FileInputStream fs = new FileInputStream(srcfile);
            FileOutputStream fos = new FileOutputStream(descfile);
            //2.2创造处理流（缓冲流）对象
            bis = new BufferedInputStream(fs);
            bos = new BufferedOutputStream(fos);

            //3.复制的细节：读取，写入
            byte[] bytes = new byte[1024];
            int len;
            while ((len = fs.read(bytes)) != -1){
                fos.write(bytes,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.资源关闭
            //要求：先关闭外层的流，再关闭内层的流
            if(bis != null){
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(bos != null){
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            //说明：在关闭外层流的同时，内层流也会自动关闭
            //fs.close();
            //fos.close();
        }
    }

    @Test
    public void testCopyFile() {
        long start = System.currentTimeMillis();
        String srcPath = "D:\\workspace-idea\\java基础\\12-IO流\\魏新雨 - 最美的情缘.mkv";
        String descPath = "D:\\workspace-idea\\java基础\\12-IO流\\魏新雨最美的情缘复制版2.mkv";
        CopyTest(srcPath, descPath);
        long end = System.currentTimeMillis();
        System.out.println("复制操作花费的时间为" + (end - start));// 486
    }















}
