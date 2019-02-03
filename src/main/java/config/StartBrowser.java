package config;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class StartBrowser {
 public static WebDriver driver;
 ExtentHtmlReporter htmlReporter;
 public static ExtentReports extent;
 public static ExtentTest parentTest;
 public static ExtentTest childTest;
 
 @BeforeTest
 public void generateReport(){
	 htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/Reports/MyReport.html");
	extent=new ExtentReports();
	extent.attachReporter(htmlReporter);
	  }
 @BeforeMethod
 public void methodname(Method method){
	parentTest=extent.createTest(method.getName()); 
 }
 
 @BeforeClass
  public void beforeClass() {
	// WebDriverManager.chromedriver().arch64();
	 //System.setProperty("webdriver.chrome.driver","/home/tectoro/Downloads/chromedriver");
	 WebDriverManager.chromedriver().setup();
	 driver= new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
      extent.flush();      
  }

}
