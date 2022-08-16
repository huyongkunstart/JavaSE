package com.teanschedule.domain;

/**
 * @author huyongkun
 * @ClassName Printer
 * @create 2022-06-02 15:31
 * @Version 1.0
 * @description: 打印机
 */
public class Printer implements Equipment{
    private String name; //打印机型号
    private String type; //打印机类型

    public Printer(String name, String type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public String getDescription() {
        return name+"("+type+")";
    }
}
