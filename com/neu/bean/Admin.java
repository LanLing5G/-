package com.neu.bean;

public class Admin extends User {
	//构造函数，编号，姓名赋值。
	public Admin(String userNo, String name) {
		super(userNo, name,User.USER_TYPE_TEACHER);
		// TODO 自动生成的构造函数存根
	}


	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		 Admin n=new  Admin("999","终结者");
		 System.out.println(n.getUserNO()+"-"+n.getAnme());
	}

	
}
