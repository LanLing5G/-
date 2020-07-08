package course;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import score.Score;
/**
* 
* @ClassName: CourseCatalog
* @Description: 开课目录类，描述课开课目录基本信息
* @author zhoushaobin
* @date 2017年7月7日
*
*/
public class CourseCatalog implements Serializable{

	private HashMap<String, Course> courses;

	public HashMap<String, Course> getAllCourses() {
		return courses;
	}

	public CourseCatalog() {
			courses = new HashMap<String, Course>();
	}
	/**
	 * 
	 * @Title: addCourse
	 * @Description: 向开课目录中添加课程
	 * @param c
	 *        课程
	 * @param @return
	 * @return 
	 * @throws 
	 */
	public void addCourse(Course c) {
		String key = c.getCourseNo();
		courses.put(key, c);
	}
	/**
	 * 
	 * @Title: updateCourse
	 * @Description: 修改课程信息
	 * @param c
	 *        课程
	 * @param @return
	 * @return 
	 * @throws 
	 */	
	public void updateCourse(Course c){
		String key = c.getCourseNo();
		if(courses.containsKey(key))
			courses.put(key, c);
	}
	/**
	 * 
	 * @Title: findCourse
	 * @Description: 根据课程编号查询课程
	 * @param courseNo
	 *        课程编号
	 * @param @return
	 * @return Course 课程
	 * @throws 
	 */
	public Course findCourse(String courseNo) {
		return courses.get(courseNo);
	}
	/**
	 * 
	 * @Title: removeCourse
	 * @Description: 根据课程编号删除课程
	 * @param courseNo
	 *        课程编号
	 * @param @return
	 * @return 
	 * @throws 
	 */
	public void removeCourse(String courseNo){
		courses.remove(courseNo);
	}
	/**
	 * 
	 * @Title: containsCourse
	 * @Description: 根据课程编号判断某门课程是否存在
	 * @param courseNo
	 *        课程编号
	 * @param @return
	 * @return boolean ：true(是)，false(否)
	 * @throws 
	 */	
	public boolean containsCourse(String courseNo){
		return courses.containsKey(courseNo);
	}
	/**
	 * 
	 * @Title: findTranscript
	 * @Description: 根据学号查询该学生的成绩单
	 * @param studentNo
	 *        学号
	 * @param @return
	 * @return ArrayList<HashMap<String, String>> 学生成绩单
	 * @throws 
	 */
	//根据学号查询该学生的成绩单
	public ArrayList<HashMap<String, String>>  findTranscript(String studentNo){
		ArrayList<HashMap<String, String>>  transcript = new ArrayList<HashMap<String, String>>();
		Collection<Course>  c = courses.values();
		for(Course course : c){
			Score score = course.findScore(studentNo);
			if(score!=null){
				int grade = score.getGrade();
				HashMap<String, String>  hs = new HashMap<String, String>();
				hs.put("courseNo", course.getCourseNo());
				hs.put("courseName", course.getCourseName());
				hs.put("grade", String.valueOf(grade));
				transcript.add(hs);
			}
		}
		return transcript;
	}
}
