package com.teanschedule.service;

import com.teanschedule.domain.*;

/**
 * @author huyongkun
 * @ClassName NameListService
 * @create 2022-06-02 18:04
 * @Version 1.0
 * @description: 公司成员数组,将Data类中的数据导入到数组中存储
 */
public class NameListService {
    private Employee[] employees = new Employee[Data.EMPLOYEES.length];;

    //通过构造器初始化将数据导入到数组中
    /*
     * @Author huyongkun
     * @Date 20:32 2022/6/2
     * @Param []
     * @return
     * @Description //根据项目提供的Data类构建相应大小的employees数组
                    再根据Data类中的数据构建不同的对象，包括Employee、Programmer、Designer和Architect对象，
                    以及相关联的Equipment子类的对象将对象存于数组中
     **/
    public NameListService() {
        for (int i = 0; i < employees.length; i++) {
            //获取常用的属性
            int id = Integer.parseInt(Data.EMPLOYEES[i][1]);
            String name = Data.EMPLOYEES[i][2];
            int age = Integer.parseInt(Data.EMPLOYEES[i][3]);
            double salary = Double.parseDouble(Data.EMPLOYEES[i][4]);

            int type = Integer.parseInt(Data.EMPLOYEES[i][0]);
            Equipment equipment;
            switch (type){
                case Data.EMPLOYEE: //员工
                    Employee employee = new Employee(id, name, age, salary);
                    employees[i] = employee;
                    break;
                case Data.PROGRAMMER: //程序员
                    equipment = getEquipment(i);
                    Programmer programmer = new Programmer(id, name, age, salary, equipment);
                    employees[i] = programmer;
                    break;
                case Data.DESIGNER: //设计师
                    equipment = getEquipment(i);
                    double bonus = Double.parseDouble(Data.EMPLOYEES[i][5]);
                    Designer designer = new Designer(id, name, age, salary, equipment, bonus);
                    employees[i] = designer;
                    break;
                case Data.ARCHITECT: //架构师
                    equipment = getEquipment(i);
                    double bonus2 = Double.parseDouble(Data.EMPLOYEES[i][5]);
                    int stock = Integer.parseInt(Data.EMPLOYEES[i][6]);
                    Arichitect arichitect = new Arichitect(id, name, age, salary, equipment, bonus2, stock);
                    employees[i] = arichitect;
                    break;
            }
        }
    }
    private Equipment getEquipment(int index){
        int type = Integer.parseInt(Data.EQUIPMENTS[index][0]);
        String key = Data.EQUIPMENTS[index][1];
        String value = Data.EQUIPMENTS[index][2];
        switch (type){
            case Data.PC:
                return new PC(key,value);
            case Data.NOTEBOOK:
                return new NoteBook(key,Double.parseDouble(value));
            case Data.PRINTER:
                return new Printer(key, value);
        }
        return null;
    }

    /*
     * @Author huyongkun
     * @Date 20:31 2022/6/2
     * @Param []
     * @return com.teanschedule.domain.Employee[]
     * @Description //获取当前所有员工
     **/
    public Employee[] getAllEmployees(){
        return employees;
    }
    /*
     * @Author huyongkun
     * @Date 20:31 2022/6/2
     * @Param [id]
     * @return com.teanschedule.domain.Employee
     * @Description //获取指定ID的员工对象。
     * 异常：找不到指定的员工
     **/
    public Employee getEmployee(int id){
        for (int i = 0; i < employees.length; i++) {
            if(employees[i].getId() == id){
                return employees[i];
            }
        }
        throw new TeamException("找不到指定的员工");
    }

}
