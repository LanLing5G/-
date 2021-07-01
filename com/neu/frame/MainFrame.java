package com.neu.frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import sun.awt.windows.WWindowPeer;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.SystemColor;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * 图形界面--主页-菜单 
 * @author tydd
 *
 */
/*？不致命错误*/
@SuppressWarnings({ "serial", "unused" })
public class MainFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		
		setTitle("学生成绩管理系统");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 787, 552);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnUser = new JMenu("用户管理");
		mnUser.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
		menuBar.add(mnUser);
		
		JMenuItem mnStundent = new JMenuItem("学生管理");
		mnStundent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
///////////////////////				
				  mnStundentClick(e);
			}
		});
		mnStundent.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
		mnUser.add(mnStundent);
		
		JMenuItem mnTeacher = new JMenuItem("教师管理");
		mnTeacher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
////////////////////
				mnTeacherClick(e);
			}
		});
		mnTeacher.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
		mnUser.add(mnTeacher);
		
		JMenu mnScore = new JMenu("成绩管理");
		mnScore.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
		menuBar.add(mnScore);
		
		JMenu mnClass = new JMenu("开课目录管理");
		mnClass.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
		menuBar.add(mnClass);
		
		JMenu mnServer = new JMenu("服务器管理");
		mnServer.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
		menuBar.add(mnServer);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("学习成绩管理系统");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBackground(SystemColor.window);
		lblNewLabel.setFont(new Font("隶书", Font.PLAIN, 70));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel, BorderLayout.CENTER);
		//this.setLocationRelativeTo(null);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
	}
	
	
//显示教师信息表///////////////////////
	protected void mnTeacherClick(ActionEvent e) {
		// TODO 自动生成的方法存根
	TeacherDialog dialog = new TeacherDialog();
	dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	dialog.setVisible(true);
	}

//显示学生信息表////////////////////////
	protected void mnStundentClick(ActionEvent e) {
		// TODO 自动生成的方法存根
			StudentDialog dialog = new StudentDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
	}

}
