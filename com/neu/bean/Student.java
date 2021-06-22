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

	//构造方法，所有属性
//	public Student(String userNo, String name, String userPw, int userType) {
//		super(userNo, name, userPw, userType);
//		// TODO 自动生成的构造函数存根
//	}
	public Student(String userNo, String name, String userPw, int userType) {
		super(userNo,name,User.USER_TYPE_STUDENT);
		this.sex=sex;
		this.age=age;
		this.department=department;
		// TODO 自动生成的构造函数存根
	}
	
//	
//	public String getSex() {
//		return sex;
//	}
//
//
//	public void setSex(String sex) {
//		this.sex = sex;
//	}
//
//
//	public int getAge() {
//		return age;
//	}
//
//
//	public void setAge(int age) {
//		this.age = age;
//	}
//
//
//	public String getDepartment() {
//		return department;
//	}
//
//
//	public void setDepartment(String department) {
//		this.department = department;
//	}
//
//
//	public Student() {
//		super();
//		// TODO 自动生成的构造函数存根
//	}
//	
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		//学生对象，编号s001,张良，男，21计算机系。
		Student stu=new Student("s001","张良","男",21);
		//打印学生的姓名 编号，年龄。
		System.out.println(stu.getName()+"-"+stu.getUserNO()+"-"+stu.getAnme());
	}


	
}
