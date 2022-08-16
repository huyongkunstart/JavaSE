package java2;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 了解类的加载器 和 ClassLoader的理解
 * @author hu
 * @create 2022-01-27 22:25
 */
public class ClassLoaderTest {
//    了解类的加载器（了解）

    @Test
    public void test1(){
        //对于自定义类，使用系统类加载器进行加载
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println(classLoader);
        System.out.println(ClassLoader.getSystemClassLoader());

        //调用系统类加载器的getParent()：获取拓展类加载器
        ClassLoader classLoader1 = classLoader.getParent();
        System.out.println(classLoader1);

        //调用拓展类加载器的getParent():无法获取引导类加载器
        //引导类加载器主要负责加载java的核心类库，无法加载自定义的类的
        ClassLoader classLoader2 = classLoader1.getParent();
        System.out.println(classLoader2);
    }


    //2.Properties：用来读取配置文件
    @Test
    public void test2() throws IOException {
        Properties properties = new Properties();

        //此时的文件默认在当前的module下
        //读取配置文件的方式一：默认识别在Module下
        FileInputStream jdbc = new FileInputStream("jdbc.properties");
        properties.load(jdbc);

        //取配置文件的方式二：使用ClassLoader
        //配置文件默认识别为：当前Module下的src下
//        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
//        InputStream is = classLoader.getResourceAsStream("jdbc.properties");
//
//        properties.load(is);

        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        System.out.println("user = "+user+",password = "+password);

    }










}
