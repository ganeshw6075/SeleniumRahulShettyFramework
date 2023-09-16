package testData;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.reporters.jq.Main;

public class Data {

	@Test(dataProvider="getData")
	public void dataproider(String username, String password,String id) throws InterruptedException
	{
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.saucedemo.com/v1/index.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(username);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@id='login-button']")).click();
		SoftAssert sf=new SoftAssert();
		System.out.println(id);
		sf.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/v1/inventory.html");
		driver.close();
		sf.assertAll();
	}

	@DataProvider
	public String[][] getData() throws Exception {
		FileInputStream fis=new FileInputStream("D:\\selenium driver and selenium\\Excel dataprovider\\SwagLabLogin.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheetAt(0);
		int row=sheet.getLastRowNum();
		int rowphy=sheet.getPhysicalNumberOfRows();
		int cell=sheet.getRow(0).getLastCellNum();
		System.out.println(cell);
		System.out.println("------------------------------------------------");
		System.out.println(row);
		System.out.println("------------------------------------------------");
        System.out.println(rowphy);
        String data[][]=new String [rowphy][cell];
        for(int i=0;i<rowphy;i++)
        {
        	for(int j=0;j<cell;j++)
        	{   DataFormatter df=new DataFormatter();
        	    
        	data[i][j]=df.formatCellValue(sheet.getRow(i).getCell(j));
        		
        	}
        }
        return data;
	}
}
 