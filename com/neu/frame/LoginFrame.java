package com.neu.frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.neu.SGS;
import com.neu.bean.User;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.concurrent.CyclicBarrier;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtUserNo;
	private JPasswordField txtPwd;
	private JComboBox cbType;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
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
	public LoginFrame() {
		setResizable(false);
		setTitle("登录");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 492, 300);
		contentPane = new JPanel();
//		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(5, 1, 0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("登    录");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 40));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		
		JLabel lblNewLabel_1 = new JLabel("用户编号：");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 24));
		panel_1.add(lblNewLabel_1);
		
		txtUserNo = new JTextField();
		txtUserNo.setFont(new Font("宋体", Font.PLAIN, 24));
		panel_1.add(txtUserNo);
		txtUserNo.setColumns(15);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2);
		
		JLabel lblNewLabel_2 = new JLabel("密    码：");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 24));
		panel_2.add(lblNewLabel_2);
		
		txtPwd = new JPasswordField();
		txtPwd.setColumns(15);
		txtPwd.setFont(new Font("宋体", Font.PLAIN, 24));
		panel_2.add(txtPwd);
		
		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3);
		
		JLabel lblNewLabel_3 = new JLabel("用户类别：");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 24));
		panel_3.add(lblNewLabel_3);
		
		cbType = new JComboBox();
		cbType.setFont(new Font("宋体", Font.PLAIN, 24));
		cbType.setModel(new DefaultComboBoxModel(new String[] {"管理员", "教师", "学生"}));
		panel_3.add(cbType);
		
		JPanel panel_4 = new JPanel();
//		panel_4.setBackground(Color.LIGHT_GRAY);
		contentPane.add(panel_4);
		
		JButton btnLogin = new JButton("登录");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//使用登录方法
				btnLoiginClick(e);
			}
		});
		btnLogin.setFont(new Font("宋体", Font.PLAIN, 24));
		panel_4.add(btnLogin);
		
		JButton btnExtut = new JButton("退出");
		btnExtut.setFont(new Font("宋体", Font.PLAIN, 24));
		panel_4.add(btnExtut);
		//居中
		this.setLocationRelativeTo(null);
	}
	
	
	
	//登录方法
	protected void btnLoiginClick(ActionEvent e) {
		// TODO 自动生成的方法存根
		//
		String uid=txtUserNo.getText();
		String pwd=txtPwd.getText();
		//
		if(uid.length()<1) {
			JOptionPane.showMessageDialog(null, "用户名不能为空！");
			txtUserNo.requestFocus();
			return;
		}
		//
		if(pwd.length()<1) {
			JOptionPane.showMessageDialog(null, "密码不能为空！");
			txtPwd.requestFocus();
			return;
		}	
		
		//登录验证
		//SGS
		//
		User user=null;
		int type=cbType.getSelectedIndex();
		switch(type) {
		case User.USER_TYPE_ADMIN:
			//管理员
			break;
		case User.USER_TYPE_TEACHER:
			//教师
			user=SGS.faculty.get(uid);
			break;
		case User.USER_TYPE_STUDENT:
			//学生
		user=SGS.school.get(uid);
			break;
		}
		
		//判断编号是否在集合中（用户名错误）
		if(user==null) {
			JOptionPane.showConfirmDialog(null, "用户编号错误");
			txtUserNo.requestFocus();
			return;
		}
		//判断密码是否正确
		if(!pwd.equals(user.getUserPw())) {
			JOptionPane.showConfirmDialog(null, "用户密码错误！");
			txtPwd.requestFocus();
			return;
		}
//		SGS SGS=new SGS();
//		SGS.login(uid);
//		login ln=new login();
//		if(uid.length()==1) {
//			JOptionPane.showMessageDialog(null, "用户名不能为空！");
//			txtUserNo.requestFocus();
//			return;
//		}
		
		
		//主窗体显示
		MainFrame frame = new MainFrame();
		frame.setVisible(true);
		//登录窗体退出
		this.dispose();
		
		
	}

}
