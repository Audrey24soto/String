package Calculator;

import java.util.Scanner;

public class View {

	
	public static void main(String[] args) {
		int num1,num2;
		// for taking input from user we have to create
		//scanner object
		Scanner in = new Scanner(System.in);
		System.out.println("Enter 1st number: ");
		num1 = in.nextInt();
		
		System.out.println("Enter 2nd Number:");
		num2 = in.nextInt();
		
		System.out.println("sum = "+(num1+num2));
		System.out.println("Subtraction = "+(num1-num2));
		System.out.println("Multiplication = "+(num1*num2));
		System.out.println("Division = "+(num1/num2));
		
		
  }
}
