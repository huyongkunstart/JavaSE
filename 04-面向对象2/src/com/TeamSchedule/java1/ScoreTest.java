package com.TeamSchedule.java1;

import java.util.Scanner;
import java.util.Vector;

/*
 * 利用Vector代替数组处理：从键盘读入学生成绩（以负数代表输入结束），找出
最高分，并输出学生成绩等级。
提示：数组一旦创建，长度就固定不变，所以在创建数组前就需要知道它的
长度。而向量类java.util.Vector可以根据需要动态伸缩。
创建Vector对象：Vector v=new Vector();
给向量添加元素：v.addElement(Object obj); //obj必须是对象
取出向量中的元素：Object obj=v.elementAt(0);
注意第一个元素的下标是0，返回值是Object类型的。
计算向量的长度：v.size();
若与最高分相差10分内：A等；20分内：B等；
30分内：C等；其它：D等
 */
public class ScoreTest {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		//定义数组对象
		Vector v = new Vector();
		//输入学生成绩
		int maxscore=0;
		for(;;) {
			System.out.println("请输入学生成绩(以负数代表输入结束):");
			int score = scan.nextInt();
			if(score<0) {
				break;
			}
			if(score>100) {
				System.out.println("输入数据非法，请重新输入:");
				continue;
			}
			v.addElement(score);
			//获取最大成绩
			if(score>maxscore) {
				maxscore=score;
			}
		}
		
		//遍历Vector，得到每个学生成绩，并与最大值比较，得到每个学生的等级
		char leval;
		for(int i=0;i<v.size();i++) {
			Object obj = v.elementAt(i);
			//包装类转为基本数据类型
			Integer score = (Integer)obj;
			//int score = (int)obj;
			
			if(maxscore-score <=10) {
				leval ='A';
			}else if(maxscore-score <=20) {
				leval ='B';
			}else if(maxscore-score <=30) {
				leval ='C';
			}else {
				leval ='D';
			}
			
			System.out.println("学生:"+i+"成绩是:"+score+"等级是:"+leval);
		}
		
	}
}
