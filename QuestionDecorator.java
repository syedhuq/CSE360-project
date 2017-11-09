/**
* A class that decorates the current question with a new question.
* Recitation Project 4
* Completion time: 1 hour
*
* @author Dalton Scott
* @version 1.0
*/

package edu.asu.CSE360._03._03;

import javax.swing.*;

public class QuestionDecorator {
	
	public void draw(Question q, JLabel label) {
		if (q.questionNumber == 1) {
			label.setText("Given an object representing a Student, which of these would NOT be a possible method one could call on that object? (2 attempts)");
		}
		else
		if (q.questionNumber == 2) {
			label.setText("An operation, or method, must be written with what characteristics? (2 attempts)");
		}
		else
		if (q.questionNumber == 3) {
			label.setText("When a class inherits from another class (other than an interface or abstract class), the inherited class is known as what? (2 attempts)");
		}
		else
		if (q.questionNumber == 4) {
			label.setText("Type the extension of the file types that go in a package (no capitals, no punctuation or spaces). (3 attempts)");
		}
	}
	
}
