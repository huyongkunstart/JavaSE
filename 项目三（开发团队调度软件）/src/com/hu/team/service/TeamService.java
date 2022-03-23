package com.hu.team.service;
/**
 * 
* @Description 关于开发团队成员的管理：添加、删除等
* @author hu Email:3300786078@qq.com
* @version jdk1.8
* @date 2021年9月30日上午8:26:41
*
 */

import com.hu.team.domain.Architect;
import com.hu.team.domain.Designer;
import com.hu.team.domain.Employee;
import com.hu.team.domain.Programmer;

public class TeamService {
	private static int counter =1; //给memberId赋值
	private final int MAX_MEMBER=5; //开发团队最大成员数
	private Programmer[] team = new Programmer[MAX_MEMBER]; //当前团队中的各成员对象
	private int total; //团队成员的实际人数
	public TeamService() {
		super();
	}
	
	public Programmer[] getTeam() { //获取开发团队中的所有成员
		Programmer[] team = new Programmer[total];
		for(int i=0;i<team.length;i++) {
			team[i] = this.team[i];
		}		
		return team;
	}
	
	//将指定的员工添加到开发团队中
	public void addMember(Employee e) throws TeamException {
// 		成员已满，无法添加
		if(total >= MAX_MEMBER) {
			throw new TeamException("成员已满，无法添加");
		}
//		该成员不是开发人员，无法添加
		if(!(e instanceof Programmer)) {
			throw new TeamException("该成员不是开发人员，无法添加");
		}
//		该员工已在本开发团队中
		if(isExist(e)) {
			throw new TeamException("该员工已在本开发团队中");
		}
//		该员工已是某团队成员		
//		该员正在休假，无法添加
		Programmer p = (Programmer)e;//一定不会出现ClassCastException
		/*if("BUSY".equals(p.getStatus().getNAME())) {
			throw new TeamException("该员工已是某团队成员");
		}else if("VOCATION".equals(p.getStatus().getNAME())) {
			throw new TeamException("该员正在休假，无法添加");
		}*/
		//使用枚举类后更改为
		switch (p.getStatus()){
			case BUSY:
				throw new TeamException("该员工已是某团队成员");
			case VOCATION:
				throw new TeamException("该员正在休假，无法添加");
		}
//		团队中至多只能有一名架构师
//		团队中至多只能有两名设计师
//		团队中至多只能有三名程序员		
		//获取team已有成员中架构师，设计师，程序员的人数
		int numOfArch= 0,numOfDes= 0,numOfPro= 0;
		for(int i=0;i<total;i++) {
			if(team[i] instanceof Architect) {
				numOfArch++;
			}else if (team[i] instanceof Designer) {
				numOfDes++;
			}else if (team[i] instanceof Programmer) {
				numOfPro++;
			}
		}		
		if(p instanceof Architect) {
			if(numOfArch >= 1) {
				throw new TeamException("团队中至多只能有一名架构师");
			}
		}else if (p instanceof Designer) {
			if(numOfDes >= 2) {
				throw new TeamException("团队中至多只能有两名设计师");
			}
		}else if (p instanceof Programmer) {
			if(numOfPro >= 3) {
				throw new TeamException("团队中至多只能有三名程序员");
			}
		}
				
		//能走到这一步，将e或p添加到现有的team中
		team[total++] = p;
		//p的属性赋值 ，状态status 和 memberId
		p.setStatus(Status.BUSY);
		p.setMemberId(counter++);  		
	}
	
	//判断e员工是否在本开发团队中
	private boolean isExist(Employee e) {
		for(int i=0;i<total;i++) {
			if(e.getId() == team[i].getId()) {//此处也可以用memberId，需要把e强转一下
				return true;
			}
		}
		return false;
	}

	//从团队当中删除成员
	public void removeMember(int memberId) throws TeamException {
		int i=0;
		for(;i<total;i++) {
			if(team[i].getMemberId() == memberId) {
				team[i].setStatus(Status.FREE);
				break;
			}
		}
		
		//未找到指定memberId的情况
		if(i == total) {
			throw new TeamException("找不到指定memberId的员工，删除失败");
		}
		 
		//在上面循环找到了，然后后一个元素覆盖前一个元素，实现删除
		for(int j=i+1;j<total;j++) {
			team[j-1] = team[j];
		}		
		team[--total] = null;		
	}	
}
