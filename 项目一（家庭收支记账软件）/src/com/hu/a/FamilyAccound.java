package com.hu.a;
/**
 * 
 * @Description
 * @author hu Email:huyongkun2000@163.com
 * @version
 * @date 2021年1月20日上午9:25:13
 */
public class FamilyAccound {

	public static void main(String[] args) {
		boolean isFlag=true;	
		String details="";
		int balance=10000;
		while(isFlag) {
			System.out.println("------家庭收支记账软件------");
			System.out.println("------1.收支明细----------");
			System.out.println("------2.登记收入----------");
			System.out.println("------3.登记支出----------");
			System.out.println("------4.退出-------------");
			System.out.println("请选择1-4:");
			//获取1-4
			char selection = Utility.readMenuSelection();
			switch(selection) {
				case '1':
					//System.out.println("1.收支明细");
					System.out.println("------当前收支明细记录--------");
					System.out.println("收支\t账户金额\t收支金额\t说    明\n");
					System.out.println(details);
					System.out.println("--------------------------");
					break;
				case '2':
					//System.out.println("2.登记收入");
					System.out.print("本次收入金额:");
					int money =Utility.readNumber();
					System.out.print("本次收入说明:");
					String info=Utility.readString();
					balance +=money;
					details +=("收入\t" + balance + "\t" + money + "\t"+info);				
					System.out.println("----------登记完成------------！");
					break;
				case '3':
					//System.out.println("3.登记支出");
					System.out.print("本次支出金额:");
					int money1 =Utility.readNumber();
					System.out.print("本次支出说明:");
					String info1=Utility.readString();
					if(balance >=money1) {
						balance -=money1;
						details +=("支出\t" + balance + "\t" + money1 + "\t"+info1);
						System.out.println("--------------登记完成！------------");
					}else {
						System.out.println("支出超出账户额度，支付失败");
					}
					break;
				case '4':
					//System.out.println("4.退出");
					System.out.print("确认是否退出(Y/N):");
					char isExit=Utility.readConfirmSelection();
					if(isExit == 'Y') {
						isFlag=false;
					}
			}
		}

	}

}
