/*
 * File: Hangman.java

 * ------------------
 * This program will eventually play the Hangman game from
 * Assignment #4.
 */

//import acm.graphics.*;

import acm.program.*;
import acm.util.RandomGenerator;

public class Hangman extends ConsoleProgram {
	
	
	public void init() {
    	canvas = new HangmanCanvas();
    	add(canvas);
    	
    }
	
    public void run() {
    	canvas.reset();
    	playGame();
    	
		
	}
    
    private void playGame() {
    	
    	HangmanLexicon lexicon = new HangmanLexicon();
    	println("Welcome to Hangman!");
    	int count = rgen.nextInt(lexicon.getWordCount());
    	
    	String word = lexicon.getWord(count);
    	int wordLength = word.length();

		print("The word looks like this: ");
		
		char[] hideWord = new char [wordLength];
		for (int i = 0; i < wordLength; i++) {
    		hideWord[i] = dash;
    		print(hideWord[i] + " ");
    	}println(" ");
    	
		while (keepPlaying == true) {
			boolean keepPlaying = checkToKeepPlaying(wordLength, word, hideWord);
			if (keepPlaying == false) break;
			
			print("You have " +guessCounter+ " guesses left" );
			println(" ");
			
			String guess = readUserGuess();
			
			check = checkGuess(wordLength, guess, word);
		
			print("The word looks like this: ");
			for (int i = 0 ; i < wordLength; i++) {
				if (check == true) {
					hideWord = update(wordLength, guess, word, hideWord);

			    	char hiddenWordCh = hideWord[i];
			    	hiddenWord += hiddenWordCh;
			    	canvas.displayWord(hideWord);

					print(hideWord[i] + " ");
					
				} if (check == false) {
					print(hideWord[i] + " ");
				}
			} println(" ");
		}
		
		boolean endGame = true;
		endGame = endGameWinLose(wordLength, word, hideWord);
		if (endGame == true) {
			endGameWithWin(endGame, word);
		} if (endGame == false) {
			endGameWithLose(endGame, word);
		}
		
		//work in progress, getting the program to restart after finishing a round.
////		if (keepPlaying = false) {
//			print("Keep Playing?  Enter Y for Yes and N for No: ");
//			String yesNo = readLine("");
//			String yes = "Y";
//			String no = "N";
//			if (yesNo.equals(yes)) {
//				keepPlaying = true;
//				wordLength = 0;
//				word = "";
//				//hideWord = [''];
//				playGame();
////			}
//			if (yesNo.equals(no)) {
//				println("Thank you for playing.");
//			}
//		}
		
    	
	}
    
    
     private boolean checkGuess(int wordLength, String guess, String word) {
    	for (int i = 0; i < wordLength; i++) {
    		if (guess.charAt(0) == word.charAt(i)) {
    			check = true;
    			break;
    		}else if (word.charAt(i) != guess.charAt(0)){
    			check = false;
    			
    		}
    	}
    	if (check == true) {
    		println("Your guess " +guess+ " is correct!");
    	} if (check == false) {
    		println("There are no " +guess+ "'s in the word ");
    		for (int i = 0; i < guess.length(); i++) {
				char chGuess = guess.charAt(i);
				canvas.noteIncorrectGuess(chGuess);
			}
			guessCounter--;
    	}
    	return check;
    }
   
    private String readUserGuess() {
    	String guess = readLine("Enter a letter: ");
    	if (!isLegalGuess(guess)) {
    		println("That was an invalid guess. Try again: ");
    		guess = readLine("Reenter Guess: ");
    	} 
    	guess = guess.toUpperCase();
		return guess;
	}
    
    private boolean isLegalGuess(String guess) {
    	if (guess.length() != 1) return false;
    	for (int i = 0; i < guess.length(); i++) {
    		char letter = guess.charAt(i);
    		if (!Character.isLetter(letter)) {
    			return false;
    		}
    	}
    	return true;
    } 
    
    private char[] update(int wordLength, String guess, String word, char[] dashArray) {
    	int letterAt = 0;
    	
    	for (int i = 0; i < wordLength; i++) {
    		if (word.charAt(i) == guess.charAt(0)) {
    			letterAt = i;
    			dashArray[letterAt] = guess.charAt(0);
        	}
    	}
    	return dashArray;
    }
    
    private boolean checkToKeepPlaying(int wordLength, String word , char[] hideWord) {
    	String finalWord = "";
    	char [] wordArray = new char [word.length()];
    	for(int i = 0; i < word.length(); i++) {
    		wordArray[i] = word.charAt(i);
    		char c = hideWord[i];
    		finalWord += c; 
    	}
    	boolean keepPlaying = true;
    	for (int i = 0 ; i < wordLength; i++) {
    		char c = hideWord[i];
       
    	if (!Character.isLetter(c) && guessCounter != 0) {
    		keepPlaying = true;
    	} else if (guessCounter == 0) {
    		keepPlaying = false;
    	} else if (word.equals(finalWord)) {
    		keepPlaying = false;
    			}
    		}
    	return keepPlaying;
    	}
  
    private boolean endGameWinLose(int wordLength,String word, char[] dashArray) {
    	boolean win = true;
    	for (int i = 0 ; i < wordLength; i++) {
    		char c = dashArray[i];
    		if (guessCounter <= 0 && !Character.isLetter(c)) {
    			win = false;
    		} else if (dashArray[i] == dash) {
    			win = false;
    		} else {
    			win = true;
    		}
    	}
    	return win;
    }
    private String[] endGameWithWin(boolean win, String word) {
    	String[] winArray = new String [] {"You guessed the word: ", "You win!"};
    	println(winArray[0] +word);
    	println(winArray[1]);
    	return winArray;
    }
    
    private String[] endGameWithLose(boolean lose, String word) {
    	String[] loseArray = new String [] {"The word was: ", "You lose."};
    	println(loseArray[0] +word);
    	println(loseArray[1]);
    	return loseArray;
    }
    
   
   
    private RandomGenerator rgen = RandomGenerator.getInstance();
	int guesses = 8;
	int guessCounter = 8;
	char dash = '_';
	boolean equals = false;	
	boolean wordGuessed = false;
	boolean keepPlaying = true;
	
	boolean check = true;
	private HangmanCanvas canvas;
	String hiddenWord = "";
}

