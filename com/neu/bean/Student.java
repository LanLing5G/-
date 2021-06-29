package com.neu.bean;
/**
 * 1.继承User
 * 构造函数
 * 
 * 2.定义内部变量-
 * 性别 sex
 * 年龄 age
 * 系 department
 * 3.get/set封装
 * @author Lenovo
 *
 */
public class Student extends User{
	private String sex;		//性别
	private int age;		//年龄
	private String department;	//系部
	
	
	//属性的封装1234
	public Student() {
		super();
		// TODO 自动生成的构造函数存根
	}
	public Student(String userNo, String name) {
		super(userNo, name);
		// TODO 自动生成的构造函数存根
	}
	public Student(String userNo, String name, int userType) {
		super(userNo, name, userType);
		// TODO 自动生成的构造函数存根
	}
	public Student(String userNo, String name, String userPw, int userType) {
		// TODO 自动生成的构造函数存根
	}
	
	//1.属性的封装5
	public Student(String userNo, String name ,String sex, int age,String department) {
		super(userNo, name, User.USER_TYPE_STUDENT);
		this.sex=sex;
		this.age=age;
		this.department=department;
		// TODO 自动生成的构造函数存根
	}

	
	//2.get/set封装
	public String getSex() {
		return sex;
	}
	public String getDepartment() {
		return department;
	}
	public int getAge() {
		return age;
	}
	
	
	public void setSex(String sex) {
		this.sex = sex;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setDepartment(String department) {
		this.department = department;
	}


	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		//学生对象，编号s001,张良，男，21，计算机系。
		Student stu=new Student("s001","张良","男",21,"计算机系");
		//打印学生的姓名 编号，年龄。
		System.out.println(stu.getName()+"-"+stu.getUserNo()+"-"+stu.getAge());
	}
	
}
