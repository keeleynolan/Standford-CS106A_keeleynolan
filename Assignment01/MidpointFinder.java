/*
 * Allows Karel to find the midpoint of square sized world using a diagonal line.
 */


import stanford.karel.*;

public class MidpointFinder extends SuperKarel {
	
	public void run() {
	//While loop that has Karel create a diaganol line.	
	while (frontIsClear()) {
		turnLeft();
		move();
		turnRight();
		move();
		putBeeper();
		}

	//create a second diagonal row of beepers to check rows of even numbered boxes
		turnRight();
		move();
		while (frontIsClear()) {
			turnRight();
			move();
			turnLeft();
			move();
			putBeeper();
	}
	
		//Moves Karel to the corner of the world.
	if (frontIsBlocked()) {
		turnLeft();
		while (frontIsClear()) {
			move();
		} turnLeft();
	}

	//Moves to find the center point of the line based on diagonal movement.
	while (noBeepersPresent()) {
			turnLeftMove();
			turnRightMove();
			if (beepersPresent()) {
				turnAround();
			}
		}
	while (frontIsClear()){
		move();
	}
	putBeeper();
	cleanUpOtherBeepers();
	goBackToBeeperPosition();
	
	}
	
	//Moves Karel until finds the beeper in the middle.
	private void goBackToBeeperPosition() {	
		turnLeft();
		while (frontIsClear()) {
			move();
		}turnRight();
		while (frontIsClear() && noBeepersPresent()) {
			move();
		}
		
	}
	
	//Calls two methods for cleaning up Beepers.
	private void cleanUpOtherBeepers() {
		startRowCleanUp();
		cleanUpBeepersEastWest();
	}
	
	//Gets Karel into positon to start row cleanup.
	private void startRowCleanUp() {
		turnRight();
		move();
		while (frontIsClear()) {
			if(beepersPresent()) {
				pickBeeper();
				 } move();
		}turn();
	}
	
	//Karel picks up beepers.
	private void cleanUpBeepers() {
		if (beepersPresent()) {
			pickBeeper();
		} while (frontIsClear()) {
			move();
			if (beepersPresent()) {
				pickBeeper();
			}
		}
	}
	
	//checks the direction Karel is facing and has Karel clean up the beepers based on the direction.
	private void cleanUpBeepersEastWest() {
		while (leftIsClear()) {
				cleanUpBeepers();
				turn();
			}
		while (rightIsClear()) {
			cleanUpBeepers();
			turn();
		}
	}
	
	//Turns Karel based on direction.
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
	
	//Karel turns left one, moves one, and turns left again.
	private void leftTurn() {
		turnLeft();
		if(frontIsClear()) {
			move();
		} turnLeft();
	}
	//Karel turns right one, moves one, and turns right again.
	private void rightTurn() {
		turnRight();
		if (frontIsClear()) {
			move();
		}turnRight();	
	}
	
	//Karel turns left and moves one.
	private void turnLeftMove() {
		turnLeft();
		move();
	} 
	
	//Karel turns right and moves one.
	private void turnRightMove() {
		turnRight();
		move();
	}	
}


