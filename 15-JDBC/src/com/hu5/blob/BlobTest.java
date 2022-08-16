package com.hu5.blob;

import com.hu3.bean.Customer;
import com.hu3.util.JDBCUtils;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.*;

/**
 * @author shkstart
 * @create 2022-03-04 23:56
 * Document: 测试使用PreparedStataemrnt操作Blob类型的数据
 */
public class BlobTest {
    //向数据表customers中插入Blob类型的字段
    @Test
    public void testInser() throws Exception{
        Connection conn = JDBCUtils.getConnection();
        String sql = "insert into customers(name,email,birth,photo) values(?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setObject(1,"王英凡");
        ps.setObject(2,"wangyingfan@qq.com");
        ps.setObject(3,"2001-12-12");
        FileInputStream fs = new FileInputStream(new File("girl.jpg"));
        ps.setBlob(4,fs);

        ps.execute();

        JDBCUtils.closeResource(conn,ps);
    }

    //查询数据表customers表中Blob类型的字段
    @Test
    public void testQuery() throws Exception{
        InputStream is = null;
        FileOutputStream fos = null;
        Connection conn = JDBCUtils.getConnection();
        String sql = "select id,name,email,birth,photo from customers where id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setObject(1,22);

        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            //方式一
            /*int id = rs.getInt(1);
            String name = rs.getString(2);
            String email = rs.getString(3);
            Date birth = rs.getDate(4);*/
            //方式二
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String email = rs.getString("email");
            Date birth = rs.getDate("birth");

            Customer customer = new Customer(id, name, email, birth);
            System.out.println(customer);

            //将Blob类型的字段下载下来，以文件的方式保存在本地
            Blob photo = rs.getBlob("photo");
             is = photo.getBinaryStream();
             fos = new FileOutputStream("王英凡.jpg");
            byte[] bytes = new byte[1024];
            int len;
            while ((len = is.read(bytes)) != -1){
                fos.write(bytes,0,len);
            }
        }
        is.close();
        fos.close();
        JDBCUtils.closeResource(conn,ps,rs);
    }


    @Test
    public void test2(){
        String sql = "select id, name, email, birth, photo from customers where id = ?";
        query(sql,16);
    }

    //查询表中Blob类型的字段
    public void query(String sql, Object ...args){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i+1, args[i]);
            }
            rs = ps.executeQuery();
            System.out.println(rs);
            System.out.println("222");
            if(rs.next()){
                System.out.println("11");
                int id = rs.getInt(1);
                String name = rs.getObject(2).toString();
                String email = rs.getObject(3).toString();
                Date birth = rs.getDate(4);
                Customer customer = new Customer(id,name,email,birth);
                System.out.println(customer);

                Blob blob = rs.getBlob(5);
                InputStream binaryStream = blob.getBinaryStream(); //输入流
                FileOutputStream fos = new FileOutputStream("1.jpg"); //输出流

                byte[] bytes = new byte[1024];
                int len;
                while ((len = binaryStream.read(bytes)) != -1){
                    fos.write(bytes,0,len);
                }
                fos.close();
            }
            //关资源
            JDBCUtils.closeResource(conn,ps,rs);

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtils.closeResource(conn,ps,rs);
        }
    }
}
