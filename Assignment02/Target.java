/*
 * File: Target.java
 * -----------------
 * Create and center circles within circles.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;


public class Target extends GraphicsProgram {	
	public void run() {
		/* You fill this in. */
		
        
        //declare some variables to use.
		int xWidth = getWidth();
		int yHeight = getHeight();
		int ovalSize = 72;
		
        //Create various circles of different size, two red, one white and place them within eachoterh.
        //add to the Canvas
		GOval largeCircle = new GOval ((xWidth - ovalSize) /2, (yHeight - ovalSize)/2, ovalSize, ovalSize);
		largeCircle.setFilled(true);
		largeCircle.setColor(Color.red);
		add(largeCircle);

		GOval mediumCircle = new GOval ((xWidth - ovalSize*0.65) / 2, (yHeight - ovalSize*0.65)/ 2, 46, 46);
		mediumCircle.setFilled(true);
		mediumCircle.setColor(Color.white);
		add(mediumCircle);
		
		GOval smallCircle = new GOval ((xWidth - ovalSize*0.30) / 2, (yHeight - ovalSize*0.30) / 2, 72 * 0.30, 72 * 0.30);
		smallCircle.setFilled(true);
		smallCircle.setColor(Color.red);
		add(smallCircle);
	}
	
	
}
