package com.TeamSchedule.java2;
//手动抛出异常
public class StudentTest {
	public static void main(String[] args) {
		try {
			Student s = new Student();
			s.regist(-1001);
			System.out.println(s);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}


		
	}
}



class Student{
	private int id;
	
	public void regist(int id){
		if(id >0) {
			this.id = id;
		}else {
//			System.out.println("你输入的数据非法！");
			//手动抛出异常对象
//			throw new Exception("你输入的数据非法！");
			throw new MyException("不能输入负数");
		}
	}

	@Override
	public String toString() {
		return "Student [id=" + id + "]";
	}
	
}