package main;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


import score.InputScoreDialog;
import score.QueryScoreDialog;


import user.LoginDialog;


/**
* 
* @ClassName: MainFrame
* @Description: 主界面类
* @author zhoushaobin
* @date 2017年7月7日
*
*/
public class MainFrame extends JFrame implements ActionListener{
	JMenuBar  menubar = new JMenuBar();
	
	JMenu   userMenu = new JMenu("用户管理");
	JMenuItem  teacherMenuItem = new JMenuItem("教师管理");
	JMenuItem  studentMenuItem = new JMenuItem("学生管理");
	JMenuItem  passMenuItem = new JMenuItem("修改密码");
	JMenuItem  exitMenuItem = new JMenuItem("退出系统");

	JMenu   gradeMenu = new JMenu("成绩管理");
	JMenuItem inputMenuItem = new JMenuItem("成绩录入");
	JMenuItem queryMenuItem = new JMenuItem("成绩查询");

	JMenu   courseMenu = new JMenu("开课目录管理");
	JMenuItem courseCatalogMenuItem = new JMenuItem("课程管理");
	JMenuItem studentListMenuItem = new JMenuItem("学生名单管理");
	

	//////////////////////////////////////////////////////////////////	
	JMenu   serverMenu = new JMenu("服务器管理");
	JMenuItem startMenuItem = new JMenuItem("启动服务");
	JMenuItem closeMenuItem = new JMenuItem("关闭服务");
	//////////////////////////////////////////////////////////////////
	JLabel  welcomeLabel = new JLabel("××学生成绩管理系统");
	
	LoginDialog  loginDialog ;
	InputScoreDialog inputScoreDialog;
	QueryScoreDialog queryScoreDialog;

	public MainFrame(){
		this.setTitle("学生成绩管理系统");
		//构造主菜单
		this.setJMenuBar(menubar);
		menubar.add(userMenu);
		menubar.add(gradeMenu);
		menubar.add(courseMenu);

		//构造用户管理菜单
		userMenu.add(studentMenuItem);
		userMenu.add(teacherMenuItem);
		userMenu.add(passMenuItem);
		userMenu.add(exitMenuItem);
		//构造成绩管理菜单
		gradeMenu.add(inputMenuItem);
		gradeMenu.add(queryMenuItem);
		//构造课程管理菜单
		courseMenu.add(courseCatalogMenuItem);
		courseMenu.add(studentListMenuItem);
		
		//////////////////////////////////////////////////////////////////
		//构造服务器管理菜单
		serverMenu.add(startMenuItem);
		serverMenu.add(closeMenuItem);
		startMenuItem.setEnabled(true);
		closeMenuItem.setEnabled(false);
		menubar.add(serverMenu);
		//////////////////////////////////////////////////////////////////
		//构造欢迎页面
		welcomeLabel.setFont(new java.awt.Font("DialogInput", 1, 48));
		welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		welcomeLabel.setForeground(Color.blue);
		this.getContentPane().add(welcomeLabel);

		//创建并弹出登录对话框
		loginDialog = new LoginDialog(this);

		//为主菜单注册监听器
		exitMenuItem.addActionListener(this);
		passMenuItem.addActionListener(this);
		inputMenuItem.addActionListener(this);
		queryMenuItem.addActionListener(this);
		
		studentMenuItem.addActionListener(this);	
		teacherMenuItem.addActionListener(this);
		courseCatalogMenuItem.addActionListener(this);
		studentListMenuItem.addActionListener(this);

		//为服务器菜单项注册监听器
		startMenuItem.addActionListener(this);
		closeMenuItem.addActionListener(this);
		//////////////////////////////////////////////////////////////////	
		//显示系统主界面
		this.setSize(600, 400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
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
		//主菜单控制
		if(e.getSource()==exitMenuItem){//退出系统
			if(JOptionPane.showConfirmDialog(this, "确认要退出系统？","退出",JOptionPane.OK_CANCEL_OPTION)==JOptionPane.OK_OPTION){
				System.exit(0);
			}			
		}else if(e.getSource()==studentMenuItem){//学生管理

		}else if(e.getSource()==teacherMenuItem){//教师管理

		}else if(e.getSource()==courseCatalogMenuItem){//课程管理

		}else if(e.getSource()==studentListMenuItem){//分配学生名单
	
		}else if(e.getSource()==inputMenuItem){//录入成绩
			//创建成绩录入面板
			if(inputScoreDialog==null){
				inputScoreDialog = new InputScoreDialog(this);
			}
			inputScoreDialog.setVisible(true);
		}else if(e.getSource()==queryMenuItem){//查询成绩
			//创建成绩查询面板
			if(queryScoreDialog==null){
				queryScoreDialog = new QueryScoreDialog(this);
			}
			queryScoreDialog.setVisible(true);
		}
		else if(e.getSource()==startMenuItem){
	
		}else if(e.getSource()==closeMenuItem){
	

		}////////////////////////////////////////
		
	}
}
