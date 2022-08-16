package com.qtummatrix.view;

import java.util.List;
import java.util.Scanner;

import com.qtummatrix.entity.Goods;
import com.qtummatrix.entity.User;
import com.qtummatrix.service.GoodsService;
import com.qtummatrix.service.LoginService;
import com.qtummatrix.service.impl.GoodsServiceImpl;
import com.qtummatrix.service.impl.LoginServiceImpl;

/**
 * 表示层
 * @author fucong
 *
 */
public class TestMail {
	
	private static LoginService loginService;
	private static GoodsService goodsService;
	
	public synchronized static LoginService getLoginInstance(){
		if(loginService==null){
			loginService=new LoginServiceImpl();
		}
		return loginService;
	}
	
	public synchronized static GoodsService getGoodsInstance(){
		if(goodsService==null){
			goodsService=new GoodsServiceImpl();
		}
		return goodsService;
	}
	

	public static void main(String[] args) {
		
		User user=getLoginInstance().login("张三", "123");
		if(user!=null){
			System.out.println("登录成功");
			//登录成功=写入登录日志+统计登录次数
			//写入日志操作是非主线业务-异步操作
			MyThread1 myThread1=new MyThread1(user.getId());
			myThread1.start();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int count=getLoginInstance().getLoginCount(user.getId());
			System.out.println("欢迎"+user.getUsername()+",这是您今天的第"+count+"次登录");
			//签到=查询是否签到过+签到+更新用户账户余额
			System.out.println(getLoginInstance().sign(user.getId()));
			//查询商品=商品名称+商品分类名称
			while(true){
				Scanner scanner=new Scanner(System.in);		
				System.out.println("请输入查询的商品名称：");
				String goodsName=scanner.nextLine();
				System.out.println("请输入查询的商品分类名称：");
				String goodsTypeName=scanner.nextLine();	
				List<Goods> goods=getGoodsInstance().getGoods(goodsName, goodsTypeName);
				for (Goods goods2 : goods) {
					System.out.println(goods2);
				}
				System.out.println("是否继续查询？1.是 2.否");
				String result=scanner.nextLine();
				if(result.equals("1")){
					continue;
				}
				else{
					break;
				}
			}
			//兑换商品=更新商品库存+生成兑换记录
			
			//退出登录=更新登录日志
		}
		else{
			System.out.println("登录失败");
		}
	}
}


class MyThread1 extends Thread{
	private int userId=0;
	
	public MyThread1(int userId) {
		this.userId=userId;
	}

	@Override
	public void run() {
		LoginService LoginService=new LoginServiceImpl();
		LoginService.writeLoginLog(userId);
	}
	
	
}
