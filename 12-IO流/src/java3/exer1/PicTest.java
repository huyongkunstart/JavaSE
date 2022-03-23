package java3.exer1;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 实现图片加密操作。
 * @author hu
 * @create 2022-01-24 23:14
 */
public class PicTest {
//    图片加密操作
    @Test
    public void test1(){
        FileInputStream fs =null;
        FileOutputStream fos =null;
        try {
            fs = new FileInputStream("1.jpg"); //构造器可以直接不需要new File对象
            fos = new FileOutputStream("1-1.jpg");

            byte[] bytes = new byte[5];
            int len;
            while ((len = fs.read(bytes)) != -1){
                //字节数组进行修改
                /*for(byte b : bytes){
                    b = (byte) (b^5);
                }*/ //这种写法错误，因为bytes数组并没有修改

                for(int i=0 ; i<len ;i++){
                    bytes[i] = (byte)(bytes[i]^5);
                }

                fos.write(bytes,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fs != null){
                try {
                    fs.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    //    图片解密操作
    @Test
    public void test2(){
        FileInputStream fs =null;
        FileOutputStream fos =null;
        try {
            fs = new FileInputStream("1-1.jpg"); //构造器可以直接不需要new File对象
            fos = new FileOutputStream("1-1-1.jpg");

            byte[] bytes = new byte[5];
            int len;
            while ((len = fs.read(bytes)) != -1){
                //字节数组进行修改
                /*for(byte b : bytes){
                    b = (byte) (b^5);
                }*/ //这种写法错误，因为bytes数组并没有修改

                for(int i=0 ; i<len ;i++){
                    bytes[i] = (byte)(bytes[i]^5);
                }

                fos.write(bytes,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fs != null){
                try {
                    fs.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
