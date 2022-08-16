package com.TeamSchedule.java8;

import org.junit.Test;

/**
 * System类 Math类
 * @author hu
 * @create 2021-12-03 23:28
 */
public class OtherClassTest {
    //system类
    @Test
    public void test(){
//        System.in;
//        System.out;
//        System.err;
//        System.exit();
//        System.gc();
        String javaVersion = System.getProperty("java.version");
        System.out.println("java的version:" + javaVersion);
        String javaHome = System.getProperty("java.home");
        System.out.println("java的home:" + javaHome);
        String osName = System.getProperty("os.name");
        System.out.println("os的name:" + osName);
        String osVersion = System.getProperty("os.version");
        System.out.println("os的version:" + osVersion);
        String userName = System.getProperty("user.name");
        System.out.println("user的name:" + userName);
        String userHome = System.getProperty("user.home");
        System.out.println("user的home:" + userHome);
        String userDir = System.getProperty("user.dir");
        System.out.println("user的dir:" + userDir);
    }
}
