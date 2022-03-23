package java6;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author hu
 * @create 2022-01-05 13:39
 */
public class PropertiesTest {
    //Properties:常用来处理配置文件。key和value都是String类型
    public static void main(String[] args) throws IOException {
        Properties p1 = new Properties();
        FileInputStream fis = new FileInputStream("jdbc.properties");
        p1.load(fis);//加载流对应的文件
        String name = p1.getProperty("name");
        String passwd = p1.getProperty("passwd");
        System.out.println(name+"---->"+passwd);
        fis.close();
    }
}
