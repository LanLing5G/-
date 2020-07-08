package user;

import java.io.Serializable;

/**
* 
* @ClassName: User
* @Description: 所有用户父类：用于描述所有用户信息。
* @author zhoushaobin
* @date 2017年7月7日
*
*/
public abstract class User implements Serializable{
	private String userNo;//用户ID号（系统内唯一）
	private String name;//用户姓名
	private String userPw;//用户密码
	private int userType;//0-admin;1-teacher;2-student;
	public final static int USER_TYPE_ADMIN = 0;
	public final static int USER_TYPE_TEACHER = 1;
	public final static int USER_TYPE_STUDENT = 2;
	public User(String userNo,String name,String userPw,int userType){
		this.userNo = userNo;
		this.name = name;
		this.userPw = userPw;
		this.userType = userType;
	}
	public User(String userNo,String name,int userType){
		this(userNo,name,"11",userType);
	}
	public User(String userNo,String name){
		this(userNo,name,User.USER_TYPE_ADMIN);
	}
	
	/**
	 * 
	 * @Title: verifyPassword
	 * @Description: 验证用户编号和密码。
	 * @param userNo 用户编号
	 * @param userPw 用户密码
	 * @param @return int 用户类别，如果失败返回-1
	 * @return 
	 * @throws
	 */
	public int verifyPassword(String userNo,String userPw){
		if(this.userNo.equals(userNo)&&this.userPw.equals(userPw)){
			return this.userType;
		}else{
			return -1;
		}
	}
	public String getUserNo() {
		return userNo;
	}
	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public int getUserType() {
		return userType;
	}
	public void setUserType(int userType) {
		this.userType = userType;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}	


}
