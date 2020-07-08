package user;
/**
* 
* @ClassName: Teacher
* @Description: 教师模型类：用于封装教师信息。
* @author zhoushaobin
* @date 2017年7月7日
*
*/
public class Teacher extends User {
	
	public Teacher(String userNo,String name){
		super(userNo,name,User.USER_TYPE_TEACHER);
	}
	
	public String toString(){
		return this.getUserNo()+":"+this.getName();
	}
}
