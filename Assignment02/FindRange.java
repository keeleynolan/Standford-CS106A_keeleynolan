/*
 * File: FindRange.java
 * --------------------
 * This file finds the largest and smallest numbers in a range.
 */

import acm.program.*;
import acm.util.*;

public class FindRange extends ConsoleProgram {
	
	int sentinel = 0;

	public void run() {
		
		
		println("This program finds the largest and smallest numbers.");
		println("Enter numbers below.");
		int inputNumbers = readInt("?: ");
		int max = inputNumbers;
		int min = inputNumbers;
		
        //keep looping until the sentinel (exit loop number) is met
		while (inputNumbers!= sentinel) {
            
            //if the input number is greater then the max number then the max number now holds the value of the input number.
			 if (inputNumbers > max) {
				 max = inputNumbers ;
				 }
            
             //if the input number is less then the min number then the min number now holds the value of the input number.
            if (inputNumbers < max) {
				  min = inputNumbers;
			 }
		
            //if the input number equals the sentinel exit loop.
			 if (inputNumbers == sentinel) break;
			 
            //get the next number from the user.
                inputNumbers = readInt("?: ");
			}
		
        //output the lowest and highest number when finished.
			println("lowest: " +min+"");
			println("highest: " +max+"");
		}
}
		


	
		
	
		




























//while (true) {
//	int valueA = readInt("?");
//	if (valueA == sentinel) break;
//	int valueB = readInt("?");
//	if (valueB == sentinel) break;
//	
//	if (valueA > valueB) {
//		highest = valueA;
//		lowest = valueB;
//		println("smallest: "+valueB+"");
//		println("largest: "+valueA+"");
//		
//	}if (valueA < valueB) {
//		lowest = valueA;
//		highest = valueB; 
//		println("smallest: "+valueA+"");
//		println("largest: "+valueB+"");
//		
//	}if (valueA == valueB) {
//		println(""+valueA+" and "+valueB+" are both the smallest and largest number.");
//		
//		}
//	}





//
//}


