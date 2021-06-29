package com.neu.frame;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.neu.SGS;
import com.neu.bean.Student;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * 更新数据
 * @author Lenovo
 *
 */
public class StudentUpdateDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtUserNo;
	private JTextField txtName;
	private JTextField txtAge;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JComboBox cbDept;
	private JRadioButton rdF;
	private JRadioButton rdM;
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			StudentUpdateDialog dialog = new StudentUpdateDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//////////////	传入选中的学生数据
	public void iniData(String stu) {
		txtUserNo.setText(stu.getUserNo());
		txtUserNo.setEditable(false);
		txtName.setText(stu.getName());
		txtAge.setText(stu.getAge()+"");
		if("男".equal(stu.getSex())) {
			rdM.setSelected(b);
		}
		
		
	}
	
	
	public JTextField getTxtUserNo() {
		return txtUserNo;
	}

	public void setTxtUserNo(JTextField txtUserNo) {
		this.txtUserNo = txtUserNo;
	}

	public JTextField getTxtName() {
		return txtName;
	}

	public void setTxtName(JTextField txtName) {
		this.txtName = txtName;
	}

	public JTextField getTxtAge() {
		return txtAge;
	}

	public void setTxtAge(JTextField txtAge) {
		this.txtAge = txtAge;
	}

	/**
	 * Create the dialog.
	 */
	public StudentUpdateDialog() {
		setResizable(false);
		setTitle("添加学生");
		setBounds(100, 100, 450, 391);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new GridLayout(5, 1, 0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel);
			{
				JLabel lblNewLabel = new JLabel("学生编号：");
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
				JLabel lblNewLabel_1 = new JLabel("学生姓名：");
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
				JLabel lblNewLabel_2 = new JLabel("学生年龄：");
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
				JLabel lblNewLabel_3 = new JLabel("学生性别：");
				lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 24));
				panel.add(lblNewLabel_3);
			}
			{
				rdM = new JRadioButton("男");
				buttonGroup.add(rdM);
				rdM.setFont(new Font("宋体", Font.PLAIN, 24));
				panel.add(rdM);
			}
			{
				rdF = new JRadioButton("女");
				buttonGroup_1.add(rdF);
				rdF.setFont(new Font("宋体", Font.PLAIN, 24));
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
				cbDept = new JComboBox();
				cbDept.setModel(new DefaultComboBoxModel(new String[] {"计算机系", "软件工程", "大数据"}));
				cbDept.setFont(new Font("宋体", Font.PLAIN, 24));
				panel.add(cbDept);
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
						btnSaveClick(e);
					}
				});
				btnSave.setActionCommand("OK");
				buttonPane.add(btnSave);
				getRootPane().setDefaultButton(btnSave);
			}
			{
				JButton btnCancel = new JButton("取消");
				btnCancel.setActionCommand("Cancel");
				buttonPane.add(btnCancel);
			}
		}
	}

	protected void btnSaveClick(ActionEvent e) {
		// TODO 自动生成的方法存根
		String userNo=txtUserNo.getText();
		String name=txtName.getText();
		String strAge=txtAge.getText();
		int age=0;
		if(!"".equals(strAge)) {
			try {
				age=Integer.parseInt(strAge);
			} catch (Exception e2){
				
			}
		}
		String sex=null;
		if(rdM.isSelected()) {
			sex=rdM.getText();
		}else {
			sex=rdF.getText();
		}
		String dept=(String) cbDept.getSelectedItem();
		Student stu=new Student(userNo, name , age,sex, dept);
		SGS.school.put(userNo,stu);
		//关闭窗体
		this.dispose();
	}

}
