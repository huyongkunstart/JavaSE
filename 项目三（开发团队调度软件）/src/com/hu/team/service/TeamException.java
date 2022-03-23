package com.hu.team.service;
/**
 * 
* @Description 自定义异常类
* @author hu Email:3300786078@qq.com
* @version jdk1.8
* @date 2021年9月28日下午3:49:28
*
 */
public class TeamException extends Exception{
	static final long serialVersionUID = -3387516993124229948L;
	public TeamException() {
		super();
	}
	public TeamException(String msg) {
		super(msg);
	}
}
