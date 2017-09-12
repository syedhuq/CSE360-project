/**
* Tutor will display one of the html files based on slider position.
* Recitation Project 1
* Completion time: 1 hour
*
* @author Nathan Nikan
* @version 1.0
*/

package edu.asu.CSE360._03._03;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JEditorPane;
import java.io.*;

public class Tutor extends JPanel {

    int state = 0;
    JLabel myName  = new JLabel("Nathan Nikan");
    JEditorPane HtmlPane= new JEditorPane();
    File file1;
    String filename;

    public Tutor() {
	// Initial state of displaying name.
	add(myName, HtmlPane);
    }

    public void changeState(int newState) {
	// Set the state to the new state and set the correct file
        state = newState;
    	remove(myName);
	    if (state != 0)
	    {
		    
	    	//File file1= new File("/resources/P" + state + ".html");
	    	filename = "resources/P" + state + ".html";
	    	file1 = new File(filename);

		try {
	        	HtmlPane.setPage(file1.toURI().toURL());
		}

		catch(IOException ex) {
			System.err.println("Either the html file for this slider state is named incorrectly or it isn't located in the right folder.");
			ex.printStackTrace();
		}
	    }
	add(HtmlPane);    
    }

} 
