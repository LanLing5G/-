package com.neu.bean;

public class Teacher extends User {
	//构造函数编号姓名赋值
//	public Teacher(String userNo,String name) {
//		super()
//	}
	public Teacher(String userNo, String name) {
		super(userNo, name,User.USER_TYPE_TEACHER);
		// TODO 自动生成的构造函数存根
	}

	
	public static void main(String[] args) {
		//老师，t123,张三丰
		//打印
		Teacher n=new Teacher("t123","张三丰");
		System.out.println(n.getUserNO()+"-"+n.getAnme());
	}

	
}
