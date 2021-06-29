package com.neu.ch2;
/**
 * 创建类，引用类--编程习惯练习
 * @author tydd
 *
 */
public class PrintRectangle {
	
	public static void drawRectangle(int x,int y) {
		for(int i=0;i<x;i++) {
			for(int j=0;j<y;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		drawRectangle(3,5);
		drawRectangle(2,4);
		drawRectangle(6,10);
	}

}


