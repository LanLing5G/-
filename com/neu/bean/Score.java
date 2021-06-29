package com.neu.bean;
/**
 * 1.定义内部变量-
 * 编号studentNo		
 * 课程编号courseNo	
 * 成绩grade
 * 2.get/set封装
 * 3.属性的封装(构造函数)
 * 
 * @author tydd
 *
 */

public class Score {
	//1.studentNo编号		courseNo课程编号	grade成绩	三个私有属性
	private int grade;		//成绩
	private String studentNo;	//编号	
	private String courseNo;	//课程编号
	
	
	//2.get/set封装
	public int getGrade() {
		return grade;
	}
	public String getStudentNo() {
		return studentNo;
	}
	public String getCourseNo() {
		return courseNo;
	}
	
	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}
	public void setCourseNo(String courseNo) {
		this.courseNo = courseNo;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	
	//3.三个属性的封装
	public Score(String studentNo, String courseNo,int grade ) {
		super();
		this.grade = grade;
		this.studentNo = studentNo;
		this.courseNo = courseNo;
	}
	
	
	//4.成绩属性的构造函数
	public Score(int grade) {
		super();
		this.grade = grade;
	}
	
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		//1.studentNo=s001, courseNo=c001, grade=98
		Score Score=new Score("s001","c001",98);
		
		//2.打印成绩
		System.out.println(/* Score.getStudentNo()+"_"+Score.getCourseNo()+"_"+ */Score.getGrade());
		
		//grade=100
		Score Scores=new Score(100);
		//2.打印成绩
		System.out.println(Scores.getGrade());
	}
	
}
