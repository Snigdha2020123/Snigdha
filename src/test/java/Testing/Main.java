package Testing;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.Sigin;
import PageObjects.Signout;
import Resources.DriverInitialization;

public class Main extends DriverInitialization {

	public WebDriver driver;
	public static Logger log=LogManager.getLogger(Main.class.getName());
	@Test
	public void tsetingmethod()
	{
		log.info("SANU TESTING METHOD");
		
	}
//	@Test
//	public void errormethod()
//	{
//		Assert.assertTrue(false);
//	}


	@BeforeTest
	public void beforetest() throws IOException
	{
		driver=callwebdriver();
		driver.get(prop.getProperty("url"));
	}
	@Test(dataProvider="getData")
	public void MainExecution(String uid,String pwd) throws InterruptedException
	{
		log.info("entering to sinin page");
		Sigin objSigin=new Sigin(driver);
		objSigin.getuid().sendKeys(uid);
		objSigin.getpass().sendKeys(pwd);
		objSigin.getcheckboxclick().click();
		
		Signout objSignout=objSigin.getsigin();
		Thread.sleep(2000);
		log.debug("i amdebugging the code");
		log.info("sigin successfull");
		String text=objSignout.getuidtext().getText();
		System.out.println("text value:--- "+text);
		
		if(text.equalsIgnoreCase("Hello "+uid+","))
		{
			
			objSignout.getLogout().click();
		}
	}
	
	@AfterTest
	public void driverclose()
	{
		log.info("driver closed successfully");
		driver.close();
		
	}
	@DataProvider
	public Object[][] getData()
	{
		//rows means how many times u want to run
		//col means how many values u are passing like uid and pwd
		Object[][] obj=new Object[2][2];
		
		obj[0][0]="sanu";
		obj[0][1]="snigdhapadhi";
		
		obj[1][0]="rahul";
		obj[1][1]="rahulshettyacademy";
		log.info("returning dataprovider object");
		return obj;
	}
}
