package com.teanschedule.domain;

/**
 * @author huyongkun
 * @ClassName NoteBook
 * @create 2022-06-02 15:31
 * @Version 1.0
 * @description: 笔记本电脑
 */
public class NoteBook implements Equipment{
    private String model; //机器型号
    private double price; //价格

    public NoteBook(String model, double price) {
        this.model = model;
        this.price = price;
    }

    @Override
    public String getDescription() {
        return model+"("+price+")";
    }
}
