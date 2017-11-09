/**
* A class that shows a question and can display different ways to answer it.
* Recitation Project 1
* Completion time: 1 hour
*
* @author Dalton Scott
* @version 1.0
*/



//package srcc; //package declaration, used only for Eclipse
package edu.asu.CSE360._03._03;

import javax.swing.*;
import java.awt.event.*;

public class Assessor extends JPanel implements ActionListener, ItemListener {
	//initialize state
	int state = 0;
	
	//instantiate all possible panel components
	JLabel nameLabel = new JLabel("Dalton Scott");
	
	JLabel questionLabel = new JLabel("Given an object representing a Student,\nwhich of these would NOT be a possible\nmethod in that class?");
	
	JLabel decoLabel = new JLabel("");
	
	String[] dropDownChoices = {"Teach", "Turn In Homework", "Sharpen Pencil", "Contact Professor"};
	JComboBox dropDownMenu = new JComboBox(dropDownChoices);
	
	JCheckBox checkBox1 = new JCheckBox("Return Type");
	JCheckBox checkBox2 = new JCheckBox("Visibility Modifier");
	JCheckBox checkBox3 = new JCheckBox("Memory Allocation");
	JButton button1 = new JButton("Inherited Class");
	JButton button2 = new JButton("Subclass");
	JButton button3 = new JButton("Parent Class");
	
	JTextField textField = new JTextField(16);
	
	ControlCenter cc = ControlCenter.ControlCenter();
	
	int correct = 0;
	int incorrect = 0;
	int net = 0;
	String aboutAnswer = "";
	String correctString = "You've entered the right answer!\n";
	String incorrectString = "You've entered the incorrect answer... try again!\n";
	String warningString1 = "WARNING: You have only ";
	String warningString2 = " more possible incorrect choices.";
	
	Boolean[] answered = {false, false, false, false};
	int[] attempts = {0, 0, 0, 0};
	
	Question question1 = new Question(1);
	Question question2 = new Question(2);
	Question question3 = new Question(3);
	Question question4 = new Question(4);
	
	QuestionDecorator deco = new QuestionDecorator();
	MessageDecorator mDeco = new MessageDecorator();
	public Assessor() {
		//JPanel constructor
		super();
		
		//set default states for components and add listeners
		dropDownMenu.setSelectedIndex(0);
		dropDownMenu.addActionListener(this);
		
		checkBox1.setSelected(false);
		checkBox1.addItemListener(this);
		checkBox2.setSelected(false);
		checkBox2.addItemListener(this);
		checkBox3.setSelected(false);
		checkBox3.addItemListener(this);
		
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		
		textField.addActionListener(this);
		
		//add name label by default
		add(nameLabel);
	}
	
	public void changeState(int changeTo) {
		//reset panel
		removeAll();
		
		//change state
		state = changeTo;
		
		//change question label to current question
		
		if (state == 1) {
			//add drop down menu
			add(questionLabel);
			add(dropDownMenu);
			deco.draw(question1, questionLabel);
			
			//questionLabel.setText("Given an object representing a Student, which of these would NOT be a possible method one could call on that object? (2 attempts)");
		}
		else
		if (state == 2) {
			deco.draw(question2, questionLabel);
			add(questionLabel);
			//questionLabel.setText("An operation, or method, must be written with what characteristics? (2 attempts)");
			//add all check boxes
			add(checkBox1);
			add(checkBox2);
			add(checkBox3);
		}
		else
		if (state == 3) {
			deco.draw(question3, questionLabel);
			add(questionLabel);
			//questionLabel.setText("When a class inherits from another class (other than an interface or abstract class), the inherited class is known as what? (2 attempts)");
			//add all buttons
			add(button1);
			add(button2);
			add(button3);
		}
		else
		if (state == 4) {
			deco.draw(question4, questionLabel);
			add(questionLabel);
			//questionLabel.setText("Type the extension of the file types that go in a package (no capitals, no punctuation or spaces). (3 attempts)");
			//add text field
			add(textField);
		}
		revalidate();
		repaint();
	}
	
	public void popUp(String message, String title) {
		//show dialog box with given message and title, as information message
		JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void actionPerformed(ActionEvent e) {
		//show a message that says "Hello World!" with title "Simple Output"
		aboutAnswer = "";
		if (answered[state-1] == false) {
			if (state == 1) {
				String choice = String.valueOf(dropDownMenu.getSelectedItem());
				if (choice.equals("Teach")) {
					correct++;
					cc.setCorrectAnswers(state, cc.getCorrectAnswers(state)+1);
					aboutAnswer = correctString;
					answered[state-1] = true;
					add(decoLabel);
					mDeco.draw(question1, decoLabel, true);
				}
				else {
					incorrect++;
					cc.setIncorrectAnswers(state, cc.getInorrectAnswers(state)+1);
					add(decoLabel);
					mDeco.draw(question1, decoLabel, false);
					aboutAnswer = incorrectString;
					attempts[state-1] += 1;
					if (attempts[state-1] >= 2) {
						answered[state-1] = true;
					}
				}
			}
			else
			if (state == 3) {
				if (e.getSource() == button3) {
					correct++;
					cc.setCorrectAnswers(state, cc.getCorrectAnswers(state)+1);
					add(decoLabel);
					mDeco.draw(question3, decoLabel, true);
					aboutAnswer = correctString;
					answered[state-1] = true;
				}
				else {
					incorrect++;
					cc.setIncorrectAnswers(state, cc.getInorrectAnswers(state)+1);
					add(decoLabel);
					mDeco.draw(question3, decoLabel, false);
					aboutAnswer = incorrectString;
					attempts[state-1] += 1;
					if (attempts[state-1] >= 2) {
						answered[state-1] = true;
					}
					
				}
			}
			else
			if (state == 4) {
				if (textField.getText().equals("java")) {
					correct++;
					cc.setCorrectAnswers(state, cc.getCorrectAnswers(state)+1);
					add(decoLabel);
					mDeco.draw(question4, decoLabel, true);
					aboutAnswer = correctString;
					answered[state-1] = true;
				}
				else {
					incorrect++;
					cc.setIncorrectAnswers(state, cc.getInorrectAnswers(state)+1);
					add(decoLabel);
					mDeco.draw(question4, decoLabel, true);
					aboutAnswer = incorrectString;
					attempts[state-1] += 1;
					if (attempts[state-1] >= 3) {
						answered[state-1] = true;
					}
				}
			}
			if (incorrect >= 6) {
				aboutAnswer += warningString1;
				aboutAnswer += Integer.toString(9-incorrect);
				aboutAnswer += warningString2;
				if (incorrect >= 9) {
					aboutAnswer += "\nYou have failed this quiz!";
				}
			}
			setNet();
			popUp(aboutAnswer, "About your answer...");
		}
	}
	
	public void itemStateChanged(ItemEvent i) {
		//show a message that says "Hello World!" with title "Simple Output"
		if (answered[1] == false) {
			if ((i.getSource() == checkBox1) || (i.getSource() == checkBox2)) {
				if (checkBox1.isSelected() == true) {
					if (checkBox2.isSelected() == true) {
						correct++;
						cc.setCorrectAnswers(state, cc.getCorrectAnswers(state)+1);
						add(decoLabel);
						mDeco.draw(question2, decoLabel, true);
						answered[1] = true;
						incorrect += attempts[1]/2;
						cc.setIncorrectAnswers(state, cc.getInorrectAnswers(state)+attempts[1]/2);
						aboutAnswer = correctString;
						setNet();
						popUp(aboutAnswer, "About your answer...");	
					}
				}
			}
			else 
			if (i.getSource() == checkBox3) {
				if (checkBox3.isSelected() == true) {
					checkBox3.setSelected(false);
					attempts[1] += 1;
					add(decoLabel);
					mDeco.draw(question2, decoLabel, false);
					if (attempts[1] >= 4) {
						answered[1] = true;
						incorrect += 2;
						cc.setIncorrectAnswers(state, cc.getInorrectAnswers(state)+2);
						
					}
					aboutAnswer = incorrectString;
					if (incorrect >= 6) {
						aboutAnswer += warningString1;
						aboutAnswer += Integer.toString(9-incorrect);
						aboutAnswer += warningString2;
						if (incorrect >= 9) {
							aboutAnswer += "\nYou have failed this quiz!";
						}
					}
					setNet();
					popUp(aboutAnswer, "About your answer...");
				}
			}
		}
	}
	
	protected void setNet() {
		net = correct - incorrect;
	}
	
	public int getNet() {
		return net;
	}
	
	public int getCorrect() {
		return correct;
	}
	
	public int getIncorrect() {
		return incorrect;
	}
}
