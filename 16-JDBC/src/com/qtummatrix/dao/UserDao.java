package com.qtummatrix.dao;

import com.qtummatrix.entity.User;

/**
 * 用户管理模块数据访问层
 * @author fucong
 *
 */
public interface UserDao {

	/**
	 * 用户注册
	 * @param user 注册信息
	 * @return返回值 true成功 false失败
	 */
	boolean regist(User user);
	
	/**
	 * 更新用户信息
	 * @param user 更新的用户信息
	 * @return 0.更新失败 1.更新成功
	 */
	int updateUser(User user);
	
	/**
	 * 根据用户id查询用户信息
	 * @param userId 用户id
	 * @return返回用户信息
	 */
	User getUserById(int userId);
}
