package com.teanschedule.domain;

/**
 * @author huyongkun
 * @ClassName Arichitect
 * @create 2022-06-02 17:48
 * @Version 1.0
 * @description: 架构师
 */
public class Arichitect extends Designer{
    private int stock; //股票

    public Arichitect(int id, String name, int age, double salary, Equipment equipment, double bonus, int stock) {
        super(id, name, age, salary, equipment, bonus);
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String showteam() {
        return getMemberId() + "/" + show() + "架构师\t" + getBonus() + "\t" + stock;
    }

    @Override
    public String toString() {
        return show() + "架构师\t" +getStatus() + "\t" + getBonus() + "\t" +
                stock + "\t" + getEquipment().getDescription();
    }
}
