package com.neu.bean;

public class Score {
	//1.studentNo编号		courseNo课程编号	grade成绩	三个私有属性
	private int grade;
	private String studentNo,courseNo;
	
	
	//2.get/set封装
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public String getStudentNo() {
		return studentNo;
	}
	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}
	public String getCourseNo() {
		return courseNo;
	}
	public void setCourseNo(String courseNo) {
		this.courseNo = courseNo;
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
