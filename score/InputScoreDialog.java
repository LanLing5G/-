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
* @ClassName: InputScoreDialog
* @Description: 成绩录入对话框类
* @author zhoushaobin
* @date 2017年7月7日
*
*/
public class InputScoreDialog extends JDialog implements ActionListener{
	private JTextField jtfCourseNo;
	private JButton jbtCancel;
	private JButton jbtSave;
	private JButton jbtInput;
	private JTable jTable1;
	private Course course;
	//构造方法
	public InputScoreDialog(JFrame owner){
		//初始化对话框
		super(owner,"成绩录入");
		this.setSize(350, 300);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setModal(true);
		JPanel jPanel1 = new JPanel();
		jtfCourseNo = new JTextField(10);
		jbtInput = new JButton("开始录入");
		jPanel1.add(new JLabel("课程号："));
		jPanel1.add(jtfCourseNo);
		jPanel1.add(jbtInput);
		getContentPane().add(jPanel1, BorderLayout.NORTH);

		JPanel jPanel2 = new JPanel();
		jbtSave = new JButton("保存");
		jbtCancel = new JButton("取消");
		jPanel2.add(jbtSave);
		jPanel2.add(jbtCancel);		
		getContentPane().add(jPanel2, BorderLayout.SOUTH);

		TableModel jTable1Model = new DefaultTableModel(new String[0][0] ,	new String[] { "学号", "姓名","成绩" });
		jTable1 = new JTable();
		jTable1.setModel(jTable1Model);
		JScrollPane jScrollPane1 = new JScrollPane(jTable1);
		getContentPane().add(jScrollPane1, BorderLayout.CENTER);		
		
		jbtSave.setEnabled(false);
		//注册监听器
		jbtInput.addActionListener(this);
		jbtSave.addActionListener(this);
		jbtCancel.addActionListener(this);
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
		if(e.getSource()==jbtInput){
			//成绩录入
			if(jtfCourseNo.getText().length()==0){
				JOptionPane.showMessageDialog(null, "请输入课程号！");
				jbtSave.setEnabled(false);
				return ;
			}
			//查找课程
			course = SGS.courseCatalog.findCourse(jtfCourseNo.getText());
			if(course==null){
				JOptionPane.showMessageDialog(null, "课程号不存在！");
				jbtSave.setEnabled(false);
				return ;				
			}
			//显示成绩单
			DefaultTableModel tm = new DefaultTableModel(new String[0][0] ,	new String[] { "学号", "姓名","成绩" });
			jTable1.setModel(tm);
			ArrayList<Student>  studentList = course.getStudentList();
			for(Student  s : studentList){
				int grade = course.findScore(s.getUserNo()).getGrade();
				tm.addRow(new String[]{s.getUserNo(),s.getName(),String.valueOf(grade)});
			}
			jbtSave.setEnabled(true);
		}else if(e.getSource()==jbtSave){
			//成绩保存，获取课程的成绩信息
			DefaultTableModel   tm = (DefaultTableModel)jTable1.getModel() ;
			Vector datas = tm.getDataVector();
			for(int i=0;i<datas.size();i++){
				Vector v = (Vector)datas.get(i);
				String studentNo = (String)v.get(0);
				String grade =  (String)v.get(2);
				Score  score = new Score(studentNo,course.getCourseNo(),Integer.parseInt(grade));
				course.setScore(score);
			}

			JOptionPane.showMessageDialog(null, "成绩保存成功！");
			jbtSave.setEnabled(false);

		}else if(e.getSource()==jbtCancel){
			this.dispose();
		}
		
	}
}
