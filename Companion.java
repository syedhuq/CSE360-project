/**
* Companion displays one of four facial expressions reacting to user inputs.
* Recitation Project 1
* Completion time: 2 hours
*
* @author Syed Huq
* @version 1.0
*/


package edu.asu.CSE360._03._03;


import javax.swing.*;

public class Companion extends JPanel
{
	// Declarations
	JLabel label, name;
	ImageIcon icon1, icon2, icon3, icon4;
	
	// Constructor
	public Companion()
	{
		// my name to be displayed on initial state
		name = new JLabel("Syed Huq");
		add(name);
		
		// label will be used to display the image
		label = new JLabel();
		add(label);

		// creating icons for each image, retrieving from path
		icon1 = new ImageIcon("resources/happy.png");
		icon2 = new ImageIcon("resources/thinking.png");
		icon3 = new ImageIcon("resources/worried.png");
		icon4 = new ImageIcon("resources/sorry.png");
		
	}
	
	public void changeState(int state)
	{
		// get rid of my name past initial state
		remove(name);
		
		// switch statement to control which image is displayed
		switch(state)
		{
		case 1: label.setIcon(icon1); break;
		case 2: label.setIcon(icon2); break;
		case 3: label.setIcon(icon3); break;
		case 4: label.setIcon(icon4); break;
		}
		
	}
	
}
