/*
 * File: Hailstone.java
 * A program that executes the Hailstone Sequence by checking odd and even numbers until the output reaches 1.
 */

import acm.program.*;

public class Hailstone extends ConsoleProgram {
	int outputNumber = 0;
	
	public void run() {
	
		println("This program performs the Hailstone Sequence until a number of one is reached");
		int inputNumber = readInt("Enter a Number:");
		
        //declare some variables.
		int Number = inputNumber;
		int outputNumber = 0;
		int firstNumber = 0;
		int remainder = Number % 2;
		int counter = 0;

		while (true) {
            //check to see whether the number is invalid.
			if (inputNumber == 0 || inputNumber == 1) {
				println("Invalid Number");
			}
            //if the remainder of the input number is 0 then check to see if is even or odd.
			else if(remainder == 0) {
			counter++;
			outputNumber = inputNumber/2;
			println(""+inputNumber+" is even, so I take half: "+outputNumber+"");
			Number = outputNumber;
			for (int i = 0; i <= 1; i++) {
				
				for (int j = Number; j > 1; j--) {
					remainder = Number % 2;
						
					if(remainder == 0) {
						counter++;
						firstNumber = Number;
						Number = Number/2;
						println(""+firstNumber+" is even, so I take half: "+Number+"");
						
					} else if (remainder != 0 && Number != 1) {
						counter++;
						firstNumber = Number;
						Number = (3*Number)+1;
						println(""+firstNumber+" is odd, so I make 3n + 1: "+Number+"");
						
					}
                    
                    //when the number reaches one break out of the hailstone sequence.
                    if (Number == 1) {
						println("The process took "+counter+" times to reach 1.");
						break;
					}
				}
			}
		} 
          
            //if the remainder of the input number is not 0 check to see if it is even or odd.
			else if(remainder != 0) {
			counter++;
			outputNumber = (3*inputNumber)+1;
			println(""+inputNumber+" is odd, so I make 3n + 1: "+outputNumber+"");
			Number = outputNumber;
			for (int i = 0; i <= 1; i++) {
				
				for (int j = Number; j > 1; j--) {
					remainder = Number % 2;
				
				if(remainder == 0) {
					counter++;
					firstNumber = Number;
					Number = Number/2;
					println(""+firstNumber+" is even, so I take half: "+Number+"");
					
				} else if (remainder != 0 && Number != 1) {
					
					counter++;
					firstNumber = Number;
					Number = (3*Number)+1;
					println(""+firstNumber+" is odd, so I make 3n + 1: "+Number+"");
					
				}
                
                //when the number reaches one break out of the hailstone sequence.
                if (Number == 1) {
					println("The process took "+counter+" to reach 1.");
					break;
						}
					}
				}
			}
            
            //println("...Finished running the Hailstone Sequence: ..Exiting Program");
			break;
		}
	}
}


