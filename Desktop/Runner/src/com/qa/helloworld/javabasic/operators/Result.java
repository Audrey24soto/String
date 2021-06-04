package com.qa.helloworld.javabasic.Operators;

public class Result {

	public static void main(String[] args) {}
		// TODO Auto-generated method stub

		public static double Physics = 130;
		public static double Chemistry = 100;
		public static double Biology = 112;
		public static double total = Physics + Chemistry + Biology;
		public static double percentage;
		
		public static void displayResults() {
			System.out.println("Physics Mark: " + Physics);
			System.out.println("Chemistry Mark: " + Chemistry);
			System.out.println("Biology Mark: " + Biology);
			
			System.out.println("\nOverall Mark: " + total);
		}
		public static void displayExamOverall() {}
}