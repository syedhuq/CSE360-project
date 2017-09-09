import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JEditorPane;
import javax.swing.JOptionPane;
import java.io.*;

public class Tutor extends JPanel {

    int state = 0;
    JLabel myName  = new JLabel("Nathan Nikan");
    JEditorPane HtmlPane= new JEditorPane();

    public Tutor() {
	// Initial state of displaying name.
	add(myName, HtmlPane);
    }

    public void changeState(int newState) {
	// Set the state to the new state and set the correct file
        state = newState;
	    if (state != 0)
	    {
		    
		File file1= new File("P" + state + ".html");

		try {
	        	HtmlPane.setPage(file1.toURI().toURL());
		}

		catch (IOException ex) {
	    	JOptionPane.showMessageDialog(null,"Could not setPage ", "TITLE", JOptionPane.WARNING_MESSAGE);
            	ex.printStackTrace();
		}
	    }
	remove(myName);
	add(HtmlPane);    
    }

} 
