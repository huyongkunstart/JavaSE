package java2;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/** 测试 节点流
 * FileInputStream和FileOutputStream字节流的使用
 * 结论：
 * 1.对于文本文件（.txt .java .c .cpp）使用字符流来处理
   2.对于非文本文件（.jpg .mp4 .docx .ppt）使用字节流来处理
 *
 * @author hu
 * @create 2022-01-24 15:37
 */
public class FileInputOutputStreamTest {
    //使用FileInputStream字节流处理文本文件可能出现乱码问题
    @Test
    public void testFileInputStream(){
        FileInputStream fs = null;
        try {
            //1.实例化File类的对象
            File file = new File("hello.txt");

            //2.实例化FileInputStream字节流
            fs = new FileInputStream(file);

            //3.读入数据
            byte[] bytes = new byte[5];
            int len;
            while ((len = fs.read(bytes)) != -1 ){
                String s = new String(bytes, 0, len);
                System.out.print(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fs != null){
                //4.关闭资源
                try {
                    fs.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void testFileInputOutputStream(){
        FileInputStream fi = null;
        FileOutputStream fo = null;
        try {
            //1.创建File文件对象
            File srcfile = new File("1.jpg");
            File descfile = new File("11.jpg");

            //2.创建FileInputStream和FileOutputStream字节流对象
            fi = new FileInputStream(srcfile);
            fo = new FileOutputStream(descfile);

            //3.读入和写出操作
            byte[] bytes = new byte[5];
            int len;
            while ((len = fi.read(bytes)) != -1){
                fo.write(bytes,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.关闭资源对象
            if(fi != null){
                try {
                    fi.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fo != null){
                try {
                    fo.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }



    //写一个方法，指定路径下文件的复制
    public static void CopyFile(String srcPath,String descPath){
        FileInputStream fi = null;
        FileOutputStream fo = null;
        try {
            //1.创建File文件对象
            File srcfile = new File(srcPath);
            File descfile = new File(descPath);

            //2.创建FileInputStream和FileOutputStream字节流对象
            fi = new FileInputStream(srcfile);
            fo = new FileOutputStream(descfile);

            //3.读入和写出操作
            byte[] bytes = new byte[1024];
            int len;
            while ((len = fi.read(bytes)) != -1){
                fo.write(bytes,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.关闭资源对象
            if(fi != null){
                try {
                    fi.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fo != null){
                try {
                    fo.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void testCopyFile(){
        long start = System.currentTimeMillis();
        String srcPath = "D:\\workspace-idea\\java基础\\12-IO流\\魏新雨 - 最美的情缘.mkv";
        String descPath = "D:\\workspace-idea\\java基础\\12-IO流\\魏新雨最美的情缘复制版.mkv";
        CopyFile(srcPath,descPath);
        long end = System.currentTimeMillis();
        System.out.println("复制操作花费的时间为"+(end-start));//601
    }

}
