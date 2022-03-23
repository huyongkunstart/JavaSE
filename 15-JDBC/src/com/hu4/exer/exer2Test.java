package com.hu4.exer;

import com.hu3.util.JDBCUtils;
import org.junit.Test;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Scanner;

/**
 * @author hu
 * @Date 2022-02-21 11:21
 * @Description 插入一个新的student 信息
 * 建立java 程序：输入身份证号或准考证号可以查询到学生的基本信息。
 */
public class exer2Test {
    //问题1：插入一个新的student 信息
    /*
    * Type:
    IDCard:
    ExamCard:
    StudentName:
    Location:
    Grade:*/
    @Test
    public void testInsert(){
        Scanner sc = new Scanner(System.in);
        System.out.print("四级/六级:");
        int Type = sc.nextInt();
        System.out.print("身份证号:");
        String IDCard = sc.next();
        System.out.print("准考证号:");
        String ExamCard = sc.next();
        System.out.print("学生姓名:");
        String StudentName = sc.next();
        System.out.print("所在区域:");
        String Location = sc.next();
        System.out.print("考试成绩:");
        int Grade = sc.nextInt();

        String sql = "insert into examstudent(Type,IDCard,ExamCard,StudentName,Location,Grade) values(?,?,?,?,?,?)";
        int updateCount = update(sql, Type, IDCard, ExamCard, StudentName, Location, Grade);
        if(updateCount > 0 ){
            System.out.println("添加成功");
        }else {
            System.out.println("添加失败");
        }

    }





    //通用的增删改操作
    public static int update(String sql,Object ...args){
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtils.getConnection();
            ps = conn.prepareStatement(sql);
            for (int i =0;i<args.length;i++){
                ps.setObject(i+1,args[i]);
            }
            /*
            execute():如果执行的是查询操作，有返回结果，此方法返回true
                      如果执行的是增删改操作，没有返回结果，此方法返回false
            */
//            ps.execute();
            return ps.executeUpdate(); //返回的是影响的行数
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,ps);
        }
        return 0;
    }



    //问题2：输入身份证号或准考证号可以查询到学生的基本信息。
    @Test
    public void testgetInstance(){
        System.out.println("请选择您要输入的类型:");
        System.out.println("a.准考证号");
        System.out.println("b.身份证号");
        Scanner sc = new Scanner(System.in);
        String selection = sc.next();
        if("a".equalsIgnoreCase(selection)){
            System.out.println("请输入准考证号：");
            String examCard = sc.next();
            String sql = "SELECT FlowID flowID,TYPE type,IdCard IDCard,examCard,studentname name,location,grade FROM Examstudent where examCard = ?";
            Student s1 = getInstance(Student.class, sql, examCard);
            if (s1 == null){
                System.out.println("输入的准考证号有误");
            }else {
                System.out.println(s1);
            }
        }else if("b".equalsIgnoreCase(selection)){
            System.out.println("请输入身份证号：");
            String idCard = sc.next();
            String sql = "SELECT FlowID flowID,TYPE type,IdCard IDCard,examCard,studentname name,location,grade FROM Examstudent where idCard = ?";
            Student s1 = getInstance(Student.class, sql, idCard);
            if (s1 == null){
                System.out.println("输入的身份证号有误");
            }else {
                System.out.println(s1);
            }
        }else {
            System.out.println("您的输入有误，请重新进入程序");
        }
    }

    public static  <T> T getInstance (Class<T> clazz,String sql,Object ...args){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i+1,args[i]);
            }
            rs = ps.executeQuery();

            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            if (rs.next()){
                T t = clazz.newInstance();
                for (int i = 0; i < columnCount; i++) {
                    //获取列的别名
                    String columnLabel = rsmd.getColumnLabel(i + 1);
                    //获取每个列的列值
                    Object columnValue = rs.getObject(i + 1);

                    Field field = clazz.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(t,columnValue);
                }
                return t;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,ps,rs);
        }

        return null;
    }



    //问题3：删除指定的学生信息
    @Test
    public void test3(){
        System.out.println("请输入学生的考号：");
        Scanner sc = new Scanner(System.in);
        String examCard = sc.next();
        //查询指定准考证号的学生
        String sql = "SELECT FlowID flowID,TYPE type,IdCard IDCard,examCard,studentname name,location,grade FROM Examstudent where examCard = ?";
        Student student = getInstance(Student.class, sql, examCard);
        if(student == null){
            System.out.println("查无此人，请重新输入");
        }else {
            String sql1 = "delete from examstudent where examCard = ?";
            int deleteCount = update(sql1, examCard);
            if (deleteCount >0){
                System.out.println("删除成功");
            }else {
                System.out.println("删除失败");
            }
        }
    }
    //问题3：删除指定的学生信息
    @Test
    public void test4() {
        System.out.println("请输入学生的考号：");
        Scanner sc = new Scanner(System.in);
        String examCard = sc.next();
        String sql1 = "delete from examstudent where examCard = ?";
        int deleteCount = update(sql1, examCard);
        if (deleteCount >0){
            System.out.println("删除成功");
        }else {
            System.out.println("查无此人，请重新输入");
        }

    }

}
