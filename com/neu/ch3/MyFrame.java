package com.neu.ch3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class MyFrame extends JFrame {
	
	public MyFrame () {
		init();
		this.setTitle("我的第一个窗口");
		this.setSize(800,600);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	/**
	 * 初始化所有组件
	 */
	private void init() {
		//获取窗体内容
		Container c=this.getContentPane();
		JLabel albl=new JLabel("我的组件",JLabel.CENTER);
		c.add(albl,BorderLayout.NORTH);
		
		JLabel blbl=new JLabel("南",JLabel.CENTER);
		c.add(blbl,BorderLayout.SOUTH);
		
		JLabel clbl=new JLabel("西",JLabel.CENTER);
		c.add(clbl,BorderLayout.WEST);
		
		JLabel dlbl=new JLabel("东",JLabel.CENTER);
		c.add(dlbl,BorderLayout.EAST);
		
		//添加一个面板
		JPanel p=new JPanel();
		c.add(p);
		p.setBackground(new Color(23,45,255));
		
		//文本框
		final JTextField txt=new JTextField(15);
		p.add(txt);
		
		//下拉列表框
		final JComboBox<String > cd=new JComboBox<String >();
		DefaultComboBoxModel<String> model=new DefaultComboBoxModel<String>(new String[] {"大连","沈阳","天津"});
		cd.setModel(model);
		p.add(cd);
		
		//单选按钮
		final JRadioButton rb1=new JRadioButton("男");
		final JRadioButton rb2=new JRadioButton("女");
		p.add(rb1);
		p.add(rb2);
		ButtonGroup bg=new ButtonGroup();
		bg.add(rb1);
		bg.add(rb2);
		
		//按钮
		JButton btn=new JButton("按钮");
		p.add(btn);
		
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				//txt.setText("程序写入信息");
				//接受文本框信息
				String str=txt.getText();
				//获取下拉列表信息
				String strCb=(String) cd.getSelectedItem();
				int index=cd.getSelectedIndex();
				
				//按钮
				String sex=null;
				if(rb1.isSelected()) {
					sex=rb1.getText();
					
				}else if(rb2.isSelected()){
					sex=rb2.getText();
				}
				
				JOptionPane.showConfirmDialog(null, index+""+strCb);
				
						//对话框
				JOptionPane.showMessageDialog(null,"hello");
			}
		});
	}
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		 MyFrame in=new   MyFrame();
		 in.init();
		 
	}

}
