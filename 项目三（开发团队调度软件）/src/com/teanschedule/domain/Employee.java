package com.teanschedule.domain;

/**
 * @author huyongkun
 * @ClassName Employee
 * @create 2022-06-02 15:19
 * @Version 1.0
 * @description: 员工类
 */
public class Employee {
    private int id;
    private String name;
    private int age;
    private double salary;

    public Employee() {
    }

    public Employee(int id, String name, int age, double salary) {
        this.id = id; //id
        this.name = name; //姓名
        this.age = age;  //年龄
        this.salary = salary; //薪水
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    public String show(){
        return id + "\t" + name + "\t" + age + "\t\t" + salary + "\t";
    }

    @Override
    public String toString() {
        return show();
    }
}
