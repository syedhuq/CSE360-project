package cse360_phase04_rec03_group03;
/**
* Companion displays one of four animated facial expressions and messages depending on the user's current question score.
* Recitation Project 4
* Completion time: 2 hours
*
* @author Syed Huq
* @version 4.0
*/



import javax.swing.*;
import java.awt.event.*;
import java.util.Observer;
import java.util.Observable;
public class Companion extends JPanel implements Observer
{
	// Declarations
	JLabel label, name, label2, labelMessage;
	ImageIcon icon1, icon2, icon3, icon4;
	ControlCenter cc;
	CompanionMessage cMessage;
	CompanionMessageDecorator cMessageDeco;
	int delay, i, j;
	boolean initial = true;
	ActionListener animate;
	
	// Constructor
	public Companion()
	{
		//QuestionObserver answers = new QuestionObserver(subj);
		// my name to be displayed on initial state
		name = new JLabel("Syed Huq");
		add(name);
		cc = ControlCenter.ControlCenter();
		cc.addObserver(this);
		cMessage = new CompanionMessage();
		cMessageDeco = new CompanionMessageDecorator();
		
		// label will be used to display the image and text
		label = new JLabel();
		label2 = new JLabel();
		labelMessage = new JLabel();
		add(label);
		add(labelMessage);

		// creating icons for each image, retrieving from path
		icon1 = new ImageIcon("src/main/resources/happy.png");
		icon2 = new ImageIcon("src/main/resources/thinking.png");
		icon3 = new ImageIcon("src/main/resources/worried.png");
		icon4 = new ImageIcon("src/main/resources/sorry.png");
		
		// initializing our array of icons for animation
		final ImageIcon[][] icons = new ImageIcon[4][4];
		for(int i = 0; i < 4; i++)
		{
			switch(i)
			{
			case 0: // happy
				for(int j = 0; j < 4; j++)
				{
					icons[i][j] = new ImageIcon("src/main/resources/happy" + j + ".png");
				}//end of happy for loop
				break;
			case 1: // thinking
				for(int j = 0; j < 4; j++)
				{
					icons[i][j] = new ImageIcon("src/main/resources/thinking" + j + ".png");
				}
				break;
			case 2: // worried
				for(int j = 0; j < 4; j++)
				{
					icons[i][j] = new ImageIcon("src/main/resources/worried" + j + ".png");
				}
				break;
			case 3: // sorry
				for(int j = 0; j < 4; j++)
				{
					icons[i][j] = new ImageIcon("src/main/resources/sorry" + j + ".png");
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
		    		if(test.toString().equals("src/main/resources/happy.png"))
		    		{
		    			i = 0;
		    		}
		    		else if(test.toString().equals("src/main/resources/thinking.png"))
		    		{
		    			i = 1; 
		    		}
		    		else if(test.toString().equals("src/main/resources/worried.png"))
		    		{
		    			i = 2;
		    		}
		    		else if(test.toString().equals("src/main/resources/sorry.png"))
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
		remove(name); // get rid of name after initial state is done
		if(initial)
		{
			label2.setIcon(icon2);
			initial = false;
		}
	}// end of changeState()
	
	// method that is called whenever the score is changed
	public void update(Observable o, Object arg)
	{
		int net = cc.getTotalNet(); // get user's total net score for our calculations
		// then set the face appropriately
		if(net > 0) {
			label2.setIcon(icon1); // happy if score > 0
		}
		else if(net == 0) {
			label2.setIcon(icon2); // thinking if score = 0
		}
		else if(net == -1) {
			label2.setIcon(icon3); // worried if score = -1
		}
		else {
			label2.setIcon(icon4); // sad if score < -1
		}
		// then our decorator stuff for the companion message
		cMessage.setNet(net);
		cMessageDeco.draw(cMessage, label);
	}
}