package com.qtummatrix.service.impl;

import com.qtummatrix.dao.LoginDao;
import com.qtummatrix.dao.impl.LoginDaoImpl;
import com.qtummatrix.entity.User;
import com.qtummatrix.service.LoginService;

public class LoginServiceImpl implements LoginService{
	
	private static LoginDao loginDao;
	
	public synchronized static LoginDao getLoginInstance(){
		if(loginDao==null){
			loginDao=new LoginDaoImpl();
		}
		return loginDao;
	}

	@Override
	public User login(String username, String password) {
		User user=getLoginInstance().login(username, password);
		return user;
	}

	@Override
	public void loginOut(int userId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String writeLoginLog(int userId) {
		String message="";
		boolean result=getLoginInstance().writeLoginLog(userId);
		if(result){
			message="成功写入日志";
		}
		else{
			message="写入日志失败";
		}
		return message;
	}

	@Override
	public int getLoginCount(int userId) {		
		return getLoginInstance().getLoginCount(userId);
	}

	@Override
	public String sign(int userId) {
		String message="";
		int count=getLoginInstance().sign(userId);
		if(count==0){
			message="签到失败";
		}
		else if(count==1){
			message="签到成功";
		}
		else{
			message="用户已经签到过";
		}
		return message;
	}

	
}
