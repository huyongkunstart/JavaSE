package com.teanschedule.domain;

/**
 * @author huyongkun
 * @ClassName PC
 * @create 2022-06-02 15:31
 * @Version 1.0
 * @description: 台式电脑
 */
public class PC implements Equipment{
    private String model; //机器型号
    private String display; //显示器名称

    public PC(String model, String display) {
        this.model = model;
        this.display = display;
    }

    @Override
    public String getDescription() {
        return model+"("+display+")";
    }
}
