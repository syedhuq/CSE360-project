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
		return correctAnswers[lessonNumber];
	}

	public int getInorrectAnswers (int lessonNumber) {
		return incorrectAnswers[lessonNumber];
	}

	public int getTimeSpent (int lessonNumber) {
		return timeSpent[lessonNumber];
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
		correctAnswers[lessonNumber] = seconds;
	}

	public void setIncorrectAnswers (int lessonNumber, int seconds) {
		incorrectAnswers[lessonNumber] = seconds;
	}

	public void setTimeSpent (int lessonNumber, int seconds) {
		timeSpent[lessonNumber] = seconds;
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

}


