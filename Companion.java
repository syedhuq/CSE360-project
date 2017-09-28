/**
* Companion displays one of four animated facial expressions reacting to user inputs.
* Recitation Project 2
* Completion time: 5 hours
*
* @author Syed Huq
* @version 2.0
*/


package edu.asu.CSE360._03._03;


import javax.swing.*;
import java.awt.event.*;

public class Companion extends JPanel
{
	// Declarations
	JLabel label, name, label2;
	ImageIcon icon1, icon2, icon3, icon4;
	int delay, i, j;
	ActionListener animate;
	
	// Constructor
	public Companion()
	{
		// my name to be displayed on initial state
		name = new JLabel("Syed Huq");
		add(name);
		
		// label will be used to display the image
		label = new JLabel();
		label2 = new JLabel();
		add(label);

		// creating icons for each image, retrieving from path
		icon1 = new ImageIcon("resources/happy.png");
		icon2 = new ImageIcon("resources/thinking.png");
		icon3 = new ImageIcon("resources/worried.png");
		icon4 = new ImageIcon("resources/sorry.png");
		
		// initializing our array of icons for animation
		ImageIcon[][] icons = new ImageIcon[4][4];
		for(int i = 0; i < 4; i++)
		{
			switch(i)
			{
			case 0: // happy
				for(int j = 0; j < 4; j++)
				{
					icons[i][j] = new ImageIcon("resources/happy" + j + ".png");
				}//end of happy for loop
				break;
			case 1: // thinking
				for(int j = 0; j < 4; j++)
				{
					icons[i][j] = new ImageIcon("resources/thinking" + j + ".png");
				}
				break;
			case 2: // worried
				for(int j = 0; j < 4; j++)
				{
					icons[i][j] = new ImageIcon("resources/worried" + j + ".png");
				}
				break;
			case 3: // sorry
				for(int j = 0; j < 4; j++)
				{
					icons[i][j] = new ImageIcon("resources/sorry" + j + ".png");
				}
				break;
			}// end of switch
			
		}// end of icons[][] initialization
		
		delay = 500; // half a second
		i = 0;
		j = 0;
		
		// timer holds this action to animate the faces
		animate = new ActionListener() 
		{
		    public void actionPerformed(ActionEvent evt)
		    {
		    	Icon test = label2.getIcon(); // input from slider
		    	if(test != null) // prevent initial state displays
		    	{
		    		// setting first index of icons[][] to select face
		    		if(test.toString().equals("resources/happy.png"))
		    		{
		    			i = 0;
		    		}
		    		else if(test.toString().equals("resources/thinking.png"))
		    		{
		    			i = 1; 
		    		}
		    		else if(test.toString().equals("resources/worried.png"))
		    		{
		    			i = 2;
		    		}
		    		else if(test.toString().equals("resources/sorry.png"))
		    		{
		    			i = 3;
		    		}
		    		
		    		// second index of icons[][] is manipulated here to create animation
		    		if(j >= 3)
	    				j = 0; // if we've hit the end of an animation sequence, reset
	    			else
	    				j++; // otherwise, increment
	    				
	    			label.setIcon(icons[i][j]); // change display
		    	}// end of null-check if
		    }
		};
		
		
		// Create a timer
		// NOTE: Timer objects will run on a separate thread, so this accomplishes the multithreading requirement
		new Timer(delay, animate).start();
	}
	
	public void changeState(int state)
	{
		
		// get rid of my name past initial state
		remove(name);
		
		// switch statement to control which image is displayed		
		// as of project 2, this section is used instead to control program flow for the animation timer
		// (label2 is not actually displayed, only label)
		switch(state)
		{
		case 1: label2.setIcon(icon1); break;
		case 2: label2.setIcon(icon2); break;
		case 3: label2.setIcon(icon3); break;
		case 4: label2.setIcon(icon4); break;
		}
		
	}
	
}
