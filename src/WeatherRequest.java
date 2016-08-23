import java.io.IOException;
import java.util.Scanner;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
public class WeatherRequest {
	public int zipcode;
	public String specific;
	public static String baseUrl = "http://www.worldweatheronline.com/v2/weather.aspx?q=";
	public int dayNumber;
	public int weekDay;
	
	public WeatherRequest(int zip, String spec, int dayNum, int wkDay) {
		this.zipcode = User.getZipcode();
		this.specific = spec;
		this.dayNumber = dayNum;
		this.weekDay = wkDay;
	}
	
	public void getWeather() {
		Document doc = new Document("My File");
		if (this.dayNumber == 0) {
			String url = baseUrl + User.getZipcode();
			try {
				doc = Jsoup.connect(url).get();
			} catch (IOException e) {
				System.out.println("Invalid URL");
				e.printStackTrace();
			}
			
			Elements todayCard = doc.getElementsByClass("temperature");
			String preFormattedTemp = todayCard.text();
			String temp = "";
			int spacePosition = preFormattedTemp.indexOf(" ");
			for (int i = 0; i < spacePosition; i++) {
				temp += preFormattedTemp.charAt(i);
			}
			int celciusTemp = Integer.parseInt(temp);
			double decimalTempF = (1.8*celciusTemp) + 32;
			int finalTemp = (int)decimalTempF;
			String daySky = doc.getElementsByClass("media-heading").text();
			String finalDaySky = "";
			int spacePositions = daySky.indexOf(" ");
			for (int i = 0; i < spacePositions; i++) {
				finalDaySky += daySky.charAt(i);
			}
			System.out.println("It is currently " + finalDaySky + " with a temperature of " + finalTemp + "°F");
		
		} else {
		String url = baseUrl + User.getZipcode() + "&day=" + this.dayNumber;
		try {
			doc = Jsoup.connect(url).get();
		} catch (IOException e) {
			System.out.println("Invalid URL");
			e.printStackTrace();
		} 
		Elements todayCard = doc.getElementsByClass("temperature");
		String preFormattedTemp = todayCard.text();
		//System.out.println("Generated weather is " + preFormattedTemp);
		
		int maxTempPosition = preFormattedTemp.indexOf("Max: ");
		String finalMaxTempS = "";
		for (int i = maxTempPosition+5; i < maxTempPosition + 7; i++) {
			finalMaxTempS+=preFormattedTemp.charAt(i);
		}
		int celciusMaxTemp = Integer.parseInt(finalMaxTempS);
		double decimalTempF = (1.8*celciusMaxTemp) + 32;
		int finalMaxTemp = (int)decimalTempF;
		
		int minTempPosition = preFormattedTemp.indexOf("Min: ");
		String finalMinTempS = "";
		for (int i = minTempPosition+5; i < minTempPosition + 7; i++) {
			finalMinTempS+=preFormattedTemp.charAt(i);
		}
		int celciusMinTemp = Integer.parseInt(finalMinTempS);
		double decimalTempFM = (1.8*celciusMinTemp) + 32;
		int finalMinTemp = (int)decimalTempFM;
		
		String daySky = doc.getElementsByClass("media-heading").text();
		String finalDaySky = "";
		int spacePositions = daySky.indexOf(" ");
		for (int i = 0; i < spacePositions; i++) {
			finalDaySky += daySky.charAt(i);
		}
		String day = "";
		if (this.weekDay == 1) {
			day = "Tomorrow";
		} else if (this.weekDay == 0){
			day = "Monday";
		} else if (this.weekDay == 2) {
			day = "Tuesday";
		} else if (this.weekDay == 3) {
			day = "Wednesday";
		} else if (this.weekDay == 4) {
			day  = "Thursday";
		} else if (this.weekDay == 5) {
			day = "Friday";
		} else if (this.weekDay == 6) {
			day = "Saturday";
		} else if (this.weekDay == 7) {
			day = "Sunday";
		}
		System.out.println(day + " will be " + finalDaySky+ " and have a high of " + finalMaxTemp + "°F and a low of " + finalMinTemp+ "°F");
		}
		
	}
	
	
	
	
	
	

}

