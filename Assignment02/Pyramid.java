/*
 * File: Pyramid.java
 *  Creates a squares and lays them out in a pyramid shape.
 * The program uses a counter to change the position of the bricks along the y until it reaches 1.
 * The program bases the position of the bricks on the brick width and automatically lays them out using a sequence of for loops.
 */

import acm.graphics.*;
import acm.program.*;


public class Pyramid extends GraphicsProgram {

	/** Width of each brick in pixels */
	private static final int BRICK_WIDTH = 30;

	/** Height of each brick in pixels */
	private static final int BRICK_HEIGHT = 12;

	/** Number of bricks in the base of the pyramid */
	private static final int BRICKS_IN_BASE = 14;
	
	/** Number of bricks in the base of the pyramid */
	private static final int HEIGHT = 850;
	
	/** Number of bricks in the base of the pyramid */
	private static final int WIDTH = 500;
	
	/**integers to hold the position of the bricks for layout*/	
	int x = 0;
	int y = 0;
	
	/**a counter with start number of 14 based on the Bricks_In_Base constant*/	
	int counter = BRICKS_IN_BASE;
	
public void init() {
		
		setSize(WIDTH , HEIGHT);
	}
	
	public void run() {
		
		
		/**top square and the GRect brick to be used through the for loops */	
		GRect brick = new GRect(getWidth()/2 + BRICK_WIDTH, getHeight()/2 + BRICK_HEIGHT, 30, 12);
		add(brick);
		
		/**base layer of bricks (14)*/
		for (int i = 0; i < counter; i++) {
		x = getWidth()/2 - (BRICK_WIDTH/2+BRICK_WIDTH*5 - BRICK_WIDTH * i);
		y = getHeight()/2  + (BRICK_HEIGHT*counter);
		//println(y);
		brick = new GRect(x, y, BRICK_WIDTH, BRICK_HEIGHT);
		add(brick);
		}counter--;
		
		/**layer of bricks (13)*/
		for (int i = 0; i < counter; i++) {
		x =  getWidth()/2 - (BRICK_WIDTH*5 - BRICK_WIDTH * i);
		y = getHeight()/2  + (BRICK_HEIGHT*counter);
		brick = new GRect(x, y, BRICK_WIDTH, BRICK_HEIGHT);
		add(brick);
		}counter--;
		
		/**layer of bricks (12)*/
		for (int i = 0; i < counter; i++) {
		x = getWidth()/2 - (BRICK_WIDTH/2+BRICK_WIDTH*4 - BRICK_WIDTH * i);
		y = getHeight()/2  + (BRICK_HEIGHT*counter);
		brick = new GRect(x, y, BRICK_WIDTH, BRICK_HEIGHT);
		add(brick);
		}counter--;
		
		/**layer of bricks (11)*/
		for (int i = 0; i < counter; i++) {
		x = getWidth()/2 - (BRICK_WIDTH*4 - BRICK_WIDTH * i);
		y = getHeight()/2  + (BRICK_HEIGHT*counter);
		brick = new GRect(x, y, BRICK_WIDTH, BRICK_HEIGHT);
		add(brick);
		}counter--;
		
		/**layer of bricks (10)*/
		for (int i = 0; i < counter; i++) {
		x = getWidth()/2 - (BRICK_WIDTH/2+BRICK_WIDTH*3 - BRICK_WIDTH * i);
		y = getHeight()/2  + (BRICK_HEIGHT*counter);
		brick = new GRect(x, y, BRICK_WIDTH, BRICK_HEIGHT);
		add(brick);
		}counter--;
		
		/**layer of bricks (9)*/
		for (int i = 0; i < counter; i++) {
		x = getWidth()/2 - (BRICK_WIDTH*3 - BRICK_WIDTH * i);
		y = getHeight()/2  + (BRICK_HEIGHT*counter);
		brick = new GRect(x, y, BRICK_WIDTH, BRICK_HEIGHT);
		add(brick);
		}counter--;
		
		/**layer of bricks (8)*/
		for (int i = 0; i < counter; i++) {
		x = getWidth()/2 - (BRICK_WIDTH/2+BRICK_WIDTH*2 - BRICK_WIDTH * i);
		y = getHeight()/2  + (BRICK_HEIGHT*counter);
		brick = new GRect(x, y, BRICK_WIDTH, BRICK_HEIGHT);
		add(brick);
		}counter--;
		
		/**layer of bricks (7)*/
		for (int i = 0; i < counter; i++) {
		x = getWidth()/2 - (BRICK_WIDTH*2 - BRICK_WIDTH * i);
		y = getHeight()/2  + (BRICK_HEIGHT*counter);
		brick = new GRect(x, y, BRICK_WIDTH, BRICK_HEIGHT);
		add(brick);
		}counter--;
		
		/**layer of bricks (6)*/
		for (int i = 0; i < counter; i++) {
		x = getWidth()/2 - (BRICK_WIDTH/2+BRICK_WIDTH - BRICK_WIDTH * i);
		y = getHeight()/2  + (BRICK_HEIGHT*counter);
		brick = new GRect(x, y, BRICK_WIDTH, BRICK_HEIGHT );
		add(brick);
		}counter--;
		
		/**layer of bricks (5)*/
		for (int i = 0; i < counter; i++) {
		x = getWidth()/2 - (BRICK_WIDTH - BRICK_WIDTH * i);
		y = getHeight()/2  + (BRICK_HEIGHT*counter);
		brick = new GRect(x, y, BRICK_WIDTH, BRICK_HEIGHT );
		add(brick);
		}counter--;
		
		/**layer of bricks (4)*/
		for (int i = 0; i < counter; i++) {
		x = getWidth()/2 - (BRICK_WIDTH/2 - BRICK_WIDTH * i);
		y = getHeight()/2  + (BRICK_HEIGHT*counter);
		brick = new GRect(x, y, BRICK_WIDTH, BRICK_HEIGHT );
		add(brick);	
		}counter--;
		
		/**layer of bricks (3)*/
		for (int i = 0; i < counter; i++) {
		x = getWidth()/2 + BRICK_WIDTH * i;
		y = getHeight()/2  + (BRICK_HEIGHT*counter);
		brick = new GRect(x, y, BRICK_WIDTH, BRICK_HEIGHT );
		add(brick);
		}counter--;
														
		/**second layer of bricks below the first brick (2)*/
		for (int i = 0; i < counter; i++) {
		x = getWidth()/2 + (BRICK_WIDTH/2 + BRICK_WIDTH * i);
		y = getHeight()/2  + (BRICK_HEIGHT*counter);
		brick = new GRect(x, y, BRICK_WIDTH, BRICK_HEIGHT );
		add(brick);
		}counter--;
		
	//	println(counter);
	}
}
