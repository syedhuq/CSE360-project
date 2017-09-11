/**
* Universe displays a GUI with Assessor, Companion, and Tutor panels, it will update each panel depending on the state of a slider.
* Recitation Project 1
* Completion time: 2 hours
*
* @author Bryce Turner
* @version 1.0
*/


package edu.asu.CSE360._03._05;

import java.awt.*;
import javax.swing.*;
import javax.swing.SwingConstants;
import javax.swing.event.*;

public class Universe extends JFrame {
	
	//Initializing components
	private JPanel a, b, c, u, north, south;
	private JLabel uL;
	private JSlider slider;

	//Universe constructor
	public Universe() {
		
		//JFrame appearance and actions
		setTitle("Project 1");
		setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//Panel setup
		a = new Tutor();
		b = new Assessor();
		c = new Companion();
		u = new JPanel(new GridLayout(1,1));
		uL = new JLabel("Bryce Turner");
		uL.setVerticalAlignment(SwingConstants.TOP);
		uL.setHorizontalAlignment(SwingConstants.CENTER);
		u.add(uL);
		
		//Slider setup
		SliderListener sl = new SliderListener();
		slider = new JSlider(0,4,0);
		slider.setMajorTickSpacing(1);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.addChangeListener(sl);

		//Adding components to north panel
		north = new JPanel(new GridLayout(2,2));
		north.add(a);
		north.add(b);
		north.add(c);
		north.add(u);
		
		//Adding components to south panel
		south = new JPanel(new BorderLayout());
		south.add(slider, BorderLayout.CENTER);
		
		//Adding panels to frame and setting size
		add(north, BorderLayout.CENTER);
		add(south, BorderLayout.SOUTH);
		setSize(512,512);
		setVisible(true);
	}
	
	public static void main(String[] args) {	
		new Universe();
	}
	
	//Update method
	public void updatePanel(int s) {
		((Tutor) a).changeState(s);
		((Assessor) b).changeState(s);
		((Companion) c).changeState(s);
	}

	//Listener for the JSlider
	private class SliderListener implements ChangeListener {
		
		public void stateChanged(ChangeEvent event) {
			updatePanel(slider.getValue());
			slider.setMinimum(1);	//Removing initial state
			uL.setVisible(false);	//Hiding universe label
			
		}
	}
}
