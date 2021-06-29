package com.neu.frame;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.neu.SGS;
import com.neu.bean.Student;

import java.awt.Font;
import java.util.HashMap;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * 图形界面--学生信息表
 * @author tydd
 *
 */
/*？不致命错误*/
@SuppressWarnings("serial")
public class StudentDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private DefaultTableModel tm;//表格数据模型

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			StudentDialog dialog = new StudentDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public StudentDialog() {
		setTitle("学生管理");
		this.setSize(800,600);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setModal(true);
		
	
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JScrollPane scrollPane = new JScrollPane();
			contentPanel.add(scrollPane, BorderLayout.CENTER);
			{
				table = new JTable();
				
				getStudents();
				
				
				scrollPane.setViewportView(table);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnAdd = new JButton("添加");
				btnAdd.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
///////////////////////////
						btnAddClick(e);
					}
				});
				btnAdd.setFont(new Font("宋体", Font.PLAIN, 24));
				btnAdd.setActionCommand("OK");
				buttonPane.add(btnAdd);
				getRootPane().setDefaultButton(btnAdd);
			}
			{
				JButton btnUpdate = new JButton("更新");
				btnUpdate.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
/////////////////////////
						btnUpdateClick(e);
					}
				});
				btnUpdate.setFont(new Font("宋体", Font.PLAIN, 24));
				btnUpdate.setActionCommand("Cancel");
				buttonPane.add(btnUpdate);
			}
			{
				JButton btnDel = new JButton("删除");
				btnDel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
/////////////////////////
						btnDelClick(e);
					}
				});
				btnDel.setFont(new Font("宋体", Font.PLAIN, 24));
				buttonPane.add(btnDel);
			}
		}
	}

	
	
//更新/////////////
	protected void btnUpdateClick(ActionEvent e) {
		// TODO 自动生成的方法存根
		//返回选中的行的索引
		int row=table.getSelectedRow();
		if(row<0) {
			JOptionPane.showMessageDialog(null, "请选中更新的行！");
			return;
		}
		
		//通过表格获得学生对象
		String userNo=(String) tm.getValueAt(row, 0);
		String name=(String) tm.getValueAt(row, 1);
		String sex=(String)tm.getValueAt(row, 2);
		String strAge=(String)tm.getValueAt(row, 3);
		int age=0;
		if(!"".equals(strAge)) {
			age=Integer.parseInt(strAge);
		}
		
		String dept=(String) tm.getValueAt(row, 4);
		//将数据打包成学生对象
		Student stu=new Student(userNo, name, sex, age, dept);
		
		
		StudentUpdateDialog dialog = new StudentUpdateDialog();
		
		//传入学生的数据
		dialog.initData(stu);
		
		dialog.setLocationRelativeTo(null);
		dialog.setModal(true);
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setVisible(true);
		
		
		//刷新数据
		getStudents();
		
		
	}

	
	
//添加///////////////////////
	protected void btnAddClick(ActionEvent e) {
		//学生添加页面显示
		StudentSaveDialog dialog = new StudentSaveDialog();
		dialog.setModal(true);
		dialog.setLocationRelativeTo(null);
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setVisible(true);
		
		//更新数据
		getStudents();
		
	}

	
	
//删除/////////////////////
	protected void btnDelClick(ActionEvent e) {
		//获得选中的行
		int row=table.getSelectedRow();
		//判断用户是否选中行
		if(row<0) {
			JOptionPane.showMessageDialog(null, "请选择行！");
			return;
		}
		
		//确认对话框
		int flag=JOptionPane.showConfirmDialog(this, "是否删除数据？", "警告", JOptionPane.YES_NO_OPTION);
		if(JOptionPane.YES_OPTION==flag) {//确认删除
			//获得学生编号
			String userNo=(String) tm.getValueAt(row, 0);
			//根据键值删除
			SGS.school.remove(userNo);
			
			//组件删除行
			tm.removeRow(row);
			//组件刷新
			table.updateUI();
			
		}
		
		
	}

//更新数据///////////////////////////
	private void getStudents() {
		tm=new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"\u5B66\u53F7", "\u59D3\u540D", "\u6027\u522B", "\u5E74\u9F84", "\u7CFB\u90E8"
				}
			);
		table.setModel(tm);
		
		//将集合中的数据写入到表格中
		tm.addRow(new String[] {"10","11","12","13","14"});
		//获得集合中的数据
		HashMap<String, Student> stuMap=SGS.school;
		for(String key:stuMap.keySet()) {
			//获得一个学生对象
			Student s=stuMap.get(key);
			//将学生对象转换为数组对象
			String[] sItem=new String[] {s.getUserNo(),s.getName(),s.getSex(),s.getAge()+"",s.getDepartment()};
			//添加一个学生
			tm.addRow(sItem);
		}
	}

}
