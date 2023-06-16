package base;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;


public class ProjectSpecificMethod {

	public static ChromeDriver driver;
	public static ExtentReports extent;
	public static ExtentTest test1;
	public String testName, testDescription, testCategory, testAuthor;
	
	@BeforeSuite
	public void startReport() {
		ExtentHtmlReporter reporter = new ExtentHtmlReporter("./reports/result.html");		
		//reporter.setAppendExisting(true);
		extent = new ExtentReports();
		extent.attachReporter(reporter);
	}
	
	@BeforeClass
	public void testDetails() {
		test1 = extent.createTest(testName, testDescription);
		test1.assignCategory(testCategory);
		test1.assignAuthor(testAuthor);
	}
	
	@AfterSuite
	public void stopReport() {
		extent.flush();
	}
	
	public void reportStep(String StepDetail, String Status) {
		if(Status.equalsIgnoreCase("pass")) {
			test1.pass(StepDetail);
		}else if (Status.equalsIgnoreCase("fail")) {
			test1.fail(StepDetail);
			throw new RuntimeException("See Extent Report for more details");
		}
	}
	
	@BeforeMethod
	public void launchBrowser() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	
	
}
