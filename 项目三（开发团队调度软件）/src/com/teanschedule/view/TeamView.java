package com.teanschedule.view;

import com.teanschedule.domain.Employee;
import com.teanschedule.domain.Programmer;
import com.teanschedule.domain.TeamException;
import com.teanschedule.service.NameListService;
import com.teanschedule.service.TeamService;

/**
 * @author huyongkun
 * @ClassName TeamView
 * @create 2022-06-02 23:46
 * @Version 1.0
 * @description: 用户窗口类
 */
public class TeamView {
    private NameListService listSvc = new NameListService();
    private TeamService teamSvc = new TeamService();

    //主界面显示及控制
    public void enterMainMenu(){
        boolean flag = true;
        char key = 0;

        while (flag){
            if(key != '1'){
                listAllEmployees();
            }
            System.out.println("1-团队列表 2-添加成员 3-删除团队成员 4-退出 请选择(1-4):");
            key = TSUtility.readMenuSelection();
            switch (key){
                case '1':
                    getTeam();
                    break;
                case '2':
                    addMember();
                    break;
                case '3':
                    deleteMember();
                    break;
                case '4':
                    System.out.println("确认是否要删除(Y/N)?");
                    char c = TSUtility.readConfirmSelection();
                    if(c == 'Y'){
                        flag = false;
                    }
                    break;
            }
        }
    }
    //列出公司所有成员
    private void listAllEmployees(){
        System.out.println("--------------------------------开发团队调度软件------------------------------------");
        Employee[] allEmployees = listSvc.getAllEmployees();
        if(allEmployees.length == 0){
            System.out.println("没有客户记录");
        }else{
            System.out.println("ID\t姓名\t\t年龄\t\t工资\t\t职位\t\t状态\t\t奖金\t\t股票\t\t领用设备");
        }
        for (Employee allEmployee : allEmployees) {
            System.out.println(allEmployee.toString());
        }
        System.out.println("---------------------------------------------------------------------------------");
    }

    //显示团队成员列表
    private void getTeam(){
        System.out.println("--------------------------------团队成员列表---------------------------------------");
        Programmer[] team = teamSvc.getTeam();
        if(team.length == 0){
            System.out.println("开发团队目前没有成员");
        }else{
            System.out.println("TID/ID\t姓名\t年龄\t工资\t职位\t奖金\t股票\t");
        }
        for (Programmer p : team) {
            System.out.println(p.showteam());
        }
        System.out.println("---------------------------------------------------------------------------------");
    }
    //实现添加成员操作
    private void addMember(){
        System.out.println("---------------------添加成员---------------------");
        System.out.print("请输入要添加的员工ID：");
        int id = TSUtility.readInt();
        try {
            Employee e = listSvc.getEmployee(id);
            teamSvc.addMember(e);
            System.out.println("添加成功");
        } catch (TeamException e) {
            System.out.println("添加失败，原因：" + e.getMessage());
        }
        // 按回车键继续...
        TSUtility.readReturn();
    }

    //实现删除成员操作
    private void deleteMember(){
        System.out.println("---------------------删除成员---------------------");
        System.out.print("请输入要删除员工的TID：");
        int id = TSUtility.readInt();
        System.out.print("确认是否删除(Y/N)：");
        char yn = TSUtility.readConfirmSelection();
        if (yn == 'N')
            return;

        try {
            teamSvc.removeMember(id);
            System.out.println("删除成功");
        } catch (TeamException e) {
            System.out.println("删除失败，原因：" + e.getMessage());
        }
        // 按回车键继续...
        TSUtility.readReturn();
    }

    public static void main(String[] args) {
        TeamView teamView = new TeamView();
        teamView.enterMainMenu();
    }
}
