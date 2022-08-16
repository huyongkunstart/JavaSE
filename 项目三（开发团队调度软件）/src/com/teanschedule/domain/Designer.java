package com.teanschedule.domain;

/**
 * @author huyongkun
 * @ClassName Designer
 * @create 2022-06-02 15:22
 * @Version 1.0
 * @description: 设计师
 */
public class Designer extends Programmer{
    private double bonus; //奖金

    public Designer(int id, String name, int age, double salary, Equipment equipment, double bonus) {
        super(id, name, age, salary, equipment);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public String showteam(){
        return getMemberId() + "/" +show() + "设计师\t" + bonus;
    }


    @Override
    public String toString() {
        return show() + "设计师\t" + getStatus() + "\t" + bonus + "\t\t\t" + getEquipment().getDescription();
    }
}
