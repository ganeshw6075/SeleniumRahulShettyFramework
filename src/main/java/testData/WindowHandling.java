package testData;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandling {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.facebook.com/r.php");
		
		String Parent=driver.getWindowHandle();
		
		System.out.println(Parent);
		
		driver.findElement(By.xpath("//*[text()='Privacy Policy']")).click();
		
		driver.switchTo().window(Parent); 

		driver.findElement(By.xpath("//*[text()='Cookies Policy']")).click();
		
	    driver.switchTo().window(Parent);
		
		driver.findElement(By.xpath("//*[text()='Terms']")).click();
		
		Set<String> AllWindow = driver.getWindowHandles();
		
		for(String window:AllWindow)
		{   
			driver.switchTo().window(window);
			String title=driver.getTitle();
			System.out.println(title);
			
			if(title.equals("Facebook"))
			{
			   boolean text = driver.findElement(By.xpath("//*[@id='email']")).isEnabled();
			   System.out.println(text);
				break;
			}
		}
		
		driver.switchTo().window(Parent);
					

	}

}
