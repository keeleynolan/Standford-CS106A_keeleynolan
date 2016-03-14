 /* File: Breakout.java
 * -------------------
 * Creates the game breakout, where a player clears all the bricks and wins or if all lives are lost loses.
 */
import acm.program.*;
import acm.util.RandomGenerator;
import acm.graphics.*;
import java.awt.Color;
import java.awt.event.*;


//add a mouse listener to restart the game after it is finished and put all the bricks in again.
public class Breakout extends GraphicsProgram {

/** Width and height of application window in pixels.  On some platforms 
  * these may NOT actually be the dimensions of the graphics canvas. */
	public static final int APPLICATION_WIDTH = 400;
	public static final int APPLICATION_HEIGHT = 600;

/** Dimensions of game board.  On some platforms these may NOT actually
  * be the dimensions of the graphics canvas. */
	private static final int WIDTH = APPLICATION_WIDTH;
	private static final int HEIGHT = APPLICATION_HEIGHT;

/** Dimensions of the paddle */
	private static final int PADDLE_WIDTH = 60;
	private static final int PADDLE_HEIGHT = 10;

/** Offset of the paddle up from the bottom */
	private static final int PADDLE_Y_OFFSET = 30;

/** Number of bricks per row */
	private static final int NBRICKS_PER_ROW = 10;

/** Number of rows of bricks */
	private static final int NBRICK_ROWS = 10;

/** Separation between bricks */
	private static final int BRICK_SEP = 4;

/** Width of a brick */
	private static final int BRICK_WIDTH =
	  (WIDTH - (NBRICKS_PER_ROW - 1) * BRICK_SEP) / NBRICKS_PER_ROW;

/** Height of a brick */
	private static final int BRICK_HEIGHT = 8;

/** Radius of the ball in pixels */
	private static final int BALL_RADIUS = 10;

/** Offset of the top brick row from the top */
	private static final int BRICK_Y_OFFSET = 70;

/** Number of turns */
	private static final int NTURNS = 3;
	
	int widthOfScreen = WIDTH/2;
	double vx; 
	double vy = 3.0;
	private RandomGenerator rgen = RandomGenerator.getInstance();
	private static final int BALL_DIAM = BALL_RADIUS*2;
	
	private GOval ball;
	private GRect paddle;
	private GLabel label;
	private GLabel label02;
	private GLabel livesLabel;
	private GLabel bricksLabel;
	private GRect sq;
	int counter = NTURNS;
	int bricksCounter = 0;
	
	boolean gameplay;
	boolean restartGame;

/* Method: run() */
/** Runs the Breakout program. */
	
	public void init() {
		addMouseListeners();
	}
	
	public void run() {
		gameplay = true;
		playGame();
	}
	
	public void playGame(){
		gameplay = true;
		setupGame();
		//println(gameplay);
		
		while(gameplay == true){
			if (counter == 0 || bricksCounter == 100) break; 
			moveBall();
			checkBoundaries();
			checkCollisions();

			}
	}
	
	public void endGame() {
		
		gameplay = false;
		removeAll();

		GLabel gameOverLabel = new GLabel("");
		gameOverLabel.setLocation((APPLICATION_WIDTH/2) - PADDLE_WIDTH/2, HEIGHT/2);
		add(gameOverLabel);
		if (counter == 0) {
			gameOverLabel.setLabel("Game Over!");
		}
		if (bricksCounter == 100) {
			gameOverLabel.setLabel("You Win!");
			}
		//wait
		pause(750);
		restartGame();
	}
	

	//method to automatically restart gameplay
	public void restartGame() {
		
		pause(100);
		counter = 3;
		bricksCounter = 0;
		playGame();
		println("play");
		
	}
	
	public void setupGame() {
		
		//creates a label that will act as the counter for how many lives are left.
		label = new GLabel("");
		label.setFont("Times New Roman-15");
		add(label, 50, 50);
		label.setLabel("Lives :");
		
		//creates a label based on the location of label that will let the user know how many lives they have left.
		livesLabel = new GLabel("" +counter+"");
		livesLabel.setFont("Times New Roman-15");
		add(livesLabel, label.getX() + label.getWidth() , 50);
		
		//creates a label that will act as the counter for how many bricks have been removed
		label02 = new GLabel("");
		label02.setFont("Times New Roman-15");
		add(label02, 300, 50);
		label02.setLabel("Bricks :");
		
		//creates a label based on the location of label02 that will let the user know how many bricks have been cleared
		println(bricksCounter);
		bricksLabel = new GLabel("");
		bricksLabel.setFont("Times New Roman-15");
		bricksLabel.setLabel("" +bricksCounter+ "");
		add(bricksLabel, label02.getX() + label02.getWidth() , 50);
	
		
		//creates and places the paddle on the gameplay screen
		paddle = new GRect((WIDTH -  PADDLE_WIDTH )/2, HEIGHT - PADDLE_Y_OFFSET, PADDLE_WIDTH, PADDLE_HEIGHT);
		paddle.setFilled(true);
		paddle.setFillColor(Color.WHITE);
		add(paddle);
		
		//creates and places the ball on the gameplay screen
		ball = new GOval ((WIDTH - BALL_RADIUS) /2, (HEIGHT - BALL_RADIUS)/2, BALL_RADIUS*2, BALL_RADIUS*2);
		ball.setFilled(true);
		ball.setColor(Color.red);
		add(ball);
		
		//creates the different colored bricks using multiple for loops
		for (int i = 0; i < NBRICK_ROWS ; i++) {
			//these nested for set up the rows of two in different colors
			for (int k = 0; k < 2; k++) {
				int x = 1 + (BRICK_WIDTH + BRICK_SEP) * i;
				int y = BRICK_Y_OFFSET + ((BRICK_HEIGHT + BRICK_SEP) * k);
				sq = new GRect(x , y, BRICK_WIDTH, BRICK_HEIGHT);
				sq.setFilled(true);
				sq.setFillColor(Color.RED);
				add(sq);
				}
					
		for (int k = 2; k < 4; k++) {
			int x = 1 + (BRICK_WIDTH + BRICK_SEP) * i;
			int y = BRICK_Y_OFFSET + ((BRICK_HEIGHT + BRICK_SEP) * k);
			sq = new GRect(x, y, BRICK_WIDTH, BRICK_HEIGHT);
			sq.setFilled(true);
			sq.setFillColor(Color.YELLOW);
			add(sq);
			}
					
		for (int k = 4; k < 6; k++) {
			int x = 1 + (BRICK_WIDTH + BRICK_SEP) * i;
			int y = BRICK_Y_OFFSET + ((BRICK_HEIGHT + BRICK_SEP) * k);
			sq = new GRect(x, y, BRICK_WIDTH, BRICK_HEIGHT);
			sq.setFilled(true);
			sq.setFillColor(Color.ORANGE);
			add(sq);
			}
					
		for (int k = 6; k < 8; k++) {
			int x = 1 + (BRICK_WIDTH + BRICK_SEP) * i;
			int y = BRICK_Y_OFFSET + ((BRICK_HEIGHT + BRICK_SEP) * k);
			sq = new GRect(x, y, BRICK_WIDTH, BRICK_HEIGHT);
			sq.setFilled(true);
			sq.setFillColor(Color.GREEN);
			add(sq);
			}
					
		for (int k = 8; k < NBRICK_ROWS; k++) {
			int x = 1 + (BRICK_WIDTH + BRICK_SEP) * i;
			int y = BRICK_Y_OFFSET + ((BRICK_HEIGHT + BRICK_SEP) * k);
			sq = new GRect(x, y, BRICK_WIDTH, BRICK_HEIGHT);
			sq.setFilled(true);
			sq.setFillColor(Color.CYAN);
			add(sq);
		}
	}
}
	

	
	public void mouseMoved(MouseEvent e) {
		
		//moves the paddle along the x-axis based on the location of the mouse in the gameplay scene
		paddle.setLocation(e.getX() - PADDLE_WIDTH,HEIGHT - PADDLE_Y_OFFSET);
		if  (paddle.getX() > 400) {
			paddle.setLocation(paddle.getX() - PADDLE_WIDTH*2, HEIGHT - PADDLE_Y_OFFSET);
		} 
		if (paddle.getX() < 0) {
			paddle.setLocation(WIDTH*0 , HEIGHT - PADDLE_Y_OFFSET);
		}
	}
	
	private void moveBall() {
		//creates a random number from 1-3 that is then passed to the balls movement
		vx = rgen.nextDouble(1.0, 3.0);
		if (rgen.nextBoolean(0.5)) vx = -vx;
		
		while (gameplay == true) {
			pause(10);
			ball.move(vx, vy);
			checkBoundaries();
			checkCollisions();
			if (counter == 0 || bricksCounter == 100) break;
			
			}
		}
	
	private void checkBoundaries() {
		//keeps the ball in the screen to play based on height and width.
		//if the ball goes beyond the specifications it alters the course of the ball to keep it in bounds
		if (ball.getY() > HEIGHT - BALL_DIAM) {
			counter--;
			livesLabel.setLabel("" +counter+"");
			vy = -vy;
			
			if (counter == 0) {
				endGame();
			}
		
		} if (ball.getY() < HEIGHT*0 - BALL_DIAM/2) {
			vy = -vy;
		}
		if (ball.getX() > WIDTH - BALL_DIAM) {
			vx = -vx;
		}if (ball.getX() < WIDTH*0 - BALL_DIAM/2) {
			vx = -vx;
	}
		
}
	
	
	private void checkCollisions() {
		
	//creates an object collider that calls the method getCollidingObject and stores the object that the ball collides with.
	GObject collider = getCollidingObject();
	
	//if the collider is the object paddle change the balls directions or hit ball
	if (collider == paddle) {
			vy = -vy;
	}
	
	//if collider is something but not the paddle or labels then go ahead and remove it.
		//ie. if the collider is a brick remove it when the ball hits it.
	if (collider != null && collider != paddle && collider != label && collider != label02 && collider != livesLabel && collider != bricksLabel) {
			remove(collider);
			
			println(bricksCounter);
			bricksLabel.setLabel("" +bricksCounter+ "");
			vy = -vy;
			if (bricksCounter == 100) {
				endGame();
			}
			
			bricksCounter++;
		}
	}
	

	private GObject getCollidingObject() {
		//variables for each of the four corners of the bounding rectangle of the ball.
		double topLeftx = ball.getX();
		double topLefty = ball.getY();
		
		double topRightx = ball.getX() + BALL_DIAM;
		double topRighty = ball.getY();
		
		double bottomLeftx = ball.getX();
		double bottomLefty = ball.getY() + BALL_DIAM;
		
		double bottomRightx = ball.getX() + BALL_DIAM;
		double bottomRighty = ball.getY() + BALL_DIAM;
		
		//checks the collision points of the four corners of the bounding rectangle of the ball 
		//and whether there is an object there other then the ball
		//then it returns whatever the object is at the location
		//if nothing is there then the object doesn't exist
		if (getElementAt(topLeftx,topLefty) != null) {
			collider = getElementAt(topLeftx,topLefty);
			return collider;
		} 
		
		//top right corner of the ball collision
		else if (getElementAt(topRightx, topRighty) != null) {
			collider = getElementAt(topRightx, topRighty);
			return collider;
		} 
		
		//bottom left corner of the ball collision
		else if (getElementAt(bottomLeftx, bottomLefty) != null) {
			collider = getElementAt(bottomLeftx ,bottomLefty);
			return collider;
		} 
		
		//bottom right corner of the ball collision
		 else if (getElementAt(bottomRightx, bottomRighty) != null) {
			 	collider = getElementAt(bottomRightx,bottomRighty);
				return collider;
			}
		
		//else there is no collision return null.
		else {
			return null;
		}
	}
	
	GObject collider;
	
}
