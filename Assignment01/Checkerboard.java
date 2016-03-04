/*	
* Creates a Checkerboard by alternating where Karel puts down the beepers in the world. 
 */



import stanford.karel.*;

public class Checkerboard extends SuperKarel {
	
	public void run() {
		
		//create rows of alternating beepers based on direction facing, if facing East
		while (noBeepersPresent()) {
			while (facingEast()){
				if (noBeepersPresent()) {
				move();
				if (frontIsClear()) {
					putBeeper();
					move();
				}
				if (frontIsBlocked()) {
					putBeeper();
					turn();
					}
				}
			}
		
			//create rows of alternating beepers based on direction facing, if facing West
			while (facingWest()) {
				if (noBeepersPresent()) {
				move();
				if (frontIsClear()) {
					putBeeper();
					move();
				}
				if (frontIsBlocked()) {
					putBeeper();
					turn();
					}
				}
			}
		}
	}
	
	//check if Karel is blocked from moving forward and turn in the appropriate direction
	private void turn() {
		while (frontIsBlocked()) {
			if (facingEast()) {
				leftTurn();
			}
			else if (facingWest()) {
				rightTurn();
			}
		}
	}

	//Moves Karel to the next row by turning left
	private void leftTurn() {
		turnLeft();
		if(frontIsClear()) {
			move();
		} turnLeft();
	}
	//Moves Karel to the next row by turning rsight
	private void rightTurn() {
		turnRight();
		if (frontIsClear()) {
			move();
		}turnRight();
		
	}


}
