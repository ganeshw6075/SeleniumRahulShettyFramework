package testLayer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageLayer.LoginPage;
import testBase.TestBase;

public class LoginTest extends TestBase {

	
	@Test(dataProvider="getData")
	public void verifyLogin(String userName,String password) throws InterruptedException
	{
		LoginPage l=new LoginPage(driver);
		l.enterUsername(userName);
		l.enterPassword(password);
		l.clickOnLoginBtn();
		Assert.assertEquals(driver.findElement(By.xpath("//ul/li[5]/button")).isDisplayed(), true);
		Thread.sleep(5000);
	}
	
	@DataProvider
	public String[][] getData() throws Exception {
		File file=new File("D:\\String\\RevisionMaven\\src\\main\\java\\testData\\UserData.xlsx");
		
		FileInputStream fin=new FileInputStream(file);
		
		XSSFWorkbook wb=new XSSFWorkbook(fin);
		
		XSSFSheet sheet=wb.getSheet("Sheet1");
		
		int rowNum=sheet.getPhysicalNumberOfRows();
		System.out.println(rowNum);
		int cellNum=sheet.getRow(0).getLastCellNum();
		System.out.println(cellNum);
		String[][] data=new String[rowNum-1][cellNum];
		
		for(int i=0;i<rowNum-1;i++)
		{
			for(int j=0;j<cellNum;j++)
			{
				DataFormatter df=new DataFormatter();
				data[i][j]=df.formatCellValue(sheet.getRow(i+1).getCell(j));
			}
		}
		wb.close();
		fin.close();
		
		return data;
	}
}
