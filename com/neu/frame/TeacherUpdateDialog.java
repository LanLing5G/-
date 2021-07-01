package com.neu.frame;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.neu.SGS;
import com.neu.bean.Teacher;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TeacherUpdateDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtUserNo;
	private JTextField txtName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			TeacherUpdateDialog dialog = new TeacherUpdateDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void initDate(Teacher tea) {
		txtUserNo.setText(tea.getUserNo());
		txtUserNo.setEditable(false);
		txtName.setText(tea.getName());
	}
	

	/**
	 * Create the dialog.
	 */
	public TeacherUpdateDialog() {
		setTitle("修改教师");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new GridLayout(2, 1, 0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel);
			{
				JLabel lblNewLabel = new JLabel("教师编号：");
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
				JLabel lblNewLabel_1 = new JLabel("教师姓名：");
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
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnSave = new JButton("保存");
				btnSave.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
////////////////////////
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

////////////////
	protected void btnSaveClick(ActionEvent e) {
		// TODO 自动生成的方法存根
		
		String userNo=txtUserNo.getText();
		String name=txtName.getText();
		
		Teacher tea=new Teacher(userNo,name);
		SGS.faculty.put(userNo, tea);
		
		this.dispose();
	}

	
}
