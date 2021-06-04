package com.qa.stringManipulation;

public class String {

	public static void main(java.lang.String[] args) {
		// TODO Auto-generated method stub

		int weather = 0;
	      //passing variable to the switch
	      switch (weather) 
	      {
	          //comparing value of variable against each case
	        case 0:
	          System.out.println("yesterday it was raining!");
	        case 1:
	          System.out.println("today it is sunny!");
	        //optional
	        default:
	          System.out.println("TODAY IT IS SUNNY, YESTERDAY IT WAS RAINING");
	    }
		
	}


}

