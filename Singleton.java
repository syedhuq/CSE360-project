/**
* Singleton will keep a count of both the correct and incorrect answers while keeping track of the time spent on each question.
* Recitation Project 4
* Completion time: 2.5 hours
*
* @author Nathan Nikan
* @version 4.0
*/

import java.util.Observable;
class ControlCenter extends Observable{
	// static variable single_instance of type Singleton
	private static ControlCenter single_instance=null;
 
	public int[] correctAnswers = new int[4];
	public int[] incorrectAnswers = new int[4];
	public int[] timeSpent = new int[4];
	public int totalCorrect, totalIncorrect, totalNet;
	
 
	private ControlCenter() {
		for (int i = 0; i < 4; i++) {
			timeSpent[i] = 0;
		}
	}
 
	// static method to create instance of Singleton class
	public static ControlCenter ControlCenter() {
        	// To ensure only one instance is created
        	if (single_instance == null) {
			single_instance = new ControlCenter();
		}
        	return single_instance;
	}

	public int getCorrectAnswers (int lessonNumber) {
		return correctAnswers[lessonNumber-1];
	}

	public int getIncorrectAnswers (int lessonNumber) {
		return incorrectAnswers[lessonNumber-1];
	}

	public int getTimeSpent (int lessonNumber) {
		return timeSpent[lessonNumber-1];
	}
	
	public int getTotalCorrect() {
		return totalCorrect;
	}
	
	public int getTotalIncorrect() {
		return totalIncorrect;
	}

	public int getTotalNet() {
		return totalNet;
	}
	
	public void setCorrectAnswers (int lessonNumber, int seconds) {
		correctAnswers[lessonNumber-1] = seconds;
		notifyObservers();
	}

	public void setIncorrectAnswers (int lessonNumber, int seconds) {
		incorrectAnswers[lessonNumber-1] = seconds;
		notifyObservers();
	}

	public void setTimeSpent (int lessonNumber, int seconds) {
		timeSpent[lessonNumber-1] = seconds;
	}
	
	public void setTotalCorrect() {
		int sum = 0;
		for(int i : correctAnswers)
			sum += i;
		totalCorrect = sum;
	}
	
	public void setTotalIncorrect() {
		int sum = 0;
		for(int i : incorrectAnswers)
			sum += i;
		totalIncorrect = sum;
	}
	
	public void setTotalNet() {
		totalNet = totalCorrect - totalIncorrect;
	}
	public void update() {
		setTotalCorrect();
		setTotalIncorrect();
		setTotalNet();
		setChanged();
		notifyObservers();
	}

}


