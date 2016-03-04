/*
 * File: ProgramHierarchy.java
 * ---------------------
 * A program to experiment with centering labels, and graphic objects on the screen.
 */

import acm.program.*;
import acm.graphics.*;

public class ProgramHierarchy extends GraphicsProgram {
	private static final int TILE_WIDTH = 100;
	private static final int TILE_HEIGHT = 50;
	//private static final int TILE_SPACE = 100;
	
	
	public void run() {
        /* You fill this in */
        
        //First Rectangle centered
		GRect rectangle1 = new GRect (getWidth()/2 - TILE_WIDTH ,getHeight()/2 - TILE_HEIGHT, TILE_WIDTH, TILE_HEIGHT);
		add(rectangle1);
		
        //First Label center within the first Rectangle
		GLabel label1 = new GLabel("CS106A");
		double lWidth = label1.getWidth();
		double lHeight = label1.getHeight();
		label1.setLocation(((getWidth()/2) - TILE_WIDTH/2) - lWidth/2, ((getHeight()/2) - TILE_HEIGHT/2) + lHeight/2);
		add(label1);
		
        //Second Rectangle centered
		GRect rectangle2 = new GRect (getWidth()/2 + TILE_WIDTH/2, getHeight()/2 - TILE_HEIGHT, TILE_WIDTH, TILE_HEIGHT);
		add(rectangle2);
		
        //Second Label center within the Second Rectangle
		GLabel label2 = new GLabel("CS106A");
		label2.setLocation(((getWidth()/2) + TILE_WIDTH) - lWidth/2, ((getHeight()/2) - TILE_HEIGHT/2) + lHeight/2);
		add(label2);
        
		//Third Rectangle centered
		GRect rectangle3 = new GRect ((getWidth()/2) - TILE_WIDTH, getHeight()/2 + TILE_HEIGHT, TILE_WIDTH, TILE_HEIGHT);
		add(rectangle3);
		
        //Third Label center within the Third Rectangle
		GLabel label3 = new GLabel("CS106A");
		label3.setLocation(((getWidth()/2) - TILE_WIDTH/2) - lWidth/2, ((getHeight()/2) + TILE_HEIGHT) + lHeight*2);
		add(label3);
		
        //Fourth Rectangle centered
		GRect rectangle4 = new GRect ((getWidth()/2) + TILE_WIDTH/2, getHeight()/2 + TILE_HEIGHT, TILE_WIDTH, TILE_HEIGHT);
		add(rectangle4);
		
        //Fourth Label center within the Fourth Rectangle
		GLabel label4 = new GLabel("CS106A");
		label4.setLocation(((getWidth()/2) + TILE_WIDTH/2) + lWidth/2, ((getHeight()/2) + TILE_HEIGHT) + lHeight*2);
		add(label4);
	
		

	}
}

