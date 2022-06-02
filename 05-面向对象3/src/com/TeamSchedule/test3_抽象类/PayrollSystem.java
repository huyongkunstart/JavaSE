package com.TeamSchedule.test3_抽象类;

import java.util.Calendar;

/*
 * 定义PayrollSystem类，创建Employee变量数组并初始化，该数组存放各
	类雇员对象的引用。利用循环结构遍历数组元素，输出各个对象的类
	型,name,number,birthday,以及该对象生日。当键盘输入本月月份值时，
	如果本月是某个Employee对象的生日
	，还要输出增加工资信息。
 */
public class PayrollSystem {
	public static void main(String[] args) {
		//方式一
//		Scanner scanner = new Scanner(System.in);
//		System.out.print("请输入本月月份:");
//		int month=scanner.nextInt();
		//方法二
		Calendar calendar = Calendar.getInstance();
		int month = calendar.get(Calendar.MONTH); //得到的月份为正常减一
		System.out.println(month+1);
		
		Employee emps[] = new Employee[2];
		
		emps[0] = new SalariedEmployee("李白", 1001, new MyDate(2010, 1, 12),10000);
		emps[1] = new HourlyEmployee("QQ", 1002, new MyDate(2010, 11, 12),60,240);
		
		
		for(int i=0;i<emps.length;i++) {
			System.out.println(emps[i]);
			System.out.println("月工资为："+emps[i].earnings());
			if(emps[i].getBirthday().getMoth()==month+1) {
				System.out.println("生日快乐，奖励100元");
			}
		}
		
		
		
		
	}
}
