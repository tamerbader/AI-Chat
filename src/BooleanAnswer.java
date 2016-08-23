
public class BooleanAnswer {
	public String question;
	public String questionType;
	public String answerType;
	public String subject;
	
	public BooleanAnswer(String prompt, String promptType, String answerType, String promptSubject) {
		question = new String(prompt);
		questionType = new String(promptType);
		answerType = new String(answerType);
		subject = new String(promptSubject);
	}
	public void getAnswer() {
		if (this.subject.equals("yourself")) {
			this.getPersonalResponse();
		} else if (this.subject.equals("computer")) {
			System.out.println("im here");
			this.getComputerResponse();
		}
	}
	public String getPersonalResponse () {
		String mainLine = "";
		int positionOfI = this.question.indexOf(" i");
		for (int i = positionOfI + 3; i < this.question.length(); i ++) {
			mainLine += this.question.charAt(i);
		}
		if (this.questionType.equals("will")) {
			System.out.println("No, you will not " + mainLine);

		} else if (this.questionType.equals("am")) {
		System.out.println("No, you are not " + mainLine);
		}
		return "true";
	}
	public String getComputerResponse () {
		String mainLine = "";
		int positionOfI = this.question.indexOf(" you");
		for (int i = positionOfI + 3; i < this.question.length(); i ++) {
			mainLine += this.question.charAt(i);
		}
		if (this.questionType.equals("will")) {
			System.out.println("No, i will not " + mainLine);
		} else if (this.questionType.equals("are")) {
		System.out.println("No, i am not " + mainLine);
		}
		return "no";
	}

}
