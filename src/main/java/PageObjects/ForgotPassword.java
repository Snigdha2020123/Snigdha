package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPassword 
{
	WebDriver driver;
	
	public ForgotPassword(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//a[@href='#'])[3]")
	private WebElement forgotpass;
	
	public WebElement getForgotpass()
	{
		return forgotpass;
	}
	
	@FindBy(xpath="//input[@placeholder='Name']")
	private WebElement name;
	
	public WebElement getnameField()
	{
		return name;
	}
	
	@FindBy(xpath="//input[@placeholder='Email']")
	private WebElement email;
	
	public WebElement getemail()
	{
		return email;
	}
	
	@FindBy(xpath="//input[@placeholder='Phone Number']")
	private WebElement phone;
	
	public WebElement getphone()
	{
		return phone;
	}
	
	@FindBy(xpath="//button[@class='go-to-login-btn']")
	private WebElement backlogin;
	
	public WebElement getbacklogin()
	{
		return backlogin;
	}
}
