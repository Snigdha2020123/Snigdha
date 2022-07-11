package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Signout {
   WebDriver driver;
	
	public Signout(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//button[@class='logout-btn']")
	private WebElement logout;
	
	public WebElement getLogout()
	{
		return logout;
	}
	
	@FindBy(xpath="//div[@class='login-container']//h2")
	private WebElement getuidtext;
	public WebElement getuidtext()
	{
		return getuidtext;
	}
}
