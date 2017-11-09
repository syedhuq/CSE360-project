package cse360_phase04_rec03_group03;
/**
* CompanionMessageDecorator implements the Decorator pattern to display Companion messages.
* Recitation Project 4
* Completion time: 1 hour
*
* @author Syed Huq
* @version 1.0
*/

import javax.swing.JLabel;

public class CompanionMessageDecorator {
	
	public void draw(CompanionMessage cm, JLabel label) {
		if(cm.net > 0) {
			label.setText("Doing great so far!");
		}
		else if(cm.net == 0) {
			label.setText("Let's see what you got!");
		}
		else if(cm.net == -1) {
			label.setText("Ouch, keep trying!");
		}
		else {
			label.setText("Maybe try again later?");
		}
	}
	
}