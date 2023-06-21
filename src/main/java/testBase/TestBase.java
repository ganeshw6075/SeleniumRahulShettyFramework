package testBase;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {
public static WebDriver driver;
	@BeforeMethod
	public void start()
	{   
		String br="chrome";
		if(br.equalsIgnoreCase("CHROME")) {
		  driver=new ChromeDriver();
		}
		else if(br.equalsIgnoreCase("FIREFOX"))
		{
			driver=new FirefoxDriver();
		}
		else if(br.equalsIgnoreCase("EDGE"))
		{
			driver=new EdgeDriver();
		}
		else
		{
			System.out.println("please enter valid browser");
		}
		
		driver.get("https://www.rahulshettyacademy.com/client/");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
