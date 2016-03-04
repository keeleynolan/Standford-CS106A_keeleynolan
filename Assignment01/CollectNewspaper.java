/*
 * TODO: comment this program
 */

import stanford.karel.*;

public class CollectNewspaper extends Karel {
	
	// TODO: write the code to implement this program
	public void run() {
		leaveHome();
		pickUpThePaper();
		returnHome();
	} 
	
	private void moveForwardTwo() {
		move();
		move();
	}
	
	private void turnLeftThree() {
		turnLeft();
		turnLeft();
		turnLeft();
	}
	
	private void leaveHome(){
		moveForwardTwo();
		turnLeftThree();
		move();
		turnLeft();
		move();
	}
	
	private void pickUpThePaper() {
		pickBeeper();
	}
	
	private void returnHome() {
		turnLeft();
		turnLeft();
		moveForwardTwo();
		move();
		turnLeftThree();
		move();
		turnLeftThree();
	}
}
