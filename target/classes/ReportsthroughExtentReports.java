package Resources;


import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReportsthroughExtentReports
{
	static ExtentReports extent;
	@Test
	public static ExtentReports getExtentReports() 
	{
		String path=System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter =new ExtentSparkReporter(path);
		reporter.config().setReportName("Offshore cash");
		reporter.config().setDocumentTitle("PASSFAILURE");
		extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("SNIGDHA PADHI", "TESTER");
		return extent;
	}

}
