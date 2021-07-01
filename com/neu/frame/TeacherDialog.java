package com.neu.frame;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Font;
import javax.swing.table.DefaultTableModel;

import com.neu.SGS;
import com.neu.bean.Student;
import com.neu.bean.Teacher;

import java.awt.event.ActionListener;
import java.util.HashMap;
import java.awt.event.ActionEvent;

/**
 * 图形界面--教师信息表
 * @author Lenovo
 *
 */
public class TeacherDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
/////////表格数据模型
private DefaultTableModel tm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			TeacherDialog dialog = new TeacherDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public TeacherDialog() {
		setType(Type.UTILITY);
		setTitle("教师管理");
///////////
		this.setSize(800, 600);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setModal(true);
		
		setResizable(false);
		setBounds(100, 100, 450, 300);
		
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JScrollPane scrollPane = new JScrollPane();
			contentPanel.add(scrollPane);
			{
				table = new JTable();
///////////////////////
				getTeachers();

				table.setFont(new Font("宋体", Font.PLAIN, 12));
				scrollPane.setViewportView(table);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("添加");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
//////////////////////////
						okButtonClick(e);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("修改");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
//////////////////////////
						cancelButtonClick(e);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
			{
				JButton btnNewButton = new JButton("删除");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
//////////////////////////						
						btnNewButtonClick(e);
					}
				});
				buttonPane.add(btnNewButton);
			}
		}
	}

	
//刷新数据//////////////
	private void getTeachers() {
		tm=new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"\u6559\u5E08\u7F16\u53F7", "\u6559\u5E08\u59D3\u540D"
				});
		table.setModel(tm);
		//将集合中的数据写入到表格中
		tm.addRow(new String[] {"10","11"});
		//获得集合中的数据
		HashMap<String, Teacher> stuMap=SGS.faculty;
		for(String key:stuMap.keySet()) {
			//获得一个学生对象
			Teacher s=stuMap.get(key);
			//将学生对象转换为数组对象
			String[] sItem = new String[] { s.getUserNo(), s.getName()};
			//添加一个学生
			tm.addRow(sItem);
		}
	}

	
//添加教师信息////////////////
	protected void btnNewButtonClick(ActionEvent e) {
		// TODO 自动生成的方法存根
		TeacherSaveDialog dialog = new TeacherSaveDialog();
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setVisible(true);
		
		//更新数据
		getTeachers();
	}

//修改教师信息/////////////////
	protected void cancelButtonClick(ActionEvent e) {
		// TODO 自动生成的方法存根
		//更新数据
		getTeachers();
	}

//删除/////////////////
	protected void okButtonClick(ActionEvent e) {
		// TODO 自动生成的方法存根
		getTeachers();
	}

	

}
