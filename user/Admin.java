package user;

import java.io.Serializable;
/**
* 
* @ClassName: Admin
* @Description: 管理员模型类：用于封装管理员信息。
* @author zhoushaobin
* @date 2017年7月7日
*
*/
public class Admin extends User implements Serializable{
	public Admin(String userNo,String name){
		super(userNo,name,User.USER_TYPE_ADMIN);
	}
}
