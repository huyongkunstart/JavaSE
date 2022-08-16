package com.teanschedule.service;

/**
 * @author huyongkun
 * @ClassName Status
 * @create 2022-06-02 15:24
 * @Version 1.0
 * @description: 员工的状态类
 */
public class Status {
    private String NAME;
    private Status(String NAME){//私有的构造器
        this.NAME = NAME;
    }
    public static final Status FREE = new Status("FREE");
    public static final Status BUSY = new Status("BUSY");
    public static final Status VACATION = new Status("VACATION");

    public String getNAME() {
        return NAME;
    }

    @Override
    public String toString() {
        return NAME;
    }
}
