import java.util.Scanner;

public class AskingTheQuestion {
	 	public static int asked = 0;
	 	public static String prompt;
	 	public static String[] questionTypes = {"who", "what", "when", "where", "why", "how", "is", "are", "will", "am"};
	 	public static String promptType;
	 	public static String promptAnswerType;
	 	public static String subject;
	
	  	public static void main(String[] args) {
	 		Scanner scan = new Scanner(System.in);
	 		greetUser();
			if (asked != 1) {
	 		System.out.println("Hello " + User.getFirstName() +", \nGo ahead and ask me anything!");
	 		} else {
	 			System.out.println("Can i help you with anything else?");
	 		}
	 		prompt = scan.nextLine();
	 		promptType = getQuestionType(prompt);
	 		promptAnswerType = getResponseType(promptType);
	 	//	System.out.println("You asked a " + promptType + " question so i will respond with a " + promptAnswerType);
	 		 subject = getSubject(prompt);
	 		if (promptAnswerType.equals("boolean")) {
	 			BooleanAnswer myAnswer = new BooleanAnswer(prompt, promptType, promptAnswerType, subject);
	 		myAnswer.getPersonalResponse();
	 		} else if (promptAnswerType.equals("object/")) {
	 			//System.out.println("Hey i'm here");
	 			WhatAnswer myAnswer = new WhatAnswer(prompt, promptType, promptAnswerType, subject);
	 			myAnswer.getAnswer();
	 		}
	 		//main(null);
	  		
	 
	 	}
	 	
	 	public static void greetUser() {
	 		Scanner scan = new Scanner(System.in);
	 		if (User.getFirstName() == null) {
	 			System.out.println("Hi, may i have your first name?");
	 			String name = scan.nextLine();
	 			User.setFirstName(name);
	 	}
	 		if (User.getLastName() == null) {
	 				System.out.println("Great now may I have your last name?");
	 				String lastName = scan.nextLine();
	 				User.setLastName(lastName);
	 			}
	 		
	 	}
	 	
	 	public static String getQuestionType(String prompt) {
		int firstWordIndex = prompt.indexOf(" ");		
	 		String firstWord = "";
	 		String returnAnswer = "Could not recognize question";
	 		for (int i = 0; i < firstWordIndex; i++) {
	 			firstWord += prompt.charAt(i);
	 		}
	 		firstWord = firstWord.toLowerCase();
	 		for (int i = 0; i < questionTypes.length; i++) {
	 			if (firstWord.equals(questionTypes[i])) {
	 				returnAnswer =  questionTypes[i];
	 			}
	 		}
	 		return returnAnswer;	
	 	}
	 	
	 	public static String getResponseType(String promptType) {
	 		String answer = "";
	 		if (promptType.equals("is") || promptType.equals("are") || promptType.equals("will") || promptType.equals("am")) {
	 			answer = "boolean";
	 		} else if (promptType.equals("who")) {
	 			answer = "person";
	 		} else if (promptType.equals("what")) {
	 			answer = "object/";
	 		} else if (promptType.equals("when")) {
	 			answer = "date";
	 		} else if (promptType.equals("where")) {
	 			answer = "place";
	 		} else if (promptType.equals("why")) {
	 			answer = "explanation";
	 		} else if (promptType.equals("how")) {
	 			answer = "explanation/numerical";
	 		}
	 		return answer;
	 	}
		
	 	public static String getSubject(String prompt) {
	 		prompt = prompt.toLowerCase();
	 		String answer = "";
	 		if (prompt.indexOf("am") != -1 || prompt.indexOf(" i") != -1 && prompt.indexOf(" i" ) > prompt.length() - 2 || prompt.indexOf(" i ") != -1 || prompt.indexOf(" my ") != -1) {
	 			answer = "yourself";
	 			//System.out.println("you are asking a question about yourself");
	 		}else if (prompt.indexOf(" you ") != -1 || prompt.indexOf(" you") != -1) {
	 			answer = "computer";
	 			//System.out.println("You are asking a question about the computer. You should really get a life!");
	 		} else {
	 			answer = "object";
	 			//System.out.println("you are asking a question about someone/something else");
	 		}
	 		return answer;
	  	}
	  
	  }

