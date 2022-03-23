package com.hu.c1.test;

//定义类Student，包括学号number（int），年级state（int），成绩score(int)
//创建20个学生对象，学号为1-20，年级和成绩随机数产生，
//问题一：打印出3年级的学生信息
//问题二：使用冒泡排序按学生成绩排序，并遍历所有学生信息

//提示：生成随机数: Math.random()  返回值为double类型
//四舍五入取整： Math.round(double d) 返回值类型Long
public class index1_test {
	public static void main(String[] args) {
		Student a[] = new Student[20];
		System.out.println("年级为3的学生信息:");
		for (int i = 0; i < a.length; i++) {
			a[i] = new Student();
			a[i].number = i + 1;
			a[i].state = (int) (Math.random() * 10 + 1);
			a[i].score = (int) (Math.random() * 100 + 1);
			if (a[i].state == 3) {
				System.out.println(a[i].info());
			}
		}
		
		System.out.println("------------------------------");
		System.out.println("排序后的结果为:");
		sort(a);
		//打印信息
		for(int j=0;j<a.length;j++) {
			System.out.println(a[j].info());
		}
	}
	//冒泡排序
	public static Student[] sort(Student a[]) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length - i - 1; j++) {
				if (a[j].score > a[j + 1].score) {
					Student temp = a[j];
					a[j] = a[j + 1];   
					a[j + 1] = temp;
				}
			}
		}
		return a;
	}
}

class Student {
	int number;
	int state;
	int score;

	public String info() {
		String a="学号为:"+number+"\t年级为:"+state+"\t成绩为:"+score;
		return a;
	}

}
