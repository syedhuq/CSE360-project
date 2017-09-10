/**
* Companion displays one of four facial expressions reacting to user inputs.
* Recitation Project 1
* Completion time: 2 hours
*
* @author Syed Huq
* @version 1.0
*/


package edu.asu.CSE360._03._05;


import javax.swing.*;

public class Companion extends JPanel
{
	JLabel label, name;
	ImageIcon icon1, icon2, icon3, icon4;
	
	public Companion()
	{
		name = new JLabel("Syed Huq");
		add(name);
		
		label = new JLabel();
		add(label);

		icon1 = new ImageIcon(getClass().getResource("resources/happy.png"));
		icon2 = new ImageIcon(getClass().getResource("resources/thinking.png"));
		icon3 = new ImageIcon(getClass().getResource("resources/worried.png"));
		icon4 = new ImageIcon(getClass().getResource("resources/sorry.png"));
		
	}
	
	public void changeState(int state)
	{
		remove(name);
		switch(state)
		{
		case 1: label.setIcon(icon1); break;
		case 2: label.setIcon(icon2); break;
		case 3: label.setIcon(icon3); break;
		case 4: label.setIcon(icon4); break;
		}
		
	}
	
}
