/**
* Menu will be visible at the bottom of the GUI and allows users to request hints, 
* request answers, request answer explanation, and or hide the companion
* Completion time: 4 hours
*
* @author Bryce Turner
* @version 1.0
*/


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Menu extends JPanel {
	JButton menu = new JButton("Menu");
	JButton hint = new JButton("Request Hint");
	JButton correct = new JButton("Request Answer");
	JButton explain = new JButton("Request Explanation");
	JButton hide = new JButton("Hide Companion");
	JPanel options = new JPanel(new GridLayout(4,1));
	ButtonListener bl = new ButtonListener();
	int SliderValue;
	boolean hidec = true;

	
	public Menu() {
		options.add(hint);
		options.add(correct);
		options.add(explain);
		options.add(hide);
		options.setVisible(false);
		menu.addActionListener(bl);
		hint.addActionListener(bl);
		correct.addActionListener(bl);
		explain.addActionListener(bl);
		hide.addActionListener(bl);
	
		this.setLayout(new BorderLayout());
		this.add(menu, BorderLayout.NORTH);
		this.add(options, BorderLayout.SOUTH);
		
	}
	
	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource().equals(menu))
				if (options.isVisible()) 
					options.setVisible(false);
				else
					options.setVisible(true);
			else if (e.getSource().equals(hint))
				if (SliderValue == 1)
					popUp("Think about what actions a student would typically perform", "Hint for Question 1");
				else if (SliderValue == 2)
					popUp("Methods are always written with a visibility modifier, such as: \n"
							+ "public, private, or protected. Now think about the format of all methods. \nFor instance:\n\npublic static void main() {\n\n"
							+ "What is 'void' in this case?", "Hint for Question 2");
				else if (SliderValue == 3)
					popUp("Here is your hint", "Hint for Question 3");
				else
					popUp("Think about the extension to all class files when creating a program.\n"
							+ "If C programming files end with .c, then what will Java files end with?\n\n"
							+ "REMEMBER DO NOT USE PUNCTUATION IN YOUR ANSWER", "Hint for Question 4");
			else if (e.getSource().equals(correct))
				if (SliderValue == 1)
					popUp("The correct answer is 'Teach'", "Answer for Question 1");
				else if (SliderValue == 2)
					popUp("The correct answers are 'Return Type' and 'Visibility Modifier'", "Answer for Question 2");
				else if (SliderValue == 3)
					popUp("The correct answer is 'Parent Class'", "Answer for Question 3");
				else
					popUp("The correct answer is 'java'", "Answer for Question 4");
			else if (e.getSource().equals(explain))
				if (SliderValue == 1)
					popUp("The correct answer is 'Teach', because a student can complete all\nother options:"
							+ " Sharpen Pencil, Turn in Homework, and Contact Professor", "Answer explanation for Question 1");
				else if (SliderValue == 2)
					popUp("The correct answers are 'Return Type' and 'Visibility Modifier', because\n"
							+ "you do not assign memory allocation for methods, memory allocation is for objects.", "Answer explanation for Question 2");
				else if (SliderValue == 3)
					popUp("The correct answer is 'Parent Class'", "Answer explanation for Question 3");
				else
					popUp("The correct answer is 'java', because the language we are writing in is Java.\n"
							+ "We are creating the source files, which is then compiled by the Java compiler\n"
							+ "and creates '.class' files for all of our separate classes.", "Answer explanation for Question 4");
			else
				if (hidec == true) {
					popUp("The Companion will be hidden for future questions", "");
					hidec = false;
					hide.setText("Show Companion");
				}
				else {
					popUp("The Companion will be visible for future questions", "");
					hidec = true;
					hide.setText("Hide Companion");
				}
		}
	}
	
	public void popUp(String message, String title) {
		//show dialog box with given message and title, as information message
		JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
	}
}
