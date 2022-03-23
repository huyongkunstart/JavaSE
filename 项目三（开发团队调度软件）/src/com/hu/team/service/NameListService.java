package com.hu.team.service;
/**
 * 
* @Description 负责将Data中的数据封装到Employee[]数组中，同时提供相关操作Employee[]的方法
* @author hu Email:3300786078@qq.com
* @version jdk1.8
* @date 2021年9月28日上午7:34:24
*
 */


import static com.hu.team.service.Data.ARCHITECT;
import static com.hu.team.service.Data.DESIGNER;
import static com.hu.team.service.Data.EMPLOYEE;
import static com.hu.team.service.Data.EMPLOYEES;
import static com.hu.team.service.Data.EQUIPMENTS;
import static com.hu.team.service.Data.NOTEBOOK;
import static com.hu.team.service.Data.PC;
import static com.hu.team.service.Data.PRINTER;
import static com.hu.team.service.Data.PROGRAMMER;

import com.hu.team.domain.Architect;
import com.hu.team.domain.Designer;
import com.hu.team.domain.Employee;
import com.hu.team.domain.Equipment;
import com.hu.team.domain.NoteBook;
import com.hu.team.domain.PC;
import com.hu.team.domain.Printer;
import com.hu.team.domain.Programmer;

public class NameListService {
	private Employee employees[];
	//给employees及数组元素进行初始化
	public NameListService() {
		/*
		 * 1.根据项目提供的Data类构建相应大小的employees数组
		   2.再根据Data类中的数据构建不同的对象，
		   包括Employee、Programmer、Designer和Architect对象，
		   以及相关联的Equipment子类的对象
		   3.将对象存于数组中
		 */
		employees = new Employee[EMPLOYEES.length];
		for(int i=0;i<employees.length;i++) {
			//获取员工的类型
			int type = Integer.parseInt(EMPLOYEES[i][0]);
			
			//获取Employee的4个基本信息
			int id = Integer.parseInt(EMPLOYEES[i][1]);
			String name = EMPLOYEES[i][2];
			int age = Integer.parseInt(EMPLOYEES[i][3]);
			Double salary = Double.parseDouble(EMPLOYEES[i][4]);
			
			Equipment equipment;
			Double bonus;
			int stock;
			
			switch(type) {
				case EMPLOYEE:
					employees[i] = new Employee(id, name, age, salary);
					break;
				case PROGRAMMER:
					equipment =createEquipment(i);
					employees[i] = new Programmer(id, name, age, salary, equipment);
					break;
				case DESIGNER:
					equipment =createEquipment(i);
					bonus = Double.parseDouble(EMPLOYEES[i][5]);
					employees[i] = new Designer(id, name, age, salary, equipment, bonus);
					break;
				case ARCHITECT:
					equipment =createEquipment(i);
					bonus = Double.parseDouble(EMPLOYEES[i][5]);
					stock = Integer.parseInt(EMPLOYEES[i][6]);
					employees[i] = new Architect(id, name, age, salary, equipment, bonus, stock);
					break;
			}
		}
	}
	//获取指定index上的员工的设备
	private Equipment createEquipment(int index) {
		int key = Integer.parseInt(EQUIPMENTS[index][0]);
		String modelOrName = EQUIPMENTS[index][1];
		
		switch (key) {
			case PC:
				String display = EQUIPMENTS[index][2];
				return new PC(modelOrName,display);

			case NOTEBOOK:
				Double price = Double.parseDouble(EQUIPMENTS[index][2]);
				return new NoteBook(modelOrName,price);

			case PRINTER:
			 	String type = EQUIPMENTS[index][2];
				return new Printer(modelOrName,type);
		}
		return null;

	}
	//取当前所有员工。 返回包含所有员工对象的数组
	public Employee[] getAllEmployees(){
		return employees;
	}
	//获取指定ID的员工对象
	public Employee getEmployee(int id) throws TeamException {
		for(int i=0;i<employees.length;i++) {
			if(employees[i].getId() == id ) {
				return employees[i];
			}
		}
		throw new TeamException("找不到指定的员工");
	}
	
	
	
}
