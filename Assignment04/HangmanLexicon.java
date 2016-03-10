/*
 * File: HangmanLexicon.java
 * -------------------------
 * This file contains a stub implementation of the HangmanLexicon
 * class that you will re-implement for Part III of the assignment.
 */

import acm.util.*;
//import acm.program.*;

import java.io.*;
import java.util.ArrayList;


public class HangmanLexicon {

	//String[] wordArray = new String [0];
	ArrayList<String> wordList  = new ArrayList<String>();
	int count = 1;
	
	public HangmanLexicon() {
		//reads in a file with hundreds of words
		try {
			BufferedReader rd = new BufferedReader(new FileReader("HangmanLexicon.txt"));
			while (true) {
				String line = rd.readLine();
				if(line == null) break;
				wordList.add(line);
				count++;

			}
			rd.close();
		} catch (IOException ex) {
			throw new ErrorException(ex);
		}
		
		
	}
	
/** Returns the number of words in the lexicon. */
	public int getWordCount() {
//		int numbersInArray = wordArray.length;
		int numberOfWords = wordList.size();
		return numberOfWords;
		//return 10;
	}

/** Returns the word at the specified index. */
	public String getWord(int index) {
		
		
		
		String word = wordList.get(index);
		return word;
		
		
		
		
//		switch (index) {
//			case 0: return "BUOY";
//			case 1: return "COMPUTER";
//			case 2: return "CONNOISSEUR";
//			case 3: return "DEHYDRATE";
//			case 4: return "FUZZY";
//			case 5: return "HUBBUB";
//			case 6: return "KEYHOLE";
//			case 7: return "QUAGMIRE";
//			case 8: return "SLITHER";
//			case 9: return "ZIRCON";
//			default: throw new ErrorException("getWord: Illegal index");
//		}
	};
}
