package java9;

import com.sun.deploy.cache.Cache;

import java.io.File;
import java.io.IOException;

/**
 * 使用外部的API，不直接使用文件流
 * @author hu
 * @create 2022-01-26 15:22
 */
public class FIleUtilsTest {
    private static Cache FileUtils;

    public static void main(String[] args) {
        File srcfile = new File("12-IO流\\1.jpg");
        File descfile = new File("12-IO流\\1--1.jpg");
        try {
            FileUtils.copyFile(srcfile,descfile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
