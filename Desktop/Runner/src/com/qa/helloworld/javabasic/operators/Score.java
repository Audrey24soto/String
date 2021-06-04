package com.qa.helloworld.javabasic.Operators;

public class Score {
	
	public static double passMark = 70;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double percent = 90.0;
		boolean flag = false;
		
		System.out.println(percent + "%");
		
		if(percent > passMark) {
			System.out.println("You have passed!");
		} else if (percent == passMark || flag) {
			System.out.println("You have Just passed!");
		}else {
			System.out.println("You have failed!");
		}
	}

}
