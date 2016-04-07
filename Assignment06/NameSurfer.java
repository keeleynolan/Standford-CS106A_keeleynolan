/*
 * File: NameSurfer.java

 * ---------------------
 * When it is finished, this program will implement the viewer for
 * the baby-name database described in the assignment handout.
 * Allows the user to search a list of names for popular baby names through 12 Decades.
 */

import acm.program.*;
import java.awt.event.*;
import javax.swing.*;


public class NameSurfer extends Program implements NameSurferConstants {
	
	/* Method: init() */
	/**
	 * This method has the responsibility for reading in the data base
	 * and initializing the interactors at the top of the window.
	 */
	public void init() {
		graph = new NameSurferGraph();
		add(graph);
		data = new NameSurferDataBase("names-data.txt");
		
	    // You fill this in, along with any helper methods //
		nameLabel = new JLabel("Name:");
		add(nameLabel, NORTH);
		
		nameTextField = new JTextField(25);
		add(nameTextField, NORTH);
		
		graphButton = new JButton("Graph");
		add(graphButton, NORTH);
		
		clearButton = new JButton("Clear");
		add(clearButton, NORTH);
		
		addActionListeners();
	}

	/* Method: actionPerformed(e) */
	/**
	 * This class is responsible for detecting when the buttons are
	 * clicked, so you will have to define a method to respond to
	 * button actions.
	 */
	public void actionPerformed(ActionEvent e) {
		// You fill this in //
		if (e.getSource() == graphButton) {
			//bunch of errors being thrown when textfield tried to get text but nothing had been entered.
			//apparently it also has access to isEmpty()
			if (!nameTextField.getText().isEmpty()){
				nameS = nameTextField.getText();
				println("Get string" + data.findEntry(nameS));
				if (!(data.findEntry(nameS) == null)) {
					graph.addEntry(data.findEntry(nameS));
					graph.update();
				}
				//graph.update();
				//graph.createBackgroundGrid();
			}
			
			
		}
		if (e.getSource() == clearButton) {
			println("Clear");
			graph.clear();
			//removeAll();
		}
	}
	NameSurferEntry line;
	NameSurferDataBase data;
	private String nameS;
	private JLabel nameLabel;
	private JTextField nameTextField;
	private JButton graphButton;
	private JButton clearButton;
	private NameSurferGraph graph;
}
