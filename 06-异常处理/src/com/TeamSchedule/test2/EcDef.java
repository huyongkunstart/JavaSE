package com.TeamSchedule.test2;
//自定义异常类
public class EcDef extends Exception{
static final long serialVersionUID = -7034897190745766939L;
	
	public EcDef() {
		
	}
	public EcDef(String msg) {
		super(msg);
	}
}
