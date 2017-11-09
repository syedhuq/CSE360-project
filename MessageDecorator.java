/**
* A class that shows a question and can display different ways to answer it.
* Recitation Project 1
* Completion time: 1 hour
*
* @author Dalton Scott
* @version 1.0
*/

package edu.asu.CSE360._03._03;

import javax.swing.JLabel;

public class MessageDecorator {
	public void draw(Question q, JLabel label, boolean correct) {
		if (q.questionNumber == 1) {
			if (correct == true) {
				label.setText("Correct!");
		
			}
			else {
				label.setText("Incorrect... remember, this has to be an action the student would do.");
			}
		}
		else
		if (q.questionNumber == 2) {
			if (correct == true) {
				label.setText("Correct!");
		
			}
			else {
				label.setText("Incorrect... think about what you would write when declaring the object.");
			}
		}
		else
		if (q.questionNumber == 3) {
			if (correct == true) {
				label.setText("Correct!");
		
			}
			else {
				label.setText("Incorrect... what would a class ABOVE another class be called?");
			}
		}
		else
		if (q.questionNumber == 4) {
			if (correct == true) {
				label.setText("Correct!");
		
			}
			else {
				label.setText("Incorrect... what is the main file extension used for Java?");
			}
		}
	}
}
