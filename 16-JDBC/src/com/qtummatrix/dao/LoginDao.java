package com.qtummatrix.dao;

import com.qtummatrix.entity.User;

/**
 * 用户登录模块数据访问层
 * @author fucong
 *
 */
public interface LoginDao {

	/**
	 * 用户登录
	 * @param username 用户名
	 * @param password 密码
	 * @return 用户实体对象
	 */
	User  login(String username,String password);
	
	/**
	 * 登录退出
	 * @param userId 用户id
	 * @return 返回0 失败 返回1 成功
	 */
	int loginOut(int userId);
	
	/**
	 * 写入日志
	 * @param userId 用户id
	 * @return 返回true 成功 返回false 失败
	 */
	boolean writeLoginLog(int userId);
	
	/**
	 * 获取用户当天的登录次数
	 * @param userId 用户id
	 * @return 登录次数
	 */
	int getLoginCount(int userId);
	
	/**
	 * 签到
	 * @param userId用户id
	 * @return返回值 0.签到失败 1.签到成功 2.用户已经签到过
	 */
	int sign(int userId);
}
