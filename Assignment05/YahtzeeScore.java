/**

 * 
 */

/**
 * @author Keeley
 *
 */

import acm.util.*;

//import acm.program.*;
import java.util.ArrayList;

public class YahtzeeScore {
	
	//calculate the score for each category of dice roll
	public int getScore(int[] diceArray, int Category) {
		int Score = 0;
		switch (Category) {
			case 0:
				for (int i : diceArray) {
				if (i == 1) {
				Score += i;
				} }
					return Score;
			case 1: 
				for (int i = 0; i < diceArray.length; i++ ) {
					if (diceArray[i] == 2) {
					Score += diceArray[i];
						}
					}
					return Score;
			case 2: 
				for (int i = 0; i < diceArray.length; i++ ) {
					if (diceArray[i] == 3) {
						Score += diceArray[i];
						}
					}
					return Score;
			case 3:
				for (int i = 0; i < diceArray.length; i++ ) {
					if (diceArray[i] == 4) {
					Score += diceArray[i];
						}
					}
					return Score;
			case 4: 
				for (int i = 0; i < diceArray.length; i++ ) {
					if (diceArray[i] == 5) {
					Score += diceArray[i];
						}
					}
					return Score;
			case 5: 
				for (int i = 0; i < diceArray.length; i++ ) {
					if (diceArray[i] == 6) {
					Score += diceArray[i];
						}
					}
					return Score;
			case 8: 
				for (int i = 0; i < diceArray.length; i++) {
					Score += diceArray[i];
					}
					return Score;
			case 9: 
				for (int i = 0; i < diceArray.length; i++) {
					Score += diceArray[i];
					}
					return Score;
			case 10: return Score = 25;
			case 11: return Score = 30;
			case 12: return Score = 40;
			case 13: return Score = 50;
			case 14:
				for (int i = 0; i < diceArray.length; i++) {
					Score += diceArray[i];
					}
					return Score;
			default: throw new ErrorException("Not a category");
			}
		}

	//get the lower scores for the players.
	public int getLowerScore(ArrayList<Integer> array, int player, int categoryNumber) {
		switch (player) {
			case 0: 
				int lowerScore = 0;
				for (int i : array) {
					lowerScore += i;
				}	return lowerScore;
			case 1:
				int twolowerScore = 0;
				for (int i : array) {
					twolowerScore += i;
				}	return twolowerScore;
			case 2:
				int threelowerScore = 0;
				for (int i : array) {
					threelowerScore += i;
				}	return threelowerScore;	
			case 3:
				int fourlowerScore = 0;
				for (int i : array) {
					fourlowerScore += i;
				}	return fourlowerScore;	
			
			default: throw new ErrorException("Not a category");
		 }

	}
	
	public int getUpperScore(ArrayList<Integer> array, int player, int categoryNumber) {
		switch (player) {
		case 0: 
			int upperScore = 0;
			for (int i : array) {
				upperScore += i;
			}	return upperScore;
		case 1:
			int twoUpperScore = 0;
			for (int i : array) {
				twoUpperScore += i;
			}	return twoUpperScore;
			
		case 2:
			int threeUpperScore = 0;
			for (int i : array) {
				threeUpperScore += i;
			}	return threeUpperScore;
		case 3:
			int fourUpperScore = 0;
			for (int i : array) {
				fourUpperScore += i;
			}	return fourUpperScore;
		default: throw new ErrorException("Not a category");
		}		
	}
	
	public int getTotalScore(int upperScore, int lowerScore, int player) {
		int totalScore = 0;
		switch (player) {
		case 0: 
			totalScore = upperScore + lowerScore;
			return totalScore;
		case 1:
			totalScore = upperScore + lowerScore;
			return totalScore;
		case 2:
			totalScore = upperScore + lowerScore;
			return totalScore;
		case 3:
			totalScore = upperScore + lowerScore;
			return totalScore;
			
		default: throw new ErrorException("Not a category");
			}
		}

	int Score = 0;
	
}
