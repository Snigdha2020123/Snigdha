package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Sigin2 

{
	WebDriver driver;
	
	public Sigin2(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//input[@id='inputUsername']")
	private WebElement uid;
	
	public WebElement getuid()
	{
		return uid;
	}
	
	@FindBy(xpath="//input[@name='inputPassword']")
	private WebElement password;
	
	public WebElement getpass()
	{
		return password;
	}
	
	@FindBy(xpath="//input[@id='chkboxTwo']")
	private WebElement checkbox;
	
	public WebElement getcheckboxclick()
	{
		return checkbox;
	}
	
	@FindBy(xpath="//button[@class='submit signInBtn']")
	private WebElement sigin;
	
	public ForgotPassword getsigining()
	{
		 sigin.click();
		 ForgotPassword objForgotPassword=new ForgotPassword(driver);
		 return objForgotPassword;
	}
	
	
}
