import java.io.IOException;
import java.util.Calendar;
import java.util.Scanner;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
public class WhatAnswer {
	public String question;
	public String questionType;
	public String answerType;
	public String subject;
	public String[] args = {"asked"};
	public String[] weatherKeywords = {"weather", "temperature", "raining"};
	public int day;
	public int weekDay;
	
	public WhatAnswer(String prompt, String promptType, String answerType, String promptSubject) {
		question = new String(prompt).toLowerCase();
		questionType = new String(promptType);
		answerType = new String(answerType);
		subject = new String(promptSubject);
	}
	
	public void getAnswer() {
		//System.out.println("We also in here");
		if (this.subject.equals("computer")) {
		//	System.out.println("im here");
			//this.getComputerResponse();
		} else {
			getPersonalResponse();
		}
	}
	
	public void getPersonalResponse () {
		//System.out.println("we in here");
		if (question.contains("weather") || question.contains("temperature")) {
			getWeatherAnswer();
		}
		
	}
	
	public void getWeatherAnswer() {
		if(User.getZipcode() == 0) {
			System.out.println("Im sorry, Could you please give me your zipcode?");
			Scanner scan = new Scanner(System.in);
			User.setZipcode(scan.nextInt()); 
		}
		Calendar calendar = Calendar.getInstance();
		int day = calendar.get(Calendar.DAY_OF_WEEK); 
		if (question.contains("today")) {
			this.day = 0;
			this.weekDay = -1;
		} else if (question.contains("tomorrow")) {
			this.day = 1;
			this.weekDay = 1;
		} else if (question.contains("monday")) {
			this.weekDay = 0;
			int counter = 0;
			for (int i = day; i <= 10; i ++ ) {
				if(i == Calendar.MONDAY) {
					break;
				}
				if (i == 9) {
					i = 1;
					continue;
				}
				counter++;
				if (counter > 6) {
					counter = 100;
					break;
					
				}
			}
			if (counter != 100) {
				this.day = counter;
				System.out.println(this.day);
			}
		} else if (question.contains("tuesday")) {
			this.weekDay = 2;
			int counter = 0;
			for (int i = day; i <= 10; i ++ ) {
				if(i == Calendar.TUESDAY) {
					break;
				}
				if (i == 9) {
					i = 1;
					continue;
				}
				counter++;
				if (counter > 6) {
					counter = 100;
					break;
					
				}
			}
			if (counter != 100) {
				this.day = counter;
				System.out.println(this.day);
			}
		} else if (question.contains("wednesday")) {
			this.weekDay = 3;
			int counter = 0;
			for (int i = day; i <= 10; i ++ ) {
				if(i == Calendar.WEDNESDAY) {
					break;
				}
				if (i == 9) {
					i = 1;
					continue;
				}
				counter++;
				if (counter > 6) {
					counter = 100;
					break;
					
				}
			}
			if (counter != 100) {
				this.day = counter;
				System.out.println(this.day);
			}
		} else if (question.contains("thursday")) {
			this.weekDay = 4;
			int counter = 0;
			for (int i = day; i <= 10; i ++ ) {
				if(i == Calendar.THURSDAY) {
					break;
				}
				if (i ==9) {
					i = 1;
					continue;
				}
				counter++;
				if (counter > 6) {
					counter = 100;
					break;
					
				}
			}
			if (counter != 100) {
				this.day = counter;
				System.out.println(this.day);
			}
		} else if (question.contains("friday")) {
			this.weekDay = 5;
			int counter = 0;
			for (int i = day; i <= 10; i ++ ) {
				if(i == Calendar.FRIDAY) {
					break;
				}
				if (i == 9) {
					i = 1;
					continue;
				}
				counter++;
				if (counter > 6) {
					counter = 100;
					break;
					
				}
			}
			if (counter != 100) {
				this.day = counter;
				System.out.println(this.day);
			}
		} else if (question.contains("saturday")) {
			this.weekDay = 6;
			int counter = 0;
			for (int i = day; i <= 10; i ++ ) {
				if(i == Calendar.SATURDAY) {
					break;
				}
				if (i == 9) {
					i = 1;
					continue;
				}
				counter++;
				if (counter > 6) {
					counter = 100;
					break;
					
				}
			}
			if (counter != 100) {
				this.day = counter;
				System.out.println(this.day);
			}
		} else if (question.contains("sunday")) {
			this.weekDay = 7;
			int counter = 0;
			for (int i = day; i <= 10; i ++ ) {
				if(i == Calendar.SUNDAY) {
					break;
				}
				if (i == 9) {
					i = 1;
					continue;
				}
				counter++;
				if (counter > 6) {
					counter = 100;
					break;
					
				}
			}
			if (counter != 100) {
				this.day = counter;
				System.out.println(this.day);
			}
		}else {
			day = 0;
		}
		WeatherRequest currentWeather = new WeatherRequest(User.getZipcode(), "hey", this.day, this.weekDay);
		currentWeather.getWeather();
		
		
	}
}
