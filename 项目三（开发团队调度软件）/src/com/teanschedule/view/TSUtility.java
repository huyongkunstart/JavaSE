package com.teanschedule.view;

import java.util.Scanner;

/**
 * @author huyongkun
 * @ClassName TSUtility
 * @create 2022-06-02 11:34
 * @Version 1.0
 * @description: 键盘输入工具类
 */
public class TSUtility {
    private static Scanner scan = new Scanner(System.in);

    private static String readKeyBoard(int limit, boolean flag){
        String line = "";
        while (scan.hasNextLine()){
            line = scan.nextLine();
            if(line.length() == 0){
                if(!flag){
                    continue;
                }
            }
            if(line.length() > limit){
                System.out.println("输入的长度超过了"+limit+"限制，请重新输入:");
                continue;
            }
            break;
        }
        return line;
    }
    /*
     * @Author huyongkun
     * @Date 13:49 2022/6/2
     * @Param []
     * @return char
     * @Description //用途：该方法读取键盘，如果用户键入’1’-’4’中的任意字符，则方法返回。返回值为用户键入字符。
     **/
    public static char readMenuSelection(){
        char c;
        while (true){
            c = readKeyBoard(1,false).charAt(0);
            if(c != '1' && c != '2' && c != '3' && c != '4'){
                System.out.println("输入的数字不在(1~4)之间，请重新输入:");
                continue;
            }
            break;
        }
        return c;
    }
    /*
     * @Author huyongkun
     * @Date 13:49 2022/6/2
     * @Param []
     * @return void
     * @Description // 用途：该方法提示并等待，直到用户按回车键后返回。
     **/
    public static void readReturn(){
        System.out.println("按回车键继续.....");
        readKeyBoard(100,true);
    }
    /*
     * @Author huyongkun
     * @Date 13:50 2022/6/2
     * @Param []
     * @return int
     * @Description //用途：该方法从键盘读取一个长度不超过2位的整数，并将其作为方法的返回值。
     **/
    public static int readInt(){
        int a;
        while (true){
            String str = readKeyBoard(2,false);
            try{
                a = Integer.parseInt(str);
                break;
            }catch (NumberFormatException e){
                System.out.println("输入的数据类型不正确，请重新输入:");
            }
        }
        return a;
    }
    /*
     * @Author huyongkun
     * @Date 13:50 2022/6/2
     * @Param []
     * @return char
     * @Description //用途：从键盘读取‘Y’或’N’，并将其作为方法的返回值。
     **/
    public static char readConfirmSelection(){
        char c ;
        while (true){
            c = readKeyBoard(1,false).toUpperCase().charAt(0);
            if(c != 'Y' && c != 'N'){
                System.out.println("输入错误，请重新输入:");
                continue;
            }
            break;
        }
        return c;
    }



}
