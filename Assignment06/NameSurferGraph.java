/*
 * File: NameSurferGraph.java
 * ---------------------------
 * This class represents the canvas on which the graph of
 * names is drawn. This class is responsible for updating
 * (redrawing) the graphs whenever the list of entries changes
 * or the window is resized.
 */

import acm.graphics.*;
import java.awt.event.*;
import java.util.*;
import java.awt.*;

public class NameSurferGraph extends GCanvas
	implements NameSurferConstants, ComponentListener {

	/**
	 * Creates a new NameSurferGraph object that displays the data.
	 */
	public NameSurferGraph() {
		addComponentListener(this);
		// You fill in the rest //
	}
	
	
	/**
	 * Clears the list of name surfer entries stored inside this class.
	 */
	public void clear() {
		// You fill this in //
		entryMap.clear();
		counter = 0;
		update();
		
	}
	
	
	/* Method: addEntry(entry) */
	/**
	 * Adds a new NameSurferEntry to the list of entries on the display.
	 * Note that this method does not actually draw the graph, but
	 * simply stores the entry; the graph is drawn by calling update.
	 */
	public void addEntry(NameSurferEntry entry) {
		
		entryMap.put(counter, entry);
		counter++;
}
	
	
	/**
	 * Updates the display image by deleting all the graphical objects
	 * from the canvas and then reassembling the display according to
	 * the list of entries. Your application must call update after
	 * calling either clear or addEntry; update is also called whenever
	 * the size of the canvas changes.
	 */
	public void update() {
		createBackgroundGrid();
		if (!entryMap.isEmpty()) {addElements();}
	}
	
	public void colors() {
		colorsArray = new Color[5];
		colorsArray[0] = Color.blue;
		colorsArray[1] = Color.red;
		colorsArray[2] = Color.yellow;
		colorsArray[3] = Color.green;
		colorsArray[4] = Color.CYAN;
}

	
	public void addElements() {
		colors();
		colorsArrayCounter = 0;
		
		
		
		for (int i = 0; i < entryMap.size(); i++) {
			nameEntry = entryMap.get(i);
			int number = 0;
			int rankNumber = 0;
			graphHeight = getHeight();
			
		for (int j = 0; j < NDECADES; j++){
			number++;
			String name01 = nameEntry.getName();
			nameEntry.getName();
			rankNumber = nameEntry.getRank(number);
			double perc = ((((double)rankNumber / getHeight()) *0.10) * getHeight()) / 100;
			
			graphHeight = (getHeight()*perc);
					//(graphHeight*0.06  + ((double)rankNumber - ((double)rankNumber *0.5)));
			if (graphHeight < 30) {
				graphHeight = getHeight()*0.05;
			}
			if (rankNumber > 0) {
				rankNum = Integer.toString(rankNumber);
			}
			if (rankNumber == 0) {
				graphHeight = (getHeight()*0.90);
				rankNum = "*";
			}
			
			addEnt = new GLabel(name01+" "+rankNum, (getWidth()/NDECADES)*j, graphHeight);
			add(addEnt);
			
			addLine = new GLine( (getWidth()/NDECADES)*j ,graphHeight , (getWidth()/NDECADES)*(j-1), previousHeight);
			if (colorsArrayCounter == 5) {
				colorsArrayCounter = 0;
			}
			Color color = colorsArray[colorsArrayCounter];
			addLine.setColor(color);
			add(addLine);
			previousHeight = graphHeight;
			}
		
		colorsArrayCounter++;
		}
		
	}
	
	//method to create the background elements
	public void createBackgroundGrid() {
		//now add twelve of them at the right intervals
		removeAll();
		for (int i = 0; i < NDECADES; i++) {
		GLine line = new GLine((getWidth()/NDECADES)*i, getHeight(),(getWidth()/NDECADES)*i, -getHeight()); 
		add(line);
		
		int num = 10*i;
		int year = START_DECADE + num;
		String decade = ""+year;
		GLabel decadeLabel = new GLabel(decade,(getWidth()/NDECADES)*i, getHeight()*.95);
		add(decadeLabel);
		}
		
		GLine upLine = new GLine(getWidth(), getHeight()*.05, getWidth()*0,  getHeight()*.05);
		add(upLine);
		
		GLine downLine = new GLine(getWidth(),  getHeight()*0.90, getWidth()*0,  getHeight()*0.90);
		add(downLine);
	}
	
	
	/* Implementation of the ComponentListener interface */
	public void componentHidden(ComponentEvent e) { }
	public void componentMoved(ComponentEvent e) { }
	public void componentResized(ComponentEvent e) { update(); }
	public void componentShown(ComponentEvent e) { }
	
	/*private instance variables*/
	private HashMap<Integer, NameSurferEntry> entryMap = new HashMap<Integer, NameSurferEntry>();
	int counter = 0;
	NameSurferEntry nameEntry;
	private double graphHeight = getHeight();
	
	private double previousHeight = graphHeight;;
	private String rankNum;
	//private String name = " ";
	
	GLine addLine;
	GLabel addEnt;
	Color[] colorsArray;
	int colorsArrayCounter = 0;
	
}
