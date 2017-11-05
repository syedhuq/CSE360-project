
class ControlCenter {
	// static variable single_instance of type Singleton
	private static ControlCenter single_instance=null;
 
	public int[] correctAnswers = new int[4];
	public int[] incorrectAnswers = new int[4];
	public int[] timeSpent = new int[4];

 
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

	public setCorrectAnswers (int lessonNumber, int seconds) {
		correctAnswers[lessonNumber] = seconds;
	}

	public setIncorrectAnswers (int lessonNumber, int seconds) {
		incorrectAnswers[lessonNumber] = seconds;
	}

	public setTimeSpent (int lessonNumber, int seconds) {
		timeSpent[lessonNumber] = seconds;
	}

}



