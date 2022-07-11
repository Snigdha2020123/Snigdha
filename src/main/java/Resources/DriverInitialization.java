package Resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverInitialization

{

	public static WebDriver driver;
	public Properties prop;

	public WebDriver callwebdriver() throws IOException {
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\data.properties");
		prop = new Properties();
		prop.load(fis);
			String browsername=System.getProperty("browser");

		if (browsername.contains("chrome")) {
			ChromeOptions options=new ChromeOptions();
			if (browsername.contains("headless"))
			{
				options.addArguments("headless");
			}
			
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+
					"\\src\\main\\java\\Resources\\chromedrive\\chromeDriver.exe");
			driver = new ChromeDriver(options);
		}
		if(browsername.equalsIgnoreCase("firefox"))
		{
			
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\geckodrive\\geckoDriver.exe");
			driver=new FirefoxDriver();
		}
		if(browsername.equalsIgnoreCase("edge"))
		{
			
			System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\edgedriver\\msedgedriver.exe");
			driver=new EdgeDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		return driver;
	}

	public static String takeScreenshot(String testcasename, WebDriver driver) throws IOException {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destinationfile = System.getProperty("user.dir") + "\\reports\\" + testcasename + ".png";
		FileUtils.copyFile(src, new File(destinationfile));
		return destinationfile;
	}
	//String browsername = prop.getProperty("browser");
			//mvn test -Dbrowser=chrome
			//System.getProperty("user.dir") will take u to current project path like MJ
		

}
