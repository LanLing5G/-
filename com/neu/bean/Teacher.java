package com.neu.bean;

public class Teacher extends User {
	
	//构造函数(编号,姓名)赋值
//	public Teacher(String userNo,String name) {
//		super()
//	}
	
	
	public Teacher(String userNo, String name) {
		super(userNo, name,User.USER_TYPE_TEACHER);
		// TODO 自动生成的构造函数存根
	}

	
	public Teacher() {
		super();
		// TODO 自动生成的构造函数存根
	}
	public Teacher(String userNo, String name, int userType) {
		super(userNo, name, userType);
		// TODO 自动生成的构造函数存根
	}
	public Teacher(String userNo, String name, String userPw, int userType) {
		super(userNo, name, userPw, userType);
		// TODO 自动生成的构造函数存根
	}
	


	public static void main(String[] args) {
		//老师，t123,张三丰
		//打印
		Teacher n=new Teacher("t123","张三丰");
		System.out.println(n.getUserNo()+"-"+n.getAnme());
	}

	
}
