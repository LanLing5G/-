package course;
import java.io.Serializable;
import java.util.*;
import score.Score;
import user.Student;
import user.Teacher;
/** 
* @ClassName: Course 
* @Description: 课程类，描述课程基本信息
* @author zhoushaobin
* @date 2017年11月17日 下午3:57:40 
*  
*/
public class Course implements Serializable{
	private String courseNo;
	private String courseName;
	private int credit;
	private int semster;
	private int period;
	private Teacher  teacher;
	private HashMap<String,Score>  scoreBook;	
	private ArrayList<Student> studentList;


	public Course(String courseNo,String courseName,int credit,int semster,int period,Teacher teacher){
		this.courseNo = courseNo;
		this.courseName = courseName;
		this.credit = credit;
		this.semster = semster;
		this.period = period;
		this.teacher = teacher;
		scoreBook = new HashMap<String ,Score>();
		studentList = new ArrayList<Student>();
	}
	/** 
	* @Title: getCredit 
	* @Description:  获取学分
	* @param @return
	* @return int 学分
	* @throws 
	*/
	public int getCredit() {
		return credit;
	}

	/** 
	* @Title: getSemster 
	* @Description:  获取学年
	* @param @return
	* @return int 学年
	* @throws 
	*/
	public int getSemster() {
		return semster;
	}

	/** 
	* @Title: getPeriod 
	* @Description:  获取学期
	* @param @return
	* @return int 学期
	* @throws 
	*/
	public int getPeriod() {
		return period;
	}

	/** 
	* @Title: getTeacher 
	* @Description:  获取教师信息
	* @param @return
	* @return Teacher 教师
	* @throws 
	*/
	public Teacher getTeacher() {
		return teacher;
	}

	/** 
	* @Title: getScoreBook 
	* @Description:  获取成绩单
	* @param @return
	* @return HashMap<String, Score> 成绩单集合
	* @throws 
	*/
	public HashMap<String, Score> getScoreBook() {
		return scoreBook;
	}




	/** 
	* @Title: getCourseName 
	* @Description:  获取课程名称
	* @param @return
	* @return String 课程名称
	* @throws 
	*/
	public String getCourseName() {
		return courseName;
	}
	/**
	 * 
	 * @Title: getCourseNo
	 * @Description: 获取课程编号
	 * @param 
	 * @param @return
	 * @return String 课程编号
	 * @throws 
	 */
	public String getCourseNo() {
			return courseNo;
	}
	/**
	 * 
	 * @Title: setScore
	 * @Description: 修改学生成绩
	 * @param s
	 *     学生成绩
	 * @param @return
	 * @return 
	 * @throws 
	 */
	public void setScore(Score  s){
		if(scoreBook.containsKey(s.getStudentNo())){
			scoreBook.put(s.getStudentNo(), s);
		}
	}
	/**
	 * 
	 * @Title: findScore
	 * @Description: 根据学号查询学生成绩
	 * @param studentNo    学号
	 * @param @return
	 * @return Score  成绩
	 * @throws 
	 */
	public Score findScore(String studentNo){
		return scoreBook.get(studentNo);
	}
	/** 
	* @Title: containsStudent 
	* @Description:  判断学生名单中是否包含某个学生
	 * @param student    学生对象
	* @param @return
	* @return boolean ：true(是)，false(否)
	* @throws 
	*/
	public boolean containsStudent(Student student){
		return studentList.contains(student);
	}
	/**
	 * 
	 * @Title: addStudent
	 * @Description: 在课程中添加学生
	 * @param student
	 *     学生对象
	 * @param @return
	 * @return 
	 * @throws 
	 */
	public void addStudent(Student student){
		if(!this.containsStudent(student)){
			studentList.add(student);
			scoreBook.put(student.getUserNo(), new Score(student.getUserNo(),this.courseNo,0));
		}
	}
	/**
	 * 
	 * @Title: removeStudent
	 * @Description: 从学生名单和成绩单中删除学生
	 * @param student
	 *     学生对象
	 * @param @return
	 * @return 
	 * @throws 
	 */
	public void removeStudent(Student student){
		studentList.remove(student);
		scoreBook.remove(student.getUserNo());
	}
	/**
	 * 
	 * @Title: getStudentList
	 * @Description: 获取课程的学生名单
	 * @param 
	 * @param @return
	 * @return ArrayList<Student> 学生名单
	 * @throws 
	 */
	public ArrayList<Student> getStudentList() {
		return studentList;
	}	


}
