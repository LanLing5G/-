package com.neu.frame;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ButtonGroup;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.MatteBorder;

import com.neu.SGS;
import com.neu.bean.Student;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * 图形界面--更新数据
 * @author tydd
 *
 */
/*？修饰不致命错误*/
@SuppressWarnings({ "unused", "serial" })
public class StudentUpdateDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtUserNo;
	private JTextField txtName;
	private JTextField txtAge;
/*？修饰不致命错误*/
	@SuppressWarnings("rawtypes")
	private JComboBox cbDept;
	private JRadioButton rdM;
	private JRadioButton rdF;
	private final ButtonGroup buttonGroup = new ButtonGroup();

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
	
///////传入选中学生的数据
	public void initData(Student stu) {
		txtUserNo.setText(stu.getUserNo());
		txtUserNo.setEditable(false);
		
		txtName.setText(stu.getName());
		txtAge.setText(stu.getAge()+"");
		if("男".equals(stu.getSex())) {
			rdM.setSelected(true);
		}else if("女".equals(stu.getSex())) {
			rdF.setSelected(true);
		}
		cbDept.setSelectedItem(stu.getDepartment());
	}
	

	/**
	 * Create the dialog.
	 */
/*？修饰不致命错误*/
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public StudentUpdateDialog() {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setResizable(false);
		setTitle("更新学生");
		setBounds(100, 100, 562, 585);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new GridLayout(5, 1, 0, 0));
		{
			JPanel panel = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panel.getLayout();
			flowLayout.setVgap(25);
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
				txtUserNo.setColumns(15);
			}
		}
		{
			JPanel panel = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panel.getLayout();
			flowLayout.setVgap(25);
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
				txtName.setColumns(15);
			}
		}
		{
			JPanel panel = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panel.getLayout();
			flowLayout.setVgap(25);
			contentPanel.add(panel);
			{
				JPanel panel_1 = new JPanel();
				panel.add(panel_1);
				{
					JLabel lblNewLabel_1 = new JLabel("学生年龄：");
					lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 24));
					panel_1.add(lblNewLabel_1);
				}
				{
					txtAge = new JTextField();
					txtAge.setFont(new Font("宋体", Font.PLAIN, 24));
					txtAge.setColumns(15);
					panel_1.add(txtAge);
				}
			}
		}
		{
			JPanel panel = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panel.getLayout();
			flowLayout.setVgap(25);
			contentPanel.add(panel);
			{
				JLabel lblNewLabel_1 = new JLabel("学生性别：");
				lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 24));
				panel.add(lblNewLabel_1);
			}
			{
				rdM = new JRadioButton("男");
				buttonGroup.add(rdM);
				rdM.setSelected(true);
				rdM.setFont(new Font("宋体", Font.PLAIN, 24));
				panel.add(rdM);
			}
			{
				rdF = new JRadioButton("女");
				buttonGroup.add(rdF);
				rdF.setFont(new Font("宋体", Font.PLAIN, 24));
				panel.add(rdF);
			}
		}
		{
			JPanel panel = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panel.getLayout();
			flowLayout.setVgap(25);
			contentPanel.add(panel);
			{
				JLabel lblNewLabel_2 = new JLabel("学生系部：");
				lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 24));
				panel.add(lblNewLabel_2);
			}
			{
				cbDept = new JComboBox();
				cbDept.setFont(new Font("宋体", Font.PLAIN, 24));
				cbDept.setModel(new DefaultComboBoxModel(new String[] {"计算机", "软件工程", "大数据"}));
				panel.add(cbDept);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			FlowLayout fl_buttonPane = new FlowLayout(FlowLayout.CENTER);
			fl_buttonPane.setVgap(20);
			buttonPane.setLayout(fl_buttonPane);
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnSave = new JButton("保存");
				btnSave.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						btnSaveClick(e);
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
	
///////////////
	protected void btnSaveClick(ActionEvent e) {
		// TODO 自动生成的方法存根
		String userNo=txtUserNo.getText();
		String name=txtName.getText();
		String strAge=txtAge.getText();
		int age=0;
		if(!"".equals(strAge)) {
			try {
				age=Integer.parseInt(strAge);
			} catch (Exception e2) {
				
			}
			
		}
		String sex=null;
		if(rdM.isSelected()) {
			sex=rdM.getText();
		}else {
			sex=rdF.getText();
		}
		
		String dept=(String) cbDept.getSelectedItem();
		
		Student stu=new Student(userNo, name, sex, age, dept);
		
		SGS.school.put(userNo, stu);
		//关闭窗体
		this.dispose();
		
	}

}
