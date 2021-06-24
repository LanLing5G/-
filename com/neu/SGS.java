package com.neu;
//
import java.util.HashMap;
import com.neu.bean.Student;
import com.neu.bean.Teacher;
import com.sun.java_cup.internal.runtime.Scanner;
import com.sun.xml.internal.ws.api.ha.StickyFeature;

import jdk.nashorn.internal.runtime.regexp.joni.ScanEnvironment;
//
public class SGS {
	//所有老师编号。建
	public static HashMap<String, Student> school;
	//所有学生编号。建
	public static HashMap<String, Teacher> faculty;
	
	//初始化
	public static void init() {
		//实例化 school
		school=new HashMap<String,Student>();
		//定义s001张三,s002李四,s003王五
//		school.HashaMap<String,Student>("","";"","";"","");
		Student s001=new Student("s001","张三");
		Student s002=new Student("s002","李四");
		Student s003=new Student("s003","王五");
		//将学生放到school集合中
		school.put(s001.getUserNO(),s001);
		school.put(s002.getUserNO(),s002);
		school.put(s003.getUserNO(),s003);
		
		//实例化 faculty
		faculty=new HashMap<String,Teacher>();
		//定义 教师对象 t001唐僧,t002孙悟空,t003张三丰
		Teacher t001=new Teacher("t001","唐僧");
		Teacher t002=new Teacher("t002","孙悟空");
		Teacher t003=new Teacher("t003","张三丰");
		//将教师放到faculty集合中
		faculty.put(t001.getUserNO(),t001);
		faculty.put(t002.getUserNO(),t002);
		faculty.put(t003.getUserNO(),t003);
		
	}
	//
	public static void test() {
		//1.从集合对象school中取出s0001编号的学生，并打印。
		Student s=school.get("s001");
		System.out.println(s.getName());
		
		//2.1.从集合对象faculty中取出t0001编号的教师，并打印。
		Teacher t=faculty.get("t001");
		System.out.println(t.getName());
		
		//3.判断s002是否在school中
		Student s002=school.get("s002");
		if(s002.getName()!=null) {
			System.out.println("是，s002在school中");
		}
		else {
			System.out.println("否，s002不在school中");
		}
		
		//4.判断教师她的密码是不是123456
		Teacher t002=faculty.get("t002");
		if(t002!=null) {
			/*if(t002.getUserPw()=="123456") {
				System.out.println("是，密码是"+t002.getUserPw());
			}*/
			String userPwd=t002.getUserPw();
			if("123456".equals(userPwd)) {
				System.out.println("是，密码是"+t002.getUserPw());
			}
			else {
				System.out.println("否，密码不是"+t002.getUserPw());
			}
		}
		
	}
		//定义login的方法，根据传入的对象，判断学生是否在集合对象SHCOOL中，密码是123456
	public static void login(String stu) {
		String userNo=stu.getUserNO();
		//
		if(school.get(userNo)!=null) {
			System.out.println("是，学生在school中");
			String pwd=stu.getUserPw();
			//
			if("123456".equals(pwd)) {
				System.out.println(userNo+"学生密码正确！");
			}
			else {
				System.out.println(userNo+"学生密码错误！");
			}
		}
		else {
			System.out.println("否，学生不在school中");
		}
	}
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		init();
		test();
		//调用login，先创建学生对象。
		Student stu=new Student("s004","张三");
		login(stu);
	}

}
