package com.hu1.connection;

import org.junit.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author hu
 * @create 2022-02-17 15:45
 */
public class ConnectionTest {
    //方法一
    @Test
    public void testConnection1() throws SQLException, IllegalAccessException, InstantiationException, ClassNotFoundException {
        //获取Driver实现类对象
        Class clazz = ClassLoader.getSystemClassLoader().loadClass("com.mysql.cj.jdbc.Driver");
        Driver driver = (Driver)clazz.newInstance();

        String url = "jdbc:mysql://localhost:3306/db";
        //将用户名和密码封装在properties中
        Properties info = new Properties();
        info.setProperty("user","root");
        info.setProperty("password","159357");
        Connection conn = driver.connect(url, info);

        System.out.println(conn);

    }


    //方式二 对方式一的迭代  :在如下的程序中不出现第三方的api，使得程序具有更好的可移植性
    @Test
    public void testConnection2() throws Exception{
        //获取Driver实现类对象:使用反射
        Class clazz = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver) clazz.newInstance();
        //提供连接的数据库
        String url = "jdbc:mysql://localhost:3306/db";
        //提供连接需要的用户名和密码
        Properties info = new Properties();
        info.setProperty("user","root");
        info.setProperty("password","159357");

        //获取连接
        Connection conn = driver.connect(url, info);
        System.out.println(conn);
    }

    //方式三 DriverManager替换Driver
    @Test
    public void testConnection3() throws Exception {

        //获取Driver实现类对象
        Class clazz = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver) clazz.newInstance();

        //提供另外三个连接的基本信息
        String url = "jdbc:mysql://localhost:3306/db";
        String user = "root";
        String password = "159357";
        //注册驱动
        DriverManager.registerDriver(driver);
        //获取连接
        Connection conn = DriverManager.getConnection(url, user, password);
        System.out.println(conn);
    }

    //方式四 DriverManager替换Driver 优化
    @Test
    public void testConnection4() throws Exception {
        //1.提供另外三个连接的基本信息
        String url = "jdbc:mysql://localhost:3306/db";
        String user = "root";
        String password = "159357";

        //2.获取Driver实现类对象
        Class.forName("com.mysql.jdbc.Driver");//这一步也可以省略；不建议省略

        //相较于方式3可以省略如下操作：
//        Driver driver = (Driver) clazz.newInstance();
//        //注册驱动
//        DriverManager.registerDriver(driver);

        //原因：在mysql的Driver实现类中声明了
        //java.sql.DriverManager.reginsterDriver(new Driver);


        //3.获取连接
        Connection conn = DriverManager.getConnection(url, user, password);
        System.out.println(conn);
    }


    //方式五：最终版
    //将数据库连接需要的4个基本信息声明在配置文件中，通过读取配置文件的方式，获取连接
    //好处：
        //1.实现了数据与代码的分离，实现了解耦
        //2.如果需要修改配置文件信息，可以避免程序重新打包
    @Test
    public void testConnection5() throws Exception {
//        //1.读取配置文件中的基本信息
//        InputStream is = ConnectionTest.class.getClassLoader().getResourceAsStream("jdbc.properties");
//        Properties ps = new Properties();
//        ps.load(is);
//
//        String user = ps.getProperty("user");
//        String password = ps.getProperty("password");
//        String url = ps.getProperty("url");
//        String driverClass = ps.getProperty("driverClass");
//
//        //加载驱动
//        Class.forName(driverClass);
//
//        //获取连接
//        Connection conn = DriverManager.getConnection(url, user, password);
//        System.out.println(conn);

        //1.读取配置信息
        InputStream is = ClassLoader.getSystemResourceAsStream("jdbc.properties");
        Properties pro = new Properties();
        pro.load(is);

        String user = pro.getProperty("user");
        String password = pro.getProperty("password");
        String url = pro.getProperty("url");
        String driverClass = pro.getProperty("driverClass");

        //加载驱动
        Class.forName(driverClass);
        Connection conn = DriverManager.getConnection(url, user, password);
        System.out.println(conn);
    }

}
