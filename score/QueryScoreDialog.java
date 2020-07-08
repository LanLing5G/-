package score;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import course.Course;

import main.SGS;
import user.Student;

/**
* 
* @ClassName: QueryScoreDialog
* @Description: 成绩查询对话框类
* @author zhoushaobin
* @date 2017年7月7日
*
*/
public class QueryScoreDialog extends JDialog implements ActionListener{
	private JTextField jtfCourseNo;
	private JButton jbtQuery;
	private JTable jTable1;
	//构造方法
	public QueryScoreDialog(JFrame owner){
		//初始化对话框
		super(owner,"成绩查询");
		this.setSize(350, 300);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setModal(true);
		JPanel jPanel1 = new JPanel();
		jtfCourseNo = new JTextField(10);
		jbtQuery = new JButton("查询");
		jPanel1.add(new JLabel("课程号："));
		jPanel1.add(jtfCourseNo);
		jPanel1.add(jbtQuery);
		getContentPane().add(jPanel1, BorderLayout.NORTH);
		//构造表格
		TableModel jTable1Model = new DefaultTableModel(new String[0][0] ,	new String[] { "学号", "姓名","成绩" });
		jTable1 = new JTable();
		jTable1.setModel(jTable1Model);
		JScrollPane jScrollPane1 = new JScrollPane(jTable1);
		getContentPane().add(jScrollPane1, BorderLayout.CENTER);		
		
		//注册监听器
		jbtQuery.addActionListener(this);

	}
	/**
	 * 
	 * @Title: actionPerformed
	 * @Description: 监听器的事件处理方法：用户操作界面时触发。
	 * @param e 事件
	 * @param @return
	 * @return 
	 * @throws
	 */
	public void actionPerformed(ActionEvent e) {
			if(jtfCourseNo.getText().length()==0){
				JOptionPane.showMessageDialog(null, "请输入课程号！");
				return ;
			}
			//根据课程号查找课程
			Course course = SGS.courseCatalog.findCourse(jtfCourseNo.getText());
			if(course==null){
				JOptionPane.showMessageDialog(null, "课程号不存在！");
				return ;				
			}
			DefaultTableModel tm = new DefaultTableModel(new String[0][0] ,	new String[] { "学号", "姓名","成绩" });
			jTable1.setModel(tm);
			//获取课程的学生名单
			ArrayList<Student>  studentList = course.getStudentList();
			//将成绩信息显示到表格上
			for(Student  s : studentList){
				int grade = course.findScore(s.getUserNo()).getGrade();
				tm.addRow(new String[]{s.getUserNo(),s.getName(),String.valueOf(grade)});
			}		
	}
}
