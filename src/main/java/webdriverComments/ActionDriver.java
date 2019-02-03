package webdriverComments;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.MediaEntityBuilder;

import config.StartBrowser;

public class ActionDriver {
	WebDriver driver;
	public ActionDriver()
	{
		driver = StartBrowser.driver;
	}
	/**
	 * Navigates to application 
	 * @param url ---Application URl Ex: http://www.google.com
	 * @throws Exception 
	 */
	public void navigateToApplication(String url) throws Exception
	{
		try {
			driver.get(url);
			StartBrowser.childTest.pass("Navigated to application successfully");
		} catch (Exception e) {
			StartBrowser.childTest.fail("Unable to Navigate to application");
			throw e;
		}
		
	}

	public boolean isElementPresent(By locator){
	try{
		driver.findElement(locator);
		return true;
	}catch(Exception e){
		System.out.println("Element is not avaliable");
	return false;
	}
	
	}
	/**
	 * Used to Perform click action on links, buttons, checkbox and radio buttons
	 * @param locator --Get it from OR
	 * @throws Exception 
	 */
	public void click(By element, String eleName) throws Exception
	{
		try {
			driver.findElement(element).click();
			StartBrowser.childTest.pass("Performed click action successfully on :"+eleName);
			
		} catch (Exception e) {
			StartBrowser.childTest.fail("Unable to Perform click on :"+eleName ,
					MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot()).build());
			StartBrowser.childTest.info(e);
			throw e;
		}
		
	}
	/**
	 * used to perform type action in textbox and Text area
	 * @param locator
	 * @param testData
	 * @throws Exception 
	 */
	public void type(By locator, String testData, String eleName) throws Exception
	{
		try {
			driver.findElement(locator).sendKeys(testData);
			StartBrowser.childTest.pass("Performed type in  :"+eleName + " with data :" +testData);
		} catch (Exception e) {
			StartBrowser.childTest.fail("Unable to Perform type action in :"+eleName + "with data "+testData ,
					MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot()).build());
			StartBrowser.childTest.info(e);
			throw e;
		}
	}
	
	public String getText(By locator)
	{
		try {
			String x=driver.findElement(locator).getText();
			StartBrowser.childTest.pass("Text is   :"+x);
			return x;
		} catch (Exception e) {
			StartBrowser.childTest.fail("unable to return text");
			return null;
		}
		
	}
	/**
	 * Perform mouse hover on given element
	 * @param locator --- get it from Or
	 * @param eleName --for reporting
	 * @throws Exception 
	 */
	public void mouseHover(By locator, String eleName) throws Exception
	{
		try {
			Actions a = new Actions(driver);
			WebElement mo=driver.findElement(locator);
			a.moveToElement(mo).build().perform();
			StartBrowser.childTest.pass("Performed mousehover on  :"+eleName );
		} catch (Exception e) {
			StartBrowser.childTest.fail("Unable to Performed mousehover on  :"+eleName,
					MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot()).build());
			StartBrowser.childTest.info(e);
			throw e;
		}
	}
	
	public String screenShot()
	{
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	}
}