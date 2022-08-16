package com.teanschedule.domain;

import com.sun.xml.internal.bind.v2.model.core.ID;
import com.teanschedule.service.Status;

/**
 * @author huyongkun
 * @ClassName Programmer
 * @create 2022-06-02 15:22
 * @Version 1.0
 * @description: 程序员
 */
public class Programmer extends Employee{
    private int MemberId;  //加入团队以后的id
    private Status status = Status.FREE; //员工状态
    private Equipment equipment; //领用的设备

    //构造器中的参数是根据data表中的数据设计的
    public Programmer(int id, String name, int age, double salary, Equipment equipment) {
        super(id, name, age, salary);
        this.equipment = equipment;
    }

    public int getMemberId() {
        return MemberId;
    }

    public void setMemberId(int memberId) {
        MemberId = memberId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }
    public String showteam(){
        return MemberId + "/" + show() + "程序员\t";
    }

    @Override
    public String toString() {
        return show()+"程序员\t"+status+"\t\t\t\t\t" +equipment.getDescription();
    }
}
