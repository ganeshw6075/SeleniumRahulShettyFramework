package testData;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTable {

	public static void main(String[] args) { 
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.sportsadda.com/football/features/top-10-football-players-of-all-time");
					
		List<WebElement> elements = driver.findElements(By.xpath("//table//tbody//tr//td"));
					
					
					for(WebElement ele:elements)
					{
						System.out.print(ele.getText());
					}
					
					System.out.println();

	}

}
