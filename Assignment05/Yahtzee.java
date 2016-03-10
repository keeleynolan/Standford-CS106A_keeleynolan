/*
 * File: Yahtzee.java
 * ------------------
 * This program will eventually play the Yahtzee game.
 */

import acm.io.*;
import java.util.ArrayList;
import acm.program.*;
import acm.util.*;

public class Yahtzee extends GraphicsProgram implements YahtzeeConstants {
	public void run() {
		setupPlayers();
		initDisplay();
		playGame();
	}
	
	/**
	 * Prompts the user for information about the number of players, then sets up the
	 * players array and number of players.
	 */
	private void setupPlayers() {
		nPlayers = chooseNumberOfPlayers();	
		
		/* Set up the players array by reading names for each player. */
		playerNames = new String[nPlayers];
		for (int i = 0; i < nPlayers; i++) {
			/* IODialog is a class that allows us to prompt the user for information as a
			 * series of dialog boxes.  We will use this here to read player names.
			 */
			IODialog dialog = getDialog();
			playerNames[i] = dialog.readLine("Enter name for player " + (i + 1));
		}
	}
	
	/**
	 * Prompts the user for a number of players in this game, reprompting until the user
	 * enters a valid number.
	 * 
	 * @return The number of players in this game.
	 */
	private int chooseNumberOfPlayers() {
		/* See setupPlayers() for more details on how IODialog works. */
		IODialog dialog = getDialog();
		
		while (true) {
			/* Prompt the user for a number of players. */
			int result = dialog.readInt("Enter number of players");
			
			/* If the result is valid, return it. */
			if (result > 0 && result <= MAX_PLAYERS)
				return result;
			
			dialog.println("Please enter a valid number of players.");
		}
	}
	
	/**
	 * Sets up the YahtzeeDisplay associated with this game.
	 */
	private void initDisplay() {
		display = new YahtzeeDisplay(getGCanvas(), playerNames);
	}

	/**
	 * Actually plays a game of Yahtzee.  This is where you should begin writing your
	 * implementation.
	 */
	private void playGame() {
	
		YahtzeeScore score = new YahtzeeScore();
		boolean trueFalse = true;
		int[] scoresArray = new int[13];
		
		while (true) {
			
			if (roundsCounter == 13) break;
			for (int i = 0; i < nPlayers; i++) {
				display.printMessage(playerNames[i]+"'s turn! Click \"Roll Dice\" button to roll the dice.");
				whichPlayer = i;
				display.waitForPlayerToClickRoll(whichPlayer);
				
				//first roll of the dice.
				int[] rollArray = new int [N_DICE ];
				rollArray = rollDice(rollArray);
				display.displayDice(rollArray);
				
				//second and third roll of dice
				//wait for player to select the dice to roll
				//then roll random die
				for (int j = 0; j < 2; j++) {
				display.printMessage("Select the dice you wish to re-roll and click \"Roll Again\"");
				display.waitForPlayerToSelectDice();
				rollArray = reroll(rollArray);
				display.displayDice(rollArray);
				}
				//N_CATEGORIES - 1 = 16 categories to choose from
				categoryNumber = display.waitForPlayerToSelectCategory();
				
				check = checkIfCategoryAlreadySelected(categoryNumber, whichPlayer);
			
				//see if the category has already been picked or not.
				while (check == true) {
					display.printMessage(playerNames[i]+ " Category has already been used. Choose Again.");
					categoryNumber = display.waitForPlayerToSelectCategory();
					check = checkIfCategoryAlreadySelected(categoryNumber, whichPlayer);
				}
				
				trueFalse = YahtzeeCheckCategory.checkCategoryY(rollArray, categoryNumber);
				
				if (trueFalse == true) {
					 Score = score.getScore(rollArray, categoryNumber);
					 display.updateScorecard(categoryNumber, whichPlayer, Score);
				} else {
					display.printMessage("That choice earns nothing in the category chosen.");				
					//Score = score.getScore(rollArray, categoryNumber);
					Score = 0;
					display.updateScorecard(categoryNumber, whichPlayer, Score);
				}
				//adds that score into the list
				if (whichPlayer == 0) {
				if (categoryNumber == ONES || categoryNumber == TWOS || categoryNumber == THREES || categoryNumber == FOURS || categoryNumber == FIVES || categoryNumber == SIXES ) {
					firstPlayerUpperScoreList.add(Score);
						
					}
				int upperScore = 0;
				upperScore = score.getUpperScore(firstPlayerUpperScoreList, whichPlayer, categoryNumber);
				
				if (categoryNumber == THREE_OF_A_KIND  || categoryNumber == FOUR_OF_A_KIND || categoryNumber == FULL_HOUSE || categoryNumber == SMALL_STRAIGHT || categoryNumber == LARGE_STRAIGHT || categoryNumber == YAHTZEE || categoryNumber == CHANCE) {
					firstPlayerLowerScoreList.add(Score);
				}
				int lowerScore = 0;
				lowerScore = score.getLowerScore(firstPlayerLowerScoreList, whichPlayer, categoryNumber);
				
				totalScore = 0;
				totalScore = score.getTotalScore(upperScore, lowerScore, whichPlayer);	
				display.updateScorecard(TOTAL, whichPlayer, totalScore);
					}
				
				if (whichPlayer == 1) {
					if (categoryNumber == ONES || categoryNumber == TWOS || categoryNumber == THREES || categoryNumber == FOURS || categoryNumber == FIVES || categoryNumber == SIXES ) {
							secondPlayerUpperScoreList.add(Score);
						}
					int upperScore = 0;
					upperScore = score.getUpperScore(secondPlayerUpperScoreList, whichPlayer, categoryNumber);
					
					if (categoryNumber == THREE_OF_A_KIND  || categoryNumber == FOUR_OF_A_KIND || categoryNumber == FULL_HOUSE || categoryNumber == SMALL_STRAIGHT || categoryNumber == LARGE_STRAIGHT || categoryNumber == YAHTZEE || categoryNumber == CHANCE) {
						secondPlayerLowerScoreList.add(Score);
					}
					int lowerScore = 0;
					lowerScore = score.getLowerScore(secondPlayerLowerScoreList, whichPlayer, categoryNumber);
					
					secondtotalScore = 0;
					secondtotalScore = score.getTotalScore(upperScore, lowerScore, whichPlayer);
					display.updateScorecard(TOTAL, whichPlayer, secondtotalScore);
						}
				
				if (whichPlayer == 2) {
					if (categoryNumber == ONES || categoryNumber == TWOS || categoryNumber == THREES || categoryNumber == FOURS || categoryNumber == FIVES || categoryNumber == SIXES ) {
							thirdPlayerUpperScoreList.add(Score);
						}
					int upperScore = 0;
					upperScore = score.getUpperScore(thirdPlayerUpperScoreList, whichPlayer, categoryNumber);
				
					if (categoryNumber == THREE_OF_A_KIND  || categoryNumber == FOUR_OF_A_KIND || categoryNumber == FULL_HOUSE || categoryNumber == SMALL_STRAIGHT || categoryNumber == LARGE_STRAIGHT || categoryNumber == YAHTZEE || categoryNumber == CHANCE) {
						thirdPlayerLowerScoreList.add(Score);
					}
					int lowerScore = 0;
					lowerScore = score.getLowerScore(thirdPlayerLowerScoreList, whichPlayer, categoryNumber);
					
					thirdtotalScore = 0;
					thirdtotalScore = score.getTotalScore(upperScore, lowerScore, whichPlayer);	
					display.updateScorecard(TOTAL, whichPlayer, thirdtotalScore);
						}
				
				
				if (whichPlayer == 3) {
					if (categoryNumber == ONES || categoryNumber == TWOS || categoryNumber == THREES || categoryNumber == FOURS || categoryNumber == FIVES || categoryNumber == SIXES ) {
							fourPlayerUpperScoreList.add(Score);
						}
					int upperScore = 0;
					upperScore = score.getUpperScore(fourPlayerUpperScoreList, whichPlayer, categoryNumber);

					if (categoryNumber == THREE_OF_A_KIND  || categoryNumber == FOUR_OF_A_KIND || categoryNumber == FULL_HOUSE || categoryNumber == SMALL_STRAIGHT || categoryNumber == LARGE_STRAIGHT || categoryNumber == YAHTZEE || categoryNumber == CHANCE) {
						fourPlayerLowerScoreList.add(Score);
					}
					int lowerScore = 0;
					lowerScore = score.getLowerScore(fourPlayerLowerScoreList, whichPlayer, categoryNumber);
					
					fourthtotalScore = 0;
					fourthtotalScore = score.getTotalScore(upperScore, lowerScore, whichPlayer);
					display.updateScorecard(TOTAL, whichPlayer, fourthtotalScore);
						}
				}
			scoresArray[roundsCounter] = Score;
			roundsCounter++;
			println(roundsCounter);
			
		}
			if (roundsCounter >= 13) {
				calculateLowScore();
				calculateUpperScore();
				print("Total " +totalScore);
				
				winner = getWinner(totalScore, 0);
				winner = getWinner(secondtotalScore, 1);
				winner = getWinner(thirdtotalScore, 2);
				winner = getWinner(fourthtotalScore, 3);
				endGame(winner);
				
//				display.printMessage("If you would like to play again click the dice.");
//				int[] array = new int[0];
//				int arrayInt = array[0];
//				display.updateScorecard(0, 0, arrayInt);
				//heres the catch write it so that it can restart the game
				//arrays will have to be cleared out
				//the categories that were told they were true need to be false so they can be picked
				//variables such as roundcounter need to be reset to zero.
				
			}
		}
	
	//the first roll that each character makes
	private int[] rollDice(int[] diceArray) {
		for (int i = 0; i < N_DICE; i++) {
			int min = 1;
			//int max = N_DICE + min;
			//get the computer to recognize the range of numbers that it needs to select randomly from.
			
			//cheat for testing large Straight
			//int diceNumbers = i + 1;
			
			int diceNumbers = rgen.nextInt(min, (N_DICE + min)) ;
			diceArray[i] += diceNumbers;
		}
		return diceArray;
	}

	//second and third roll
	private int[] reroll(int[] rArray) {
		for (int i = 0; i < N_DICE; i++) {
			int min = 1;
			//int max = N_DICE + min;
			if (display.isDieSelected(i) == true) {
//				rArray[i] = rgen.nextInt(N_DICE) + 2;
//				rArray[i] = rgen.nextInt((max - min) + 1) + min;
				rArray[i] = rgen.nextInt(min, (N_DICE + min));
				counter++;
			}
		}
		return rArray;
	}
	
	private boolean checkIfCategoryAlreadySelected(int categoryNumber, int playerNumber) {
		boolean isAlreadySelected = false;
		if (playerNumber == 0) {
		for (int i = 0; i < firstPlayerCategoryCheckList.size(); i++) {
			if (categoryNumber == firstPlayerCategoryCheckList.get(i)) {
				isAlreadySelected = true;
			} 
				}
		firstPlayerCategoryCheckList.add(categoryNumber);
		}
		
		if (playerNumber == 1) {
			for (int i = 0; i < secondPlayerCategoryCheckList.size(); i++) {
				if (categoryNumber == secondPlayerCategoryCheckList.get(i)) {
					isAlreadySelected = true;
				} 
					}
			secondPlayerCategoryCheckList.add(categoryNumber);
			}
		
		if (playerNumber == 2) {
			for (int i = 0; i < thirdPlayerCategoryCheckList.size(); i++) {
				if (categoryNumber == thirdPlayerCategoryCheckList.get(i)) {
					isAlreadySelected = true;
				} 
					}
			thirdPlayerCategoryCheckList.add(categoryNumber);
			}
		
		if (playerNumber == 3) {
			for (int i = 0; i < fourthPlayerCategoryCheckList.size(); i++) {
				if (categoryNumber == fourthPlayerCategoryCheckList.get(i)) {
					isAlreadySelected = true;
				} 
					}
			fourthPlayerCategoryCheckList.add(categoryNumber);
			}
			return isAlreadySelected;
	}
	
	private int getWinner(int totalScores, int player) {
		int total = totalScores;
		if (highestScore < total) {
			highestScore = total;
			winner = player;
			}
		return winner;
		}
	
	private void endGame(int winner) {
		display.printMessage("Player " +playerNames[winner]+ " has the highest score and wins!");
	}
	
	private void calculateLowScore() {
		ArrayList<Integer> lowerScoreList  = new ArrayList<Integer>();
		int firstPlayerLowScore = 0;
		int secondPlayerLowScore = 0;
		int thirdPlayerLowScore = 0;
		int fourthPlayerLowScore = 0;
		
		for (int i = 0; i < 6; i++) {
			firstPlayerLowScore += firstPlayerLowerScoreList.get(i);
			lowerScoreList.add(0, firstPlayerLowScore);
			if (nPlayers >= 2) {
			secondPlayerLowScore += secondPlayerLowerScoreList.get(i);
			lowerScoreList.add(1, secondPlayerLowScore);
				}
			if (nPlayers >= 3) {
			thirdPlayerLowScore += thirdPlayerLowerScoreList.get(i);
			lowerScoreList.add(2, thirdPlayerLowScore);
				}
			if (nPlayers == MAX_PLAYERS) {
			fourthPlayerLowScore += fourPlayerLowerScoreList.get(i);
			lowerScoreList.add(3, fourthPlayerLowScore);
					}
				}
			for (int i = 0; i < nPlayers; i++) {
			display.updateScorecard(LOWER_SCORE, i, lowerScoreList.get(i));
		}
}
	
	private void calculateUpperScore() {
		ArrayList<Integer> upperScoreList  = new ArrayList<Integer>();
		int firstPlayerUpperScore = 0;
		int secondPlayerUpperScore = 0;
		int thirdPlayerUpperScore = 0;
		int fourthPlayerUpperScore = 0;
		int upperScore = 0;
		int upperBonus = 35;
		
		for (int i = 0; i < 6; i++) {
			firstPlayerUpperScore += firstPlayerUpperScoreList.get(i);
			upperScoreList.add(0, firstPlayerUpperScore);
			if (nPlayers >= 2) {
			secondPlayerUpperScore += secondPlayerUpperScoreList.get(i);
			upperScoreList.add(1, secondPlayerUpperScore);
				}
			if (nPlayers >= 3) {
			thirdPlayerUpperScore += thirdPlayerUpperScoreList.get(i);
			upperScoreList.add(2, thirdPlayerUpperScore);
				}
			if (nPlayers == MAX_PLAYERS) {
			fourthPlayerUpperScore += fourPlayerUpperScoreList.get(i);
			upperScoreList.add(3, fourthPlayerUpperScore);
				}
		}
		
		for (int i = 0; i < nPlayers; i++) {
			display.updateScorecard(UPPER_SCORE, i, upperScoreList.get(i));
			upperScore = upperScoreList.get(i);
		if (upperScore >= 63) {
			display.updateScorecard(UPPER_BONUS, i, upperBonus);
			if (i == 0) {
				totalScore = totalScore + upperBonus;
				display.updateScorecard(TOTAL, i, totalScore);
				}
			if (i == 1) {
				secondtotalScore = secondtotalScore + upperBonus;
				display.updateScorecard(TOTAL, i, secondtotalScore);
				}
			if (i == 2) {
				thirdtotalScore = thirdtotalScore + upperBonus;
				display.updateScorecard(TOTAL, i, thirdtotalScore);
				}
			if (i == 3) {
				fourthtotalScore = fourthtotalScore + upperBonus;
				display.updateScorecard(TOTAL, i, fourthtotalScore);
				}
			}
		}
	}
	
	
	
	/* Private instance variables */
	private int nPlayers;
	private String[] playerNames;
	private YahtzeeDisplay display;
	
	private RandomGenerator rgen = RandomGenerator.getInstance();
	int counter = 0;
	int roundsCounter = 0;
	
	int categoryNumber = 0;
	int Score = 0;
	
//	ArrayList<Integer> lowerScoreList  = new ArrayList<Integer>();
	ArrayList<Integer> upperScoreList  = new ArrayList<Integer>();
	
	ArrayList<Integer> firstPlayerLowerScoreList  = new ArrayList<Integer>();
	ArrayList<Integer> firstPlayerUpperScoreList  = new ArrayList<Integer>();
	ArrayList<Integer> firstPlayerTotalScoreList  = new ArrayList<Integer>();
	
	ArrayList<Integer> secondPlayerLowerScoreList  = new ArrayList<Integer>();
	ArrayList<Integer> secondPlayerUpperScoreList  = new ArrayList<Integer>();
	ArrayList<Integer> secondPlayerTotalScoreList  = new ArrayList<Integer>();
	
	ArrayList<Integer> thirdPlayerLowerScoreList  = new ArrayList<Integer>();
	ArrayList<Integer> thirdPlayerUpperScoreList  = new ArrayList<Integer>();
	ArrayList<Integer> thirdPlayerTotalScoreList  = new ArrayList<Integer>();
	
	ArrayList<Integer> fourPlayerLowerScoreList  = new ArrayList<Integer>();
	ArrayList<Integer> fourPlayerUpperScoreList  = new ArrayList<Integer>();
	ArrayList<Integer> fourPlayerTotalScoreList  = new ArrayList<Integer>();
	
	ArrayList<Integer> firstPlayerCategoryCheckList = new ArrayList<Integer>();
	ArrayList<Integer> secondPlayerCategoryCheckList = new ArrayList<Integer>();
	ArrayList<Integer> thirdPlayerCategoryCheckList = new ArrayList<Integer>();
	ArrayList<Integer> fourthPlayerCategoryCheckList = new ArrayList<Integer>();
	
	ArrayList<Integer> TotalScoreList  = new ArrayList<Integer>();
	
	int lowerScoreCounter = 0;
	
	int totalScore = 0;
	int secondtotalScore = 0;
	int thirdtotalScore = 0;
	int fourthtotalScore = 0;
	
	int whichPlayer = 0;
	boolean check  = false;
	
	int highestScore = 0;
	int winner = 0;
}
