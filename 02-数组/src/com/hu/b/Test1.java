package com.hu.b;

import java.text.DecimalFormat;

/**
 * @author shkstart
 * @create 2022-03-21 22:14
 * @description：
 */
public class Test1 {
    public static void main(String[] args) {

        //设置保留小数点位数
        DecimalFormat df=new DecimalFormat("0.00");//设置保留位数
        System.out.println(df.format((float) 5 / 2));
    }
}
