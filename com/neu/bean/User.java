package com.neu.bean;

public abstract class User {
	
	private String userNO;
	private String anme;
	private String userPw;
	private int userType;
	
	//定义常量
	public final static int USER_TYPE_ADMIN=0;
	public final static int USER_TYPE_TEACHER=1;
	public final static int USER_TYPE_STUDENT=2;
	
	
	
	public User() {	}
	
	
	//构造方法,默认管理员，密码123456
	public User(String userNo,String name) {
		this.userNO=userNo;
		this.anme=name;
		this.userPw="123456";
		this.userType=User.USER_TYPE_ADMIN;
	}
	
	
	//构造方法，默认密码，123456.传3 个参数。
	public User(String userNo,String name,int userType) {
		this.userNO=userNo;
		this.anme=name;
		this.userPw="123456";
		this.userType=userType;
	}
	
	
	//构造方法，传4个参数。
	public User(String userNo,String name,String userPw,int userType) {
		this.userNO=userNo;
		this.anme=name;
		this.userPw=userPw;
		this.userType=userType;
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
	
	
	public String getUserPw() {
		return userPw;
	}
	public String getUserNO() {
		return userNO;
	}
	public String getAnme() {
		return anme;
	}
	
	
	
	public void setUserNO(String userNO) {
		this.userNO = userNO;
	}
	public void setAnme(String anme) {
		this.anme = anme;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public void setUserType(int userType) {
		this.userType = userType;
	}

}
