package com.TeamSchedule.IO;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author huyongkun
 * @ClassName InputOutputStreamTest
 * @create 2022-05-18 15:20
 * @Version 1.0
 * @description: TODO
 */
public class InputOutputStreamTest {
    //使用FileInputStream字节流读取文件
    @Test
    public void test1(){
        FileInputStream fs = null;
        try {
            File file = new File("hu.txt");
            fs = new FileInputStream(file);

            byte[] bytes = new byte[5];
            int len;
            while ((len = fs.read(bytes))!= -1){
                String str = new String(bytes,0,len);
                System.out.println(str);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fs != null){
                try {
                    fs.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
