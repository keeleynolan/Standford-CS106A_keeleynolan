import java.util.Arrays;


public class YahtzeeCheckCategory {
	
	//check whether the category chosen by the player to score in, fits the criteria of the category.
	//if the criteria fits, return true
	//if the criteria does not fit, return false.
	public static boolean checkCategoryY(int[] rollArray, int categoryNumber ) {
		boolean trueFalse = false;
		int counter = 0;
		int number = 0;
		int a = 0;
		int b = 0;
		
		switch (categoryNumber) {
		case 0: 
			for(int i: rollArray) {
				if (i == 1) {
					trueFalse = true;
					break;
				} 
			}return trueFalse;
		case 1:
			for(int i: rollArray) {
				if (i == 2) {
					trueFalse = true;
					break;
				} 
			}return trueFalse;
		case 2:
			for(int i: rollArray) {
				if (i == 3) {
					trueFalse = true;
					break;
				} 
			}return trueFalse;
		case 3:
			for(int i: rollArray) {
				if (i == 4) {
					trueFalse = true;
					break;
				} 
			}return trueFalse;
		case 4:
			for(int i: rollArray) {
				if (i == 5) {
					trueFalse = true;
					break;
				} 
			}return trueFalse;
		case 5:
			for(int i: rollArray) {
				if (i == 6) {
					trueFalse = true;
					break;
				} 
			}return trueFalse;
			
		case 8: 
			//Three of a kind
				for (int i = 0; i < rollArray.length; i++) {
				//store the number at rollArray[i] in the int number
				number = rollArray[i];
				//check the number against the rollArray to see how many times it occurs.
				for (int j = 0 ; j < rollArray.length; j++) {
					if (number == rollArray[j]) {
						counter++;
					}
				}
				
				//if the number doesn't occur three times then reset the counter.
				//for the next iteration.
				if (counter < 3) {
					counter = 0;
				}
				//break out of loops if counter is = or greater then 3
				if (counter >= 3) {
					break;
					}
				}
			//if the counter equals three, trueFalse = true
				if (counter >= 3) {
					trueFalse = true;
				} else if (counter < 3) {
					trueFalse = false;
				}
				return trueFalse;
				
		case 9: 
			//Four of a kind
				for (int i = 0; i < rollArray.length; i++) {
				//store the number at rollArray[i] in the int number
				number = rollArray[i];
				//check the number against the rollArray to see how many times it occurs.
				for (int j = 0 ; j < rollArray.length; j++) {
					if (number == rollArray[j]) {
						counter++;
					}
				}
				
				//if the number doesn't occur three times then reset the counter.
				//for the next iteration.
				if (counter < 4) {
					counter = 0;
				}
				//break out of loops if counter is = or greater then 3
				if (counter >= 4) {
					break;
					}
				}
			//if the counter equals three, trueFalse = true
				if (counter >= 4) {
					trueFalse = true;
				} else if (counter < 4) {
					trueFalse = false;
				}
				return trueFalse;
			
		case 10:
			//Full House, three of One kind two of another
			for (int i = 0; i < rollArray.length; i++) {
			//store the number at rollArray[i] in the int number
			number = rollArray[i];
			//check the number against the rollArray to see how many times it occurs.
			for (int j = 0 ; j < rollArray.length; j++) {
				if (number == rollArray[j]) {
					counter++;
				}
			}
			
			//if number occurs twice store it in int b
			if (counter == 2) {
				b = counter;
			}
			//if the number doesn't occur three times then reset the counter.
			if (counter < 3) {
				counter = 0;
			}
			//break out of loops if counter is = or greater then 3
			if (counter == 3) {
				a = counter;
				counter = 0;
			}
		}
	//add all the occurrences together if it equals five then trueFalse equals true.
		counter = a + b;
		//print(counter);
		if (counter == 5) {
			trueFalse = true;
		} else if (counter < 5) {
			trueFalse = false;
		}
		//print(trueFalse);
		return trueFalse;
		
		case 11:
			//Small Straight
			Arrays.sort(rollArray);
			for (int i = 0; i< 1; i++) {
				int total = rollArray[i]; 
				for (int j = 0; j < rollArray.length - 1; j++) {
					total = rollArray[j]; 
					int goUp = (j + 1);
					int subtract = rollArray[(goUp)];
					
					if (total + 1 == subtract) {
						counter++;
					} 
				}
			}
			if (counter >= 3) {
				trueFalse = true;
			}
			return trueFalse;
		
		case 12:
			//get the numbers, put them in order from smallest to largets, then run the check.
			Arrays.sort(rollArray);
			//large straight
			for (int i = 0; i< 1; i++) {
				int total = rollArray[i]; 
				for (int j = 0; j < rollArray.length - 1; j++) {
					total = rollArray[j]; 
					int goUp = (j + 1);
					int subtract = rollArray[(goUp)];
					
					if (total + 1 == subtract) {
						counter++;
					} 
				}
			}
			if (counter >= 4) {
				trueFalse = true;
			}
			return trueFalse;
		
		case 13: 
			//Yahtzee!  
			for (int i = 0; i < rollArray.length; i++) {
				//store the number at rollArray[i] in the int number
				number = rollArray[i];
				//check the number against the rollArray to see how many times it occurs.
				for (int j = 0 ; j < rollArray.length; j++) {
					if (number == rollArray[j]) {
						counter++;
					}
				}
				if (counter < 5) {
					counter = 0;
				}
				if (counter == 5) {
					break;
				}
			}
			if (counter == 5) {
				trueFalse = true;
			} else if (counter < 5) {
				trueFalse = false;
			}
			return trueFalse;
			
		case 14:
			//chance any dice config works.
			//no need to check what it is really..at this point.
			trueFalse = true;
			return trueFalse;
			
		default: return trueFalse;
		}
		
	}



}
