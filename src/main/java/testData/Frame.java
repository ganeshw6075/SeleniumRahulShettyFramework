package testData;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Frame {

	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.selenium.dev/selenium/docs/api/java/index.html?overview-summary.html");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//first frame
		driver.switchTo().frame("packageListFrame");
		driver.findElement(By.xpath("//a[text()='org.openqa.selenium.bidi.log'][1]")).click();
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
        
		
		driver.switchTo().frame("packageFrame");
		driver.findElement(By.xpath("//*[text()='JavascriptLogEntry']")).click();
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame("classFrame");
		driver.findElement(By.xpath("//*[text()='org.openqa.selenium.bidi.log.BaseLogEntry']")).click();
		Thread.sleep(5000);
		
	}
}
