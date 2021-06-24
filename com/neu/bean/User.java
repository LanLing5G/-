package com.neu.bean;

public abstract class User {
	
	private String userNo;	//用户id
	private String name;	///编号
	private String userPw;	//密码
	private int userType;	//
	
	//定义常量
	public final static int USER_TYPE_ADMIN=0;//管理员
	public final static int USER_TYPE_TEACHER=1;
	public final static int USER_TYPE_STUDENT=2;
	
	
	//默认构造函数
	public User() {	}
	//构造方法,默认管理员，密码123456.传2个参数.
	public User(String userNo,String name) {
		this.userNo=userNo;
		this.name=name;
		this.userPw="123456";
		this.userType=User.USER_TYPE_ADMIN;
	}
	//构造方法，默认密码，123456.传3 个参数。
		public User(String userNo,String name,int userType) {
			this.userNo=userNo;
			this.name=name;
			this.userPw="123456";
			this.userType=userType;
		}
		//构造方法，传4个参数。
		public User(String userNo,String name,String userPw,int userType) {
			this.userNo=userNo;
			this.name=name;
			this.userPw=userPw;
			this.userType=userType;
		}
		
		
	public String getName() {
		return name;
	}
	public String getUserPw() {
		return userPw;
	}
	public String getUserNo() {
		return userNo;
	}
	public String getAnme() {
		return name;
	}
	
	
	public static int getUserTypeAdmin() {
		return USER_TYPE_ADMIN;
	}
	public static int getUserTypeTeacher() {
		return USER_TYPE_TEACHER;
	}
	public static int getUserTypeStudent() {
		return USER_TYPE_STUDENT;
	}
	
	
	public int getUserType() {
		return userType;
	}
	
	
	public void setUserNo(String userNO) {
		this.userNo = userNO;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public void setUserType(int userType) {
		this.userType = userType;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
