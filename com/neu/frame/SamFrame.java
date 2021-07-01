package com.neu.frame;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;

@SuppressWarnings("serial")
public class SamFrame extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
/////////
	private DefaultTableModel tm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			SamFrame dialog = new SamFrame();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public SamFrame() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JScrollPane scrollPane = new JScrollPane();
			contentPanel.add(scrollPane, BorderLayout.CENTER);
			{
				table = new JTable();
//////////////////
				getData();
					/*
					* table.setModel(
					*	new DefaultTableModel(
					*  		new Object[][] {
					*   	}, 
					*   	new String[] {
					*    		"\u52173","\u52172", "\u52171" 
					*    	} 
					*    )
					*  );
					*/
				/**
				 * tm=new DefaultTableModel( 
					new Object[][] { 	
					}, 
					new String[] {
						"\u52173", "\u52172", "\u52171" 
					} 
				);
				table.setModel(tm);
				 */
				scrollPane.setViewportView(table);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("添加\r\n");
				okButton.setFont(new Font("宋体", Font.PLAIN, 24));
				okButton.setActionCommand("添加");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("更新");
				cancelButton.setFont(new Font("宋体", Font.PLAIN, 24));
				cancelButton.setActionCommand("更新");
				buttonPane.add(cancelButton);
			}
			{
				JButton btnNewButton = new JButton("删除");
				btnNewButton.setFont(new Font("宋体", Font.PLAIN, 24));
				buttonPane.add(btnNewButton);
			}
		}
	}

//获得所有数据/////////////
	private void getData() {
		tm=new DefaultTableModel( 
			new Object[][] { 	
			}, 
			new String[] {
				"\u52173", "\u52172", "\u52171" 
			} 
		);
		table.setModel(tm);
	}

}
