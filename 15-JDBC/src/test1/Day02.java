package test1;

import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author huyongkun
 * @ClassName Day02
 * @create 2022-07-19 18:40
 * @Version 1.0
 * @description: TODO
 */

//要求：
//1.商品卖出后，状态改变，生成订单
//2.用事务，采用线程锁实现线程安全（方法加锁、代码块加锁、手动加锁）
public class Day02 {

    @Test
    public void aaaTest(){
        affairs(1);
    }

    public synchronized void affairs(int id){
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtils.getConnection3();
            conn.setAutoCommit(false);

            String sql1 = "update t_goods set state = ? where id  = ?";
            ps = conn.prepareStatement(sql1);
            ps.setObject(1,"1");
            ps.setObject(2,id);
            int count = ps.executeUpdate();
            if(count > 0){
                System.out.println("状态改变成功");
            }

            String sql2 = "insert into t_orders(goods_id) values(?)";
            ps = conn.prepareStatement(sql2);
            ps.setObject(1,id);
            int cc = ps.executeUpdate();
            if(cc > 0){
                System.out.println("订单已经生成");
            }
            //提交事务
            conn.commit();

        }catch (Exception e){
            try {
                conn.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            JDBCUtils.closeResource(conn,ps);
        }
    }
}
