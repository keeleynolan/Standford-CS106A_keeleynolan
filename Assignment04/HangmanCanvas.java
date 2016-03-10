/*
 * File: HangmanCanvas.java
 * ------------------------
 * This file keeps track of the Hangman display.
 */

import acm.graphics.*;
import java.util.*;

public class HangmanCanvas extends GCanvas {

	
/** Resets the display so that only the scaffold appears */
	public void reset() {
		/* You fill this in */
		
		scaffold = new GLine(getWidth()/2 - BEAM_LENGTH, SCAFFOLD_HEIGHT, getWidth()/2 - BEAM_LENGTH, getHeight() - SCAFFOLD_HEIGHT);
		add(scaffold);
		
		beam = new GLine(getWidth()/2 - BEAM_LENGTH, getHeight() - SCAFFOLD_HEIGHT, getWidth()/2, getHeight() - SCAFFOLD_HEIGHT);
		add(beam);
		
//		GRect box = new GRect(getWidth()/2, getHeight() - 360 + 18, 20, 20);
//		add(box);
		
		rope = new GLine(getWidth()/2  ,getHeight() - SCAFFOLD_HEIGHT , getWidth()/2, getHeight() - SCAFFOLD_HEIGHT + ROPE_LENGTH);
		add(rope);
		
		wordLabel.setFont("SansSerif-10");
		add(wordLabel, (getWidth())/2 - BEAM_LENGTH, (getHeight()/2 + SCAFFOLD_HEIGHT/2));
		
	}

/**
 * Updates the word on the screen to correspond to the current
 * state of the game.  The argument string shows what letters have
 * been guessed so far; unguessed letters are indicated by hyphens.
 */
	public void displayWord(char[] hideWord) {
		/* You fill this in */

		String hiddenWord = "";
		for (int i = 0; i < hideWord.length; i++) {
			char hiddenWordCh = hideWord[i];
    		hiddenWord += hiddenWordCh;
		}
		
			wordLabel.setFont("SansSerif-20");
			wordLabel.setLabel(""+hiddenWord);
			
				    
	}

/**
 * Updates the display to correspond to an incorrect guess by the
 * user.  Calling this method causes the next body part to appear
 * on the scaffold and adds the letter to the list of incorrect
 * guesses that appears at the bottom of the window.
 */
	public void noteIncorrectGuess(char letter) {
		/* You fill this in */
		//addBodyPart
		
		String incorrectLetter = " " + letter;
		
		wordlist.add(incorrectLetter);
		int totalCount = wordlist.size();
		counter++;
		
//		GLabel label = new GLabel( totalCount+ " " );
//		label.setFont("SansSerif-15");
//		add(label, (getWidth())/2 - BEAM_LENGTH + 100, (getHeight()/2 + SCAFFOLD_HEIGHT/2));

		
		for (int i = 0; i < totalCount; i++) {
		String letters = wordlist.get(i);
		int labelPosition = i * 10;
		GLabel wordLabel = new GLabel(" ");
		wordLabel.setLabel(letters);
		wordLabel.setFont("SansSerif-10");
		add(wordLabel, (getWidth())/2 - BEAM_LENGTH + labelPosition, (getHeight()/2 + SCAFFOLD_HEIGHT/2) + 20);
		
}
		
		
		if (counter == 1) {
		head = new GOval(getWidth()/2 - HEAD_RADIUS/2 , getHeight() - SCAFFOLD_HEIGHT + ROPE_LENGTH ,HEAD_RADIUS, HEAD_RADIUS);
		add(head);
		}
		if (counter == 2) {
		body = new GLine (getWidth()/2, 144 + 43, getWidth()/2, getHeight() - 144 - 36 );
		add(body);
		}
		
		if (counter == 3) {
		upperArm = new GLine (getWidth()/2 - 72, getHeight()/2 - 28, getWidth()/2 + 72, getHeight()/2 - 28 );
		add(upperArm);
		}
		if (counter == 4) {
			
			leftArm = new GLine (getWidth()/2 - 72, getHeight()/2 - 28, getWidth()/2 - 72, getHeight()/2 - 28 + 44);
			add(leftArm);
			
			rightArm = new GLine (getWidth()/2 + 72, getHeight()/2 - 28, getWidth()/2 + 72, getHeight()/2 - 28 + 44);
			add(rightArm);
		}
		if (counter == 5) {
			hip = new GLine( getWidth()/2 + 36, getHeight() - 144 - 36  ,getWidth()/2 - 36, getHeight() - 144 - 36 );
			add(hip);
		}
		if (counter == 6) {
			leftLeg = new GLine(getWidth()/2 - 36, getHeight() - 144 - 36,getWidth()/2 - 36, getHeight() - 108);
			add(leftLeg);
			
		}
		if (counter == 7) {
			rightLeg = new GLine(getWidth()/2 + 36, getHeight() - 144 - 36, getWidth()/2 + 36, getHeight() - 108);
			add(rightLeg);
			
		}
		if (counter == 8) {

			leftFoot = new GLine(getWidth()/2 - 36  , getHeight() - 108, getWidth()/2 - 36 - 28 ,getHeight() - 108 );
			add(leftFoot);
			
			rightFoot = new GLine(getWidth()/2 + 36  , getHeight() - 108, getWidth()/2 + 36 + 28 ,getHeight() - 108);
			add(rightFoot);
			
		}

	}

/* Constants for the simple version of the picture (in pixels) */
	private static final int SCAFFOLD_HEIGHT = 360;
	private static final int BEAM_LENGTH = 144;
	private static final int ROPE_LENGTH = 18;
	private static final int HEAD_RADIUS = 36;
//	private static final int BODY_LENGTH = 144;
//	private static final int ARM_OFFSET_FROM_HEAD = 28;
//	private static final int UPPER_ARM_LENGTH = 72;
//	private static final int LOWER_ARM_LENGTH = 44;
//	private static final int HIP_WIDTH = 36;
//	private static final int LEG_LENGTH = 108;
//	private static final int FOOT_LENGTH = 28;
	
	private ArrayList<String> wordlist = new ArrayList<String>();
	//private objects [] = new Array[];
	int counter = 0;
	GLabel label = new GLabel( " " );
	GLabel wordLabel = new GLabel(" ");
	GLine scaffold;
	GLine beam;
	GLine rope;

	GOval head;
	GLine body;
	GLine upperArm;
	GLine leftArm;
	GLine rightArm;
	GLine leftLeg;
	GLine rightLeg;
	GLine hip;
	GLine leftFoot;
	GLine rightFoot;


}
