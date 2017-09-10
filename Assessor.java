/**
* A class that shows a question and can display different ways to answer it.
* Recitation Project 1
* Completion time: 1 hour
*
* @author Dalton Scott
* @version 1.0
*/



//package srcc; //package declaration, used only for Eclipse

import javax.swing.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;

public class Assessor extends JPanel implements ActionListener, ItemListener {
	int state = 0; //state of assessor panel
	
	JLabel nameLabel = new JLabel("Dalton Scott");
	
	JLabel questionLabel = new JLabel("Question 1");
	
	String[] dropDownChoices = {"Option 1", "Option 2", "Option 3"};
	JComboBox dropDownMenu = new JComboBox(dropDownChoices);
	
	JCheckBox checkBox1 = new JCheckBox("Option 1");
	JCheckBox checkBox2 = new JCheckBox("Option 2");
	JCheckBox checkBox3 = new JCheckBox("Option 3");
	
	JButton button1 = new JButton("Option 1");
	JButton button2 = new JButton("Option 2");
	JButton button3 = new JButton("Option 3");
	
	JTextField textField = new JTextField(16);
	
	public Assessor() {
		super();
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
		
		add(nameLabel);
	}
	
	public void changeState(int changeTo) {
		removeAll();
		state = changeTo;
		questionLabel.setText("Question " + Integer.toString(state));
		add(questionLabel);
		if (state == 1) {
			add(dropDownMenu);
		}
		else
		if (state == 2) {
			add(checkBox1);
			add(checkBox2);
			add(checkBox3);
		}
		else
		if (state == 3) {
			add(button1);
			add(button2);
			add(button3);
		}
		else
		if (state == 4) {
			add(textField);
		}
	}
	
	public void popUp(String message, String title) {
		JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void actionPerformed(ActionEvent e) {
		popUp("Hello World!", "Simple Output");
	}
	
	public void itemStateChanged(ItemEvent i) {
		popUp("Hello World!", "Simple Output");
	}
}
