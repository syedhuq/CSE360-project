package cse360_phase04_rec03_group03;
/**
* CompanionMessage is a base class for the Decorator pattern to display Companion messages.
* Recitation Project 4
* Completion time: 1 hour
*
* @author Syed Huq
* @version 1.0
*/

public class CompanionMessage {
	
	protected int net;
	
	public CompanionMessage() {
		net = 0;
	}
	public void setNet(int val) {
		net = val;
	}
}