/*
 * File: PythagoreanTheorem.java
Program to calculate Pythagorean Theorem (a2 + b2 = c2) or (A squared + B squared = C squared).
 */

import acm.program.*;


public class PythagoreanTheorem extends ConsoleProgram {
	public void run() {
		/* You fill this in */
		
        //Get the numbers input.
		println("Enter values to compute the Pythagorean Theorem");
		double inputA = readDouble("a:");
		double inputB = readDouble("b:");
		
        //compute the PythagoranTheorem.
        //use Math.sqrt to sqaure the numbers.
		double outputC = Math.sqrt((inputA * inputA) + (inputB * inputB));

		println("c = "+outputC+"");
		
	}
}
