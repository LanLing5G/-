package user;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Collection;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import main.SGS;
/**
* 
* @ClassName: LoginDialog
* @Description: 登录对话框类：用于实现登录对话框图形界面，实现用户身份验证功能。
* @author zhoushaobin
* @date 2017年7月7日
*
*/
public class LoginDialog extends JDialog implements ActionListener{
	JTextField  jtfUser = new JTextField(10);
	JPasswordField  jtfPass = new JPasswordField(10);
	JComboBox  jcbUserType = new JComboBox();
	JButton   jbtOk = new JButton("登录");
	JButton   jbtCancel = new JButton("退出");
	//构造方法，完成界面初始构造
	public LoginDialog(JFrame owner){
		super(owner);
		this.setTitle("登录");
		JPanel  p1 = new JPanel();
		p1.add(new JLabel("用户ID："));
		p1.add(jtfUser);
		JPanel  p2 = new JPanel();
		p2.add(new JLabel("密    码："));
		p2.add(jtfPass);
		JPanel p3 = new JPanel();
		p2.add(new JLabel("用户类别："));
		jcbUserType.addItem("教务管理员");
		jcbUserType.addItem("教师");
		jcbUserType.addItem("学生");
		jcbUserType.setSelectedIndex(0);
		p2.add(jcbUserType);
		p3.add(jbtOk);
		p3.add(jbtCancel);

		this.getContentPane().add(p1,BorderLayout.NORTH);
		this.getContentPane().add(p2,BorderLayout.CENTER);
		this.getContentPane().add(p3,BorderLayout.SOUTH);
		//注册监听器
		jbtOk.addActionListener(this);
		jbtCancel.addActionListener(this);
		//设定对话框初始参数
		this.setSize(200,180);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setModal(true);
		this.setVisible(true);
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
		if(e.getSource()==jbtOk){
			//根据选择的用户类别，验证身份
			if(jcbUserType.getSelectedIndex()==User.USER_TYPE_ADMIN){
				//验证是否是管理员
				if(SGS.admin.verifyPassword(jtfUser.getText(), jtfPass.getText())==-1){
					JOptionPane.showMessageDialog(null, "用户名或者密码不正确！");
					jtfUser.setText("");
					jtfPass.setText("");
				}else{
					SGS.currentUser = SGS.admin;
					this.dispose();				
				}
			}else if(jcbUserType.getSelectedIndex()==User.USER_TYPE_TEACHER){
				//验证是否是教师
				Collection<Teacher> teachers = SGS.faculty.values();
				Iterator<Teacher> it = teachers.iterator();
				while(it.hasNext()){
					Teacher t1 = it.next();
					if(t1.verifyPassword(jtfUser.getText(), jtfPass.getText())!=-1){
						SGS.currentUser = t1;
						this.dispose();
						return;
					}
				}
				JOptionPane.showMessageDialog(null, "用户名或者密码不正确！");
				jtfUser.setText("");
				jtfPass.setText("");
			}else{
				//验证是否是学生
				Collection<Student> students = SGS.school.values();
				Iterator<Student> it = students.iterator();
				while(it.hasNext()){
					Student s = it.next();
					if(s.verifyPassword(jtfUser.getText(), jtfPass.getText())!=-1){
						SGS.currentUser = s;
						this.dispose();
						return;
					}
				}
				JOptionPane.showMessageDialog(null, "用户名或者密码不正确！");
				jtfUser.setText("");
				jtfPass.setText("");	
			}
		}else if(e.getSource()==jbtCancel){
			//退出应用程序
			System.exit(0);
		}
		
	}

}
