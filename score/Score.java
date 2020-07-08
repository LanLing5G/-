package score;

import java.io.Serializable;
/**
* 
* @ClassName: Score
* @Description: 成绩模型类：描述得分、学生和课程之间的对应关系
* @author zhoushaobin
* @date 2017年7月7日
*
*/
public class Score implements Serializable{
	private String studentNo;
	private String courseNo;
	private int grade;
	public Score(String studentNo,String courseNo,int grade){
		this.studentNo = studentNo;
		this.courseNo = courseNo;
		this.grade = grade;
	}
	/** 
	* @Title: getStudentNo 
	* @Description:  获取学号
	* @param @return
	* @return String 学号
	* @throws 
	*/
	public String getStudentNo() {
		return this.studentNo;
	}
	/** 
	* @Title: getGrade 
	* @Description:  获取得分
	* @param @return
	* @return int 得分
	* @throws 
	*/
	public int getGrade() {
		return grade;
	}
	/** 
	* @Title: getCourseNo 
	* @Description:  获取课程编号
	* @param @return
	* @return String 课程编号
	* @throws 
	*/
	public String getCourseNo() {
		return courseNo;
	}
	
}
