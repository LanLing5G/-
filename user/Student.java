package user;
/**
* 
* @ClassName: Student
* @Description: 学生模型类：用于封装学生信息。
* @author zhoushaobin
* @date 2017年7月7日
*
*/
public class Student extends User{
	private String sex;
	private int age;
	private String department;
	public Student(String studentNo,String name,String sex,int age,String department){
		super(studentNo,name,User.USER_TYPE_STUDENT);
		this.sex = sex;
		this.age = age;
		this.department = department;
	}
	public Student(String studentNo,String name){
		this(studentNo,name,"男",19,"计算机系");
	}
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
	public boolean equals(Object o){
		if(o instanceof Student){
			Student s = (Student)o;
			return this.getUserNo().equals(s.getUserNo());
		}else{
			return false;
		}
	}
	
}
