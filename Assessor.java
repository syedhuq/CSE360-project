//package srcc; //package declaration, used only for Eclipse

import javax.swing.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;

public class Assessor extends JPanel implements ActionListener, ItemListener {                //class is a child of JPanel, and uses ActionListener and ItemListener to handle actions on answer choices
	int state = 0;                                                                            //state of assessor panel
	
	JLabel nameLabel = new JLabel("Dalton Scott"); 											  //label with name of program writer
	
	JLabel questionLabel = new JLabel("Question 1");										  //label that displays question
	
	String[] dropDownChoices = {"Option 1", "Option 2", "Option 3"};						  //create an array with the choices for the drop down menu
	JComboBox dropDownMenu = new JComboBox(dropDownChoices); 								  //create a new drop down menu with the choices in the above array
	
	JCheckBox checkBox1 = new JCheckBox("Option 1"); 									      //create a new checkbox labelled Option 1
	JCheckBox checkBox2 = new JCheckBox("Option 2");  										  //create a new checkbox labelled Option 2
	JCheckBox checkBox3 = new JCheckBox("Option 3"); 										  //create a new checkbox labelled Option 3
	
	JButton button1 = new JButton("Option 1"); 												  //create a new button with "Option 1" inside it
	JButton button2 = new JButton("Option 2"); 												  //create a new button with "Option 2" inside it
	JButton button3 = new JButton("Option 3"); 												  //create a new button with "Option 3" inside it
	
	JTextField textField = new JTextField(16); 												  //create a new text field with 16 character spaces
	
	public Assessor() { 																	  //assessor panel constructor
		super(); 																			  //call JPanel constructor
		dropDownMenu.setSelectedIndex(0); 													  //set default selected answer to first one
		dropDownMenu.addActionListener(this); 												  //add action listener to pop up message when answer is selected
		
		checkBox1.setSelected(false); 														  //set check box to not be selected by default
		checkBox1.addItemListener(this);  													  //add item listener to pop up message when answer is selected
		checkBox2.setSelected(false); 											              //set check box to not be selected by default
		checkBox2.addItemListener(this); 													  //add item listener to pop up message when answer is selected
		checkBox3.setSelected(false); 											              //set check box to not be selected by default
		checkBox3.addItemListener(this); 													  //add item listener to pop up message when answer is selected
		
		button1.addActionListener(this); 													  //add action listener to pop up message when answer is selected
		button2.addActionListener(this); 													  //add action listener to pop up message when answer is selected
		button3.addActionListener(this); 													  //add action listener to pop up message when answer is selected
		
		textField.addActionListener(this); 												      //add action listener to pop up message when answer is entered into text box
		
		add(nameLabel); 																	  //add name to panel by default
	}
	
	public void changeState(int changeTo) { 												  //method to change the state of the panel (from Universe slider)
		removeAll(); 																		  //remove all elements from panel
		state = changeTo; 																	  //change state variable
		questionLabel.setText("Question " + Integer.toString(state));                         //set question label to show the correct question
		add(questionLabel); 																  //add question label back to panel
		if (state == 1) { 																	  //if we are in the drop down menu state
			add(dropDownMenu); 														          //add drop down menu to panel
		}
		else
		if (state == 2) { 																	  //if we are in the check box state
			add(checkBox1); 															      //add check box 1 to panel
			add(checkBox2); 																  //add check box 2 to panel
			add(checkBox3); 																  //add check box 3 to panel
		}
		else
		if (state == 3) { 																	  //if we are in the button state
			add(button1); 																      //add button 1 to panel
			add(button2); 																	  //add button 2 to panel
			add(button3); 																	  //add button 3 to panel
		}
		else
		if (state == 4) { 																	  //if we are in the text field state
			add(textField); 																  //add text field to panel
		}
	}
	
	public void popUp(String message, String title) { 										  //method to display a pop up message
		JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE); //display a pop up message with the given title and message as an information message
	}
	
	public void actionPerformed(ActionEvent e) { 											  //if action is performed (for button, text field, and drop down menu)
		popUp("Hello World!", "Simple Output"); 											  //show a message with message "Hello World!" and title "Simple Output"
	}
	
	public void itemStateChanged(ItemEvent i) { 											  //if state is changed (for check boxes)
		popUp("Hello World!", "Simple Output"); 											  //show a message with message "Hello World!" and title "Simple Output"
	}
}
