package com.neu.bean;
/**
 * 性别 sex
 * 年龄 age
 * 系 department
 * @author Lenovo
 *
 */
public class Student extends User{
	private String sex;
	private int age;
	private String department;
	
	public Student() {
		super();
		// TODO 自动生成的构造函数存根
	}

	public Student(String userNo, String name, int userType) {
		super(userNo, name, userType);
		// TODO 自动生成的构造函数存根
	}

	//属性的封装
	public Student(String userNo, String name, String userPw, int userType) {
		super(userNo,name,User.USER_TYPE_STUDENT);
		this.sex=userNo;
		this.age=userType;
		this.department=userPw;
		// TODO 自动生成的构造函数存根
	}
	
	public Student(String userNo, String name) {
		super(userNo, name);
		// TODO 自动生成的构造函数存根
	}

	//2.get/set封装
	public String getSex() {
		return sex;
	}


	public void setSex(String sex) {
		this.sex = sex;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getDepartment() {
		return department;
	}


	public void setDepartment(String department) {
		this.department = department;
	}


	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		//学生对象，编号s001,张良，男，21计算机系。
		Student stu=new Student("s001","张良","男",21);
		//打印学生的姓名 编号，年龄。
		System.out.println(stu.getName()+"-"+stu.getUserNO()+"-"+stu.getAnme());
	}


	
}
