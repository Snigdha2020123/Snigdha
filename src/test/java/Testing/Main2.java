package Testing;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import PageObjects.ForgotPassword;
import PageObjects.Sigin2;
import Resources.DriverInitialization;

public class Main2 extends DriverInitialization {

	public WebDriver driver;
	public static Logger log = LogManager.getLogger(Main2.class.getName());

	@Test
	public void tsetingmethod() {
		log.info("SANU TESTING METHOD");

	}

	

	@BeforeTest
	public void beforetest() throws IOException {
		driver = callwebdriver();
		driver.get(prop.getProperty("url"));
	}

	@Test(dataProvider = "getData")
	public void MainExecution(String uid, String pwd,String name,String email,String phone) throws InterruptedException {
		log.info("entering to sinin page");
		Sigin2 objSigin = new Sigin2(driver);
		objSigin.getuid().sendKeys(uid);
		objSigin.getpass().sendKeys(pwd);
		objSigin.getcheckboxclick().click();

		log.debug("i amdebugging the code");
		log.info("sigin successfull");
		ForgotPassword objForgotPassword = objSigin.getsigining();
		objForgotPassword.getForgotpass().click();
		objForgotPassword.getnameField().sendKeys(name);
		objForgotPassword.getemail().sendKeys(email);
		objForgotPassword.getphone().sendKeys(phone);
		Thread.sleep(2000);
		objForgotPassword.getbacklogin().click();
		
	}

	@AfterTest
	public void driverclose() {
		log.info("driver closed successfully");
		driver.close();

	}

	@DataProvider
	public Object[][] getData() {
		// rows means how many times u want to run
		// col means how many values u are passing like uid and pwd
		Object[][] obj = new Object[1][5];

		obj[0][0] = "sanu";
		obj[0][1] = "snigdhapadhi";
		obj[0][2]="snigdha";
		obj[0][3]="abc@gmail.com";
		obj[0][4]="235678";
	
		log.info("returning dataprovider object");
		return obj;
	}
}
