package pageLayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
   public WebDriver driver;
   
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id=\"userEmail\"]")
	private WebElement userName;

	@FindBy(xpath="//*[@id=\"userPassword\"]")
	private WebElement password;

	@FindBy(xpath="//*[@id=\"login\"]")
	private WebElement loginBtn;
	
	public void enterUsername(String un)
	{
		userName.sendKeys(un);
	}
	
	public void enterPassword(String pass)
	{
		password.sendKeys(pass);
	}
	
	public void clickOnLoginBtn()
	{
		loginBtn.click();
	}

}
