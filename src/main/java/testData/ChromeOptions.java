package testData;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeOptions {

	public static void main(String[] args) {


		org.openqa.selenium.chrome.ChromeOptions opt=new org.openqa.selenium.chrome.ChromeOptions();
     	opt.addArguments("start-maximized");
		opt.addArguments("disable-notifications");
//		opt.addArguments("incognito");
		//opt.addArguments("--headless");
		
//		List<String> al=new ArrayList<>();
//		al.add("disable-notifications");
//		al.add("incognito");
//		al.add("start-maximized");
		
		WebDriver driver=new ChromeDriver(opt);
		driver.get("https://www.ajio.com/");
		

	}

}
