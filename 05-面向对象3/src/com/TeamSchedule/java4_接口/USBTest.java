package com.TeamSchedule.java4_接口;
//接口的多态性
public class USBTest {
	public static void main(String[] args) {
		Computer a = new Computer();
		
		//创建接口的 非匿名实现类的非匿名对象
		Flash flash = new Flash();
		a.transferDate(flash);
		
		//创建接口的 非匿名实现类的匿名对象
		a.transferDate(new Printer());
		
		
		//创建了接口的匿名实现类的非匿名对象
		System.out.println("**************************");
		USB b = new USB() {

			@Override
			public void start() {
				System.out.println("MP3开始工作");
			}

			@Override
			public void stop() {
				System.out.println("MP3结束工作");
			}
			
		};
		a.transferDate(b);
		
		//创建接口的匿名实现类的匿名对象
		System.out.println("************************");
		a.transferDate(new USB() {
			@Override
			public void start() {
				System.out.println("电脑开始工作");
			}

			@Override
			public void stop() {
				System.out.println("电脑结束工作");
			}
		});
		
	}
}

class Computer{
	public void transferDate(USB usb) {
		usb.start(); 
		System.out.println("数据开始传送数据");
		usb.stop();
	}
}


interface USB{
	//定义了长，宽等
	void start(); //默认就是抽象方法，省略了public abstract
	public abstract void stop(); 
}

class Flash implements USB{

	@Override
	public void start() {
		System.out.println("U盘开始工作");
	}

	@Override
	public void stop() {
		System.out.println("U盘结束工作");
	}
	
}

class Printer implements USB{

	@Override
	public void start() {
		System.out.println("打印机开始工作");
	}

	@Override
	public void stop() {
		System.out.println("打印机结束工作");
	}
	
}