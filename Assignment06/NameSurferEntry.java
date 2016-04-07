/*
 * File: NameSurferEntry.java
 * --------------------------
 * This class represents a single entry in the database.  Each
 * NameSurferEntry contains a name and a list giving the popularity
 * of that name for each decade stretching back to 1900.
 */

import java.util.*;

public class NameSurferEntry implements NameSurferConstants {

	
	/* Constructor: NameSurferEntry(line) */
	/**
	 * Creates a new NameSurferEntry from a data line as it appears
	 * in the data file.  Each line begins with the name, which is
	 * followed by integers giving the rank of that name for each
	 * decade.
	 */
	public NameSurferEntry(String line) {
		// You fill this in //
		entryArray = line.split(" ");
		childName = entryArray[0];
		
		for (int i = 1; i <= 12; i++) {
			numbersMap.put(i, Integer.parseInt(entryArray[i]));
		}
}

	/* Method: getName() */
	/**
	 * Returns the name associated with this entry.
	 */
	public String getName() {
		// You need to turn this stub into a real implementation //
		return childName;
	}

	/* Method: getRank(decade) */
	/**
	 * Returns the rank associated with an entry for a particular
	 * decade.  The decade value is an integer indicating how many
	 * decades have passed since the first year in the database,
	 * which is given by the constant START_DECADE.  If a name does
	 * not appear in a decade, the rank value is 0.
	 */
	public int getRank(int decade) {
		decadeRank = numbersMap.get(decade);
		return decadeRank;
	}

	/* Method: toString() */
	/**
	 * Returns a string that makes it easy to see the value of a
	 * NameSurferEntry.
	 */
	public String toString() {
		// You need to turn this stub into a real implementation //
		return " "+childName+ " [" +numbersMap.get(1)+ " " +numbersMap.get(2)+ " " +numbersMap.get(3)+ " " +numbersMap.get(4)+ " " +numbersMap.get(5)+ " " +numbersMap.get(6)+ " " +numbersMap.get(7)+ " " +numbersMap.get(8)+ " " +numbersMap.get(9)+ " " +numbersMap.get(10)+ " " +numbersMap.get(11)+ " " +numbersMap.get(12)+ "]";
	}
	
	HashMap <Integer, Integer> numbersMap = new HashMap <Integer, Integer>();
	private String[] entryArray;
	private int decadeRank;
	private String childName;
	
	//HashMap <String, Object> entryMap = new HashMap <String, Object>();
}

