package com.neu.ch1;
/**
 * 
 * @author tydd
 *
 */
public class TestScope {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int x=12;
		//{
			int q=96;
			System.out.println("x is"+x);
			System.out.println("q is"+q);
		//}
		q=x;
		System.out.println("x is"+x);
	}

}
