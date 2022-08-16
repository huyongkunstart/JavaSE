package com.teanschedule.service;

import com.teanschedule.domain.*;
import org.testng.annotations.Test;

/**
 * @author huyongkun
 * @ClassName TeamService
 * @create 2022-06-02 18:05
 * @Version 1.0
 * @description: 团队成员类,
 */
public class TeamService {
    private static int counter = 1; //自动生成成员在团队中的Memberid
    private final int MAX_MEMBER = 5;
    private Programmer[] team =  new Programmer[MAX_MEMBER]; //存放当前团队成员的对象
    private int total = 0; //记录团队成员的实际人数

    /*
     * @Author huyongkun
     * @Date 21:14 2022/6/2
     * @Param []
     * @return com.teanschedule.domain.Programmer[]
     * @Description //返回当前团队的所有对象
     **/
    public Programmer[] getTeam(){
        Programmer[] programmers = new Programmer[total];
        for (int i = 0; i < total; i++) {
            programmers[i] = team[i];
        }
        return programmers;
    }
    /*
     * @Author huyongkun
     * @Date 21:14 2022/6/2
     * @Param [e]
     * @return void
     * @Description //向团队中添加成员
     **/
    public void addMember(Employee e){
//        成员已满，无法添加
        if (total >= MAX_MEMBER){
            throw new TeamException("成员已满，无法添加");
        }
//        该成员不是开发人员，无法添加
        if(!(e instanceof Programmer)){
            throw new TeamException("该成员不是开发人员，无法添加");
        }
        Programmer p = (Programmer) e;
//        该员工已在本开发团队中
        if(isExist(p)){
            throw new TeamException("该员工已在本开发团队中");
        }
//        该员工已是某团队成员
//        该员正在休假，无法添加
        if(p.getStatus().getNAME().equals("BUSY")){
            throw new TeamException("该员工已是某团队成员");
        }else if(p.getStatus().getNAME().equals("VACATION")){
            throw new TeamException("该员正在休假，无法添加");
        }

        int arinumber = 0; //记录团队中架构师数量
        int desnumber = 0; //设计师数量
        int pronumber = 0; //程序员数量
        for (int i = 0; i < total; i++) {
            if(team[i] instanceof Arichitect){
                arinumber++;
            }else if(team[i] instanceof Designer){
                desnumber++;
            }else{
                pronumber++;
            }
        }
//        团队中至多只能有一名架构师
//        团队中至多只能有两名设计师
//        团队中至多只能有三名程序员
        if(p instanceof Arichitect){
            if(arinumber >= 1){
                throw new TeamException("团队中至多只能有一名架构师");
            }
        }else if(p instanceof Designer){
            if(desnumber >=2){
                throw new TeamException("团队中至多只能有两名设计师");
            }
        }else{
            if(pronumber >= 3){
                throw new TeamException("团队中至多只能有三名程序员");
            }
        }
        //判断完之后，可以添加了
        p.setMemberId(counter++);
        p.setStatus(Status.BUSY);
        team[total++] = p;
    }

    public boolean isExist(Programmer e) {
        for (int i = 0; i < total; i++) {
            if(team[i].getMemberId() == e.getMemberId()){
                return true;
            }
        }
        return false;
    }

    /*
     * @Author huyongkun
     * @Date 21:14 2022/6/2
     * @Param [memberid]
     * @return void
     * @Description //从团队中删除成员
     * 异常：找不到指定memberId的员工，删除失败
     **/
    public void removeMember(int memberid){
        int i;
        for (i = 0; i < total; i++) {
            if(team[i].getMemberId() == memberid){ //找到了
                team[i].setStatus(Status.FREE);
                for (int j = i; j < total-1; j++) {
                    team[j] = team[j+1];
                }
                team[--total] = null;
                break;
            }
        }
        if(i >= total){ //没有找到
            throw new TeamException("找不到指定memberId的员工，删除失败");
        }
    }

}
