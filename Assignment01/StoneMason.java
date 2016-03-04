/*
 * TODO: comment this program
 */

import stanford.karel.*;

public class StoneMason extends SuperKarel {
	
	// TODO: write the code to implement this program
	public void run() {
		rebuildColumns();
	}
	
	private void rebuildColumns(){
			while (frontIsClear()) {
				moveUpColumn();
				moveDownColumn();
				moveToNextColumn();
			}moveUpColumn();
			moveDownColumn();
		}

	//checks the direction Karel is facing, then moves Karel in the directon. 
	//calls repairColumn()
	private void moveUpColumn() {
		turnLeft();
		while (facingNorth()) {
			if (frontIsClear()) {
				repairColumn();
				move();
			} if(frontIsBlocked()) {
				repairColumn();
				turnAround();
			}
		}
	}
	
	//returns Karel to the base of the column
	private void moveDownColumn() {
		while (frontIsClear()) {
			move();
		} turnLeft();
	}
	
	//Karel places beepers where there are none
	private void repairColumn() {
		if(noBeepersPresent()) {
			putBeeper();
		}
	}
	//moves Karel to the next repair spot or next column in need of beepers.
	private void moveToNextColumn() {
		for (int i=0; i<4; i++) {
			if (frontIsClear()) {
			move();
			} 
		}
	}
}

