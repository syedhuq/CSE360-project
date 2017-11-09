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