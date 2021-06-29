package com.neu.frame;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.neu.SGS;
import com.sun.org.apache.xml.internal.security.encryption.AgreementMethod;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * 添加数据
 */
public class StudentSaveDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtUserNo;
	private JTextField txtName;
	private JTextField txtAge;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private JRadioButton rdM;
	private JRadioButton rdF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			StudentSaveDialog dialog = new StudentSaveDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public StudentSaveDialog() {
		setResizable(false);
		setTitle("添加学生");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 408);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new GridLayout(5, 1, 0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel);
			{
				JLabel lblNewLabel = new JLabel("学生编号");
				lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 24));
				panel.add(lblNewLabel);
			}
			{
				txtUserNo = new JTextField();
				txtUserNo.setFont(new Font("宋体", Font.PLAIN, 24));
				panel.add(txtUserNo);
				txtUserNo.setColumns(10);
			}
		}
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel);
			{
				JLabel lblNewLabel_1 = new JLabel("学生姓名");
				lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 24));
				panel.add(lblNewLabel_1);
			}
			{
				txtName = new JTextField();
				txtName.setFont(new Font("宋体", Font.PLAIN, 24));
				panel.add(txtName);
				txtName.setColumns(10);
			}
		}
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel);
			{
				JLabel lblNewLabel_2 = new JLabel("学生年龄");
				lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 24));
				panel.add(lblNewLabel_2);
			}
			{
				txtAge = new JTextField();
				txtAge.setFont(new Font("宋体", Font.PLAIN, 24));
				panel.add(txtAge);
				txtAge.setColumns(10);
			}
		}
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel);
			{
				JLabel lblNewLabel_3 = new JLabel("学生性别");
				lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 24));
				panel.add(lblNewLabel_3);
			}
			{
				rdM = new JRadioButton("男");
				rdM.setFont(new Font("宋体", Font.PLAIN, 24));
				buttonGroup.add(rdM);
				panel.add(rdM);
			}
			{
				rdF = new JRadioButton("女");
				rdF.setFont(new Font("宋体", Font.PLAIN, 24));
				buttonGroup_1.add(rdF);
				panel.add(rdF);
			}
		}
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel);
			{
				JLabel lblNewLabel_4 = new JLabel("学生系部");
				lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 24));
				panel.add(lblNewLabel_4);
			}
			{
				JComboBox comboBox = new JComboBox();
				comboBox.setModel(new DefaultComboBoxModel(new String[] {"计算机", "软件工程", "大数据"}));
				panel.add(comboBox);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnSave = new JButton("保存");
				btnSave.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
////////////////////////////
						btnSaveClicke(e);
					}
				});
				btnSave.setFont(new Font("宋体", Font.PLAIN, 24));
				btnSave.setActionCommand("OK");
				buttonPane.add(btnSave);
				getRootPane().setDefaultButton(btnSave);
			}
			{
				JButton btnCancel = new JButton("取消");
				btnCancel.setFont(new Font("宋体", Font.PLAIN, 24));
				btnCancel.setActionCommand("Cancel");
				buttonPane.add(btnCancel);
			}
		}
	}

	
////////////////////	
	protected void btnSaveClicke(ActionEvent e) {
		// TODO 自动生成的方法存根

	//获取学生豆瓣方法
	String userNo=txtUserNo.getText();
	String name=txtName.getText();
	String str=txtAge.getText();
	//获取年龄
	int age =0;
	try {
		if(!"".equals(str)) {
			age=Integer.parseInt(str);
		}
	} catch (Exception ex) {
		// TODO: handle exception
		JOptionPane.showMessageDialog(null, "年龄，请输入正确的数字");
		return;
	}
	//获得性别
	String sex=null;
	if(rdF.isSelected()) {
		sex=rdF.getText();
	}else {
		sex=rdM.getText();
	}
	//获得系部
	String dept=(String) cbDept.getSelectedItem();
	SGS.school.put(userNo,stu);
	//关闭窗体
	this.dispose();

	}



}
