package com.qa.helloworld;

import com.qa.helloworld.javabasic.Operators.Result;
import com.qa.helloworld.javabasic.conditionals.Hello;

public class Runner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(" Hello World!");
		condecitional();
		Result.displayResults();
		
		
	}

	
	public static void condecitional() {
		
		Hello.flowchart(2005);
		Result.displayExamOverall();
		
	}
	
}
