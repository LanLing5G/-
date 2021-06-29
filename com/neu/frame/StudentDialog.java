package com.neu.frame;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.neu.SGS;
import com.neu.bean.Student;

import java.awt.Font;
import java.util.HashMap;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * 学生信息表
 * @author Lenovo
 *
 */
public class StudentDialog extends JDialog {


	private final JPanel contentPanel = new JPanel();
	private JTable table;
////////////////////////////////////////
	private DefaultTableModel tm;

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
		setBounds(100, 100, 868, 517);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JScrollPane scrollPane = new JScrollPane();
			contentPanel.add(scrollPane, BorderLayout.CENTER);
			{
				table = new JTable();
				table.setFont(new Font("宋体", Font.PLAIN, 15));
				
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
////////////////////////////
						btnAddClick(e);
					}
				});
				btnAdd.setFont(new Font("宋体", Font.PLAIN, 24));
				btnAdd.setActionCommand("OK");
				buttonPane.add(btnAdd);
				getRootPane().setDefaultButton(btnAdd);
			}
			{
				JButton btnNewbutton = new JButton("更新");
				btnNewbutton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
///////////////////////////////
						btnUpdateClick(e);
					}
				});
				btnNewbutton.setFont(new Font("宋体", Font.PLAIN, 24));
				btnNewbutton.setActionCommand("Cancel");
				buttonPane.add(btnNewbutton);
			}
			{
				JButton btnNewButton = new JButton("删除");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
////////////////////////////////
						btnDelclick(e);
					}
				});
				btnNewButton.setFont(new Font("宋体", Font.PLAIN, 24));
				buttonPane.add(btnNewButton);
			}
		}
	}
	
	
	
//更新/////////////
	protected void btnUpdateClick(ActionEvent e) {
		// TODO 自动生成的方法存根
		//返回选中的索引
		int row=table.getSelectedRow();
		if(row<0) {
			JOptionPane.showMessageDialog(null, "请选中更新的行！");
			return;
		}
		
		String userNo=(String) tm.getValueAt(row, 0);
		String name=(String) tm.getValueAt(row, 1);
		String sex=(String) tm.getValueAt(row, 2);
		String strAge=(String) tm.getValueAt(row, 3);
		int age=0;
		if(!"".equals(strAge)){
			age=Integer.parseUnsignedInt(strAge);
		}
		String dept=(String) tm.getValueAt(row, column);
		
		
		StudentUpdateDialog dialog = new StudentUpdateDialog();
		//传入学生数据
		dialog.initData(stu);
		dialog.setLocationRelativeTo(null);
		dialog.setModal(true);
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setVisible(true);
		
		//传入学生数据
		dialog.iniData(stu);
		
		//刷新数据
		getStudents();
		
	}

	
	
	
//添加///////////////////////
	protected void btnAddClick(ActionEvent e) {
		// TODO 自动生成的方法存根
		StudentSaveDialog dialog = new StudentSaveDialog();
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setVisible(true);
		dialog.setVisible(true);
		//更新数据
		getStudents();
		
	}

	
	
//删除/////////////////////
	protected void btnDelclick(ActionEvent e) {
		//获得选中的行
		int row=table.getSelectedRow();
		if(row<0) {
			JOptionPane.showMessageDialog(null, "请选择行!");
			return;
		}
		
		//确认对话框
		int flag=JOptionPane.showConfirmDialog(this, "是否删除数据？","警告",JOptionPane.YES_NO_CANCEL_OPTION);
		if(JOptionPane.YES_NO_CANCEL_OPTION==flag);{//确认删除
			//获得学生编号
			String userNo=(String) tm.getValueAt(row, 0);
			SGS.school.remove(userNo);
			tm.removeRow(row);
			table.updateUI();
		}
		
	}

	
	
/////////////////////////////
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
		HashMap<String, Student> stuMap=SGS.school;
		for(String key:stuMap.keySet()) {
			Student s=stuMap.get(key);
			String[] sItem=new String[] {s.getUserNo(),s.getName(),s.getSex(),s.getAge()+"",s.getDepartment()};
			tm.addRow(sItem);
		}
	}
	
	
	  

}
