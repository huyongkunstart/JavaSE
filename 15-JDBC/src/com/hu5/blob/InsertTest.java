package com.hu5.blob;

import com.hu3.util.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * @author shkstart
 * @create 2022-03-05 10:53
 * Document: 使用PreparedStatement实现批量数据的操作
 *
 * update , delete 本身就具有批量操作的效果
 * 此时的批量操作主要指批量插入
 *
 * 实例：向goods表中插入2万条数据
 * CREATE TABLE `goods`(
 * id INT PRIMARY KEY AUTO_INCREMENT,
 * NAME VARCHAR(25)
 * );
 *
 * 方法一：
   Connection conn = JDBCUtils.getConnection();
   Statement st = conn.createStatement();
   for (int i = 0; i < 20000; i++) {
   String sql = "insert into goods(name) values('name_" + i + "')";
   st.execute(sql);
}
 *
 */
public class InsertTest {
    //批量插入方式二
    @Test
    public void testInsert1() throws Exception{
        Connection conn = null;
        PreparedStatement ps =null;
        try {
            long begin = System.currentTimeMillis();
            conn = JDBCUtils.getConnection();
            String sql = "insert into goods(name) values(?)";
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < 20000; i++) {
                ps.setObject(1,"name_"+i);
                ps.executeUpdate();
            }
            long after = System.currentTimeMillis();
            System.out.println(after-begin);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtils.closeResource(conn, ps);
        }
    }

    //批量插入方式三
    /*
    addBatch(String)：添加需要批量处理的SQL语句或是参数；
    executeBatch()：执行批量处理语句；
    clearBatch():清空缓存的数据
    修改2：mysql服务器默认是关闭批处理的，我们需要通过一个参数，让mysql开启批处理的支持。
 * 		 ?rewriteBatchedStatements=true 写在配置文件的url后面
    * */

    //批量插入方式三
    @Test
    public void testInsert2() throws Exception{
        Connection conn = JDBCUtils.getConnection();
        String sql = "insert into goods(name) values(?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        long start = System.currentTimeMillis();
        for (int i = 1; i <= 20000; i++) {
            ps.setObject(1,"name_"+i);

            //1."攒"sql
            ps.addBatch();
            if(i%500 == 0){
                //2.执行batch
                ps.executeBatch();
                //3.清空batch
                ps.clearBatch();
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("花费的时间为："+(end-start));  //花费的时间为：558
        JDBCUtils.closeResource(conn,ps);
    }


    //批量插入方式四 设置连接不允许提交数据
    @Test
    public void testInsert3() throws Exception{
        long start = System.currentTimeMillis();
        Connection conn = JDBCUtils.getConnection();
        //设置不允许自动提交数据
        conn.setAutoCommit(false);
        String sql = "insert into goods(name) values(?)";
        PreparedStatement ps = conn.prepareStatement(sql);


        for (int i = 0; i < 20000; i++) {
            ps.setObject(1,"name_"+i);

            //1."攒"sql
            ps.addBatch();
            if(i%500 == 0){
                //2.执行batch
                ps.executeBatch();
                //3.清空batch
                ps.clearBatch();
            }
        }
        //提交数据
        conn.commit();
        long end = System.currentTimeMillis();
        System.out.println("花费的时间为："+(end-start));  //花费的时间为：558
        JDBCUtils.closeResource(conn,ps);
    }


}
