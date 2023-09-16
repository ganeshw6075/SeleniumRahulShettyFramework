package testData;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutoIt {

	public static void main(String[] args) throws Exception {

    WebDriver driver=new ChromeDriver();
    driver.get("https://www.ilovepdf.com/pdf_to_jpg");
    driver.manage().window().maximize();
    driver.manage().deleteAllCookies();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    
    driver.findElement(By.xpath("//a[@id='pickfiles']")).click();
    Runtime.getRuntime().exec("C:\\Users\\Dell\\Desktop\\notepad\\Auto.exe");
    
    driver.findElement(By.xpath("//*[@id='processTask']")).click();
    
    WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(90));
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
    

	}

}
