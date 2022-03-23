package java4;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 从TomCat服务器下载资源
 * @author hu
 * @create 2022-01-26 23:37
 */
public class URLTest1 {
    public static void main(String[] args) throws IOException {
        URL url = new URL("http://localhost:8080/examples/a.jpg");
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

        urlConnection.connect();

        InputStream is = urlConnection.getInputStream();
        FileOutputStream fos = new FileOutputStream("a2.jpg");

        byte[] bytes = new byte[1024];
        int len;
        while ((len = is.read(bytes)) != -1){
            fos.write(bytes,0,len);
        }

        fos.close();
        is.close();
        urlConnection.disconnect(); //断开连接

    }
}
